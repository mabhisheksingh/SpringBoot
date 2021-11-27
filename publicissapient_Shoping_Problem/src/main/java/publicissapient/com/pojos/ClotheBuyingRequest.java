package publicissapient.com.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClotheBuyingRequest {
	private Long clotheId;
	private PaymentInfo paymentInfo;
}
