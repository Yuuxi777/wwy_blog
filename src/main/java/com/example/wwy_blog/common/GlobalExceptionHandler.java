package com.example.wwy_blog.common;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    Gson gson;

    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest request, Exception e) {

        //从request里获取请求参数
        Map<String, String> res = new HashMap<>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                //如果字段的值为空，判断若值为空，则删除这个字段>
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        System.out.println(("参数：" + gson.toJson(res)));


        //打印异常信息
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        System.out.println(("异常：" + sw.toString()));


        //自定义处理
//        if(e instanceof MyException) {
//            System.out.println(("My异常：" + ((MyException) e).getEnumExceptionType().getCodeMessage()));
//            return Result.result(((MyException) e).getEnumExceptionType());
//        }

        if(e instanceof RuntimeException) {
            //...
        }

        return Result.fail(e.getMessage());
    }
}
