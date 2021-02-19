package com.soya.myboard.comment.repository;

import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.vo.CommentVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentVO, Long> {
        CommentVO findByCmtNo(Long cmtNo);
        Page<CommentVO> findAll(Pageable pageable);

}

