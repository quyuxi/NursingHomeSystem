package server.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import server.pojo.Elder;

import java.util.List;

@Component
public interface ElderDao {

    Elder selectElderById(@Param("id") int id);

    List<Elder> selectElderList();

    boolean createElder(Elder elder);

    boolean updateElder(Elder elder);

    boolean deleteElderById(@Param("id") int id);


    int selectLastId();
}