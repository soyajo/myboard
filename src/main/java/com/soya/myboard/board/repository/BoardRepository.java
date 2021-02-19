package com.soya.myboard.board.repository;

import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.vo.CategoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;

public interface BoardRepository extends JpaRepository<BoardVO, Long> {

    Page<BoardVO> findAllByBdContentContainingOrBdTitleContaining(String bdContent,String bdTitle,Pageable pageable); // 검색기능 넣으려고하니까 에러 안됨 콘테이닝 안됨.

    BoardVO findByBdNo(Long bdNo);
}

