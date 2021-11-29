package publicissapient.com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import publicissapient.com.pojos.Clothes;
import publicissapient.com.pojos.ClothesOrderDetails;
import publicissapient.com.pojos.Image;

@Repository
public class ClothesDAO implements ClothesDAOInterface{

	/*  OLD_LOGIC_NOT_GOD_Below_Implemented new Logic///Which is slow but thread safe
	 * @Autowired private EntityManager entityManager; //EntityManager are not
	 * thread Safe EntityManagerfactory are thread safe
	 * 
	 * private Session getSession() { return entityManager.unwrap(Session.class); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Clothes> getAllClothes(){ Session session =
	 * getSession(); List<Clothes> laptoplist = new ArrayList<>(); try { laptoplist
	 * = new ArrayList<Clothes>(); Query<Clothes> query =
	 * session.createQuery("from Clothes"); //Table name same as class name
	 * laptoplist = query.getResultList(); }catch(Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * session.close();
	 * 
	 * return laptoplist;
	 * 
	 * }
	 * 
	 * @Override public void saveAllClothes(List<Clothes> list){
	 * 
	 * Session session = getSession(); try { for(Clothes c :list) { session.save(c);
	 * } }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * session.close();
	 * 
	 * }
	 */

	@Autowired
	private RedisTemplate redisTemplate;
	private final static String HASH_KEY = "CLOTHES";

	@Override
	public Clothes saveClothesredis(Clothes clothes){
		redisTemplate.opsForHash().put(HASH_KEY,clothes.getId(),clothes);
		return clothes;
	}
	public List<Clothes> getAllClothesredis(){
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	@Override
	public Clothes getClothesredis(@PathVariable Long id){
		System.out.println("calling db for request .. ");
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Clothes c = em.find(Clothes.class,id);
		tx.commit();
		em.close();
		return c;
	}

	//Thread safe
	@Autowired
	private EntityManagerFactory entityManagerfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Clothes> getAllClothes(){
		EntityManager em = entityManagerfactory.createEntityManager();
		List<Clothes> laptoplist = new ArrayList<>();
		try {
			laptoplist = new ArrayList<Clothes>();
			Query<Clothes> query = (Query<Clothes>) em.createQuery("from Clothes"); //Table name same as class name
			laptoplist = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
		return laptoplist;
		
	}
	
	@Override
	public void saveAllClothes(List<Clothes> list){
		
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Iterator<Clothes> iterator = list.iterator();
			while(iterator.hasNext()) {
				tx.begin();
				em.merge(iterator.next());
				tx.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		
	}

	
	@Override
	public void delete(Clothes c) {
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(  em.contains(c)  ? c : em.merge(c) );
		tx.commit();
		em.close();
		
	}

	
	@Override
	public Clothes getById(Long id) {
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Clothes c = em.find(Clothes.class,id);
		tx.commit();
		em.close();
		return c;
	}


	public void ClothesOrderDetailsBooking(ClothesOrderDetails clothesOrderDetails) {
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out.println("Clll : "+clothesOrderDetails);
		em.merge(clothesOrderDetails);
		tx.commit();
		em.close();
	}

	
	@Override
	public Long createClothe(Clothes c) {
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Clothes clothes  =(Clothes) em.merge(c);
		System.out.println("clothes : "+clothes);
		tx.commit();
		em.close();
		return clothes.getId();
	}

	@Override
	public String saveImage(Image image) {
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(image);
		System.out.println("image : "+image);
		tx.commit();
		em.close();
		return "Success full image uploaded";
	}

	public Image getImage(Long id){
		EntityManager em = entityManagerfactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Image image = em.find(Image.class,id);
		tx.commit();
		em.close();
		return image;
	}


	
}
