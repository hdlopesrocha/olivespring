package com.rochaware;

import com.rochaware.exception.ServiceException;
import com.rochaware.model.DatabaseObject;
import com.rochaware.model.User;
import com.rochaware.service.RegisterUserService;
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

    @RequestMapping("/reset")
    String reset() throws ServiceException {
        DatabaseObject.getDatabase().drop();
        new RegisterUserService("hdlpesrocha91@gmail.com","Henrique Rocha","12345678").execute();
        return "OK";
    }

}
