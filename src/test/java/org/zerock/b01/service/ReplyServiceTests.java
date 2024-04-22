package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.ReplyDTO;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;


    @Test
    public void testRegister(){
    //댓글 등록
        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyText("새로운 댓글 추가")
                .replyer("replyer")
                .bno(130L)
                .build();

        log.info(replyService.register(replyDTO));

    }

}
