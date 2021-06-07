package com.hatchways.api.resources;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**use RestController to add controller and response notation to class
request beginning with this path prefix will be handled by this
 controller class**/
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, Object> userMap){
        String userName = (String) userMap.get("userName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        return userName + ", " + email + ", " + password;
    }
}
