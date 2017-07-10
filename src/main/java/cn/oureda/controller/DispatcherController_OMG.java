package cn.oureda.controller;

import cn.oureda.entity.*;
import cn.oureda.util.JsonUtil_OMG;
import cn.oureda.util.PageParams_OMG;
import cn.oureda.util.UploadHelper_OMG;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 继承于控制层基类,作为业务逻辑的控制类主类
 */
@Controller
public class DispatcherController_OMG extends BaseController_OMG {

    /**
     * 匹配前端@url / 的路由
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(ModelAndView model, HttpServletRequest request) {
        //若已经登录,把user对象添加到model对象中返回给前端
        UserAdd(model, request);
        //mybatis的插件
        PageParams_OMG pageParams = new PageParams_OMG();
        //获取数据库的第一页
        pageParams.setPage(1);
        //一页数据有6条信息
        pageParams.setPageSize(6);
        //通过service层获取标签为今日特惠的商品
        List<Food> prefersDayList = foodService.findPrefers("今日特惠", pageParams);
        //通过service层获取标签为今周特惠的商品
        List<Food> prefersWeekList = foodService.findPrefers("今周特惠", pageParams);
        //设置返回前端的index.html
        model.setViewName("index");
        //把获取到的数据添加到model对象中,用于前端数据的使用
        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);
        return model;
    }

    /**
     * 匹配url /login,获取登录的界面
     *
     * @param model
     * @return
     */
    @GetMapping("/login")
    public ModelAndView Glogin(ModelAndView model) {
        //返回login.html页面
        model.setViewName("login");
        return model;
    }

    /**
     * 匹配url /product
     * 返回商品的列表
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/product")
    public ModelAndView product(ModelAndView model, HttpServletRequest request) {
        //若已经登录,把user对象添加到model对象中返回给前端
        UserAdd(model, request);
        //获取request对象中的page和size值
        Integer page = getRequestValue(request, "page", 1, Integer.class);
        Integer size = getRequestValue(request, "size", 9, Integer.class);
        //mybatis的插件
        PageParams_OMG pageParams = new PageParams_OMG();
        //获取数据库的第page页
        pageParams.setPage(page);
        //一页数据有size条信息
        pageParams.setPageSize(size);
        //通过service层获取数据列表
        List<Food> foodList = foodService.findAll(pageParams);
        //返回product.html页面
        model.setViewName("product");
        //把数据添加到model对象中,返回给前端
        model.addObject("page", page);
        model.addObject("foodList", foodList);
        return model;
    }

    /**
     * 匹配url /single
     * 返回单个商品的页面
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/single")
    public ModelAndView single(ModelAndView model, HttpServletRequest request) {
        //若已经登录,把user对象添加到model对象中返回给前端
        UserAdd(model, request);
        //返回single.html页面
        model.setViewName("single");
        //获取request对象中的id值,该id值是对应数据库中的哪个商品
        String id = request.getParameter("id");
        //通过service层查找该商品
        Food food = foodService.find(id);
        //把数据添加到model对象中,返回给前端
        model.addObject("food", food);
        //通过service层找到对应该商品的所有评论
        List<Comment> listComments = commentService.findByGoodsId(Integer.valueOf(id));
        //通过一个循环遍历,把每条评论对应的用户信息添加进来
        for (int i = 0; i < listComments.size(); i++) {
            Long userId = listComments.get(i).getUser_id();
            User user = userService.find(userId);
            listComments.get(i).setUser(user);
        }
        //把数据添加到model对象中,返回给前端
        model.addObject("listComments", listComments);
        return model;
    }

    /**
     * 匹配 url /post 方法为post
     * 用户登录
     *
     * @param model
     * @param email
     * @param password
     * @param response
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ModelAndView Plogin(ModelAndView model,
                               @RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,
                               HttpServletResponse response,
                               HttpServletRequest request) {
        //根据email和password通过service层向数据库中获取该用户
        User auser = userService.selectByEmailAndPassword(email, password);
        //用户不存在则返回login.html重新登录
        if (auser == null) {
            model.setViewName("login");
            return model;
        }
        //根据email通过service层向数据库中获取该用户
        User user = userService.findByEmail(email);
        //把密码设置为空才可将user对象返回给前端
        user.setPassword(null);
        //把该用户存进redis
        helperLogin(response, user);
        //把用户添加到model对象
        UserAdd(model, request);
        //返回index.html页面
        model.setViewName("index");
        //mybatis插件
        PageParams_OMG pageParams = new PageParams_OMG();
        //返回第一页数据
        pageParams.setPage(1);
        //一页返回6条数据
        pageParams.setPageSize(6);
        //从数据库中获取标签为今日特惠和今周特惠的数据
        List<Food> prefersDayList = foodService.findPrefers("今日特惠", pageParams);
        List<Food> prefersWeekList = foodService.findPrefers("今周特惠", pageParams);
        //把数据添加到model对象中返回给前端
        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);
        return model;
    }


    /**
     * 匹配 url /search
     * 返回搜索的内容
     *
     * @param model
     * @param str
     * @param request
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(ModelAndView model,
                               @RequestParam(value = "search", required = true) String str,
                               HttpServletRequest request) {
        //若已经登录,把user对象添加到model对象中返回给前端
        UserAdd(model, request);
        //返回product.html页面
        model.setViewName("product");
        //通过正则表达式把搜索分割为数组,例如搜索为"好吃的 甜的"则变为["好吃的","甜的"]
        String[] strings = str.split("\\s+");
        //通过set集合去除重复元素
        Set<String> set = new HashSet<>();
        for (String string : strings) {
            set.add(string.trim());
        }
        ArrayList<Food> foodArrayList = new ArrayList<>();
        //通过service从数据库中搜索,并且把数据添加到集合中
        foodArrayList.addAll(foodService.search(set));
        //把数据添加到model对象返回给前端
        model.addObject("foodList", foodArrayList);
        return model;
    }


    /**
     * 匹配url /shop
     * 返回某一家商店
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/shop")
    public ModelAndView shop(ModelAndView model,
                             HttpServletRequest request) {
        //若已经登录,把user对象添加到model对象中返回给前端
        UserAdd(model, request);
        //返回shop.html页面
        model.setViewName("shop");
        //从request对象中获取shopId值
        Integer shopId = getRequestValue(request, "shopId", null, Integer.class);
        //mybatis插件
        PageParams_OMG pageParams = new PageParams_OMG();
        //设置第一页
        pageParams.setPage(1);
        //一页6条信息
        pageParams.setPageSize(6);
        //通过service层向数据库中获取标签为"今日特惠"和"今周特惠"的数据
        List<Food> prefersDayList = foodService.findPrefersAndShopId("今日特惠", shopId, pageParams);
        List<Food> prefersWeekList = foodService.findPrefersAndShopId("今周特惠", shopId, pageParams);

        //把数据添加到model对象中返回给前端
        model.addObject("prefersDayList", prefersDayList);
        model.addObject("prefersWeekList", prefersWeekList);
        //从request获取page和size值
        Integer page = getRequestValue(request, "page", 1, Integer.class);
        Integer size = getRequestValue(request, "size", 9, Integer.class);

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


    /**
     * 商店老板的后台管理
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/back")
    public ModelAndView back(ModelAndView model,
                             HttpServletRequest request) {
        User user = User(request);
        if (user == null || user.getType() == 1) {
            model.setViewName("login");
            return model;
        }
        Shop shop = shopService.findByBossId(user.getId());
        model.addObject("shop_id", shop.getId());
        UserAdd(model, request);
        model.setViewName("back");

        return model;
    }

    /**
     * 老板后台添加商品
     *
     * @param model
     * @param request
     * @param file
     * @return
     */
    @PostMapping("/addGoods")
    public ModelAndView addGoods(ModelAndView model,
                                 HttpServletRequest request,
                                 @RequestParam(value = "cover", required = true)
                                         CommonsMultipartFile file) {
        Enumeration<String> names = request.getParameterNames();
        Map<String, String> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            map.put(name, request.getParameter(name));
        }
        Food food = JsonUtil_OMG.parse(map.toString(), Food.class);
        food.setCover("images/" + file.getOriginalFilename());
        UploadHelper_OMG.upload(request, file);
        foodService.insert(food);
        User user = User(request);
        if (user == null || user.getType() == 1) {
            model.setViewName("login");
            return model;
        }
        Shop shop = shopService.findByBossId(user.getId());
        model.addObject("shop_id", shop.getId());
        UserAdd(model, request);
        model.setViewName("back");
        return model;
    }

    @GetMapping("/sell")
    public ModelAndView sell(ModelAndView model,
                             HttpServletRequest request) {
        UserAdd(model, request);
        Integer shopId = getRequestValue(request, "shopId", null, Integer.class);
        List<Food> listFood = foodService.findByShopId(shopId);
        List<SalesVolume> salesVolumeList = new LinkedList<>();
        listFood.forEach(food -> {
            SalesVolume salesVolume = salesVolumeService.findByGoods_id(food.getId());
            if (salesVolume.getCount() != 0) {
                salesVolume.setName(food.getGoods_name());
                salesVolumeList.add(salesVolume);
            }
        });
        model.setViewName("sell");
        model.addObject("salesVolumeList", salesVolumeList);
        return model;
    }
}


