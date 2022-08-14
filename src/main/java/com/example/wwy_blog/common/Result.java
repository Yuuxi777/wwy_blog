package com.example.wwy_blog.common;

import lombok.Data;

import java.io.Serializable;

/*
 * params
 * code: 状态码
 * status: 0表示正确 -1表示错误返回
 * msg: 给前端的提示信息
 * data: 给前端返回的数据类型
 * */
@Data
public class Result implements Serializable {

    private Integer code;
    private Integer status;
    private String msg;
    private Object data;

    public static Result success(String msg,Object data){
        Result m = new Result();
        m.setCode(0);
        m.setMsg(msg);
        m.setStatus(0);
        m.setData(data);

        return m;
    }

    public static Result success(String msg){
        Result m = new Result();
        m.setCode(0);
        m.setMsg(msg);
        m.setStatus(0);

        return m;
    }

    public static Result result(EnumExceptionType enumExceptionType,Object data) {
        Result m = new Result();
        m.setCode(enumExceptionType.getErrorCode());
        m.setStatus(-1);
        m.setData(data);
        m.setMsg(enumExceptionType.getCodeMessage());

        return m;
    }

    public static Result result(EnumExceptionType enumExceptionType) {
        return result(enumExceptionType,null);
    }

    public static Result fail(String msg){
        return fail(msg,null);
    }

    private static Result fail(String msg, Object data) {
        Result m = new Result();
        m.setData(data);
        m.setMsg(msg);
        m.setCode(-1);
        m.setStatus(-1);


        return m;
    }


}
