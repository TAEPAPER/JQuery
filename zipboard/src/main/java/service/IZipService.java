package service;

import java.util.List;
import java.util.Map;

import vo.ZipVO;

public interface IZipService {
   public List<String>  selectSido();
   public List<String>  selectGugun(String sido);
   public List<String>  selectDong(Map<String, String> map);
   public List<ZipVO>  selectAddr(ZipVO  vo);   
}
