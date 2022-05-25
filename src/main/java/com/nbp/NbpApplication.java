package com.nbp;

import com.nbp.db.NBPdao;
import com.nbp.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class NbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpApplication.class, args);

        NBPdao nbpdao = new NBPdao();
        Users newUser = new Users("", 113, new Date(Calendar.getInstance().getTime().getTime()),
                "TestDisplayName", 4, "", new Date(Calendar.getInstance().getTime().getTime()),
                "TestLocation", 1, 4, 6, "", 1);
        System.out.println(nbpdao.getMaxSizeUsers());

        newUser.setId(nbpdao.getMaxSizeUsers() - 1);

        nbpdao.deleteUser(newUser);

    }

}
