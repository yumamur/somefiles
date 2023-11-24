package com.yumamur.websecond.repository;

import com.yumamur.websecond.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
