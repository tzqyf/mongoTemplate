package com.mongodb.demo.page;

import java.util.List;

/**
 * 分页类
 * @param <T>
 */
public class PageResult<T> {
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 数据
     */
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
