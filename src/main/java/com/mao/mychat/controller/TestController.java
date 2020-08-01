package com.mao.mychat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @GetMapping("getAddressList")
    public String getAddressList(){
        return "[{\"title\":\"A\",\"userList\":[{\"id\":\"23412351\",\"name\":\"阿啊哈哈\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"134\",\"name\":\"爱丽丝\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"12412\",\"name\":\"阿波罗\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"B\",\"userList\":[{\"id\":\"12421\",\"name\":\"爸爸\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"14\",\"name\":\"巴塞罗那\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"C\",\"userList\":[{\"id\":\"122345344\",\"name\":\"C罗\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"634634\",\"name\":\"蔡徐坤\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"4323425\",\"name\":\"坤坤\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"D\",\"userList\":[{\"id\":\"2344234\",\"name\":\"大张伟\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"1236756\",\"name\":\"爹爹\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"2344\",\"name\":\"呆呆\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"345341\",\"name\":\"阿莎\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"E\",\"userList\":[{\"id\":\"756842346\",\"name\":\"张伟\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"475623423\",\"name\":\"李嘉晨\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"F\",\"userList\":[{\"id\":\"232423423\",\"name\":\"周杰伦\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"890897563\",\"name\":\"林俊杰\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"112321\",\"name\":\"林志玲\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"23524443\",\"name\":\"张杰\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"4442232\",\"name\":\"张宇\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"87907890\",\"name\":\"王思聪\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"G\",\"userList\":[{\"id\":\"532423\",\"name\":\"苍井空\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"23523355\",\"name\":\"爱丽丝\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"456742352345\",\"name\":\"Mao\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]},{\"title\":\"H\",\"userList\":[{\"id\":\"444341479\",\"name\":\"毛宇翔\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"235231123\",\"name\":\"爱丽丝\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false},{\"id\":\"263464346\",\"name\":\"乔布斯\",\"imgUrl\":\"../../static/img/interimHead.jpg\",\"url\":\"/\",\"checked\":false}]}]";
    }

    @PostMapping("getGroupChat")
    public String getGroupChat(@RequestParam("selectedList") List<String> selectedList){
        System.out.println(selectedList.toString());
        if(selectedList.size() == 0){
            return "0";
        }else{
            return "1";
        }
    }
}
