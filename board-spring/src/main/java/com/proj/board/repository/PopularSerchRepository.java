package com.proj.board.repository;

import com.proj.board.entity.PopularSerchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularSerchRepository extends JpaRepository<PopularSerchEntity, Integer> {

    public List<PopularSerchEntity> findTop10ByOrderByPopSearchCntDesc();
}
