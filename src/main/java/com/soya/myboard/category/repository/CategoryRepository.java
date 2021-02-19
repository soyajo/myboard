package com.soya.myboard.category.repository;

import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.vo.CategoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryVO, Long> {
        CategoryVO findByCtgrNo(Long ctgrNo);

}

