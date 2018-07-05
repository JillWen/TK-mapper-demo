package cn.idoo.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ResponseResult<T> implements Serializable{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	@ApiModelProperty("状态码,0:操作成功,1:操作失败")
	private Integer code;

	/**
	 * 提示信息
	 */
	@ApiModelProperty("提示信息")
	private String message;

	/**
	 * 返回的数据
	 */
	@ApiModelProperty("返回的数据")
	private T data;

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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ResponseResult<T> success(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
		return this;
	}
	
	public ResponseResult<T> success(Integer code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}
	
	public ResponseResult<T> fail(Integer code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}
	
	public ResponseResult<T> fail(Integer code, String message,T data) {
		this.code = code;
		this.message = message;
		this.data = data;
		return this;
	}
}
