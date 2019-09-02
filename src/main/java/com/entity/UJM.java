package com.entity;

import java.io.Serializable;

public class UJM implements Serializable {
    private static final long serialVersionUID = -7641404203520621786L;
    private Integer userId;

    private Integer JobId;

    public UJM() {
    }

    public Integer getJobId() {
        return JobId;
    }

    public void setJobId(Integer jobId) {
        JobId = jobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UJM{" +
                "userId=" + userId +
                ", JobId=" + JobId +
                '}';
    }
}
