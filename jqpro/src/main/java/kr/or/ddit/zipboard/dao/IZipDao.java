package kr.or.ddit.zipboard.dao;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.member.vo.ZipVO;

public interface IZipDao {

	public List<String> selectSido();
	public List<String> selectGugun(String sido);
	public List<String> selectDong(ZipVO zipVO);
	
	public List<ZipVO> selectDetail(ZipVO zipVO);
	
	
	
}
