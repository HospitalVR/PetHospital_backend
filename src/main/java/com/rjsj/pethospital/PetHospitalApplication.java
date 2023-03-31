package com.rjsj.pethospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PetHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetHospitalApplication.class, args);
    }

}
