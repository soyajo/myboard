package com.soya.myboard.board.vo;

import com.soya.myboard.auth.vo.AuthVO;
import com.soya.myboard.category.vo.CategoryVO;
import com.soya.myboard.comment.vo.CommentVO;
import com.soya.myboard.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board", catalog = "test01")
public class BoardVO implements Serializable {
    //번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdNo;

    private Long ctgrNo;
    //제목
    @Column(nullable = true)
    private String bdTitle;
    //내용
    @Column(nullable = true)
    private String bdContent;
    //등록일
    @Column(nullable = true)
    private String regDt;
    //등록자
    @Column(nullable = true)
    private String regUser;
    //수정일
    @Column(nullable = true)
    private String updateDt;
    //수정자
    @Column(nullable = true)
    private String updateUser;
    //상태
    @Column(nullable = true)
    private int bdFlag;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn( name="bdNo", referencedColumnName = "bdNo")
    private List<CommentVO> commentVOS = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserVO userVO;


    //에러
    /*@ManyToOne
    @JoinColumn(name = "bdNo", referencedColumnName = "ctgrNo",insertable = false,updatable = false)
    private CategoryVO categoryVO;*/

}
