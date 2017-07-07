package db;

import cn.oureda.dao.CommentDao;
import cn.oureda.dao.FoodDao;
import cn.oureda.dao.ShopDao;
import cn.oureda.dao.UserDao;
import cn.oureda.entity.Comment;
import cn.oureda.entity.Food;
import cn.oureda.entity.Shop;
import cn.oureda.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by webhugo on 17-7-5.
 */
public class Migrate {
    InputStream init() {
        String resource = "test/mybatis-config.xml";

        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println(classLoader.getResource(resource).getPath());
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();
        run.exec("make migrate");

        Migrate migrate = new Migrate();

        InputStream inputStream = migrate.init();

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        FoodDao foodDao = session.getMapper(FoodDao.class);
        ShopDao shopDao = session.getMapper(ShopDao.class);
        UserDao userDao = session.getMapper(UserDao.class);
        CommentDao commentDao = session.getMapper(CommentDao.class);

        try {
            User user = new User();
            user.setEmail("ch.shanchuan@gmail.com");
            user.setPassword("123");
            user.setType(1);
            user.setCreate_time(System.currentTimeMillis());
            user.setUpdate_time(System.currentTimeMillis());
            User user1 = new User();
            user1.setEmail("webhugo@gmail.com");
            user1.setPassword("123");
            user1.setType(2);
            user1.setCreate_time(System.currentTimeMillis());
            user1.setUpdate_time(System.currentTimeMillis());
            userDao.insert(user1);
            userDao.insert(user);


            Food food = new Food();
            food.setCount(10);
            food.setCover("images/1.png");
            food.setGoods_name("Tata-sal");
            food.setOrigin_price(35.00);
            food.setPrice(20.99);
            food.setShop_id(10000L);
            food.setCreate_time(System.currentTimeMillis());
            food.setUpdate_time(System.currentTimeMillis());
            food.setSell_num(0);
            food.setClick_num(0);
            food.setType("食物");
            food.setFlag("今日特惠");
            food.setDescription("这种食物有益健康,养颜美白");
            Food food1 = new Food();
            food1.setCount(10);
            food1.setCover("images/2.png");
            food1.setGoods_name("Fortune-sunflowe");
            food1.setOrigin_price(35.00);
            food1.setPrice(20.99);
            food1.setShop_id(10000L);
            food1.setCreate_time(System.currentTimeMillis());
            food1.setUpdate_time(System.currentTimeMillis());
            food1.setSell_num(0);
            food1.setClick_num(0);
            food1.setType("食物");
            food1.setDescription("这种食物有益健康,养颜美白");
            food1.setFlag("今日特惠");
            Food food2 = new Food();
            food2.setCount(10);
            food2.setCover("images/3.png");
            food2.setGoods_name("Aashirvaad-atta");
            food2.setOrigin_price(65.00);
            food2.setPrice(20.99);
            food2.setShop_id(10000L);
            food2.setCreate_time(System.currentTimeMillis());
            food2.setUpdate_time(System.currentTimeMillis());
            food2.setSell_num(0);
            food2.setClick_num(0);
            food2.setType("食物");
            food2.setDescription("这种食物有益健康,养颜美白");
            food2.setFlag("今日特惠");
            Food food3 = new Food();
            food3.setGoods_name("Sampann-toor-dal");
            food3.setCount(10);
            food3.setCover("images/4.png");
            food3.setOrigin_price(35.99);
            food3.setPrice(55.00);
            food3.setShop_id(10000L);
            food3.setCreate_time(System.currentTimeMillis());
            food3.setUpdate_time(System.currentTimeMillis());
            food3.setSell_num(0);
            food3.setClick_num(0);
            food3.setType("食物");
            food3.setDescription("这种食物有益健康,养颜美白");
            food3.setFlag("今日特惠");
            Food food4 = new Food();
            food4.setGoods_name("Parryss-Sugar");
            food4.setCount(10);
            food4.setCover("images/5.png");
            food4.setOrigin_price(30.99);
            food4.setPrice(45.00);
            food4.setShop_id(10000L);
            food4.setCreate_time(System.currentTimeMillis());
            food4.setUpdate_time(System.currentTimeMillis());
            food4.setSell_num(0);
            food4.setClick_num(0);
            food4.setType("食物");
            food4.setDescription("这种食物有益健康,养颜美白");
            food4.setFlag("今日特惠");
            Food food5 = new Food();
            food5.setGoods_name("Saffola-Gold");
            food5.setCount(10);
            food5.setCover("images/6.png");
            food5.setOrigin_price(80.99);
            food5.setPrice(105.00);
            food5.setShop_id(10000L);
            food5.setCreate_time(System.currentTimeMillis());
            food5.setUpdate_time(System.currentTimeMillis());
            food5.setSell_num(0);
            food5.setClick_num(0);
            food5.setType("食物");
            food5.setDescription("这种食物有益健康,养颜美白");
            food5.setFlag("今日特惠");
            foodDao.insert(food);
            foodDao.insert(food1);
            foodDao.insert(food2);
            foodDao.insert(food3);
            foodDao.insert(food4);
            foodDao.insert(food5);


            food.setCount(10);
            food.setCover("images/7.png");
            food.setGoods_name("Sona-Masoori-Rice");
            food.setOrigin_price(35.99);
            food.setPrice(50.00);
            food.setShop_id(10000L);
            food.setCreate_time(System.currentTimeMillis());
            food.setUpdate_time(System.currentTimeMillis());
            food.setSell_num(0);
            food.setClick_num(0);
            food.setType("食物");
            food.setFlag("今周特惠");
            food.setDescription("这种食物有益健康,养颜美白");
            food.setId(null);

            food1.setCount(10);
            food1.setCover("images/8.png");
            food1.setGoods_name("Milky-Mist-Paneer");
            food1.setOrigin_price(30.99);
            food1.setPrice(45.00);
            food1.setShop_id(10000L);
            food1.setCreate_time(System.currentTimeMillis());
            food1.setUpdate_time(System.currentTimeMillis());
            food1.setSell_num(0);
            food1.setClick_num(0);
            food1.setType("食物");
            food1.setDescription("这种食物有益健康,养颜美白");
            food1.setFlag("今周特惠");
            food1.setId(null);

            food2.setCount(10);
            food2.setCover("images/9.png");
            food2.setGoods_name("Basmati-Rice");
            food2.setOrigin_price(80.99);
            food2.setPrice(105.00);
            food2.setShop_id(10000L);
            food2.setCreate_time(System.currentTimeMillis());
            food2.setUpdate_time(System.currentTimeMillis());
            food2.setSell_num(0);
            food2.setClick_num(0);
            food2.setType("食物");
            food2.setDescription("这种食物有益健康,养颜美白");
            food2.setFlag("今周特惠");
            food2.setId(null);

            food3.setGoods_name("Fortune-Sunflower");
            food3.setCount(10);
            food3.setCover("images/10.png");
            food3.setOrigin_price(20.99);
            food3.setPrice(35.00);
            food3.setShop_id(10000L);
            food3.setCreate_time(System.currentTimeMillis());
            food3.setUpdate_time(System.currentTimeMillis());
            food3.setSell_num(0);
            food3.setClick_num(0);
            food3.setType("食物");
            food3.setDescription("这种食物有益健康,养颜美白");
            food3.setFlag("今周特惠");
            food3.setId(null);

            food4.setGoods_name("Nestle-A-Slim");
            food4.setCount(10);
            food4.setCover("images/12.png");
            food4.setOrigin_price(20.99);
            food4.setPrice(35.00);
            food4.setShop_id(10000L);
            food4.setCreate_time(System.currentTimeMillis());
            food4.setUpdate_time(System.currentTimeMillis());
            food4.setSell_num(0);
            food4.setClick_num(0);
            food4.setType("食物");
            food4.setDescription("这种食物有益健康,养颜美白");
            food4.setFlag("今周特惠");
            food4.setId(null);

            food5.setGoods_name("Bread-Sandwich");
            food5.setCount(10);
            food5.setCover("images/13.png");
            food5.setOrigin_price(40.99);
            food5.setPrice(65.00);
            food5.setShop_id(10000L);
            food5.setCreate_time(System.currentTimeMillis());
            food5.setUpdate_time(System.currentTimeMillis());
            food5.setSell_num(0);
            food5.setClick_num(0);
            food5.setType("食物");
            food5.setDescription("这种食物有益健康,养颜美白");
            food5.setFlag("今周特惠");
            food5.setId(null);
            foodDao.insert(food);
            foodDao.insert(food1);
            foodDao.insert(food2);
            foodDao.insert(food3);
            foodDao.insert(food4);
            foodDao.insert(food5);



            Food food6 = new Food();
            food6.setGoods_name("Sampann-toor-dal");
            food6.setPrice(35.99);
            food6.setOrigin_price(55.00);
            food6.setCount(10);
            food6.setCover("images/pf4.png");
            food6.setShop_id(10000L);
            food6.setCreate_time(System.currentTimeMillis());
            food6.setUpdate_time(System.currentTimeMillis());
            food6.setSell_num(0);
            food6.setClick_num(0);
            food6.setType("食物");
            food6.setDescription("这种食物有益健康,养颜美白");
            food6.setFlag("今周特惠");


            Food food7 = new Food();
            food7.setGoods_name("Parryss-sugar");
            food7.setPrice(30.99);
            food7.setOrigin_price(45.00);
            food7.setCount(10);
            food7.setCover("images/bv3.png");
            food7.setShop_id(10000L);
            food7.setCreate_time(System.currentTimeMillis());
            food7.setUpdate_time(System.currentTimeMillis());
            food7.setSell_num(0);
            food7.setClick_num(0);
            food7.setType("食物");
            food7.setDescription("这种食物有益健康,养颜美白");
            food7.setFlag("今周特惠");


            Food food8 = new Food();
            food8.setGoods_name("Saffola-gold");
            food8.setPrice(80.99);
            food8.setOrigin_price(105.00);
            food8.setCount(10);
            food8.setCover("images/16.png");
            food8.setShop_id(10000L);
            food8.setCreate_time(System.currentTimeMillis());
            food8.setUpdate_time(System.currentTimeMillis());
            food8.setSell_num(0);
            food8.setClick_num(0);
            food8.setType("食物");
            food8.setDescription("这种食物有益健康,养颜美白");
            food8.setFlag("今周特惠");


            Food food9 = new Food();
            food9.setGoods_name("Sampann-toor-dal");
            food9.setPrice(35.99);
            food9.setOrigin_price(55.00);
            food9.setCount(10);
            food9.setCover("images/16.png");
            food9.setShop_id(10000L);
            food9.setCreate_time(System.currentTimeMillis());
            food9.setUpdate_time(System.currentTimeMillis());
            food9.setSell_num(0);
            food9.setClick_num(0);
            food9.setType("食物");
            food9.setDescription("这种食物有益健康,养颜美白");
            food9.setFlag("今周特惠");

            foodDao.insert(food6);
            foodDao.insert(food7);
            foodDao.insert(food8);
            foodDao.insert(food9);


            Shop shop = new Shop();
            shop.setBoss_id(1000L);
            shop.setCover("1.png");
            shop.setDescription("主要经营食品小吃");
            shop.setShop_name("OMG");
            shop.setCreate_time(System.currentTimeMillis());
            shop.setUpdate_time(System.currentTimeMillis());
            shopDao.insert(shop);

            Comment comment = new Comment();
            comment.setContent("好吃!");
            comment.setGoods_id(1000L);
            comment.setUser_id(1000L);
            comment.setCreate_time(System.currentTimeMillis());
            comment.setUpdate_time(System.currentTimeMillis());
            commentDao.insert(comment);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }
}
