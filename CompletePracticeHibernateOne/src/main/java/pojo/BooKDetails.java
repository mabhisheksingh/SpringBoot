package pojo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "BookTable")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class BooKDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookId;
	
	private String bookName;
	private String bookWriter;
	private float price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BooKDetails [bookId=" + bookId + ", bookName=" + bookName + ", bookWriter=" + bookWriter + ", price="
				+ price + "]";
	}
	

}
