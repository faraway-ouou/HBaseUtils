package com.winks.base_utils.request.manager;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseObjectBean<T> implements Serializable {
    public static final int DATA_TYPE_BANNER = 1;//banner
    @SerializedName("success")
    public boolean success;

    @Override
    public String toString() {
        return "BaseObjectBean{" +
                "success=" + success +
                ", content='" + content + '\'' +
                ", dataType=" + dataType +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String content;

    public BaseObjectBean() {
    }

    public BaseObjectBean(T data) {
        this.data = data;
    }

    /**
     * 1 banner 数据
     */
    public int dataType;

    public static String bean2String(Object data) {
        return new Gson().toJson(new BaseObjectBean(data));
    }

    public static BaseObjectBean string2Bean(String data) {
        return new Gson().fromJson(data,BaseObjectBean.class);
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public BaseObjectBean(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public BaseObjectBean(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public T data;
}
