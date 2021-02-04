package com.soya.myboard.board.web;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.common.util.PageUtil;
import com.soya.myboard.common.vo.RedirectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(BoardVO boardVO, Model model, @PageableDefault(size = 5) Pageable pageable,@RequestParam(required = false,defaultValue = "") String searchText){

            Page<BoardVO> list = boardService.selectAll(searchText, searchText , pageable);

        int startPage = Math.max(1,list.getPageable().getPageNumber() - 5);
        int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber() + 5);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("list",list);

        return "board/list";
    }
    @GetMapping("/insert")
    public String insert(){


        return "board/insert";
    }
    @PostMapping("/insertAction")
    public String insertAction(BoardVO boardVO, RedirectAttributes redirectAttributes){

        boardService.insert(boardVO);
        RedirectVO redirectVO = RedirectVO.builder()
                .message(RedirectVO.MSG_OK)
                .url("/board/view")
                .build();

        redirectAttributes.addFlashAttribute("redirectVO",redirectVO);
        return "redirect:/board/list";
    }
    @GetMapping("/view")
    public String view(Long bdNo, HttpServletRequest request, Model model){
        String no = request.getParameter("bdNo");
        BoardVO boardVO = boardService.selectOne(bdNo);
        model.addAttribute(boardVO);
        return "board/view";
    }
    @GetMapping("/update")
    public String update(){

        return "board/update";
    }
    @PostMapping("/updateAction")
    public String updateAction(){

        return "";
    }

    @PostMapping("deleteAction")
    @ResponseBody
    public String deleteAction(RedirectAttributes redirectAttributes){



        return "";
    }

}
