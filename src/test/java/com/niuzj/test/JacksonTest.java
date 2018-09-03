package com.niuzj.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niuzj.model.User;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonTest {

    private ObjectMapper mapper = new ObjectMapper();

    //把对象转为json字符串
    @Test
    public void test01() throws JsonProcessingException {
        //日期类型会变为毫秒
        String str = mapper.writeValueAsString(User.getDefault());
        System.out.println("日期为毫秒数:" + str);
        //日期格式自定义
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String str1 = mapper.writeValueAsString(User.getDefault());
        System.out.println("日期格式自定义:" + str1);
    }

    //把对象转为字节数组,起始就是把对象转为json字符串然后getBytes
    @Test
    public void test02() throws JsonProcessingException {
        byte[] bytes = mapper.writeValueAsBytes(User.getDefault());
        System.out.println(Arrays.toString(bytes));
    }

    //把对象转为json字符串并写到文件中
    @Test
    public void test03() throws IOException {
        File file = new File("E:\\data.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        mapper.writeValue(file, User.getDefault());
    }

    //把对象转为json字符串并写到输出流中
    @Test
    public void test04() throws IOException {
        File file = new File("E:\\data.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        mapper.writeValue(outputStream, User.getDefault());
        outputStream.close();
    }

    //把List集合转换为json字符串
    @Test
    public void test05() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        list.add(User.getDefault());
        list.add(User.getDefault());
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
    }

    //把Map集合转换为json字符串
    @Test
    public void test06() throws JsonProcessingException {
        Map<String, User> map = new HashMap<>();
        map.put("001", User.getDefault());
        map.put("002", User.getDefault());
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    //======================================================反序列化=====================================================
    @Test
    public void test07() throws IOException {
        String msg = "{\"username\":\"niuzj\",\"age\":23,\"birthday\":1535964593864,\"money\":8.79}";
        User user = mapper.readValue(msg, User.class);
        System.out.println(user);
    }

    @Test
    public void test08() throws IOException {
        byte[] b = {123, 34, 117, 115, 101, 114, 110, 97, 109, 101, 34, 58, 34, 110, 105, 117, 122, 106, 34, 44, 34, 97, 103, 101, 34, 58, 50, 51, 44, 34, 98, 105, 114, 116, 104, 100, 97, 121, 34, 58, 49, 53, 51, 53, 57, 54, 52, 56, 54, 49, 48, 48, 57, 44, 34, 109, 111, 110, 101, 121, 34, 58, 50, 46, 50, 51, 125};
        User user = mapper.readValue(b, User.class);
        System.out.println(user);
    }


}
