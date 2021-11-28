package publicissapient.com.dao;

import java.util.List;

import publicissapient.com.pojos.Clothes;
import publicissapient.com.pojos.Image;

public interface ClothesDAOInterface {
	public List<Clothes> getAllClothes();
	public void saveAllClothes(List<Clothes> list);
	public void delete(Clothes c);
	public Clothes getById(Long id);
	public Long createClothe(Clothes c);
	public String saveImage(Image image) ;
	public Image getImage(Long id);
}
