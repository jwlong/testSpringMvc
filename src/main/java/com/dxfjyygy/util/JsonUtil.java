package com.dxfjyygy.util;

import com.dxfjyygy.exception.IllegalParameterValueException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * json通用工具.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/07/2018 17:39:37<br/>
 * @author parko.lam
 * @version 1.0
 */
public final class JsonUtil {
    
    private JsonUtil() {
        super();
    }
    
    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectWriter prettyJsonWriter;

    private static ObjectMapper mapper2 = new ObjectMapper();
    private static ObjectWriter prettyJsonWriter2;

    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); // 定義格式化規則
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        prettyJsonWriter = mapper.writerWithDefaultPrettyPrinter();


        mapper2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); // 定義格式化規則
        mapper2.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper2.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        prettyJsonWriter2 = mapper2.writerWithDefaultPrettyPrinter();
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }
    
    /**
     * parse.
     * @param content json字符串内容
     * @param valueType 類類型
     * @param <T> valueType對應的對象
     * @return 對應的對象
     */
    public static <T> T parse(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Parse list t.
     *
     * @param <T>     the type parameter
     * @param content the content
     * @param tClass  the t class
     * @return the t
     */
    public static <T> List<T> parseList(String content, Class<T> tClass) {
        ObjectMapper objectMapper = JsonUtil.getObjectMapper();
        JavaType javaType = TypeFactory.defaultInstance().constructParametricType(List.class, tClass);
        try {
            return objectMapper.readValue(content, javaType);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    
    /**
     * format對象.
     * @param obj obj
     * @return String
     */
    public static String format(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalParameterValueException(obj);
        }
    }
    
    public static String formatAsPrettyJson(Object obj) {
        try {
            return prettyJsonWriter.writeValueAsString(obj);
        }
        catch (JsonProcessingException e) {
            throw new IllegalParameterValueException(obj);
        }
    }

    public static String formatExcludeNull(Object obj) {
        try {
            return mapper2.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalParameterValueException(obj);
        }
    }

    public static String formatExcludeNullAsPrettyJson(Object obj) {
        try {
            return prettyJsonWriter2.writeValueAsString(obj);
        }
        catch (JsonProcessingException e) {
            throw new IllegalParameterValueException(obj);
        }
    }

    /**
     * requestBody 轉爲JsonNode.
     * @param requestBody requestBody
     * @return JsonNode
     */
    public static JsonNode readTree(String requestBody) {
        try {
            return mapper.readTree(requestBody);
        } catch (Exception e) {
            throw new IllegalParameterValueException(requestBody);
        }
    }

    /**
     * xml 转json
     */
    public static JSONObject convertXmlToJson(String xml) throws IOException {

        JSONObject jsonObject = XML.toJSONObject(xml);

        return jsonObject;
    }
}
