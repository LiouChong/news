package com.lc.sasyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.lc.sasyexcel.pojo.Patch;

import java.util.*;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/9 11:20
 */
public class PatchExcelListener<T extends BaseRowModel> extends AnalysisEventListener {
    private Map<Integer, T> dataMap = new HashMap<>();

    private T t;

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        if (analysisContext.getCurrentRowNum() == 0) {
            return;
        }
        t = (T) o;
        Integer currentRowNum = analysisContext.getCurrentRowNum();
        dataMap.put(currentRowNum, t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public Map<Integer, T> getHashmap() {
        return dataMap;
    }
}
