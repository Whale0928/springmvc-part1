package hello.springmvc.basic.request;

import hello.springmvc.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class ReqeustParamController {


    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam("username") String memberName,
                                 @RequestParam("age") int age) {
        log.info(memberName);
        log.info(String.valueOf(age));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam String username,
                                 @RequestParam int age) {
        log.info(username);
        log.info(String.valueOf(age));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info(username);
        log.info(String.valueOf(age));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true, defaultValue = "requi") String username,
                                       @RequestParam(required = true, defaultValue = "12") int age) {
        log.info(username);
        log.info(String.valueOf(age));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("{}:{}", paramMap.get("username"), paramMap.get("age"));
        // Map < KEY : VALUE >
        // MultiValueMap < KEY : { V1, V2 , V3 } >

        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("{}-{}",helloData.getUsername(),helloData.getAge());
        return helloData.toString();
    }

}

