package com.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class rectangleController {

    @RequestMapping("/rectangle")
    public String greeting(@RequestParam(value="length", required=true, defaultValue="0") Integer length,@RequestParam(value="width", required=true, defaultValue="0") Integer width, Model model) {
	Rectangle myRectangle = new Rectangle(length, width); 
        model.addAttribute("area", myRectangle.getArea());
	model.addAttribute("perimeter", myRectangle.getPerimeter());
        return "rectangle";
    }

}
