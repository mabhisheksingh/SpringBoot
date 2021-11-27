package publicissapient.com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import publicissapient.com.dao.ClothesDAO;
import publicissapient.com.pojos.Clothes;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PublicissapientShopingProblemApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext  cac = SpringApplication.run(PublicissapientShopingProblemApplication.class, args);
		List<Clothes> list = new ArrayList<>(); 
		list.add(new Clothes(105,"Nike","Shoe","Red",8,true,320));
		list.add(new Clothes(101,"Nike","Shoe",		"Black",8,true,333));
		list.add(new Clothes(102,"Adidas","shoe",		"Red",10,false,320));
		list.add(new Clothes(103,"Nike","Shoe",		"White",10,true,320));
		ClothesDAO clothesDAO = cac.getBean(ClothesDAO.class);
		clothesDAO.saveAllClothes(list);
		
		/*
		 * Configuration con = new
		 * Configuration().configure().addAnnotatedClass(Clothes.class); SessionFactory
		 * sf = con.buildSessionFactory(); Session session = sf.openSession();
		 * Transaction tr = session.beginTransaction(); session.saveOrUpdate(list);
		 * tr.commit(); session.close(); sf.close();
		 */
		
		
		
		
	}

}
