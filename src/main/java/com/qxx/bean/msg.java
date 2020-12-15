package com.qxx.bean;

import java.util.HashMap;
import java.util.Map;

//通用返回json数据类
public class msg {
private int code;//返回状态码
private String msginfo;//返回提示信息
private Map<String,Object> extend=new HashMap<String,Object>();//返回用户信息
 public static  msg success()//数据获得成功
 {
     msg result = new msg();
     result.setCode(200);
     result.setMsginfo("处理成功");
     return  result;
 }
    public static  msg fail()//数据获得失败
    {
        msg result = new msg();
        result.setCode(404);
        result.setMsginfo("处理失败");
        return  result;
    }
    public msg add(String key,Object value)//链式操作放入数据信息
    {
      this.getExtend().put(key,value);
         return  this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsginfo() {
        return msginfo;
    }

    public void setMsginfo(String msginfo) {
        this.msginfo = msginfo;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
