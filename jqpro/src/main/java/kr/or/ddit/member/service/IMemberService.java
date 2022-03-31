package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	
	
	public List<MemberVO> selectAll();
	
	public String idCheck(String memId); 
	
	//우편번호검색 메소드
public List<ZipVO> zipList(String dong);		

	//저장하기

public String insertMember(MemberVO memberVO);
	
	
	
}
