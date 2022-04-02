package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import vo.ZipVO;

public class ZipDaoImpl  implements IZipDao{

	private SqlMapClient  client;
	private static IZipDao  dao;
	
	
	private ZipDaoImpl() {
		client =SqlMapClientFactory.getSqlMapClient();
	}
	
	public static  IZipDao getInstance() {
		if(dao == null)  dao = new ZipDaoImpl();
		
		return dao;
	}
	@Override
	public List<String> selectSido() {
		List<String>  list= null;
		try {
			list = client.queryForList("zip.selectSido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectGugun(String sido) {
		List<String>  list= null;
		try {
			list = client.queryForList("zip.selectGugun",sido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> selectDong(Map<String, String> map) {
		List<String>  list= null;
		try {
			list = client.queryForList("zip.selectDong",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<vo.ZipVO> selectAddr(ZipVO vo) {
		List<ZipVO>  list= null;
		try {
			list = client.queryForList("zip.selectAddr",vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
