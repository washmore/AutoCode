package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendMessageTask;
/**
 * @author Washmore
 * @version V1
 * @summary 针对文案发送任务(bless_send_message_task)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessSendMessageTaskBaseDao {

	List<BlessSendMessageTask> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendMessageTask blessSendMessageTask);

	int insertSelective(BlessSendMessageTask blessSendMessageTask);

	int updateByPrimaryKey(BlessSendMessageTask blessSendMessageTask);

	int updateByPrimaryKeySelective(BlessSendMessageTask blessSendMessageTask);

	int deleteByPrimaryKey(Long id);

	BlessSendMessageTask selectByPrimaryKey(Long id);

	List<BlessSendMessageTask> selectByExample(BlessSendMessageTask example);

	int countByExample(BlessSendMessageTask example);

}