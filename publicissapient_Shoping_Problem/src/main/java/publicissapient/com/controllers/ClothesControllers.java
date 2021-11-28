package publicissapient.com.controllers;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Compression;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;
import publicissapient.com.pojos.ClotheBuyingAcknowledgement;
import publicissapient.com.pojos.ClotheBuyingRequest;
import publicissapient.com.pojos.Clothes;
import publicissapient.com.pojos.Image;
import publicissapient.com.services.ClothesServices;

@RestController
@RequestMapping("/clothes")
public class ClothesControllers {
	
	@Autowired
	ClothesServices clothesServices;
	
	@ApiOperation(value ="Get All Clothes ",notes=" you can get all clothes from DB",response =Clothes.class )
	@RequestMapping(value="/getAllClothes", method = RequestMethod.GET )
	public  ResponseEntity<List<Clothes>> getAllClothes(){
		return new ResponseEntity<>(clothesServices.getAllClothes(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getClotheById/{id}", method = RequestMethod.POST)
	public ResponseEntity<Clothes> getClotheByID(@PathVariable Long id){
		return new ResponseEntity<>(clothesServices.getClotheById(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteClotheById/{id}", method = RequestMethod.POST)
	public ResponseEntity<String > deleteById(@ApiParam(value = "Getting primery key of clothes" , required = true)  @PathVariable Long id){
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

	@RequestMapping(value = "/bookClothe", method = RequestMethod.POST)
	public ResponseEntity<ClotheBuyingAcknowledgement > bookClothe(@RequestBody ClotheBuyingRequest clotheBuyingRequest){
		
		System.out.println("clotheBuyingRequest "+ clotheBuyingRequest);
		ClotheBuyingAcknowledgement clotheBuyingAcknowledgement  = clothesServices.bookClothe(clotheBuyingRequest);
		return new ResponseEntity<>( clotheBuyingAcknowledgement,HttpStatus.OK);
	}


	//image processing
	@PostMapping(value = "/clotheImageUpload")
	public ResponseEntity<String> clotheImageUpload(@RequestParam("Image") MultipartFile multipartFile) throws IOException {
		System.out.println("Multipart file : "+multipartFile);
		System.out.println("Multipart file getContentType : "+multipartFile.getContentType());
		System.out.println("Multipart file getSize : "+multipartFile.getSize());
		System.out.println("Multipart file getName : "+multipartFile.getName());
		System.out.println("Multipart file getResource : "+multipartFile.getResource());
		System.out.println("Multipart file getOriginalFilename : "+multipartFile.getOriginalFilename());
		//File saving
		byte[] buffer =multipartFile.getBytes();

		File targetFile = new File("src/main/resources/"+multipartFile.getOriginalFilename());

		try (OutputStream outStream = new FileOutputStream(targetFile)) {
			outStream.write(buffer);
		}
		String response = clothesServices.saveImage(multipartFile);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/getImage/{id}")
	public ResponseEntity<String> getIamge(@PathVariable Long id) throws IOException {
		//FROM db
		Image image = clothesServices.getImage(id);
		System.out.println("images : "+image);
		return ResponseEntity.ok("getting image");
	}
	//images store in resource folder
	@GetMapping(value = "/getclotheUploadIamge")
	public ResponseEntity<ByteArrayResource> getclotheUploadIamge() throws IOException {

		File file = new File("src/main/resources/Clothes2.jpg");
		String fileName =file.getName();
		InputStream inputStream = new FileInputStream(file);
		System.out.println("Get Multipart file : "+fileName);
		System.out.println("Get Multipart file getContentType : "+inputStream);
		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok()
				.headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		//return ResponseEntity.ok(file);
	}

	@PostMapping(value = "/clotheImagesUpload")
	public ResponseEntity<Void> clotheImagesUpload(@RequestParam Map<String, MultipartFile> multipartFileMap){
		System.out.println("Multipart files : "+multipartFileMap);
		System.out.println("Multipart files getContentType : "+multipartFileMap.get("Images1"));
		/*if(multipartFile.getContentType().contains("image")) {
			return ResponseEntity.ok().build();
		}
		System.out.println("Multipart file getSize : "+multipartFile.getSize());
		System.out.println("Multipart file getName : "+multipartFile.getName());
		System.out.println("Multipart file getResource : "+multipartFile.getResource());*/
		return ResponseEntity.ok().build();
	}


}
