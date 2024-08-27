package com.sparta.upgradescheduler.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(nullable = false, length = 200)
    private String comment;

    @Column(nullable = false, length = 20)
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    //삭제 여부
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

}
