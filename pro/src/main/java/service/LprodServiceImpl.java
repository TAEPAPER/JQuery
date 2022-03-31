package service;

import java.util.List;

import dao.ILprodDao;
import dao.LprodDaoImpl;
import vo.LprodVO;

public class LprodServiceImpl implements ILprodService {

	private static ILprodService service;
	private ILprodDao dao;
	private LprodServiceImpl() {
	     dao = LprodDaoImpl.getInstance();
	}
	public static ILprodService getInstance() {
		if(service ==null) {
			service = new LprodServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<LprodVO> selectAll() {
		return dao.selectAll();
	}

}
