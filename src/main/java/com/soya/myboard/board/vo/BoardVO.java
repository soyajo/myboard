package com.soya.myboard.board.vo;

import com.soya.myboard.auth.vo.AuthVO;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.vo.CommentVO;
import com.soya.myboard.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board", catalog = "test01")
public class BoardVO {
    //번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdNo;
    //제목
    @Column(nullable = true, name = "bd_title")
    private String bdTitle;
    //내용
    @Column(nullable = true, name = "bd_content")
    private String bdContent;
    //등록일
    @Column(nullable = true, name = "reg_dt")
    private String regDt;
    //등록자
    @Column(nullable = true, name = "reg_user")
    private String regUser;
    //수정일
    @Column(nullable = true, name = "update_dt")
    private String updateDt;
    //수정자
    @Column(nullable = true, name = "update_user")
    private String updateUser;

    @OneToMany
    @JoinColumn(name = "cmtNo")
    private List<CommentVO> commentVOS = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserVO userVO;

    @ManyToOne
    @JoinColumn(name = "ctgrNo")
    private CategoryVO categoryVO;

}
