package com.library.demo.Controller.User;

import com.library.demo.Controller.BookController;
import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.User;
import com.library.demo.Repository.User.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final UserRepository adminRepository;




    public AdminController(UserRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @GetMapping
    public List<User> getUsers(){
        List<User> rslt =  (List<User>) adminRepository.findAll();
        return rslt;
    }

    record NewAdminRequest(
            String username,
            String passwd,
            String email,
            String phone
    ){}

    @PostMapping
    public List<User> addAdmin(@RequestBody AdminController.NewAdminRequest request){
        Admin admin1 = new Admin();
        admin1.setUsername(request.username());
        admin1.setPasswd(request.passwd());
        admin1.setEmail(request.email());
        admin1.setPhone(request.phone());
        adminRepository.save(admin1);
        List<User> rslt =  (List<User>) adminRepository.findAll();
        return rslt;
    }

    @GetMapping("{userId}")
    public User getAdmin(@PathVariable("userId") Integer id){
        Optional nadmin = adminRepository.findById(id);
        if (nadmin.isPresent()){
            return (Admin) nadmin.get();
        } else {
            return new Admin();
        }
    }


//    @PutMapping("{admin_id}")
//    public List<User> updateAdmin(@RequestBody AdminController.NewAdminRequest request), @PathVariable{
//
//    }




}
