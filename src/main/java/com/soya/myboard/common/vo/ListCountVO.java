package com.soya.myboard.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 1. 프로젝트명 : icf
 * 2. 패키지명   : com.fourfree.common.vo
 * 3. 작성일     : 2020. 08. 12. 오후 12:01
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListCountVO {
    private Long totalCount;
    private List list;
}
