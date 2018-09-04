package com.niuzj.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.niuzj.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gson
 */
public class GsonTest {

    //默认方式
//    private Gson gson = new Gson();

    /*
        默认的gson对象会把值为null的属性忽略掉,
        使用serializeNulls方法后不会忽略为null的属性
        setDateFormat方法设置日期格式化格式
        GsonBuilder是一个配置类,可以配置很多属性
     */
    private Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    //序列化
    @Test
    public void test01() {
        User user = User.getDefault();
        user.setUsername(null);
        String s = gson.toJson(user);
        System.out.println(s);
    }

    //反序列化
    @Test
    public void test02() {
        User user = gson.fromJson("{\"username\":\"niuzj\",\"age\":23,\"birthday\":\"Sep 3, 2018 5:14:25 PM\",\"money\":0.89}", User.class);
        System.out.println(user);
    }

    //操作List
    @Test
    public void test03() {
        List<User> list = new ArrayList<>();
        list.add(User.getDefault());
        list.add(User.getDefault());
        String s = gson.toJson(list);
        System.out.println("序列化:" + s);
        list = gson.fromJson(s, new TypeToken<List<User>>() {
        }.getType());
        System.out.println("反序列化:" + list);
    }

    @Test
    public void test04() {
        Map<String, User> map = new HashMap<>();
        map.put("001", User.getDefault());
        map.put("002", User.getDefault());
        String s = gson.toJson(map);
        System.out.println("序列化:" + s);
        map = gson.fromJson(s, new TypeToken<Map<String, User>>() {}.getType());
        System.out.println("反序列化:" + map);

    }


}
