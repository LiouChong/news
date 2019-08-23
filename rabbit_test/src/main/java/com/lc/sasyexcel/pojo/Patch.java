package com.lc.sasyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 *Author: Liuchong
 *Description:
 *date: 2019/8/9 11:06
 **/
public class Patch extends BaseRowModel {
    @ExcelProperty(value = "补丁编号", index = 0)
    private String patchNum;
    @ExcelProperty(value = "补丁名称",index = 1)
    private String patchName;
    @ExcelProperty(value = "补丁等级",index = 2)
    private String patchGrade;
    @ExcelProperty(value = "补丁状态",index = 3)
    private String patchStatus;
    @ExcelProperty(value = "补丁热支持",index = 4)
    private String patchHotSupport;
    @ExcelProperty(value = "用户交互",index = 5)
    private String userOpration;
    @ExcelProperty(value = "独占方式安装",index = 6)
    private String onlyUse;
    @ExcelProperty(value = "补丁描述",index = 7)
    private String patchDesc;
    @ExcelProperty(value = "卸载步骤",index = 8)
    private String unloadStep;
    @ExcelProperty(value = "发布时间",index = 9)
    private String publishTime;
    @ExcelProperty(value = "补丁来源",index = 10)
    private String patchSource;
    @ExcelProperty(value = "卸载注意事项",index = 11)
    private String unloadNotice;
    @ExcelProperty(value = "补丁链接",index = 12)
    private String patchRel;

    public String getPatchNum() {
        return patchNum;
    }

    public void setPatchNum(String patchNum) {
        this.patchNum = patchNum;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public String getPatchGrade() {
        return patchGrade;
    }

    public void setPatchGrade(String patchGrade) {
        this.patchGrade = patchGrade;
    }

    public String getPatchStatus() {
        return patchStatus;
    }

    public void setPatchStatus(String patchStatus) {
        this.patchStatus = patchStatus;
    }

    public String getPatchHotSupport() {
        return patchHotSupport;
    }

    public void setPatchHotSupport(String patchHotSupport) {
        this.patchHotSupport = patchHotSupport;
    }

    public String getUserOpration() {
        return userOpration;
    }

    public void setUserOpration(String userOpration) {
        this.userOpration = userOpration;
    }

    public String getOnlyUse() {
        return onlyUse;
    }

    public void setOnlyUse(String onlyUse) {
        this.onlyUse = onlyUse;
    }

    public String getPatchDesc() {
        return patchDesc;
    }

    public void setPatchDesc(String patchDesc) {
        this.patchDesc = patchDesc;
    }

    public String getUnloadStep() {
        return unloadStep;
    }

    public void setUnloadStep(String unloadStep) {
        this.unloadStep = unloadStep;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPatchSource() {
        return patchSource;
    }

    public void setPatchSource(String patchSource) {
        this.patchSource = patchSource;
    }

    public String getUnloadNotice() {
        return unloadNotice;
    }

    public void setUnloadNotice(String unloadNotice) {
        this.unloadNotice = unloadNotice;
    }

    public String getPatchRel() {
        return patchRel;
    }

    public void setPatchRel(String patchRel) {
        this.patchRel = patchRel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"patchNum\":\"")
                .append(patchNum).append('\"');
        sb.append(",\"patchName\":\"")
                .append(patchName).append('\"');
        sb.append(",\"patchGrade\":\"")
                .append(patchGrade).append('\"');
        sb.append(",\"patchStatus\":\"")
                .append(patchStatus).append('\"');
        sb.append(",\"patchHotSupport\":\"")
                .append(patchHotSupport).append('\"');
        sb.append(",\"userOpration\":\"")
                .append(userOpration).append('\"');
        sb.append(",\"onlyUse\":\"")
                .append(onlyUse).append('\"');
        sb.append(",\"patchDesc\":\"")
                .append(patchDesc).append('\"');
        sb.append(",\"unloadStep\":\"")
                .append(unloadStep).append('\"');
        sb.append(",\"publishTime\":\"")
                .append(publishTime).append('\"');
        sb.append(",\"patchSource\":\"")
                .append(patchSource).append('\"');
        sb.append(",\"unloadNotice\":\"")
                .append(unloadNotice).append('\"');
        sb.append(",\"patchRel\":\"")
                .append(patchRel).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
