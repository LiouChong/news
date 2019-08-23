package com.lc.sasyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.lc.sasyexcel.PatchExcelListener;
import com.lc.sasyexcel.pojo.Patch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/9 11:14
 */
public class PatchExcelDeal {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Antiy\\Desktop\\patch_import.xlsx"));
        PatchExcelListener listener = new PatchExcelListener();
        ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, listener);
        excelReader.read(new Sheet(1,0, Patch.class));
        Map<Integer, Patch> hashmap = listener.getHashmap();
        hashmap.forEach((k,v)-> {
            System.out.println(v);
        });
    }
}
