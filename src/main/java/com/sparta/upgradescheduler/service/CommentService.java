package com.sparta.upgradescheduler.service;

import com.sparta.upgradescheduler.dto.comment.CommentCreateRequestDto;
import com.sparta.upgradescheduler.dto.comment.CommentCreateResponseDto;
import com.sparta.upgradescheduler.dto.comment.CommentDto;
import com.sparta.upgradescheduler.dto.comment.CommentListResponseDto;
import com.sparta.upgradescheduler.entity.Comment;
import com.sparta.upgradescheduler.entity.Schedule;
import com.sparta.upgradescheduler.repository.CommentRepository;
import com.sparta.upgradescheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentCreateResponseDto createComment(CommentCreateRequestDto data){
        // 조회 :
        Optional<Schedule> foundScheduleOptional = scheduleRepository.findById(data.getScheduleId());
        Schedule foundSchedule = foundScheduleOptional.get();

        // 생성: 회원 엔티티
        Comment comment = Comment.createNewComment(
            foundSchedule,
            data.getComment(),
            data.getUsername()
        );

        // DB 저장 : 회원
        Comment saveComment = commentRepository.save(comment);

        // 반환 응답
        return new CommentCreateResponseDto(
            saveComment.getCommentId(),
            "created",
            201
        );
    }

    public Comment getComment(Long commentId){
        return commentRepository.findById(commentId).orElseThrow(() ->
            new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }

    public CommentListResponseDto getCommentList() {

        // 조회: 댓글 엔티티 목록 조회
        log.info("::: 댓글 목록 조회 :::");
        List<Comment> foundCommentList = commentRepository.findAll(); // +1 쿼리 발생

        log.info("::: 댓글 DTO 변환 :::");
        // DTO 변환: 회원 엔티티 목록 -> List<MemberDto> memberListDto
        List<CommentDto> commentDtoList = foundCommentList.stream().map(comment -> new CommentDto(
            comment.getCommentId(),
            comment.getComment(),
            comment.getUsername(),
            comment.getSchedule().getTitle()
        )).toList();

        // 응답 반환
        return new CommentListResponseDto(
            "success",
            200,
            commentDtoList
        );
    }

    @Transactional
    public Long updateComment(Long commentId, CommentDto dto) {
        // 해당 일정 존재하는지 DB 확인
        Comment comment = getComment(commentId);

        // 일정 수정
        comment.update(dto);

        return commentId;
    }

    public Long deleteComment(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Comment comment = getComment(id);

        // memo 삭제
        commentRepository.delete(comment);

        return id;
    }

}
