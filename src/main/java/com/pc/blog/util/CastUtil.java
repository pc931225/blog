package com.pc.blog.util;

/**
 * @author pc
 **/
public class CastUtil {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}
