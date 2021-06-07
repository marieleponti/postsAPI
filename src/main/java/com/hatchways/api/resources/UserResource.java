package com.hatchways.api.resources;
import com.hatchways.api.domain.User;
import com.hatchways.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**use RestController to add controller and response notation to class
request beginning with this path prefix will be handled by this
 controller class**/
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    /**for all resource end points, instead of returning row object,
     *wrap inside response entity which is extension of http entity*/
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap){
        String userName = (String) userMap.get("userName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(userName, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
