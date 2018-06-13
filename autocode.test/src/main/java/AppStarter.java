
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Washmore
 * @version V1.0
 * @summary 项目入口, 启动器
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/2/27
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = "washmore")
@MapperScan("washmore.dao.ext")//使用单独的@Mapper更清晰
public class AppStarter extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(AppStarter.class);
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(AppStarter.class, args);
            System.out.println("---------------正常启动--^_^------------#####################################");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("---------------启动挂了--T_T------------#####################################");
        }
    }
}
