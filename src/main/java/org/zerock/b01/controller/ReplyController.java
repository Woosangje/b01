package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.dto.ReplyDTO;
import org.zerock.b01.service.ReplyService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor    //의존성 주입을 위한
public class ReplyController {

    private final ReplyService replyService;

    //@ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @Operation(summary = "Replies POST")// @ApiOperation 대신 사용
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Long> register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {

        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();

        Long rno = replyService.register(replyDTO);

        resultMap.put("rno", rno);//replyDTO클래스를 jSON화
        

        return resultMap;
    }

    // # 특정 게시물의 댓글 목록
    //@ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @Operation(summary = "Replies POST")// @ApiOperation 대신 사용
    @GetMapping(value = "/list/{bno}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("bno") Long bno, PageRequestDTO pageRequestDTO){

        
        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno, pageRequestDTO);

        return responseDTO;

    }

    // # 특정 댓글 조회
    //@ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @Operation(summary = "GET 방식으로 특정 댓글 조회")
    @GetMapping("/{rno}")
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno){

        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

    //@ApiOperation(value = "Replies POST", notes = "Delete 방식으로 특정 댓글 조회")
    @Operation(summary = "Delete 방식으로 특정 댓글 조회")
    @DeleteMapping("/{rno}")
    public Map<String, Long> remove( @PathVariable("rno") Long rno){

        replyService.remove(rno);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }

    @Operation(summary = "PUT 방식으로 특정 댓글 수정")
    @PutMapping(value = "/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Long> remove(@PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO){
        // rno를 받아 객체를 수정 후 rno를 전달
        replyDTO.setRno(rno);   //번호를 일치시킴

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;


    }

}
