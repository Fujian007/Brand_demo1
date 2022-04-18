package com.xu.pojo;

import java.util.List;

public class pageBean<T> {
    private int totalCount;//总条数
    private List<T> rows;//每页展示行数

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
