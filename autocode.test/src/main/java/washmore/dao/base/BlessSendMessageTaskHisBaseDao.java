package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendMessageTaskHis;
/**
 * @author Washmore
 * @version V1
 * @summary 针对文案发送任务历史表(bless_send_message_task_his)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessSendMessageTaskHisBaseDao {

	List<BlessSendMessageTaskHis> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendMessageTaskHis blessSendMessageTaskHis);

	int insertSelective(BlessSendMessageTaskHis blessSendMessageTaskHis);

	int updateByPrimaryKey(BlessSendMessageTaskHis blessSendMessageTaskHis);

	int updateByPrimaryKeySelective(BlessSendMessageTaskHis blessSendMessageTaskHis);

	int deleteByPrimaryKey(Long id);

	BlessSendMessageTaskHis selectByPrimaryKey(Long id);

	List<BlessSendMessageTaskHis> selectByExample(BlessSendMessageTaskHis example);

	int countByExample(BlessSendMessageTaskHis example);

}