package publicissapient.com.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import publicissapient.com.dao.ClothesDAO;
import publicissapient.com.exception.ClotheAllReadyExistException;
import publicissapient.com.exception.NoDataFoundException;
import publicissapient.com.pojos.*;
import publicissapient.com.util.PaymentUtil;

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
	@Override
	public ClotheBuyingAcknowledgement bookClothe(ClotheBuyingRequest clotheBuyingRequest) {
		Clothes c = clothesDAO.getById(clotheBuyingRequest.getClotheId());
		String transactionId = UUID.randomUUID().toString().split("-")[0];
		if( c == null) {
			throw new NoDataFoundException("Id : "+clotheBuyingRequest.getClotheId()+" not found in DB",HttpStatus.NOT_FOUND);
		}
		System.out.println("Clothes : "+c);
		PaymentInfo paymentInfo = clotheBuyingRequest.getPaymentInfo();
		PaymentUtil.ValidatePayment(paymentInfo.getCardType(),paymentInfo.getAmount());
		ClothesOrderDetails clothesOrderDetails = new ClothesOrderDetails(clotheBuyingRequest.getClotheId(),c.getBrandName(),c.getProductName()
			,c.isAvailable(),c.getPrice(),"Success",transactionId);
		clothesDAO.ClothesOrderDetailsBooking(clothesOrderDetails);
		return new ClotheBuyingAcknowledgement("Success",clotheBuyingRequest.getPaymentInfo().getAmount(),transactionId,c);
	}

	@Override
	public String saveImage(MultipartFile multipartFile) {
		Image image = new Image();
		try{
			image.setPhoto(multipartFile.getBytes());
			image.setSize(multipartFile.getSize());
			image.setPhotoName(multipartFile.getOriginalFilename());

		}catch (Exception ex ){
			ex.printStackTrace();
		}
		return clothesDAO.saveImage(image);
	}

	@Override
	public Image getImage(Long id) {
		Image image =null;
		try{
			image = clothesDAO.getImage(id);

		}catch (Exception ex ){
			ex.printStackTrace();
		}
		return image;
	}


}
