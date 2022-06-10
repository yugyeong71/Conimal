package com.example.api_conimal.image.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder @Getter
@NoArgsConstructor @AllArgsConstructor
public class Image {

    @Id @GeneratedValue
    private Integer imageId;
}
