package com.mahedi.imagedatabase.controller;

import com.mahedi.imagedatabase.entity.ImageData;
import com.mahedi.imagedatabase.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class ImageDataController {
    @Autowired
    private ImageDataService imageDataService;

    @GetMapping("/")
    public String showExampleView(Model model)
    {
        List<ImageData> imgs = imageDataService.getAllProduct();
        model.addAttribute("listofimg", imgs);
        return "/listImgs";
    }
    @GetMapping("/addimg")
    public String showAddProduct()
    {

        return "/addimg";
    }

//    @RequestParam("file") MultipartFile file,
//    @RequestParam("name") String name,
    @PostMapping("/addimg")
    public String saveProduct(MultipartFile file1,MultipartFile file2,
                              String name, @ModelAttribute ImageData imageData)

    {
        imageDataService.saveImageToDB(imageData,file1,file2,name);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model) {
        ImageData imageData = imageDataService.updatetest(id);
        model.addAttribute("updatelist", imageData);
        System.out.println(imageData);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id)
    {
        imageDataService.delete(id);
        return "redirect:/";
    }
}
