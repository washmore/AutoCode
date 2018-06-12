package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessScanH5TaskHis;
/**
 * @author Washmore
 * @version V1
 * @summary 针对H5浏览任务_his(bless_scan_h5_task_his)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessScanH5TaskHisBaseDao {

	List<BlessScanH5TaskHis> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessScanH5TaskHis blessScanH5TaskHis);

	int insertSelective(BlessScanH5TaskHis blessScanH5TaskHis);

	int updateByPrimaryKey(BlessScanH5TaskHis blessScanH5TaskHis);

	int updateByPrimaryKeySelective(BlessScanH5TaskHis blessScanH5TaskHis);

	int deleteByPrimaryKey(Long id);

	BlessScanH5TaskHis selectByPrimaryKey(Long id);

	List<BlessScanH5TaskHis> selectByExample(BlessScanH5TaskHis example);

	int countByExample(BlessScanH5TaskHis example);

}