package com.ruoyi.system.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OrderQueryDTO implements Serializable {
    private int pageIndex;
    private int pageSize;
    private Date startTime;
    private Date endTime;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderQueryDTO that = (OrderQueryDTO) o;
        return pageIndex == that.pageIndex && pageSize == that.pageSize && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageIndex, pageSize, startTime, endTime);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
