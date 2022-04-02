package kr.or.ddit.zipboard.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.ZipVO;

public class ZipDaoImpl implements IZipDao {
	private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	private static IZipDao dao;

	private ZipDaoImpl() {

	}

	public static IZipDao getInstance() {
		if (dao == null) {
			dao = new ZipDaoImpl();
		}
		return dao;
	}

	@Override
	public List<String> selectSido() {
		List<String> list = null;
		try {
			list = client.queryForList("zipboard.selectSido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectGugun(String sido) {
		List<String> list = null;
		try {
			list = client.queryForList("zipboard.selectGugun", sido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectDong(ZipVO zipVO) {
		List<String> list = null;
		try {
			list = client.queryForList("zipboard.selectDong",zipVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override //동구하기 (sido와gugun을 파라미터로 넘겨줘서!)
	public List<ZipVO> selectDetail(ZipVO zipVO) {
		List<ZipVO> list =null;
		try {
		    list = client.queryForList("zipboard.selectDetail",zipVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
