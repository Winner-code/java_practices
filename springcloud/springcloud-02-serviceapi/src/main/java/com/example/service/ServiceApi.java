package com.example.service;

import com.example.pojo.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ServiceApi {
    /**
     * 测试GET请求的方法。
     * 请求不传递任何的参数。
     */
    @RequestMapping(value="/test", method= RequestMethod.GET)
    public List<String> testFeign();

    /**
     * 测试GET请求传递一个普通的参数。  /get?age=xxx&name=yyy
     * 在为Feign定义服务标准接口的时候，处理请求参数的方法参数，必须使用@RequestParam注解描述。
     * 且，无论方法参数名和请求参数名是否一致，都需要定义@RequestParam注解的value/name属性。
     */
    @GetMapping(value="/get")
    public Student getMultiParams(@RequestParam(value = "age") Integer age, @RequestParam("name") String name);

    /**
     * 测试使用POST请求传递普通参数
     * 如果使用POST方式发起请求，传递多个普通参数，是使用请求头传递的参数。可以使用@RequestParam注解来处理请求参数。
     */
    @PostMapping(value="/post")
    public Student postMultiParams(@RequestParam(value = "age") Integer age, @RequestParam("name") String name);

    /**
     * 使用POST请求传递自定义类参数。
     * 必须使用@RequestBody处理。
     */
    @PostMapping(value="/postObjectParam")
    public Student postObjectParam(@RequestBody Student pojo);

}
