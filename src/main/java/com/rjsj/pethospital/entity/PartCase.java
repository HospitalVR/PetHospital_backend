package com.rjsj.pethospital.entity;

import lombok.Data;

@Data
public class PartCase {

    private String text;
    private String image;
    private String video;

    public PartCase(String text, String image, String video) {
        this.text = text;
        this.image = image;
        this.video = video;
    }

}
