package com.nbp;

import com.nbp.db.NBPdao;
import com.nbp.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class NbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpApplication.class, args);

        /*NBPdao nbpdao = new NBPdao();
        Date date = new Date();
        Users newUser = new Users("", 113, new Timestamp(date.getTime()),
                "TestDisplayName", 4, "", new Timestamp(date.getTime()),
                "TestLocation", 1, 4, 6, "", 1);
        System.out.println(nbpdao.getMaxSizeUsers());

        newUser.setId(nbpdao.getMaxSizeUsers());

        nbpdao.addUser(newUser);

        System.out.println(newUser.getId());
        System.out.println(newUser.getCreationDate());*/

    }

}
