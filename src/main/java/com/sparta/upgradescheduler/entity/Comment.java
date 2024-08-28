package com.sparta.upgradescheduler.entity;


import com.sparta.upgradescheduler.dto.comment.CommentCreateRequestDto;
import com.sparta.upgradescheduler.dto.comment.CommentDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "Comment")
@Getter
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(nullable = false, length = 200)
    private String comment;

    @Column(nullable = false, length = 20)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    //삭제 여부
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    public Comment(CommentCreateRequestDto dto) {
        this.comment = comment;
    }

    public Comment() {

    }

    public void update(CommentDto dto) {
        this.comment = comment;
    }

    public static Comment createNewComment(Schedule schedule, String comment, String username) {
        Comment newComment = new Comment();
        newComment.schedule = schedule;
        newComment.comment = comment;
        newComment.username = username;
        newComment.isDeleted = false;
        return newComment;
    }
}
