package hello.springmvc.basic.requestMapping;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {

    @GetMapping("/mapping/users")
    public String user(){return "get users";}

    @PostMapping("/mapping/users")
    public String addUser(){return "add users";}

    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId){return "find users : " + userId;}

    @PatchMapping("/mapping/users/{userId}")
    public String patchUser(@PathVariable String userId){return "patch users : " + userId;}

    @DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable String userId){return "delete users : " + userId;}
}
