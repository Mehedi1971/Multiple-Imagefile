package com.mahedi.imagedatabase.repository;

import com.mahedi.imagedatabase.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData,Long> {

//    Query(nativeQuery = true, value = "UPDATE `imgs`.`img` SET `name` = 'b' WHERE (`id` = '2')");
}
