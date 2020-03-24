package com.aistar.util;

public class ServerResponse {
    private Integer code;//响应的状态码:1 表示 成功，0 ： 表示操作不成功
    private String message;
    private Object data;
    //构造函数
    public ServerResponse(){}
    public ServerResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ServerResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //方法
    //查询
    public  static ServerResponse getDataSuccess(Object data){
        ServerResponse response  = new ServerResponse(1,"查询数据成功");
        response.setData(data);
        return response;
    }

    public  static ServerResponse getDataFailed(){
        ServerResponse response  = new ServerResponse(0,"查询数据失败",MessageUtil.NO_DATA);
        return response;
    }
    public static ServerResponse addSuccess(){
        return new ServerResponse(1,"添加数据成功",MessageUtil.ADD_SUCCESS);
    }
    public static ServerResponse addFailed(){
        return new ServerResponse(0,"添加数据失败",MessageUtil.ADD_FAIL);
    }

    public static ServerResponse deleteSuccess(){
        return new ServerResponse(1,"删除数据成功",MessageUtil.DELETE_SUCCESS);
    }

    public static ServerResponse deleteFailed(){
        return new ServerResponse(0,"删除数据失败",MessageUtil.DELETE_FAIL);
    }

    public static ServerResponse updateSuccess(){
        return new ServerResponse(1,"修改数据成功",MessageUtil.UPDATE_SUCCESS);
    }

    public static ServerResponse updateFailed(){
        return new ServerResponse(0,"修改数据失败",MessageUtil.UPDATE_FAIL);
    }





















    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
