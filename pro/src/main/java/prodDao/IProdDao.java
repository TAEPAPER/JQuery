package prodDao;

import java.util.List;

import prodVo.prodVO;

public interface IProdDao {

	public List<prodVO> selectByLgu(String lgu);
	public prodVO selectById(String id);
	
}
