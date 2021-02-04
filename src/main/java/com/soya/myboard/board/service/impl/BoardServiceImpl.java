package com.soya.myboard.board.service.impl;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.common.util.DateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public Page<BoardVO> selectAll(String bdTitle,String bdContent, Pageable pageable) {

        Page<BoardVO> list = boardRepository.findAllByBdTitleContainingOrBdContentContaining(bdTitle, bdContent, pageable);
        return list;
    }

    @Override
    public void insert(BoardVO boardVO) {

        String regDt = DateUtil.nowYYYYMMDDHH24MMDD();
        boardVO.setRegDt(regDt);
        boardRepository.save(boardVO);
    }

    @Override
    public BoardVO selectOne(Long bdNo) {
        BoardVO boardVO = boardRepository.findById(bdNo).orElse(null);
        return boardVO;
    }
}
