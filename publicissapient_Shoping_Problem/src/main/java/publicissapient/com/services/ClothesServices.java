package publicissapient.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import publicissapient.com.dao.ClothesDAO;
import publicissapient.com.exception.ClotheAllReadyExistException;
import publicissapient.com.exception.NoDataFoundException;
import publicissapient.com.pojos.Clothes;

@Service
public class ClothesServices implements ClothesServiceInterface {

	@Autowired
	private ClothesDAO clothesDAO;
	
	public List<Clothes> getAllClothes(){
		List<Clothes> list = clothesDAO.getAllClothes();
		if(list.isEmpty()) {
			throw new NoDataFoundException();
		}
		return list;
	}


	@Override
	public Clothes getClotheById(Long id) {
		Clothes c = clothesDAO.getById(id);
		if( c == null) {
			throw new NoDataFoundException("Id : "+id+" not found in DB",HttpStatus.NOT_FOUND);
		}
		return c;
	}

	@Override
	public Long saveOrUpdateClothes(Clothes c) {
		Clothes clothes = clothesDAO.getById(c.getId());
		if( clothes == null) {
			return  clothesDAO.createClothe(c); 
		}else {
			throw new ClotheAllReadyExistException(clothes.toString(),HttpStatus.CONFLICT);
		}
		
	}


	@Override
	public void deleteClothe(long id) {
		Clothes c = clothesDAO.getById(id);
		if( c == null) {
			throw new NoDataFoundException("Id : "+id+" not found in DB",HttpStatus.NOT_FOUND);
		}
		clothesDAO.delete(c);
		
	}


	
}
