package com.soya.myboard.common.util;

/**
 * 1. 프로젝트명 : sales
 * 2. 패키지명   : com.fourfree.sales.common.util
 * 3. 작성일     : 2018. 07. 11. 오전 9:56
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 */

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SaveRequest {

}