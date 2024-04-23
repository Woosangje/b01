package org.zerock.b01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")  // 객체로 사용해야 함.
public class BoardImage implements Comparable<BoardImage>{
//첨부파일을 의미하는 BoardImage

    @Id
    private String uuid;

    private String fileName;

    private int ord;

    @ManyToOne
    private Board board;

    @Override
    public int compareTo(BoardImage other){
        return this.ord - other.ord;
    }

    public void changeBoard(Board board){
        this.board = board;
    }
}
