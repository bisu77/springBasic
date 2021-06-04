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
    private final MyLogger myLogger;
    private final LogDemoService logDemoService;

    @RequestMapping("/logger")
    @ResponseBody
    public String logger(HttpServletRequest request) throws InterruptedException {
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(request.getRequestURL().toString());

        myLogger.log("controller message");
        Thread.sleep(1000);
        logDemoService.logic("service message");

        return "OK";
    }
}
