package washmore.service;

import org.springframework.stereotype.Service;
import washmore.dao.ext.BlessSendRuleDao;
import washmore.model.BlessSendRule;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/12
 */
@Service
public class RuleService {
    @Resource
    BlessSendRuleDao blessSendRuleDao;

    public int countAll() {
        return blessSendRuleDao.countAll();
    }

    public List<BlessSendRule> selectAll() {
        return blessSendRuleDao.selectAll();
    }

    public List<BlessSendRule> selectByParams(Map<String, Object> params) {
        return blessSendRuleDao.selectByParams(params);
    }

    public int countByParams(Map<String, Object> params) {
        return blessSendRuleDao.countByParams(params);
    }

    public int insert(BlessSendRule blessSendRule) {
        return blessSendRuleDao.insert(blessSendRule);
    }

    public int insertSelective(BlessSendRule blessSendRule) {
        return blessSendRuleDao.insertSelective(blessSendRule);
    }

    public int updateByPrimaryKey(BlessSendRule blessSendRule) {
        return blessSendRuleDao.updateByPrimaryKey(blessSendRule);
    }

    public int updateByPrimaryKeySelective(BlessSendRule blessSendRule) {
        return blessSendRuleDao.updateByPrimaryKeySelective(blessSendRule);
    }

    public int deleteByPrimaryKey(Long id) {
        return blessSendRuleDao.deleteByPrimaryKey(id);
    }

    public BlessSendRule selectByPrimaryKey(Long id) {
        return blessSendRuleDao.selectByPrimaryKey(id);
    }

    public List<BlessSendRule> selectByExample(BlessSendRule example) {
        return blessSendRuleDao.selectByExample(example);
    }

    public int countByExample(BlessSendRule example) {
        return blessSendRuleDao.countByExample(example);
    }
}
