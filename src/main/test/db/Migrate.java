package db;

import cn.oureda.dao.FoodDao;
import cn.oureda.entity.Food;
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

        try {
            Food food = new Food();
            food.setCount(10);
            food.setCover("1.png");
            food.setGoodsName("Tata-sal");
            food.setOriginPrice(35.00);
            food.setPrice(20.99);
            Food food1 = new Food();
            food.setCount(10);
            food.setCover("2.png");
            food.setGoodsName("Fortune-sunflowe");
            food.setOriginPrice(35.00);
            food.setPrice(20.99);
            foodDao.insert(food);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }
}
