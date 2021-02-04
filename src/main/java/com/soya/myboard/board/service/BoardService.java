package com.soya.myboard.board.service;

import com.soya.myboard.board.vo.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {


    Page<BoardVO> selectAll(String bdTitle, String bdContent , Pageable pageable);

    void insert(BoardVO boardVO);

    void selectOne(Long bd_no);
}
