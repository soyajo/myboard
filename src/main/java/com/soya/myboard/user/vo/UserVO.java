package com.soya.myboard.user.vo;

import com.soya.myboard.auth.vo.AuthVO;
import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.comment.vo.CommentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", catalog = "test01")
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;

    @Column(nullable = true, name = "user_id")
    private String userId;

    @Column(nullable = true, name = "user_pw")
    private String userPw;

    @Column(nullable = true, name = "user_name")
    private String userName;

    @Column(nullable = true, name = "reg_dt")
    private String regDt;

    @Column(nullable = true, name = "update_dt")
    private String updateDt;

    @OneToMany
    @JoinColumn(name = "bdNo")
    private List<BoardVO> boardVOS = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "cmtNo")
    private List<CommentVO> commentVOS = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "authNo")
    private List<AuthVO> authVOS = new ArrayList<>();

}
