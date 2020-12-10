package com.qf.dao;

import com.qf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Integer> {
    User findByEmail(String mail);
}
