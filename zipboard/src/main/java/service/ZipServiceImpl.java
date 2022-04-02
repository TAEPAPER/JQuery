package service;

import java.util.List;
import java.util.Map;

import dao.IZipDao;
import dao.ZipDaoImpl;
import vo.ZipVO;

public class ZipServiceImpl  implements IZipService{

	private IZipDao  dao;
	private static IZipService service;
	
	private ZipServiceImpl() {
		dao = ZipDaoImpl.getInstance();
	}
	
	public static IZipService getInstance() {
		if(service == null) service = new ZipServiceImpl();
		
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
	public List<String> selectDong(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectDong(map);
	}

	@Override
	public List<ZipVO> selectAddr(ZipVO vo) {
		// TODO Auto-generated method stub
		return dao.selectAddr(vo);
	}

}
