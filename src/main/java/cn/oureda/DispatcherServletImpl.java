package cn.oureda;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by webhugo on 3/30/17.
 */
public class DispatcherServletImpl extends DispatcherServlet {
    static {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties props = new Properties();
        String filePath = path + "log4j.properties";
        try {
            FileInputStream log4jStream = new FileInputStream(filePath);
            props.load(log4jStream);
            log4jStream.close();

            Map<String, String> map = System.getenv();
            String home = map.get("HOME");
            if (home.endsWith("/")) {
                home = home.substring(0, home.length() - 1);
            }
            props.setProperty("log4j.appender.appender2.File", home + "/info.log");
            PropertyConfigurator.configure(props); //装入log4j配置信息
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
