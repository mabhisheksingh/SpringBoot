package publicissapient.com.dao;

import java.util.List;

import publicissapient.com.pojos.Clothes;

public interface ClothesDAOInterface {
	public List<Clothes> getAllClothes();
	public void saveAllClothes(List<Clothes> list);
	public void delete(Clothes c);
	public Clothes getById(Long id);
	public Long createClothe(Clothes c);
}
