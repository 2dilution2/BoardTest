package com.proj.board.repository;

import com.proj.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    public List<BoardEntity> findTop3ByBoardWriteDateAfterOrderByBoardLikeCountDesc(LocalDateTime boardWriteDate);

    public List<BoardEntity> findByOrderByBoardWriteDateDesc();

    public List<BoardEntity> findByBoardTitleContains(String boardTitle);
}
