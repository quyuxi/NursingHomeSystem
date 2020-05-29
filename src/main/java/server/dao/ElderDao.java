package server.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import server.entity.Elder;

import java.util.List;

@Component
public interface ElderDao {

    Elder selectElderById(@Param("elderId") String elderId);

    List<Elder> selectElderList();

    boolean createElder(Elder elder);

    boolean updateElder(Elder elder);

    boolean deleteElderById(@Param("elderId") String elderId);


}