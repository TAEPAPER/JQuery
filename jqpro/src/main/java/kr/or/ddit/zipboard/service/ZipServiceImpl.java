package kr.or.ddit.zipboard.service;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.zipboard.dao.IZipDao;
import kr.or.ddit.zipboard.dao.ZipDaoImpl;

public class ZipServiceImpl implements IZipService {
    private IZipDao dao;
    private static IZipService service;
    private ZipServiceImpl() {
		dao = ZipDaoImpl.getInstance();
	}
	public static IZipService getInstance() {
		if(service == null) {
			service = new ZipServiceImpl(); 
		}
		return service;
	}
    
	
	@Override
	public List<String> selectSido() {
		// TODO Auto-generated method stub
		return dao.selectSido();
	}

	@Override
	public List<String> selectGugun(String sido) {
		// TODO Auto-generated method stub
		return dao.selectGugun(sido);
	}

	@Override
	public List<String> selectDong(ZipVO zipVO) {
		// TODO Auto-generated method stub
		return dao.selectDong(zipVO);
	}

	@Override
	public List<ZipVO> selectDetail(ZipVO zipVO) {
		 
		return dao.selectDetail(zipVO);
	}

}
