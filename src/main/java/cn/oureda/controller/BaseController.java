package cn.oureda.controller;

import cn.oureda.cache.RedisUtil;
import cn.oureda.entity.User;
import cn.oureda.service.FoodService;
import cn.oureda.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by webhugo on 5/5/17.
 */
public class BaseController<T> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final static String cookieName = "taobaoName";

    @Autowired
    private RedisUtil redisUtil;
    @Resource
    protected FoodService foodService;
    @Resource
    protected UserService userService;


    protected static <T> T getMaptValue(Map<String, String> map, String key, T defaultValue, Class<T> type) {
        String obj = map.get(key);
        if (obj == null)
            return defaultValue;
        if (type.getSimpleName().equals("String")) {
            return (T) obj;
        }
        Method method = null;
        try {
            method = type.getMethod("valueOf", String.class);
            return (T) method.invoke(null, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static <T> T getRequestValue(HttpServletRequest request, String key, T defaultValue, Class<T> type) {
        String obj = request.getParameter(key);
        if (obj == null)
            return defaultValue;
        if (type.getSimpleName().equals("String")) {
            return (T) obj;
        }
        Method method = null;
        try {
            method = type.getMethod("valueOf", String.class);
            return (T) method.invoke(null, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void helperLogin(HttpServletResponse response, User user) {
        redisUtil.set(user.getId().toString(), user);
        Cookie cookie = new Cookie(cookieName, user.getId().toString());
        response.addCookie(cookie);
    }

    protected User User(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            String value = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName))
                    value = cookie.getValue();
            }
            if (value == null)
                return null;
            User user = (User) redisUtil.get(value);
            System.out.print("user:");
            System.out.println(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void UserAdd(ModelAndView model, HttpServletRequest request) {
        User user = User(request);
        model.addObject("user", user);
    }
}