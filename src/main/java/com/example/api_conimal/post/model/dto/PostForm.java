package com.example.api_conimal.post.model.dto;

import com.example.api_conimal.image.model.Image;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PostForm {

    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image imageId;

    public Image getImg(){
        return imageId;
    }

}
