package com.proj.board.controller;

import com.proj.board.dto.ResponseDto;
import com.proj.board.entity.BoardEntity;
import com.proj.board.entity.PopularSerchEntity;
import com.proj.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/top3")
    public ResponseDto<List<BoardEntity>> getTop3() {
        return boardService.getTop3();
    }

    @GetMapping("/list")
    public ResponseDto<List<BoardEntity>> getList() {
        return boardService.getList();
    }

    @GetMapping("/popSerchList")
    public ResponseDto<List<PopularSerchEntity>> getPopSearchList() {
        return boardService.getPopSearchList();
    }

    @GetMapping("/search/{boardTitle}")
    public ResponseDto<List<BoardEntity>> getSearchList(@PathVariable("boardTitle") String boardTitle) {
        return null;
    }

    @PostMapping("/")
    public ResponseDto<BoardEntity> createPost(@RequestBody BoardEntity boardEntity) {
        return boardService.createPost(boardEntity);
    }

    @PutMapping("/{boardNumber}")
    public ResponseDto<BoardEntity> updatePost(@PathVariable("boardNumber") int boardNumber, @RequestBody BoardEntity boardEntity) {
        return boardService.updatePost(boardNumber, boardEntity);
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseDto<String> deletePost(@PathVariable("boardNumber") int boardNumber) {
        return boardService.deletePost(boardNumber);
    }
}
