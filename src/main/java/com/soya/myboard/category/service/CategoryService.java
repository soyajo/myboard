package com.soya.myboard.category.service;

import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.vo.CategoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryVO selectOne(Long ctgrNo);

    List<CategoryVO> selectAll(CategoryVO categoryVO);
}
