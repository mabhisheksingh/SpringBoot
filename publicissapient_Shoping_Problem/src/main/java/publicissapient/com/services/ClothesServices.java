package publicissapient.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import publicissapient.com.dao.ClothesDAO;
import publicissapient.com.pojos.Clothes;

@Service
public class ClothesServices {

	@Autowired
	private ClothesDAO clothesDAO;
	
	public List<Clothes> getAllClothes(){
		return clothesDAO.getAllClothes();
	}
	
}
