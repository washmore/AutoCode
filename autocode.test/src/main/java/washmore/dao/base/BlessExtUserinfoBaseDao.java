package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessExtUserinfo;
/**
 * @author Washmore
 * @version V1
 * @summary 针对个人配置信息(bless_ext_userinfo)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessExtUserinfoBaseDao {

	List<BlessExtUserinfo> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessExtUserinfo blessExtUserinfo);

	int insertSelective(BlessExtUserinfo blessExtUserinfo);

	int updateByPrimaryKey(BlessExtUserinfo blessExtUserinfo);

	int updateByPrimaryKeySelective(BlessExtUserinfo blessExtUserinfo);

	int deleteByPrimaryKey(Long id);

	BlessExtUserinfo selectByPrimaryKey(Long id);

	List<BlessExtUserinfo> selectByExample(BlessExtUserinfo example);

	int countByExample(BlessExtUserinfo example);

}