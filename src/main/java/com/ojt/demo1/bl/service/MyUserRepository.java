package com.ojt.demo1.bl.service;

import com.ojt.demo1.persistance.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    List<MyUser> findByCity(String cityName);
}
