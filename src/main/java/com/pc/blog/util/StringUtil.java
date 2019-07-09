package com.pc.blog.util;

/**
 * @author pc
 * @Date 2019-07-08 11:04
 **/
public class StringUtil {
    public static boolean  isNull(Object obj){
        if(obj==null){
            return true;
        }
        if("".equals(obj.toString()) || "null".equals(obj.toString())){
            return true;
        }
        return false;
    }
}
