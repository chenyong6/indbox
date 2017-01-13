package com.cy.core.domain.result;

public class ResponseResult {
	private boolean susseed;
	
	private String msg;
	
	private Object data;

	public Object getData() {
		return data;
	}

	public ResponseResult setData(Object data) {
		this.data = data;
		return this;
	}

	public boolean isSusseed() {
		return susseed;
	}

	public ResponseResult setSusseed(boolean susseed) {
		this.susseed = susseed;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}

}
