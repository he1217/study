package com.he.excise.netty.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/2/2 16:41
 */
@Data
@AllArgsConstructor
public class ResponseSample {
    private String code;
    private String data;
    private long timeStamp;
}
