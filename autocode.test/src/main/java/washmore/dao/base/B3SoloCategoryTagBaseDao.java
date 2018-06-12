package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloCategoryTag;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_category_tag)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloCategoryTagBaseDao {

	int insert(B3SoloCategoryTag b3SoloCategoryTag);

	int insertSelective(B3SoloCategoryTag b3SoloCategoryTag);

	int updateByPrimaryKey(B3SoloCategoryTag b3SoloCategoryTag);

	int updateByPrimaryKeySelective(B3SoloCategoryTag b3SoloCategoryTag);

	int deleteByPrimaryKey(String oid);

	B3SoloCategoryTag selectByPrimaryKey(String oid);

	List<B3SoloCategoryTag> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}