package com.ebay.order.api.dto;

import java.io.Serializable;

/**
 * 该类的作用在于前后台通过远程调时,用来包装服务结果
 * @author chuchen
 *
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 2521601569143435775L;
	
	private T data;
	
	private Integer count = 0;//这里表示总共有多少个,数据库count的结果用来进行分页处理
	
	private Boolean success = false;//默认值是不成功
	
	private Integer status;//状态码约定
	
	private String info;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + ", count=" + count
				+ ", success=" + success + ", status=" + status + ", info="
				+ info + "]";
	}
	
}
