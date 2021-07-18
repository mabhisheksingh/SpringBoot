package publicissapient.com.services;

import java.util.List;

import publicissapient.com.pojos.Clothes;

public interface ClothesServiceInterface {
	
	public List<Clothes> getAllClothes();
	public void deleteClothe(long id);
	public Clothes getClotheById(Long id);
	public Long saveOrUpdateClothes(Clothes c);

}
