package com.soya.myboard.board.service.impl;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.service.CategoryService;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.common.util.CustomBeanUtils;
import com.soya.myboard.common.util.DateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public Page<BoardVO> selectAll(String bdTitle,String bdContent, Pageable pageable) {

        Page<BoardVO> list = boardRepository.findAllByBdContentContainingOrBdTitleContaining(bdContent,bdTitle, pageable);

        return list;
    }

    @Override
    public void insert(BoardVO boardVO) {

        String regDt = DateUtil.nowYYYYMMDDHH24MMDD();
        boardVO.setRegDt(regDt);
        boardVO.setBdFlag(1);

        boardRepository.save(boardVO);
    }

    @Override
    public BoardVO selectOne(Long bdNo) {
        BoardVO boardVO = boardRepository.findById(bdNo).orElse(null);
        return boardVO;
    }

    @Override
    public void deleteOne(Long bdNo) {
        BoardVO boardVO = this.selectOne(bdNo);
        /*boardRepository.delete(boardVO);*/
       /* if (boardVO != null){
            boardVO.setBdFlag(1);
            CustomBeanUtils.copyProperties(boardVO,boardVO1);
        }*/
    }

    @Override
    public void update(BoardVO boardVO) {

        BoardVO boardVO1 = this.selectOne(boardVO.getBdNo());

        if (boardVO1 != null){
            String updateDt = DateUtil.nowYYYYMMDDHH24MMDD();
            boardVO.setUpdateDt(updateDt);
            CustomBeanUtils.copyProperties(boardVO,boardVO1);
        }
    }

}
