package memberDao;

import java.util.List;

import memberVO.MemberVO;
import memberVO.ZipVO;

public interface IMemberDao {
   //아이디 중복검사 
	public String idCheck (String memId);
	
	//회원정보 저장하기
	public String insertMem (MemberVO memvo);
	
	//우편번호 검색!
	public List<ZipVO> zipList(String dong);
	
	
}
