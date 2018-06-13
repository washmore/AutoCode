package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessScanH5Task;
/**
 * @author Washmore
 * @version V1
 * @summary 针对H5浏览任务(bless_scan_h5_task)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessScanH5TaskBaseDao {

	List<BlessScanH5Task> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessScanH5Task blessScanH5Task);

	int insertSelective(BlessScanH5Task blessScanH5Task);

	int updateByPrimaryKey(BlessScanH5Task blessScanH5Task);

	int updateByPrimaryKeySelective(BlessScanH5Task blessScanH5Task);

	int deleteByPrimaryKey(Long id);

	BlessScanH5Task selectByPrimaryKey(Long id);

	List<BlessScanH5Task> selectByExample(BlessScanH5Task example);

	int countByExample(BlessScanH5Task example);

}