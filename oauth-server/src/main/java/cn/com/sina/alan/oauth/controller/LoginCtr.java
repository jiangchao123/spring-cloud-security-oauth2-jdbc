package cn.com.sina.alan.oauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 */
@Controller
//@SessionAttributes("authorizationRequest")
public class LoginCtr {
    private static final Logger log = LoggerFactory.getLogger(LoginCtr.class);

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(HttpServletRequest request, HttpServletResponse response,
//            String username, String password, BindingResult result)
//            throws ServletException {
//        System.out.println("========================name: " + username);
//        System.out.println("========================password: " + password);
//        try {
//            request.login(username, password);
//        }
//        catch (ServletException authenticationFailed) {
//            result.rejectValue(null, "authentication.failed",
//                    authenticationFailed.getMessage());
//            return "login";
//        }
//        return "redirect:/";
//    }
}
