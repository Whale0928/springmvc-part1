package hello.springmvc.basic.response;

import hello.springmvc.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("response-body-string-v1")
    public ResponseEntity<String> responseBody(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("response-body-string-v3")
    public String responseBodyV3(){
        return "ok";
    }


    @ResponseStatus(HttpStatus.OK) //어노테이션으로 응답  ( 어노테이션을 동적으로 보내할 경우에는 ResponseEntity을 사용한다)
    @ResponseBody
    @GetMapping("response-body-json-v1")
    public HelloData responseBodyJsonV1(){
        return new HelloData("KHG",50);
    }
}
