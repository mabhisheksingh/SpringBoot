package publicissapient.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import publicissapient.com.pojos.Clothes;

@Repository
@Transactional
public class ClothesDAO {

	@Autowired
	private EntityManager entityManager;
	//EntityManager are not thread Safe EntityManagerfactory are thread safe

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Clothes> getAllClothes(){
		Session session = getSession();
		List<Clothes> laptoplist = new ArrayList<>();
		try {
			laptoplist = new ArrayList<Clothes>();
			Query<Clothes> query = session.createQuery("from Clothes"); //Table name same as class name
			laptoplist = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		
		return laptoplist;
		
	}
	
	public boolean saveAllClothes(List<Clothes> list){
		
		Session session = getSession();
		try {
			for(Clothes c :list) {
				session.save(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		return true;
		
	}

	
}
