package washmore.service;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import washmore.model.BlessSendRule;

import java.util.List;

/**
 * RuleService Tester.
 *
 * @author Washmore
 * @version 1.0
 * @since <pre>06/12/2018</pre>
 */
public class RuleServiceTest extends BaseTest {
    @Autowired
    private RuleService ruleService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectByParams(Map<String, Object> params)
     */
    @Test
    public void testSelectByParams() throws Exception {
        //TODO: Test goes here...
        System.out.println(ruleService.selectByParams(null));
    }

    /**
     * Method: countByParams(Map<String, Object> params)
     */
    @Test
    public void testCountByParams() throws Exception {
        //TODO: Test goes here...
        //ruleService.countByParams();
    }

    /**
     * Method: insert(BlessSendRule blessSendRule)
     */
    @Test
    public void testInsert() throws Exception {
        //TODO: Test goes here...
        //ruleService.insert();
    }

    /**
     * Method: insertSelective(BlessSendRule blessSendRule)
     */
    @Test
    public void testInsertSelective() throws Exception {
        //TODO: Test goes here...
        //ruleService.insertSelective();
    }

    /**
     * Method: updateByPrimaryKey(BlessSendRule blessSendRule)
     */
    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        //TODO: Test goes here...
        //ruleService.updateByPrimaryKey();
    }

    /**
     * Method: updateByPrimaryKeySelective(BlessSendRule blessSendRule)
     */
    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        //TODO: Test goes here...
        //ruleService.updateByPrimaryKeySelective();
    }

    /**
     * Method: deleteByPrimaryKey(Long id)
     */
    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        //TODO: Test goes here...
        //ruleService.deleteByPrimaryKey();
    }

    /**
     * Method: selectByPrimaryKey(Long id)
     */
    @Test
    public void testSelectByPrimaryKey() throws Exception {
        //TODO: Test goes here...
        //ruleService.selectByPrimaryKey();
    }

    /**
     * Method: selectByExample(BlessSendRule example)
     */
    @Test
    public void testSelectByExample() throws Exception {
        //TODO: Test goes here...
        List<BlessSendRule> rules = ruleService.selectByParams(null);
        System.out.println(rules);
        System.out.println();
        System.out.println(ruleService.selectByExample(rules.get(0)));
    }

    /**
     * Method: countByExample(BlessSendRule example)
     */
    @Test
    public void testCountByExample() throws Exception {
        //TODO: Test goes here...
        //ruleService.countByExample();
    }

    /**
     * Method: countAll()
     */
    @Test
    public void testCountAll() throws Exception {
        //TODO: Test goes here...
        System.out.println(ruleService.countAll());
    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
        //TODO: Test goes here...
        System.out.println(ruleService.selectAll());
    }
} 
