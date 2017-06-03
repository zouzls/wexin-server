package com.bt.ommvets.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ParseUtil {
	/**
	 * 流转换为字符串
	 * @param is
	 * @return
	 */
	public static String parseStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String line = null;

           while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       return sb.toString();
    }
	/**
	 * 将json字符串转化为jsonNode
	 * @param json
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parseStringToJsonNode(String json) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(json);
		return jsonNode;
	}
	/**
	 * 将Java对象转化为JsonNode
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static JsonNode parseObjectToJsonNode(Object object) throws IOException {
		ObjectMapper mapper=new ObjectMapper();
		String objectJson = mapper.writeValueAsString(object);
		JsonNode objectJsonNode = mapper.readTree(objectJson);
		return objectJsonNode;
	}

}
