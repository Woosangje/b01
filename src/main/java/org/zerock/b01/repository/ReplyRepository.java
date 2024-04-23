package org.zerock.b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Reply;

//Reply의 crud관리
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

    // 특정한 게시물에 해당하는 데이터들을 삭제할 수 있는 쿼리 메소드
    void deleteByBoard_Bno(Long bno);
}
