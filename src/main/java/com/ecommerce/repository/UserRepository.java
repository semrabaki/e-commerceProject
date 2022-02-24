package com.ecommerce.repository;

import com.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<Users,Long> {

    public Optional<Users> findUsersByEmail(String mail);
}
