package prodDao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import prodVo.prodVO;

public class prodDaoImpl implements IProdDao {
	private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	private static IProdDao dao;

	private prodDaoImpl() {
	}

	public static IProdDao getInstance() {
		if (dao == null) {
			dao = new prodDaoImpl();
		}
		return dao;
	}

	@Override
	public List<prodVO> selectByLgu(String lgu) {
		List<prodVO> list = null;
		try {
			list = client.queryForList("prod.selectByLgu", lgu);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public prodVO selectById(String id) {
		prodVO vo = null;
		try {
			vo = (prodVO) client.queryForObject("prod.selectById", id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return vo;
	}

}
