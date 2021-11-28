package publicissapient.com.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import publicissapient.com.pojos.ClotheBuyingAcknowledgement;
import publicissapient.com.pojos.ClotheBuyingRequest;
import publicissapient.com.pojos.Clothes;
import publicissapient.com.pojos.Image;

import javax.persistence.Id;

public interface ClothesServiceInterface {
	
	public List<Clothes> getAllClothes();
	public void deleteClothe(long id);
	public Clothes getClotheById(Long id);
	public Long saveOrUpdateClothes(Clothes c);
	public ClotheBuyingAcknowledgement bookClothe(ClotheBuyingRequest clotheBuyingRequest);

	public String saveImage(MultipartFile multipartFile);
	public Image getImage(Long id);

}
