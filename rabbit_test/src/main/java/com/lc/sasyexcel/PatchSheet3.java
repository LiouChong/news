package com.lc.sasyexcel;

import com.alibaba.excel.metadata.BaseRowModel;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/7 9:49
 */
public class PatchSheet3 extends BaseRowModel {
    private String patchNum;
    private String prePatch;

    public String getPatchNum() {
        return patchNum;
    }

    public void setPatchNum(String patchNum) {
        this.patchNum = patchNum;
    }

    public String getPrePatch() {
        return prePatch;
    }

    public void setPrePatch(String prePatch) {
        this.prePatch = prePatch;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"patchNum\":\"")
                .append(patchNum).append('\"');
        sb.append(",\"prePatch\":\"")
                .append(prePatch).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
