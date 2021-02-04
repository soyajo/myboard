package com.soya.myboard.category.vo;

import com.soya.myboard.board.vo.BoardVO;
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
@Table(name = "category",catalog = "test01")
public class CategoryVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ctgr_no;

    @Column(nullable = true, name = "ctgr_title")
    private String ctgrTitle;

    @Column(nullable = true, name = "ctgr_kind")
    private String ctgrKind;

    @Column(nullable = true, name = "reg_dt")
    private String regDt;

    @Column(nullable = true, name = "update_dt")
    private String updateDt;

    @OneToMany
    @JoinColumn(name = "bd_no")
    private List<BoardVO> boardVOS = new ArrayList<>();

}
