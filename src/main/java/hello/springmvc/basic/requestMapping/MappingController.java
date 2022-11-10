package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * The type Mapping controller.
 */
@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        return "hello";
    }

    /** 겟 매핑
     * Mapping get v 2 string.
     *
     * @return the string
     */
    @GetMapping("/mapping-get")
    public String mappingGetV2(){
        return "getMapping";
    }


    /**경로 변수
     * Mapping path string.
     *
     * @param data the data
     * @return the string
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        return data;
    }


    /**파라미터 매핑 된 파라미터가 있어야 접속 가능
     * Mapping param string.
     *
     * @return the string
     */
    @GetMapping(value = "/mapping-param" , params = "mode=test")
    public String mappingParam(){
        return "ok";
    }


    /**HttpHeader으로 접근 제어
     * Mapping haeder string.
     *
     * @return the string
     */
    @GetMapping(value = "/mapping-header" , headers = "mode=header")
    public String mappingHaeder(){
        return "ok";
    }


    /**요청 컨텐츠 정보에 따라 접근 가능
     * JSON만 접근 가능
     * Mapping content string.
     *
     * @return the string
     */
    @GetMapping(value = "/mapping-header" , consumes = "application/json")
    public String mappingContent(){
        return "ok";
    }

    /**
     * Mapping produces string.
     *
     * @return the string
     */
    @PostMapping(value = "/mapping-produces" , produces = "text/html")
    public String mappingProduces(){
        return "ok";
    }
}
