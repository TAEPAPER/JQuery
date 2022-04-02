package memberService;

import java.util.List;

import memberVO.MemberVO;
import memberVO.ZipVO;

public interface IMemberService {
	     //아이디 중복검사 
		public String idCheck (String memId);
		
		//회원정보 저장하기
		public String insertMem (MemberVO memvo);
		
		public List<ZipVO> zipList(String dong);
}
