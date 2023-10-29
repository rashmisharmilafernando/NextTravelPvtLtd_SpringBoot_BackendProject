package lk.ijse.guideserver.dao;

import lk.ijse.guideserver.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideDAO extends JpaRepository<GuideEntity,String> {



}
