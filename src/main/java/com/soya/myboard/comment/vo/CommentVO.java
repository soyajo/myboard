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
    private Long cmtNo;

    private Long bdNo;

    @Column(nullable = true)
    private String cmtContent;

    @Column(nullable = true)
    private String regDt;

    @Column(nullable = true)
    private String regUser;

    @Column(nullable = true)
    private String updateDt;

    @Column(nullable = true)
    private String updateUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bdNo", referencedColumnName = "bdNo", foreignKey = @ForeignKey(name = "comment_FK"), insertable = false, updatable = false)
    private BoardVO boardVO;

    /*@ManyToOne
    @JoinColumn(name = "cmtNo", referencedColumnName = "userNo",insertable = false,updatable = false)
    private UserVO userVO;*/

}
