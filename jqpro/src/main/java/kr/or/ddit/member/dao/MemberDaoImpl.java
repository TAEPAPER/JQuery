package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

// mapper접근 - SqlMapClient객체가 필요
// dao클래스 객체 생성해서 return (service에서 사용할~)
public class MemberDaoImpl implements IMemberDao {
    private SqlMapClient client;
    
    private static IMemberDao dao; //  MemberDaoImpl 대신 온 이유 : 다형성위해~! 
    private MemberDaoImpl() {
    	client = SqlMapClientFactory.getSqlMapClient();
	}
    public static IMemberDao getInstance() {
    	if (dao ==null) {
    		dao = new MemberDaoImpl();
    	}
        return dao;
    }
	
	@Override
	public List<MemberVO> selectAll() {
		
	List<MemberVO> list =null;
	try {
		list = client.queryForList("member.selectAll");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	    return list;	
	}
	@Override
	public String idCheck(String memId) {
		String idCheck = null;
		     try {
   idCheck=	(String) client.queryForObject("member.idCheck",memId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return idCheck;
	}
	@Override
	public List<ZipVO> zipList(String dong) {
		List<ZipVO> list = null;
		    try {
			list=	client.queryForList("zip.zipList",dong);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}
	@Override
	public String insertMember(MemberVO memberVO) {
		String id = null;
		           try {
	   id= (String) client.insert("member.insertMember",memberVO);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return id;
	}    





}

