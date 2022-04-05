package com.fc.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//将指定的字符串转为支持的Date类型
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //这是SpringMvc所支持的格式
        String pattern = "yyyy/MM/dd";

        //如果请求中的字符串携带了-
        if (source.contains("-")){
            pattern= "yyyy-MM-dd";
        }

        //声明一个简单的日期格式化器
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Date parse = null;
        try {
            //字符串转为对应日期对象
            parse = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
