package publicissapient.com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClothesOrderDetails {
	@Id
	private Long clotheId;
	@Column(name ="brandname")
	private String brandName;
	@Column(name ="productname")
	private String productName;
	private boolean available;
	private Double price;
	private String status;
	private String transactionId;
	
}
