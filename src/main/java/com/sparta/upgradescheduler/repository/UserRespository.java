package com.sparta.upgradescheduler.repository;

import com.sparta.upgradescheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
