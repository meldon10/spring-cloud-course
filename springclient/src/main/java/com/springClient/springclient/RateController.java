package com.springClient.springclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class RateController {

    @Value("${rate}")
    String rate;

    @Value("${tollstart}")
    String tollStart;

    @Value("${lanecount}")
    String laneCount;

    @Value("${connstring}")
    String connString;

    @RequestMapping("/rate")
    public String getRate(Model m){
        m.addAttribute("rateAmount",rate);
        m.addAttribute("laneCount",laneCount);
        m.addAttribute("tollStart",tollStart);
        m.addAttribute("connString",connString);

        return "rateView";
    }

}

