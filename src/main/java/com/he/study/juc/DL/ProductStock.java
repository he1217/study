package com.he.study.juc.DL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/8 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock {
    private Integer  id ;
    private Integer  stock01 = 10 ;
    private Integer  stock02 = 10 ;
    private Integer  stock03 = 10 ;
    private Integer  stock04 = 10 ;
    private Integer  stock05 = 10 ;
    private Integer  stockSegment ;


}
