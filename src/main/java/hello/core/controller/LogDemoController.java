package hello.core.controller;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final MyLogger logger;
    private final LogDemoService logDemoService;

    @RequestMapping("/logger")
    @ResponseBody
    public String logger(HttpServletRequest request){
        logger.setRequestURL(request.getRequestURL().toString());

        logger.log("controller message");
        logDemoService.logic("service message");
        return "OK";
    }
}
