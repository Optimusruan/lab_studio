package dao;

import model.SliderEntity;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface SliderRepository extends CrudRepository<SliderEntity,Long>{
    @Transactional
    Iterable<SliderEntity> findBySliderId(int id);
}
