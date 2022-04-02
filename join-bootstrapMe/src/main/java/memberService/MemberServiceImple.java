package memberService;

import java.util.List;

import memberDao.IMemberDao;
import memberDao.MemberDaoImpl;
import memberVO.MemberVO;
import memberVO.ZipVO;

public class MemberServiceImple implements IMemberService {
    private static IMemberService service;
    private IMemberDao dao;
    private MemberServiceImple() {
	       dao = MemberDaoImpl.getInstance(); 
	}
    public static IMemberService getInstance() {
    	if(service ==null) {
    		service = new MemberServiceImple();
    	}
    	return service;
    }
	
	@Override
	public String idCheck(String memId) {
		// TODO Auto-generated method stub
		return dao.idCheck(memId);
	}

	@Override
	public String insertMem(MemberVO memvo) {
		// TODO Auto-generated method stub
		return dao.insertMem(memvo);
	}
	@Override
	public List<ZipVO> zipList(String dong) {
		// TODO Auto-generated method stub
		return dao.zipList(dong);
	}

}
