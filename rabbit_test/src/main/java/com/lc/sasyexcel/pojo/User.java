package com.lc.sasyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;


/**
 * Author: Liuchong
 * Description:
 * date: 2019/8/7 14:56
 */
public class User extends BaseRowModel {
    @ExcelProperty(value = "用户名")
    private String username;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "地址")
    private String address;
    @ExcelProperty(value = "密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
