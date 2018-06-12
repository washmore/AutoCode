package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloComment;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_comment)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloCommentBaseDao {

	int insert(B3SoloComment b3SoloComment);

	int insertSelective(B3SoloComment b3SoloComment);

	int updateByPrimaryKey(B3SoloComment b3SoloComment);

	int updateByPrimaryKeySelective(B3SoloComment b3SoloComment);

	int deleteByPrimaryKey(String oid);

	B3SoloComment selectByPrimaryKey(String oid);

	List<B3SoloComment> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}