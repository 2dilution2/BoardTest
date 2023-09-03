package com.proj.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PopularSerch")
@Table(name = "PopularSerch")
public class PopularSerchEntity {
    @Id
    private String popTerm;
    private int popSearchCnt;
}
