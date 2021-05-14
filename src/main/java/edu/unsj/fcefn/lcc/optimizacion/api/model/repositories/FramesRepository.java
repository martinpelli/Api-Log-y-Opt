package edu.unsj.fcefn.lcc.optimizacion.api.model.repositories;

import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.FramesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FramesRepository extends CrudRepository<FramesEntity,Integer> {
    List<FramesEntity> findAll();
}
