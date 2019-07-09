package com.pc.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pc.blog.util.CastUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 *
 * @author pc
 **/
public class BaseController {

    final private static int CODE_OK=200;
    final private static int CODE_LACK=300;
    final private static int CODE_ERROR=500;
    final private static String MANGER="manager";
    final private static String USER="user";
    final private static String USER_ID="userId";
    final private static String MANGER_USER_ID="userId";

    public String getJson(Object object,String msg){
        return getJson(CODE_OK,object,msg);
    }

    public String getErrorJson(String msg){
        return getJson(CODE_ERROR,"{}",msg);
    }

    public String getErrorJson(String msg,String data){
        return getJson(CODE_ERROR,data,msg);
    }

    public String getErrorJson(){
        return getJson(CODE_ERROR,"{}","操作失败");
    }

    public String getEmptyJson(String msg){
        return getJson(CODE_LACK,null,msg);
    }

    private String getJson(int code,Object object,String msg){
        JSONObject json= new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if(object!=null){
            json.put("data", object);
        }
        return setJson(json);
    }

    private String setJson(JSONObject json){
        SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect;
        byte[] bytes = JSON.toJSONBytes(json,feature);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public Integer getUserId(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute(USER_ID)==null) {
            return null;
        }
        try {
            return Integer.parseInt(session.getAttribute(USER_ID)+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setUserId(HttpServletRequest request,Integer userId) {
        HttpSession session=request.getSession();
        session.setAttribute(USER_ID, userId);
    }

    public Integer getManagerUserId(HttpServletRequest request) {
        HttpSession session=request.getSession();
        try {
            return Integer.parseInt(session.getAttribute(MANGER_USER_ID)+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setManagerUserId(HttpServletRequest request,Integer userId) {
        HttpSession session=request.getSession();
        session.setAttribute(MANGER_USER_ID, userId);
    }

    public void setUser(HttpServletRequest request,HashMap<String, Object> user) {
        HttpSession session=request.getSession();
        session.setAttribute(USER, user);
    }

    public HashMap<String, Object> getUser(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute(USER)==null) {
            return null;
        }
        return CastUtil.cast( session.getAttribute(USER));
    }

    public void setManager(HttpServletRequest request,HashMap<String, Object> user) {
        HttpSession session=request.getSession();
        session.setAttribute(MANGER, user);
    }

    public HashMap<String, Object> getManager(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute(MANGER)==null) {
            return null;
        }
        return CastUtil.cast(session.getAttribute(MANGER));
    }

    public Object getSessionAttribute(String attributeKeyName, HttpServletRequest request){
        HttpSession session=request.getSession();
        if (session.getAttribute(attributeKeyName)==null) {
            return null;
        }
        return session.getAttribute(attributeKeyName);
    }
}
