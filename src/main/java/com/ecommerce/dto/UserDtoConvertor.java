package com.ecommerce.dto;

import com.ecommerce.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConvertor {

    public UsersDto convert(Users from){
//DTO veriler bunun la gelsin gonder
        return new UsersDto(from.getEmail(),
                            from.getFirstName(),
                            from.getLastName(),
                            from.getMiddleName(),
                             from.isActive());

    }
}
