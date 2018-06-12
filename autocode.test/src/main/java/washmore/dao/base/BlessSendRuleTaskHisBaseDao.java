package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendRuleTaskHis;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发对象_按工号(bless_send_rule_task_his)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessSendRuleTaskHisBaseDao {

	List<BlessSendRuleTaskHis> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendRuleTaskHis blessSendRuleTaskHis);

	int insertSelective(BlessSendRuleTaskHis blessSendRuleTaskHis);

	int updateByPrimaryKey(BlessSendRuleTaskHis blessSendRuleTaskHis);

	int updateByPrimaryKeySelective(BlessSendRuleTaskHis blessSendRuleTaskHis);

	int deleteByPrimaryKey(Long id);

	BlessSendRuleTaskHis selectByPrimaryKey(Long id);

	List<BlessSendRuleTaskHis> selectByExample(BlessSendRuleTaskHis example);

	int countByExample(BlessSendRuleTaskHis example);

}