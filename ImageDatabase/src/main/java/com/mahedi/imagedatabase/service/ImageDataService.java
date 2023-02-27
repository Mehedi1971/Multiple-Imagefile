package com.mahedi.imagedatabase.service;

import com.mahedi.imagedatabase.entity.ImageData;
import com.mahedi.imagedatabase.repository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageDataService {
    @Autowired
    private ImageDataRepository imageDataRepository;

//    public  void saveImageToDB(MultipartFile file, String name){
//        ImageData img=new ImageData();
//        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
//        if(fileName.contains(".."))
//        {
//            System.out.println("not a a valid file");
//        }
//        try {
//            img.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        img.setName(name);
//
//        imageDataRepository.save(img);
//    }


    public void saveImageToDB(ImageData imageData,MultipartFile file1,MultipartFile file2, String name) {
        try {
            imageData.setImage1(Base64.getEncoder().encodeToString(file1.getBytes()));
            imageData.setImage2(Base64.getEncoder().encodeToString(file2.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageData.setName(name);

        imageDataRepository.save(imageData);
    }


    public List<ImageData> getAllProduct()
    {
        return imageDataRepository.findAll();
    }

//    public ImageData updatetest(long id){
//        Optional<ImageData> optional=imageDataRepository.findById(id);
//        ImageData imageData=optional.get();
//        return imageData;
//    }

    public ImageData updatetest(long id) {
        Optional<ImageData> optional=imageDataRepository.findById(id);
        ImageData lab=optional.get();
        return lab;
//        return imageDataRepository.findById(id);
    }

    public void delete(long id){
        this.imageDataRepository.deleteById(id);
    }


}
