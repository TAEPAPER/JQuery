package memberDao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import memberVO.MemberVO;
import memberVO.ZipVO;

public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	private static IMemberDao dao;

	private MemberDaoImpl() {

	}

	public static IMemberDao getInstance() {
		if (dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	@Override
	public String idCheck(String memId) {
		String checkId = null;
		try {
			checkId = (String) client.queryForObject("member.idCheck", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkId;
	}

	@Override
	public String insertMem(MemberVO memvo) { // insert가 성공하면 성공한 id를 리턴해준다~!
		String joinId = null;
		try {
			joinId = (String) client.insert("member.insertMem", memvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return joinId;
	}

	@Override
	public List<ZipVO> zipList(String dong) {
		   List<ZipVO> list = null;
		try {
			list = client.queryForList("zip.zipList", dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}
