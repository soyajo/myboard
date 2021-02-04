package com.soya.myboard.comment.vo;


import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment", catalog = "test01")
public class CommentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cmt_no;

    @Column(nullable = true, name = "cmt_title")
    private String cmtTitle;

    @Column(nullable = true, name = "cmt_content")
    private String cmtContent;

    @Column(nullable = true, name = "reg_dt")
    private String regDt;

    @Column(nullable = true, name = "reg_user")
    private String regUser;

    @Column(nullable = true, name = "update_dt")
    private String updateDt;

    @Column(nullable = true, name = "update_user")
    private String updateUser;

    @ManyToOne
    @JoinColumn(name = "bd_no")
    private BoardVO boardVO;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private UserVO userVO;

}
