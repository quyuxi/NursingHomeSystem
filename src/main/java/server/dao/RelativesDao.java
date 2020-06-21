package server.dao;


import org.springframework.stereotype.Component;
import server.pojo.Relative;

@Component
public interface RelativesDao {
    boolean deleteByElderId(Integer id);

    boolean insert(Relative relative);

    boolean insertSelective(Relative relative);


    boolean updateByPrimaryKeySelective(Relative relative);

    boolean updateByPrimaryKey(Relative relative);

}