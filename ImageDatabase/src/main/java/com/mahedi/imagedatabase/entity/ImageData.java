package com.mahedi.imagedatabase.entity;

import jakarta.persistence.*;

@Entity
@Table(name="img")
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
    @Column(length = 90000)
    private String image1;
    @Lob
    @Column(length = 90000)
    private String image2;

    public ImageData() {
    }

    public ImageData(long id, String name, String image1, String image2) {
        this.id = id;
        this.name = name;
        this.image1 = image1;
        this.image2 = image2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Override
    public String toString() {
        return "ImageData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                '}';
    }
}
