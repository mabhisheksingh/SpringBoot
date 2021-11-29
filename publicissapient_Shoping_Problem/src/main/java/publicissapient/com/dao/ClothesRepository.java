package publicissapient.com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import publicissapient.com.pojos.Clothes;

@Repository
public interface ClothesRepository extends CrudRepository<Clothes, Long>  {

	List<Clothes> findByBrandName(String string);

}
