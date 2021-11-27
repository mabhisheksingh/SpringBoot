package publicissapient.com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice.Unused;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "CLOTHES")
@SuppressWarnings("unused")
@ApiModel(description = "Details about Clothes")
public class Clothes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = " it is primary key in long ",notes = "This is unique in DB clothes taables")
	private long id;
	@Column(name ="brandname")
	private String brandName;
	@Column(name ="productname")
	private String productName;
	@Column(name = "color")
	private String color;
	private int size;
	private boolean available;
	private double price;
	
	/*lombok can replace this boiler code
	 * public long getId() { return id; } public void setId(long id) { this.id = id;
	 * } public String getBrandName() { return brandName; } public void
	 * setBrandName(String brandName) { this.brandName = brandName; } public String
	 * getProductName() { return productName; } public void setProductName(String
	 * productName) { this.productName = productName; } public String getColor() {
	 * return color; } public void setColor(String color) { this.color = color; }
	 * public int getSize() { return size; } public void setSize(int size) {
	 * this.size = size; } public boolean isAvailable() { return available; } public
	 * void setAvailable(boolean available) { this.available = available; } public
	 * double getPrice() { return price; } public void setPrice(double price) {
	 * this.price = price; }
	 * 
	 * @Override public String toString() { return "Clothes [id=" + id +
	 * ", brandName=" + brandName + ", productName=" + productName + ", color=" +
	 * color + ", size=" + size + ", available=" + available + ", price=" + price +
	 * "]"; }
	 */
	
	
}
