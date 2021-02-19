package com.soya.myboard.comment.service.impl;


import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.repository.CategoryRepository;
import com.soya.myboard.category.service.CategoryService;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.repository.CommentRepository;
import com.soya.myboard.comment.service.CommentService;
import com.soya.myboard.comment.vo.CommentVO;
import com.soya.myboard.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentVO selectOne(Long cmtNo) {

        return commentRepository.findByCmtNo(cmtNo);
    }

    @Override
    public List<CommentVO> selectAll(CommentVO commentVO, Long bdNo) {
        List<CommentVO> list = commentRepository.findAll();
        return list;
    }

    @Override
    public void insert(CommentVO commentVO) {

        String regDt = DateUtil.nowYYYYMMDDHH24MMDD();
        commentVO.setRegDt(regDt);
        commentRepository.save(commentVO);
    }
}
