package com.soya.myboard.auth.vo;

import com.soya.myboard.board.vo.BoardVO;
import com.soya.myboard.comment.vo.CommentVO;
import com.soya.myboard.user.vo.UserVO;
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
@Table(name = "auth", catalog = "test01")
public class AuthVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auth_no;

    @Column(nullable = true, name = "auth_id")
    private String authId;

    @Column(nullable = true, name = "auth_level")
    private int authLevel;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private UserVO userVO;

}
