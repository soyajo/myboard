package com.soya.myboard.category.service.impl;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.repository.CategoryRepository;
import com.soya.myboard.category.service.CategoryService;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.common.util.CustomBeanUtils;
import com.soya.myboard.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryVO selectOne(Long ctgrNo) {

        return categoryRepository.findByCtgrNo(ctgrNo);
    }

    @Override
    public List<CategoryVO> selectAll(CategoryVO categoryVO) {


        return categoryRepository.findAll();
    }
}
