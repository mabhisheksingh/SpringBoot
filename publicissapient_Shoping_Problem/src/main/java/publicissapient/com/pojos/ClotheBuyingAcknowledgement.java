package publicissapient.com.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClotheBuyingAcknowledgement {
	private String status;
	private Double price;
	private String transactionID;
	private Clothes Clothes;
}
