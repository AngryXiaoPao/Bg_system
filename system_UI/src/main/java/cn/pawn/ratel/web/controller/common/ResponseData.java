package cn.pawn.ratel.web.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName ResponseData
 * @Description 前台响应
 * @Author zengyejun
 * @Date 2019-07-10 15:22:21
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseData<T> {
    private Integer status;
    private String message;
    private T data;

    public ResponseData(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseData(ResponseStatus status, T data) {
        this(status.getCode(), status.getMessage(), data);
    }

    public String toJson() {
        T t = this.getData();
        if (t instanceof List || t instanceof Collection) {
            return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
        } else {
            return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
        }
    }
}
