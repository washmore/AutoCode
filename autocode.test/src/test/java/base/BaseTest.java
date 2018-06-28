package base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tech.washmore.AppStarter;

/**
 * @author Washmore
 * @version V1.0
 * @summary 基础测试类
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/1/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStarter.class)
@WebAppConfiguration  //开启web上下文测试
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
}
