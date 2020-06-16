package server.dao;


import org.springframework.stereotype.Component;
import server.pojo.Relative;

@Component
public interface RelativesDao {
    boolean deleteByPrimaryKey(Integer id);

    boolean insert(Relative relative);

    boolean insertSelective(Relative relative);

    Relative selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Relative relative);

    boolean updateByPrimaryKey(Relative relative);
}