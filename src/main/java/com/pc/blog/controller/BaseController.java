package com.pc.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 *
 * @author pc
 * @Date 2019-07-05 15:41
 **/
public class BaseController {

    final private static int CODE_OK=200;
    final private static int CODE_LACK=300;
    final private static int CODE_ERROR=500;
    //final private static int CODE_AUTH_ERROR=10000;

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

    public String getJson(int code,Object object,String msg){
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
        String str="";
        try {
            str= new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {

        }
        return str;
    }

    public Integer getUserId(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute("userId")==null) {
            return null;
        }
        try {
            return Integer.parseInt(session.getAttribute("userId")+"");
        } catch (Exception e) {

        }
        return null;

    }

    public void setUserId(HttpServletRequest request,Integer userId) {
        HttpSession session=request.getSession();
        session.setAttribute("userId", userId);
    }

    public Integer getManagerUserId(HttpServletRequest request) {
        HttpSession session=request.getSession();
        try {
            return Integer.parseInt(session.getAttribute("managerUserId")+"");
        } catch (Exception e) {

        }
        return null;

    }

    public void setManagerUserId(HttpServletRequest request,Integer userId) {
        HttpSession session=request.getSession();
        session.setAttribute("managerUserId", userId);
    }

    public void setUser(HttpServletRequest request,HashMap<String, Object> user) {
        HttpSession session=request.getSession();
        session.setAttribute("user", user);
    }

    public HashMap<String, Object> getUser(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute("user")==null) {
            return null;
        }
        return (HashMap<String, Object>) session.getAttribute("user");
    }

    public void setManager(HttpServletRequest request,HashMap<String, Object> user) {
        HttpSession session=request.getSession();
        session.setAttribute("manager", user);
    }

    public HashMap<String, Object> getManager(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (session.getAttribute("manager")==null) {
            return null;
        }
        return (HashMap<String, Object>) session.getAttribute("manager");
    }

    public Object getSessionAttribute(String attributeKeyName, HttpServletRequest request){
        HttpSession session=request.getSession();
        if (session.getAttribute(attributeKeyName)==null) {
            return null;
        }
        return session.getAttribute(attributeKeyName);
    }
}
