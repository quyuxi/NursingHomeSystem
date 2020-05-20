package server.dao;

import org.springframework.stereotype.Component;
import server.entity.Elder;
import server.entity.ElderKey;

import java.util.List;

@Component
public interface ElderDao {

    Elder selectElderById(int id);

    List<Elder> selectElderList();

    boolean createElder(Elder elder);

    boolean updateElder(Elder elder);

    boolean deleteElderById(Integer id);
}