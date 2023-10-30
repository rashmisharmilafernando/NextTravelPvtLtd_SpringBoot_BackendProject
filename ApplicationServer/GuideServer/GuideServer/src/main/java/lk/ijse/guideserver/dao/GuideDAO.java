package lk.ijse.guideserver.dao;

import lk.ijse.guideserver.entity.GuideEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideDAO extends CrudRepository<GuideEntity,String> {

    @Query(value = "{}", sort = "{ guideId: -1 }")
   /* @Query("{}").with(Sort.by(Sort.Direction.DESC, "guideId")).limit(1)*/
    String getLastIndex();



}
