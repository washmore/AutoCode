package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessJiaxinNoticeUser;
/**
 * @author Washmore
 * @version V1
 * @summary 针对Link主题包(bless_jiaxin_notice_user)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessJiaxinNoticeUserBaseDao {

	List<BlessJiaxinNoticeUser> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessJiaxinNoticeUser blessJiaxinNoticeUser);

	int insertSelective(BlessJiaxinNoticeUser blessJiaxinNoticeUser);

	int updateByPrimaryKey(BlessJiaxinNoticeUser blessJiaxinNoticeUser);

	int updateByPrimaryKeySelective(BlessJiaxinNoticeUser blessJiaxinNoticeUser);

	int deleteByPrimaryKey(Long id);

	BlessJiaxinNoticeUser selectByPrimaryKey(Long id);

	List<BlessJiaxinNoticeUser> selectByExample(BlessJiaxinNoticeUser example);

	int countByExample(BlessJiaxinNoticeUser example);

}