package lk.ijse.guideserver.dao;

import lk.ijse.guideserver.entity.GuideEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideDAO extends CrudRepository<GuideEntity,String> {



}
