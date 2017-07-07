package cn.oureda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by webhugo on 17-7-5.
 */
@Controller
public class UserController extends BaseController{

    @GetMapping("/cart")
    public ModelAndView cart(ModelAndView model) {
        model.setViewName("cart");
        return model;
    }

    @PostMapping("/addToCart")
    public ModelAndView addToCart(ModelAndView model) {

        return model;
    }

    @GetMapping("/back")
    public ModelAndView back(ModelAndView model,
                             HttpServletRequest request){
        UserAdd(model,request);
        model.setViewName("back");
        return model;
    }
}
