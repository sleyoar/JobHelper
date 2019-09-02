package com.entity;

import java.io.Serializable;

public class Resume implements Serializable {
    private static final long serialVersionUID = 9044508942189776025L;
    private Integer resumeId;

    private String resumePic;

    private String resumeName;

    private String resumeAddress;

    private String resumePhone;

    private String resumeEmail;

    private String resumePage;

    private String resumeDescribe;

    private String resumeSchool;

    private String resumeDegree;

    private String resumeHonour;

    private String projectName;

    private Integer projectTime;

    private String projectDescribe;

    private Integer userId;

    public Resume() {
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resumeId=" + resumeId +
                ", resumePic='" + resumePic + '\'' +
                ", resumeName='" + resumeName + '\'' +
                ", resumeAddress='" + resumeAddress + '\'' +
                ", resumePhone='" + resumePhone + '\'' +
                ", resumeEmail='" + resumeEmail + '\'' +
                ", resumePage='" + resumePage + '\'' +
                ", resumeDescribe='" + resumeDescribe + '\'' +
                ", resumeSchool='" + resumeSchool + '\'' +
                ", resumeDegree='" + resumeDegree + '\'' +
                ", resumeHonour='" + resumeHonour + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectTime=" + projectTime +
                ", projectDescribe='" + projectDescribe + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumePic() {
        return resumePic;
    }

    public void setResumePic(String resumePic) {
        this.resumePic = resumePic == null ? null : resumePic.trim();
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName == null ? null : resumeName.trim();
    }

    public String getResumeAddress() {
        return resumeAddress;
    }

    public void setResumeAddress(String resumeAddress) {
        this.resumeAddress = resumeAddress == null ? null : resumeAddress.trim();
    }

    public String getResumePhone() {
        return resumePhone;
    }

    public void setResumePhone(String resumePhone) {
        this.resumePhone = resumePhone == null ? null : resumePhone.trim();
    }

    public String getResumeEmail() {
        return resumeEmail;
    }

    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail == null ? null : resumeEmail.trim();
    }

    public String getResumePage() {
        return resumePage;
    }

    public void setResumePage(String resumePage) {
        this.resumePage = resumePage == null ? null : resumePage.trim();
    }

    public String getResumeDescribe() {
        return resumeDescribe;
    }

    public void setResumeDescribe(String resumeDescribe) {
        this.resumeDescribe = resumeDescribe == null ? null : resumeDescribe.trim();
    }

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool == null ? null : resumeSchool.trim();
    }

    public String getResumeDegree() {
        return resumeDegree;
    }

    public void setResumeDegree(String resumeDegree) {
        this.resumeDegree = resumeDegree == null ? null : resumeDegree.trim();
    }

    public String getResumeHonour() {
        return resumeHonour;
    }

    public void setResumeHonour(String resumeHonour) {
        this.resumeHonour = resumeHonour == null ? null : resumeHonour.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(Integer projectTime) {
        this.projectTime = projectTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe == null ? null : projectDescribe.trim();
    }
}