package com.niuzj.test;

import com.niuzj.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不常用
 */
public class JsonlibTest {

    /**
     * 对象序列化
     */
    @Test
    public void test01(){
        JSONObject jsonObject = JSONObject.fromObject(User.getDefault());
        System.out.println("序列化:" + jsonObject);
        User o = (User) JSONObject.toBean(jsonObject, User.class);
        System.out.println("反序列化:" + o);
    }

    /**
     * 数组序列化
     */
    @Test
    public void test02(){
        List<User> list = new ArrayList<>();
        list.add(User.getDefault());
        list.add(User.getDefault());
        JSONArray array = JSONArray.fromObject(list);
        System.out.println(array);
        Object[] o = (Object[]) JSONArray.toArray(array, User.class);
        System.out.println(Arrays.toString(o));

    }
}
