package com.soya.myboard.comment.service;

import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.vo.CommentVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    CommentVO selectOne(Long cmtVO);

    List<CommentVO> selectAll(CommentVO commentVO, Long bdNo);

    void insert(CommentVO commentVO);
}
