package com.lyd.controller;

import com.lyd.pojo.UserBean;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/lyd")
public class MyController {
    private Map<String, Object> map = new HashMap<String, Object>();

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    /**
     * 因为类的头部添加了@RestController注解，所以以下方法中不需要再添加 @ResponseBody注解，返回的类型也是json格式
     *
     * @RestController=@Controller+@ResponseBody
     **/
    @RequestMapping("/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Lyd");
        map.put("age", "28");
        return map;
    }

    /**
     * @RequestMapping(path = "/{name}/{age}", method = RequestMethod.GET)其中：path表示的是传入的参数，method中的赋值表示GET请求
     * 与下面的GetTest1方法比较，传入参数的数量不同。spring会根据参数个数选择对应的方法，不需额外的命名
     * @param name
     * @param age
     * @return map
     */
    @RequestMapping(path = "/{name}/{age}", method = RequestMethod.GET)
    public Map<String, Object> GetTest(@PathVariable("name") String name, @PathVariable("age") Object age) {
        map.clear();
        map.put("name", name);
        map.put("age", age);
        return map;
    }
    @RequestMapping(path = "/{name}/{age}/{address}", method = RequestMethod.GET)
    public Map<String, Object> GetTest1(@PathVariable("name") String name, @PathVariable("age") Object age,@PathVariable("address") String address) {
        map.clear();
        map.put("name", name);
        map.put("age", age);
        map.put("address", address);
        return map;
    }

    /**
     * 比较高级的get请求方法，使用@GetMapping()注解
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/getMappingTest")
    public Map<String, Object> GetMappingTest(String name,int age){
        map.clear();
        map.put("name",name);
        map.put("age",age);
        return map;

    }

    /**
     * @RequestParam(defaultValue = "0",name = "page")通过该注解的方式设置默认值，如果接口中该参数没有赋值，
     * 那么就用提前定义好的默认值。name=page是将参数page的数据映射到form字段
     * @param form
     * @param size
     * @return
     */
    @GetMapping("/defaultValue")
    public Map<String,Object> defaultValue(@RequestParam(defaultValue = "0",name = "page") int form,int size ){
        map.clear();
        map.put("size",size);
        map.put("form",form);
        return map;
    }

    /**
     * 将实体类添加到方法中，通过@RequestBody注解
     * @param user
     * @return
     */
    @RequestMapping("/userBeanTest")
    public Object UserBeanTest(@RequestBody UserBean user){
        map.clear();
        map.put("user",user);
        return map;
    }

    /**
     * 测试获取http头信息
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/getHeaderTest")
    public Object GetHeaderTest(@RequestHeader("access_token") String accessToken,String id){
        map.clear();
        map.put("access_token",accessToken);
        map.put("id",id);
        return map;
}
    @GetMapping("/userBeanTest1")
    public Object UserBeanTest1(){
        return new UserBean("lyd",28,"山东省",new Date());
    }


}
