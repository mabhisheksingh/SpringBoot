package publicissapient.com.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
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

	//redis cache methods work as a database
	public Clothes saveClothesredis(Clothes clothes);
	public List<Clothes> getAllClothesredis();

	//redis as a cache
	public Clothes getClothesredis(@PathVariable Long id);
}
