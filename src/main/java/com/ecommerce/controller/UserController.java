package com.ecommerce.controller;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.dto.UpdateUserRequest;
import com.ecommerce.dto.UsersDto;
import com.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    //Constructor ile user service classini user controller classina enjeckte ettik
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UsersDto>> getAllUser(){
        //Response entity veriyi json formatinda gosterior ve http status codei modify etmemize yarior

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{mail}")
    public ResponseEntity<UsersDto> getUserByMail(@PathVariable("mail")String mail){ //Response entity veriyi json formatinda gosterior ve http status codei modify etmemize yarior
        return ResponseEntity.ok(userService.getUserByMail(mail));
    }

    @PostMapping("/put")
    public ResponseEntity<UsersDto>createUser(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }


    @PutMapping("/{mail}")
    public ResponseEntity<UsersDto>updateUser(@PathVariable("mail") String mail,@RequestBody UpdateUserRequest request ){

        return ResponseEntity.ok(userService.updateUser(mail,request));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();   //responseenttity birsey dondurmuyorsa bu sekilde build() ekliyoruz
    }

}
