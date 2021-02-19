package com.soya.myboard.category.web;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.repository.CategoryRepository;
import com.soya.myboard.category.service.CategoryService;
import com.soya.myboard.category.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model){

        CategoryVO categoryVO = new CategoryVO();
        List<CategoryVO> list = categoryService.selectAll(categoryVO);
        model.addAttribute("list",list);

        return "category/list";
    }

    @GetMapping("/insert")
    public String insert(String bdNo, Model model){

        return "board/insert";
    }

    @PostMapping("/insertAction")
    public String insertAction(@ModelAttribute("BoardVO")BoardVO boardVO){

        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String view(Long bdNo, HttpServletRequest request, Model model){

        return "board/view";
    }

    @GetMapping("/update")
    public String update(Long bdNo, Model model){

        return "board/update";
    }

    @PostMapping("/updateAction")
    public String updateAction(BoardVO boardVO,Long bdNo){


        return "redirect:/board/view?bdNo="+boardVO.getBdNo();
    }

    @PostMapping("/deleteAction")
    public String deleteAction(String bdNo){

        return "board/list";
    }

}
