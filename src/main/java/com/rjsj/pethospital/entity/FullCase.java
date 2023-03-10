package com.rjsj.pethospital.entity;

import lombok.Data;

@Data
public class FullCase {

    private String type;
    private PartCase name;
    private PartCase treat;
    private PartCase check;
    private PartCase result;
    private PartCase plan;

    public FullCase(Case hospitalCase) {
        this.type = hospitalCase.getType();
        this.name = new PartCase(hospitalCase.getName1(), hospitalCase.getName2(), hospitalCase.getName3());
        this.treat = new PartCase(hospitalCase.getTreat1(), hospitalCase.getTreat2(), hospitalCase.getTreat3());
        this.check = new PartCase(hospitalCase.getCheck1(), hospitalCase.getCheck2(), hospitalCase.getCheck3());
        this.result = new PartCase(hospitalCase.getResult1(), hospitalCase.getResult2(), hospitalCase.getResult3());
        this.plan = new PartCase(hospitalCase.getPlan1(), hospitalCase.getPlan2(), hospitalCase.getPlan3());
    }

}

@Data
class PartCase {

    private String text;
    private String image;
    private String video;

    public PartCase(String text, String image, String video) {
        this.text = text;
        this.image = image;
        this.video = video;
    }

}
