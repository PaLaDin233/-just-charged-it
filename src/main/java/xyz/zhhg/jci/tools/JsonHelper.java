package xyz.zhhg.jci.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import xyz.zhhg.jci.model.standard.jsons.Jsonable;

public final class JsonHelper {
	private static Gson gson=new Gson();
	private JsonHelper() {

	}
	/**
	 * 将jsonString字符串转化为对象
	 * @param jsonString
	 * @param o 返回的对象
	 */
	public static void jsonStringToJson(String jsonString,Object o) {

		gson.fromJson(jsonString, o.getClass());
	}

	/**
	 * 将jsonString字符串转化为对象
	 * @param jsonString
	 * @param c 返回的对象类型
	 * @return 返回的对象
	 */
	public static <E> E jsonStringToJson(String jsonString,Class<E> c){
			return gson.fromJson(jsonString, c);		
	}

	/**
	 * json对象转化为字符串
	 * @param json
	 * @return
	 */
	public static String jsonToJsonString(Jsonable json) {
		return gson.toJson(json);
	}

	/**
     * 将Map转成json
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map){
        Gson gson = new Gson();
        return gson.toJson(map, Map.class);
    }

    /**
     * 依据json字符串返回Map对象
     * @param json
     * @return
     */
    public static Map<String,Object> toMap(String json){
        return toMap(parseJson(json));
    }

    /**
     * 获取JsonObject
     * @param json
     * @return
     */
    public static JsonObject parseJson(String json){
        JsonParser parser = new JsonParser();
        JsonObject jsonObj = parser.parse(json).getAsJsonObject();
        return jsonObj;
    }

    /**
     * 将JSONObjec对象转换成Map-List集合
     * @param json
     * @return
     */
    public static Map<String, Object> toMap(JsonObject json){
        Map<String, Object> map = new HashMap<String, Object>();
        Set<Map.Entry<String, JsonElement>> entrySet = json.entrySet();
        for (Iterator<Map.Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ){
            Map.Entry<String, JsonElement> entry = iter.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if(value instanceof JsonArray)
                map.put((String) key, toList((JsonArray) value));
            else if(value instanceof JsonObject)
                map.put((String) key, toMap((JsonObject) value));
            else
                map.put((String) key, value);
        }
        return map;
    }

    /**
     * 将JSONArray对象转换成List集合
     * @param json
     * @return
     */
    public static List<Object> toList(JsonArray json){
        List<Object> list = new ArrayList<Object>();
        for (int i=0; i<json.size(); i++){
            Object value = json.get(i);
            if(value instanceof JsonArray){
                list.add(toList((JsonArray) value));
            }
            else if(value instanceof JsonObject){
                list.add(toMap((JsonObject) value));
            }
            else{
                list.add(value);
            }
        }
        return list;
    }


}
