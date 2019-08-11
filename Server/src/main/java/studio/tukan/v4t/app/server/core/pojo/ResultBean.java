package studio.tukan.v4t.app.server.core.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResultBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2991062174895933800L;

	public enum status {
		SUCCESS(1, "SUCCESS"), UNKNOWN(0, "UNKNOWN"), FAIL(-1, "FAIL");

		private final String msg;
		private final int code;

		private status(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public int getCode() {
			return code;
		}

	}

	private String msg;
	private int code;
	private T data;
	
	public void set(int code,T data,String msg) {
		this.code=code;
		this.data=data;
		this.msg=msg;
	}
	
	
	public ResultBean(int code,T data,String msg) {
		this.code=code;
		this.data=data;
		this.msg=msg;
	}
	
	public ResultBean(ResultBean<T> e){
		this.code=e.code;
		this.data=e.data;
		this.msg=e.msg;
	}

}
