package com.niuzj.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.niuzj.model.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * fastjson
 * JsonObject类对应一个json对象
 * JsonArray类对应一个json数组
 */
public class FastJsonTest {

    @Test
    public void test01(){
        User user1 = User.getDefault();
        user1.setUsername(null);
        //格式化日期,默认格式yyyy-MM-dd HH:mm:ss
        String s = JSON.toJSONString(user1, SerializerFeature.WriteDateUseDateFormat);
        System.out.println("序列化:" + s);
        User user = JSON.parseObject(s, User.class);
        System.out.println("反序列化:" + user);
    }

    @Test
    public void test02(){
        List<User> list = new ArrayList<>();
        list.add(User.getDefault());
        list.add(User.getDefault());
        String s = JSON.toJSONString(list);
        System.out.println("序列化:" + s);
        //指定泛型
        list = JSON.parseObject(s, new TypeReference<List<User>>(){});
        System.out.println("反序列化:" + list);
    }

    /**
     * JsonArray对象是List的一个实现
     */
    @Test
    public void test03() throws IOException {
        InputStream in = new FileInputStream("data1.json");
        byte[] datas = new byte[in.available()];
        int i = in.read(datas);
        in.close();
        if (i != -1){
            JSONArray arr = (JSONArray) JSON.parse(datas);
            if (arr != null && arr.size() > 0){
                for (Object o : arr) {
                    System.out.println(o);
                }
            }
        }
    }

    /**
     * JsonObject是Map的一个实现
     * 可以使用各种类型的getXXX方法获取值
     */
    @Test
    public void test04() throws IOException {
        InputStream in = new FileInputStream("data2.json");
        byte[] datas = new byte[in.available()];
        int i = in.read(datas);
        in.close();
        if (i != -1){
            JSONObject data = (JSONObject) JSON.parse(datas);
            System.out.println(data.getString("result"));
            System.out.println(data.getJSONArray("pairs"));
        }
    }




}
