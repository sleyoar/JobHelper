package com.entity;

import java.util.Date;

public class Job {
    private Integer jobId;

    private String jobName;

    private String jobSalary;

    private String jobCategory;

    private String jobDescribe;

    private String jobBuff;

    private String jobNeed;

    private String jobQuality;

    private Date jobDate;

    private String jobAddress;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary == null ? null : jobSalary.trim();
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory == null ? null : jobCategory.trim();
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe == null ? null : jobDescribe.trim();
    }

    public String getJobBuff() {
        return jobBuff;
    }

    public void setJobBuff(String jobBuff) {
        this.jobBuff = jobBuff == null ? null : jobBuff.trim();
    }

    public String getJobNeed() {
        return jobNeed;
    }

    public void setJobNeed(String jobNeed) {
        this.jobNeed = jobNeed == null ? null : jobNeed.trim();
    }

    public String getJobQuality() {
        return jobQuality;
    }

    public void setJobQuality(String jobQuality) {
        this.jobQuality = jobQuality == null ? null : jobQuality.trim();
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress == null ? null : jobAddress.trim();
    }
}