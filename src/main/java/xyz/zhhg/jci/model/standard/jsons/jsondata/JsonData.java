package xyz.zhhg.jci.model.standard.jsons.jsondata;
import java.io.Serializable;

import xyz.zhhg.jci.model.standard.jsons.Jsonable;
public class JsonData implements Jsonable,Serializable{
	
	private static final long serialVersionUID = 155857915901620905L;
	public static int CODE_SUCCESS = 0;
	public static int CODE_FAILURED = -1;
	private static String[] NOOP = new String[]{};
	
	private int code;
	private String message;
    private Object data;
    
    
    
	private JsonData(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
    public static final JsonData success(Object data){
        return new JsonData(CODE_SUCCESS, "成功", data);
    }
    public static final JsonData success(String message, Object data){
        return new JsonData(CODE_SUCCESS, message, data);
    }
    
    public static final JsonData failure(int code, String message){
        return new JsonData(code, message, NOOP);
    }
    public static final JsonData failure(String message){
        return failure(CODE_FAILURED, message);
    }
    
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
	public String toString() {
		return "{code:\"" + code + "\", message:\"" + message + "\", data:\"" + data.toString() + "\"}";
	}
   
	
}