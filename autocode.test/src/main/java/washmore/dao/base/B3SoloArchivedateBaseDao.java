package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloArchivedate;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_archivedate)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloArchivedateBaseDao {

	int insert(B3SoloArchivedate b3SoloArchivedate);

	int insertSelective(B3SoloArchivedate b3SoloArchivedate);

	int updateByPrimaryKey(B3SoloArchivedate b3SoloArchivedate);

	int updateByPrimaryKeySelective(B3SoloArchivedate b3SoloArchivedate);

	int deleteByPrimaryKey(String oid);

	B3SoloArchivedate selectByPrimaryKey(String oid);

	List<B3SoloArchivedate> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}