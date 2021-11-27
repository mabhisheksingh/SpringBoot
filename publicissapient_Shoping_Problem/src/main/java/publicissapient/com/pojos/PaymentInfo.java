package publicissapient.com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "PAYMENT_INFO")
@SuppressWarnings("unused")
@ApiModel(description = "Details about payment")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = " it is primary key in long ",notes = "This is unique in DB payment tables")
	private Long paymentId;
	private String accountName;
	private Double amount;
	private String cardType;
	private Long ClotheId;
}
