package com.andy.common.utils;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * <p>ClassName: 自定义FastJson转换LocalDateTime操作 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2017/11/14 17:30 </p>
 */
public class LocalDateTimeDeserializer implements ObjectSerializer, ObjectDeserializer {

    public static final LocalDateTimeDeserializer instance = new LocalDateTimeDeserializer();

    /**
     * fastjson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JSON#parseObject(String, Type, Feature[])} method to create objects
     * for any non-trivial field of the returned object.
     *
     * @param parser    context DefaultJSONParser being deserialized
     * @param type      The type of the Object to deserialize to
     * @param fieldName parent object field name
     * @return a deserialized object of the specified type which is a subclass of {@code T}
     */
    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_INT) {
            long longValue = lexer.longValue();
            lexer.nextToken();
            //将long类型 数字串转换成时间
            java.util.Date date = new java.util.Date(longValue);
            ZoneId zoneId = ZoneId.systemDefault();
            if (type == LocalDateTime.class) {
                return (T) date.toInstant().atZone(zoneId).toLocalDateTime();
            } else if (type == LocalDate.class) {
                return (T) date.toInstant().atZone(zoneId).toLocalDate();
            } else if (type == LocalTime.class) {
                return (T) date.toInstant().atZone(zoneId).toLocalTime();
            }
//        }else if (lexer.token() == JSONToken.LITERAL_STRING){
//            String stringVal = lexer.stringVal();
//            lexer.nextToken();
//            //将long类型 数字串转换成时间
//            if (type == LocalDateTime.class) {
//                return (T) date.toInstant().atZone(zoneId).toLocalDateTime();
//            } else if (type == LocalDate.class) {
//                return (T) date.toInstant().atZone(zoneId).toLocalDate();
//            } else if (type == LocalTime.class) {
//                return (T) date.toInstant().atZone(zoneId).toLocalTime();
//            }
        } else {
            throw new UnsupportedOperationException();
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }

    /**
     * fastjson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     *
     * @param serializer
     * @param object     src the object that needs to be converted to Json.
     * @param fieldName  parent object field name
     * @param fieldType  parent object field type
     * @param features   parent object field serializer features
     * @throws IOException
     */
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            out.writeNull();
            return;
        }
        out.writeString(object.toString());
    }
}
