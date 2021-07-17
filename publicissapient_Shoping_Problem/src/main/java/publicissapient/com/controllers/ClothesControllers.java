package publicissapient.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import publicissapient.com.pojos.Clothes;
import publicissapient.com.services.ClothesServices;

@RestController
@RequestMapping("/clothes")
public class ClothesControllers {
	
	@Autowired
	ClothesServices clothesServices;
	
	@RequestMapping("/getAllClothes")
	public  List<Clothes> getAllClothes(){
		return clothesServices.getAllClothes();
		
	}

}
