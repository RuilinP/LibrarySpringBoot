package com.library.demo.Controller;

import com.library.demo.Entity.Book;
import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.Reader;
import com.library.demo.Entity.User.User;
import com.library.demo.Repository.User.AdminRepository;
import com.library.demo.Repository.User.ReaderRepository;
import com.library.demo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository adminRepository;
    private final UserRepository readerRepository;


    public UserController(UserRepository adminRepository, UserRepository readerRepository) {
        this.adminRepository = adminRepository;
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<User> getUsers(){
        User admin1 = new Admin("Ruilin", "123",
                "ruilin@email", "6478594493");
        User reader1 = new Reader("Coco", "567",
                "coco@email.com", new Date(2025, 8,
                21), "Cat No. 1");
        adminRepository.save(admin1);
        readerRepository.save(reader1);
        List<User> rslt =  (List<User>) adminRepository.findAll();
        rslt.addAll((List<User>) readerRepository.findAll());
        return rslt;
    }
}
