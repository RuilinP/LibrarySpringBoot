package com.library.demo.Controller.User;

import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.Reader;
import com.library.demo.Entity.User.User;
import com.library.demo.Repository.User.UserRepository;
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
                "coco@email.com", new Date(-806953280000L), "Cat No. 1");
        User reader2 = new Reader("Louie", "888",
                "louie@email.com", new Date(1000255600000L), "Cat No. 2");
        adminRepository.save(admin1);
        readerRepository.save(reader1);
        readerRepository.save(reader2);
        List<User> rslt =  (List<User>) adminRepository.findAll();
        rslt.addAll((List<User>) readerRepository.findAll());
        return rslt;
    }


}
