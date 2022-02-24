package com.ecommerce.service;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.dto.UpdateUserRequest;
import com.ecommerce.dto.UserDtoConvertor;
import com.ecommerce.dto.UsersDto;
import com.ecommerce.model.Users;
import com.ecommerce.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserDtoConvertor userDtoConvertor;


    public UserService(UserRepository userRepository, UserDtoConvertor userDtoConvertor) {
        this.userRepository = userRepository;
        this.userDtoConvertor = userDtoConvertor;
    }

    public List<UsersDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userDtoConvertor.convert(user))
                .collect(Collectors.toList());
    }

    public UsersDto getUserByMail(String mail) { //once entitye gidior ordan veriyi users turunde cekior sonrada onu dto ya convert edior
        Users user = userRepository.findUsersByEmail(mail).get(); //optional i stringe cevirior

        return userDtoConvertor.convert(user);
    }

    public UsersDto createUser(CreateUserRequest request) { //arazyuden girilen bilgiler requestin nesnesinin icinde
        Users users = new Users(request.getEmail(),           //bu bgilleri users classina ceviriorum.
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                false); //burda user kaydoldugunda default olarak false olcak

        return userDtoConvertor.convert(userRepository.save(users));
        //ekrandan gelen CreateUserRequest adli classin ciindeki bilgileri user a cevridim ve o sekilde repositry deki save
        //method u ile kaydettim sonra bunu ekrana dondururken guvenlik acisindan userDto ya  convert edip o sekilde dondurdm.


    }

    public UsersDto updateUser(String mail, UpdateUserRequest request) {

        Users users = userRepository.findUsersByEmail(mail).get();

        // burda request in icinde UI dan gelen bilgiler var ,users icinde databaseden gelen veriler var updated user icinde
        // updadilmesini istemediklerimi users dan aliyorum( id and email) update edilsin dediklerimi request den aliyorum.
        // son olarak user reposotry deki save ile save edip ocnverter classi ile userDTo ya cevirip ekrana gondereyirm
        Users updatedUser = new Users(users.getId(),
                users.getEmail(),
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                users.isActive());

        return userDtoConvertor.convert(userRepository.save(updatedUser));
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}

