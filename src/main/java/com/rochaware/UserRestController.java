package com.rochaware;

import com.rochaware.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hdlopesrocha on 8/31/16.
 */
@RestController
public class UserRestController {

    @RequestMapping("/test")
    User test(){
        return  new User("hdlopesrocha91@gmail.com","Henrique Rocha","/images/user.jpg");
    }



}
