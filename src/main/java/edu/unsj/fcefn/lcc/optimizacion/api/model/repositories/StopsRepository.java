package edu.unsj.fcefn.lcc.optimizacion.api.model.repositories;

import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.StopsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopsRepository extends CrudRepository<StopsEntity,Integer> {
    List<StopsEntity> findAll();
}
