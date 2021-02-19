package com.soya.myboard.board.web;


import com.soya.myboard.board.repository.BoardRepository;
import com.soya.myboard.board.service.BoardService;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.repository.CommentRepository;
import com.soya.myboard.comment.service.CommentService;
import com.soya.myboard.comment.vo.CommentVO;
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

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentService commentService;

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
    public String insert(String bdNo, Model model){
        BoardVO boardVO = new BoardVO();
        model.addAttribute("BoardVO",boardVO);
        model.addAttribute("bdNo",bdNo);

        return "board/insert";
    }

    @PostMapping("/insertAction")
    public String insertAction(@ModelAttribute("BoardVO")BoardVO boardVO){

        boardService.insert(boardVO);

        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String view(Long bdNo, HttpServletRequest request, Model model,CommentVO commentVO){
        String no = request.getParameter("bdNo");
        BoardVO boardVO = boardService.selectOne(bdNo);
        model.addAttribute("boardVO",boardVO);

        List<CommentVO> list = commentService.selectAll(commentVO, bdNo);
        if(list != null){
            model.addAttribute("list",list);
        }
        return "board/view";
    }
    @GetMapping("/update")
    public String update(Long bdNo, Model model){

        BoardVO boardVO1 = boardService.selectOne(bdNo);

        model.addAttribute("boardVO1",boardVO1);
        model.addAttribute("bdNo",bdNo);
        return "board/update";
    }
    @PostMapping("/updateAction")
    public String updateAction(BoardVO boardVO,Long bdNo){

        boardVO.setBdNo(bdNo);
        boardService.update(boardVO);

        return "redirect:/board/view?bdNo="+boardVO.getBdNo();
    }
    @PostMapping("/deleteAction")
    public String deleteAction(String bdNo){

        int intNo = Integer.parseInt(bdNo);
        Long bdNo1 = Integer.toUnsignedLong(intNo);

        boardService.deleteOne(bdNo1);

        return "board/list";
    }

    @PostMapping("/commentInsert")
    @ResponseBody
    public String commentInsert(CommentVO commentVO){
        if(commentVO != null){
            commentService.insert(commentVO);
        }

        return "1";
    }
}
