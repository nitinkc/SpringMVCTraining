package com.flags.rest.webservice;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Nitin C on 1/3/2016.
 * This is going to have the Rest Controllers implemented
 */

@Controller
// 5 types of in Spring Core - 	1. Singleton, 2. Prototype, 3. Request, 4. Session, 5. Global Sesssion
// 4 in JSP/Servlet - Request, Session, application, page
@Scope("request")
public class FruitRestController {

    @RequestMapping(value = "testMessage", method = RequestMethod.GET)
    //This this make the "return" return the String as the text to the response!!
   @ResponseBody public String message(){
        return "TEST_SUCCESSFULLY";
    }
}
