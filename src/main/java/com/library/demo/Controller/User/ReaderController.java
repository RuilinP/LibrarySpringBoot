package com.library.demo.Controller.User;

import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.Reader;
import com.library.demo.Entity.User.User;
import com.library.demo.Repository.User.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final UserRepository readerRepository;




    public ReaderController(UserRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


    @GetMapping
    public List<User> getUsers(){
        List<User> rslt =  (List<User>) readerRepository.findAll();
        return rslt;
    }

    record NewReaderRequest(
            String username,
            String passwd,
            String email,
            String note,
            Long unix
    ){}

    @PostMapping
    public List<User> addReader(@RequestBody ReaderController.NewReaderRequest request){
        Reader reader1 = new Reader();
        reader1.setUsername(request.username());
        reader1.setPasswd(request.passwd());
        reader1.setEmail(request.email());
        reader1.setNote(request.note());
        reader1.setExpiryDate(new Date(request.unix()));
        readerRepository.save(reader1);
        List<User> rslt =  (List<User>) readerRepository.findAll();
        return rslt;
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId") Integer id){
        Optional nreader = readerRepository.findById(id);
        if (nreader.isPresent()){
            return (Reader) nreader.get();
        } else {
            return new Reader();
        }
    }




}
