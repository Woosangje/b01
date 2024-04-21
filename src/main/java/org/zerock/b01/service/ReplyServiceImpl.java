package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Reply;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.dto.ReplyDTO;
import org.zerock.b01.repository.ReplyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    //@Query("select r from Reply r where r.board.bno = :bno")
    private final ReplyRepository replyRepository;

    private final ModelMapper modelMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {

        Reply reply = modelMapper.map(replyDTO, Reply.class);

        Long rno = replyRepository.save(reply).getRno();

        return rno;
    }

   /* @Override
    public ReplyDTO read(Long rno) {

        Optional<Reply> replyOptional = replyRepository.findById(rno);

        Reply reply = replyOptional.orElseThrow();

        return modelMapper.map(reply, ReplyDTO.class);
    }*/
   @Override
   public ReplyDTO read(Long rno) {
       // rno를 받아 findById 찾아와 Reply 객체를 모델로 리턴한다.
       Optional<Reply> replyOptional = replyRepository.findById(rno);
       Reply reply = replyOptional.orElseThrow();

       return modelMapper.map(reply, ReplyDTO.class);
   }


    @Override
    public void modify(ReplyDTO replyDTO) {

        Optional<Reply> replyOptional = replyRepository.findById(replyDTO.getRno());

        Reply reply = replyOptional.orElseThrow();

        reply.changeText(replyDTO.getReplyText()); // 댓글의 내용만 수정 가능

        replyRepository.save(reply);

    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }


    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {
        // 댓글 리스트 처리용 -> bno를 활용하여 페이징 처리를 추가한다.
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <=0? 0: pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("rno").ascending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        List<ReplyDTO> dtoList =
                result.getContent().stream().map(reply -> modelMapper.map(reply, ReplyDTO.class))
                        .collect(Collectors.toList());
        // 실제 반환 되어야 하는 타입이 Reply가 아니라 ReplyDTO임으로 변환 작업 진행

        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

    }
    /*@Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {

        //삼항 연산자 페이지가 0이나 0이하면
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <= 0 ? 0 :
                        pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("rno").ascending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        List<ReplyDTO> dtoList =
                result.getContent().stream().map(reply -> modelMapper.map(reply, ReplyDTO.class))
                        .collect(Collectors.toList());

        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }*/
}
