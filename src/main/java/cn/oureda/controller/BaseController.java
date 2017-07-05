package cn.oureda.controller;

import cn.oureda.realm.HelperUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by webhugo on 5/5/17.
 */
public class BaseController<T> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());



    protected HelperUser User() {
        Object obj = SecurityUtils.getSubject().getPrincipal();
        HelperUser user = null;
        try {
            user = (HelperUser) obj;
        } catch (Exception e) {
            user = null;
        }
        return user;
    }


    protected static <T> T getMaptValue(Map<String, String> map, String key, T defaultValue, Class<T> type) {
        String obj = map.get(key);
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

    protected <T> T getRequestValue(HttpServletRequest request, String key, T defaultValue, Class<T> type) {
        String obj = request.getParameter(key);
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
}