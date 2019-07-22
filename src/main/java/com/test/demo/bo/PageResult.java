package com.test.demo.bo;

import lombok.Data;

import java.util.Collection;

/**
 * @author ：miaoqs
 * @date ：2019-06-04 15:02
 * @description：分页插件
 */
@Data
public class PageResult<T> {

    private PageInfo pageInfo;
    private Collection<T> result;

    @Data
    public static class PageInfo {
        /**
         * 是否是最后一页
         */
        private boolean isLastPage;
        /**
         * 页码，从1开始
         */
        private int pageIndex;
        /**
         * 每页记录数
         */
        private int pageSize;
        /**
         * 总记录数
         */
        private long total;
        /**
         * 总页数
         */
        private int pageTotal;
    }
}
