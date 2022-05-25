package com.nbp;

import com.nbp.db.NBPdao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpApplication.class, args);

        NBPdao nbpdao = new NBPdao();
    }

}
