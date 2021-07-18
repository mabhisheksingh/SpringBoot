package publicissapient.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import publicissapient.com.pojos.Clothes;
import publicissapient.com.services.ClothesServices;

@RestController
@RequestMapping("/clothes")
public class ClothesControllers {
	
	@Autowired
	ClothesServices clothesServices;
	
	@RequestMapping(value="/getAllClothes", method = RequestMethod.GET )
	public  ResponseEntity<List<Clothes>> getAllClothes(){
		return new ResponseEntity<>(clothesServices.getAllClothes(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getClotheById/{id}", method = RequestMethod.POST)
	public ResponseEntity<Clothes> getClotheByID(@PathVariable Long id){
		return new ResponseEntity<>(clothesServices.getClotheById(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteClotheById/{id}", method = RequestMethod.POST)
	public ResponseEntity<String > deleteById(@PathVariable Long id){
		clothesServices.deleteClothe(id);
		return new ResponseEntity<String>( "Object id : "+id+" deleted from DB",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/CreateClothe", method = RequestMethod.POST)
	public ResponseEntity<String > createClothe(@RequestBody Clothes clothes){
		System.out.println("pS "+ clothes);
		Long id  = clothesServices.saveOrUpdateClothes(clothes);
		System.out.println("AS "+ clothes);
		return new ResponseEntity<String>( "Clothes created and its id is : "+id,HttpStatus.CREATED);
	}

}
