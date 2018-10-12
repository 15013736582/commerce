package com.util;

import java.util.List;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-20 02:50
 **/
public class MyPage {

    //每页条数
    private int pageSize;

    //当前页
    private int currPage;

    //总记录数
    private int totalCount;

    //总页数
    private int totalPage;

    //数据
    private List data;

    /**
     * 计算总页数
     */
    public void init() {
        if(this.totalCount % pageSize == 0) {
            this.totalPage = this.totalCount/pageSize;
        }else {
            this.totalPage = this.totalCount/pageSize+1;
        }
        this.currPage = 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }


}
