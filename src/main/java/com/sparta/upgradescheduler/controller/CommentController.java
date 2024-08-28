package com.sparta.upgradescheduler.controller;

import com.sparta.upgradescheduler.dto.comment.CommentCreateRequestDto;
import com.sparta.upgradescheduler.dto.comment.CommentCreateResponseDto;
import com.sparta.upgradescheduler.dto.comment.CommentDto;
import com.sparta.upgradescheduler.dto.comment.CommentListResponseDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateRequestDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleCreateResponseDto;
import com.sparta.upgradescheduler.dto.schedule.ScheduleDto;
import com.sparta.upgradescheduler.entity.Comment;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.service.CommentService;
import com.sparta.upgradescheduler.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 저장
    @PostMapping("/comment/save")
    public CommentCreateResponseDto createComment(@RequestBody CommentCreateRequestDto dto){
        return commentService.createComment(dto);
    }

    // 단건 조회
    @GetMapping("/comment/{commentId}")
    public Comment getComment(@PathVariable("commentId") Long commentId){
        return commentService.getComment(commentId);
    }

    // 댓글 전체 조회
    @GetMapping("/comment")
    public CommentListResponseDto getCommentList(){
        return commentService.getCommentList();
    }


    // 수정(수정안됨)
//    @PutMapping("/comment/{commentId}")
//    public Long updateComment (@PathVariable("commentId") Long commentId, @RequestBody CommentDto dto){
//        return commentService.updateComment(commentId, dto);
//    }

    @DeleteMapping("/comment/{commentId}")
    public Long deleteComment(@PathVariable("commentId") Long commentId){
        return commentService.deleteComment(commentId);
    }



}
