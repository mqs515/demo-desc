package com.test.demo.bo;

import lombok.Data;

/**
 * @author ：miaoqs
 * @date ：2019-06-04 15:13
 * @description：222
 */
@Data
public class PageInfo {
    private boolean isLastPage;
    private int pageIndex;
    private int pageSize;
    private int total;
    private int pageTotal;
    private boolean lastPage;
}
