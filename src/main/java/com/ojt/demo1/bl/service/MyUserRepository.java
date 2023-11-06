package com.ojt.demo1.bl.service;

import com.ojt.demo1.persistance.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {


}
