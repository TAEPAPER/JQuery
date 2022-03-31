package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {
	private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	private static ILprodDao dao;

	public LprodDaoImpl() {

	}

	public static ILprodDao getInstance() {
		if (dao == null) {
			dao = new LprodDaoImpl();
		}
		return dao;
	}

	@Override
	public List<LprodVO> selectAll() {
		List<LprodVO> list = null;
		
		try {
		list = client.queryForList("lprod.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
