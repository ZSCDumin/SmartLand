package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * http请求返回的最外层对象
 *
 * @author huxudong
 */
@ApiModel("HTTP请求返回的数据对象")
public class Result<T> {
    /**
     * 编码
     */
    @ApiModelProperty(value = "状态码，0表示操作成功", required = true)
    private Integer code;

    /**
     * 信息
     */
    @ApiModelProperty(value = "状态信息，返回\"操作成功\"，或者说明错误原因", required = true)
    private String message;

    /**
     * 数据
     */
    @ApiModelProperty("返回的数据")
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
    }


}
