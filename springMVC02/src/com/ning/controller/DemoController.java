package com.ning.controller;

import com.ning.pojo.Demo;
import com.ning.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
*   在web.xml中配置前端控制器DispatcherServlet
* */
@Controller
public class DemoController {
    @RequestMapping("demo")//value时默认值 可以省略不写
    public String demo1(@RequestParam("name1") String name, @RequestParam("age1") int age){
        System.out.println("执行demo1"+"  "+name+"  "+age);
        return "main.jsp";
    }
    @RequestMapping("page")
    public String page(@RequestParam(defaultValue = "2") int pageSize,@RequestParam(defaultValue = "1") int pageNumber) {
        System.out.println(pageSize+"  "+pageNumber);
        return "main.jsp";
    }
    @RequestMapping("demo2")
    public String demo2(@RequestParam(required = true) String name){
        System.out.println("name必须要传参数"+name);
        return "main.jsp";
    }
    @RequestMapping("demo3")
    public String demo3(@RequestParam(defaultValue = "测试") String name){
        System.out.println(name);
        return "main.jsp";
    }
    @RequestMapping("demo5")
    public String demo5(String name, int age, @RequestParam("hover") List<String> list){
        System.out.println(name+" "+age+" "+list);
        return "main.jsp";
    }
    @RequestMapping("demo6")
    public String demo6(Demo demo){
        System.out.println(demo);
        return "main.jsp";
    }

    @RequestMapping("demo7")
    public String demo7(String name,int age){
        System.out.println(name+" "+age);
        return "main.jsp";
    }
//restful传值方式 简化jsp中参数编写格式 在Jsp中设定特定的格式
    @RequestMapping("demo8/{id1}/{name}")
    public String demo8(@PathVariable String name,@PathVariable("id1") int age){
        System.out.println(name+" "+age);
        return "/main.jsp";
    }

    //跳转方式 默认跳转方式是请求转发
    /*
    *   设置返回值字符串内容
    *   添加redirect:资源路径  重定向
    *   添加forward:资源路径 或省略forward: 请求转发
    * */
    @RequestMapping("demo9")
    public String demo9(){
        System.out.println("重定向");
        return "redirect:/main.jsp";
    }
    //前面加上东西就不会走自定义的视图解析器
    @RequestMapping("demo10")
    public String demo10(){
        return "forward:demo11";
    }
    @RequestMapping("demo11")
    public String demo11(){
        System.out.println("1111111");
        return "main";
    }

    /*
    *   @ResponseBody
    *   在方法上只有@ResponseMapping时，无论方法返回值是什么都认为需要跳转
    *   在方法上添加@ResponseBody(恒不跳转)
    *   如果返回值满足key-value的形式(对象或者map) 把响应头设置为
    *   application/json;charset=utf-8并且把转换后的内容以输出流的形式响应给客户端
    *
    *  如果返回值不满足key-value,例如返回值为String，把响应头设置为text/html
    *  把方法返回值以流的形式直接输出 如果返回值包含中文则会出现中文乱码
    *  produces表示响应头中content-type的取值
    *
    * */
    @RequestMapping(value = "demo12",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String demo12(){
        People p = new People();
        p.setAge(12);
        p.setName("张三");
        return "中文";
    }

//    @RequestMapping("demo2")
//    public String demo2(){
//        System.out.println("执行demo2");
//        return "main1.jsp";
//    }
}
