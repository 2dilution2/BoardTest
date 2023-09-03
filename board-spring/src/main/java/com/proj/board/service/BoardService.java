package com.proj.board.service;

import com.proj.board.dto.ResponseDto;
import com.proj.board.entity.BoardEntity;
import com.proj.board.entity.PopularSerchEntity;
import com.proj.board.repository.BoardRepository;
import com.proj.board.repository.PopularSerchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    PopularSerchRepository popularSerchRepository;

    public ResponseDto<List<BoardEntity>> getTop3 () {
        List<BoardEntity> boardList = new ArrayList<BoardEntity>();
        Date date = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));

        try {
            boardList = boardRepository.findTop3ByBoardWriteDateAfterOrderByBoardLikeCountDesc(LocalDateTime.now());
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 오류");
        }

        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<BoardEntity>> getList() {
        List<BoardEntity> boardList = new ArrayList<BoardEntity>();

        try {
            boardList = boardRepository.findByOrderByBoardWriteDateDesc();
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 오류");
        }
        return ResponseDto.setSuccess("Success", boardList);
    }

    public ResponseDto<List<PopularSerchEntity>> getPopSearchList() {
        List<PopularSerchEntity> popularSerchEntities = new ArrayList<PopularSerchEntity>();

        try {
            popularSerchEntities = popularSerchRepository.findTop10ByOrderByPopSearchCntDesc();
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 오류");
        }
        return ResponseDto.setSuccess("Success", popularSerchEntities);
    }

    public ResponseDto<List<BoardEntity>> getSearchList(String boardTitle){
        List<BoardEntity> boardList = new ArrayList<BoardEntity>();

        try {
            boardList = boardRepository.findByBoardTitleContains(boardTitle);
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 오류");
        }

        return ResponseDto.setSuccess("Success", boardList);

    }

    public ResponseDto<BoardEntity> createPost(BoardEntity boardEntity) {
        try {
            BoardEntity createdPost = boardRepository.save(boardEntity);
            return ResponseDto.setSuccess("Post created successfully", createdPost);
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }
    }

    public ResponseDto<BoardEntity> updatePost(int boardNumber, BoardEntity boardEntity) {
        try {
            if (!boardRepository.existsById(boardNumber)) {
                return ResponseDto.setFailed("Post not found");
            }
            boardEntity.setBoardNumber(boardNumber);
            BoardEntity updatedPost = boardRepository.save(boardEntity);
            return ResponseDto.setSuccess("Post updated successfully", updatedPost);
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }
    }

    public ResponseDto<String> deletePost(int boardNumber) {
        try {
            boardRepository.deleteById(boardNumber);
            return ResponseDto.setSuccess("Post deleted successfully", null);
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }
    }
}
