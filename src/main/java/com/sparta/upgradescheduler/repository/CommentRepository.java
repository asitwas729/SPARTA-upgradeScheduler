package com.sparta.upgradescheduler.repository;

import com.sparta.upgradescheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
