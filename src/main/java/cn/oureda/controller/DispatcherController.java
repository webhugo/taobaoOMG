package cn.oureda.controller;

import cn.oureda.entity.Food;
import cn.oureda.entity.User;
import cn.oureda.util.PageParams;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by webhugo on 17-7-5.
 */
@Controller
public class DispatcherController extends BaseController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView model, HttpServletRequest request) {
        UserAdd(model, request);

        PageParams pageParams = new PageParams();
        pageParams.setPage(1);
        pageParams.setPageSize(6);
        List<Food> prefersDayList = foodService.findPrefers("今日特惠", pageParams);
        List<Food> prefersWeekList = foodService.findPrefers("今周特惠", pageParams);
        model.setViewName("index");
        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);
        return model;
    }

    @GetMapping("/login")
    public ModelAndView Glogin(ModelAndView model) {
        model.setViewName("login");
        return model;
    }

    @GetMapping("/product")
    public ModelAndView product(ModelAndView model, HttpServletRequest request) {
        UserAdd(model, request);
        Integer page = getRequestValue(request, "page", 1, Integer.class);
        Integer size = getRequestValue(request, "size", 9, Integer.class);
        System.out.println("page: " + page);
        System.out.println("size: " + size);
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(size);
        List<Food> foodList = foodService.findAll(pageParams);
        model.setViewName("product");
        model.addObject("page", page);
        model.addObject("foodList", foodList);
        return model;
    }

    @GetMapping("/single")
    public ModelAndView single(ModelAndView model, HttpServletRequest request) {
        UserAdd(model, request);

        model.setViewName("single");
        String id = request.getParameter("id");
        Food food = foodService.find(id);
        model.addObject("food", food);
        return model;
    }

    @PostMapping("/login")
    public ModelAndView Plogin(ModelAndView model,
                               @RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,
                               HttpServletResponse response) {
        User auser = userService.selectByEmailAndPassword(email, password);
        if (auser == null) {
            model.setViewName("login");
            return model;
        }
        User user = userService.findByEmail(email);
        user.setPassword(null);
        //录入
        helperLogin(response, user);

        model.setViewName("index");
        model.addObject("user", user);
        PageParams pageParams = new PageParams();
        pageParams.setPage(1);
        pageParams.setPageSize(6);
        List<Food> prefersDayList = foodService.findPrefers("今日特惠", pageParams);
        List<Food> prefersWeekList = foodService.findPrefers("今周特惠", pageParams);
        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);
        return model;
    }

    @PostMapping("/search")
    public ModelAndView search(ModelAndView model,
                               @RequestParam(value = "search", required = true) String str,
                               HttpServletRequest request) {
        UserAdd(model, request);

        model.setViewName("product");

        logger.info(str);

        String[] strings = str.split("\\s+");
        //去除重复元素
        Set<String> set = new HashSet<>();
        for (String string : strings) {
            set.add(string.trim());
        }
        ArrayList<Food> foodArrayList = new ArrayList<>();
        foodArrayList.addAll(foodService.search(set));
        model.addObject("foodList", foodArrayList);
        return model;
    }


    @GetMapping("/shop")
    public ModelAndView shop(ModelAndView model,
                             HttpServletRequest request) {
        UserAdd(model, request);
        model.setViewName("shop");
        Integer shopId = getRequestValue(request, "shopId", null, Integer.class);


        PageParams pageParams = new PageParams();
        pageParams.setPage(1);
        pageParams.setPageSize(6);
        List<Food> prefersDayList = foodService.findPrefers("今日特惠", pageParams);
        List<Food> prefersWeekList = foodService.findPrefers("今周特惠", pageParams);

        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);


        Integer page = getRequestValue(request, "page", 1, Integer.class);
        Integer size = getRequestValue(request, "size", 9, Integer.class);
        System.out.println("page: " + page);
        System.out.println("size: " + size);
        pageParams.setPage(page);
        pageParams.setPageSize(size);
        List<Food> foodList = foodService.findAll(pageParams);
        model.addObject("page", page);
        model.addObject("foodList", foodList);


        pageParams.setPage(1);
        pageParams.setPageSize(4);
        List<Food> foodsNew = foodService.findAll(pageParams);
        model.addObject("foodsNew", foodsNew);
        return model;
    }
}
