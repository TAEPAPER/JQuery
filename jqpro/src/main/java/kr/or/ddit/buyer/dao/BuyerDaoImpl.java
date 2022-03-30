package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao {
    private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	//싱글톤
	private static IBuyerDao dao;
	//생성자
	private BuyerDaoImpl() {
		
	}
	//3번
	public static IBuyerDao getInstance() {
		if(dao ==null) {
			dao = new BuyerDaoImpl();
		}
		return dao;
	}
	

	@Override
	public List<BuyerVO> selectByName() {
		    List<BuyerVO> list = null;
		      try {
				list =  client.queryForList("buyer.selectByName");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return list;
	}

	@Override
	public BuyerVO idByDetail(String buyerId) {
		BuyerVO vo = null;
		try {
			vo = (BuyerVO) client.queryForObject("buyer.idByDetail", buyerId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("dao buyerId = " + buyerId);
		return vo;
	}

}
