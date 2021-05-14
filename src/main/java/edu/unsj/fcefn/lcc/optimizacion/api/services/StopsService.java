package edu.unsj.fcefn.lcc.optimizacion.api.services;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopsDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.mappers.StopsMapper;
import edu.unsj.fcefn.lcc.optimizacion.api.model.repositories.StopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopsService {

    @Autowired
    StopsRepository stopsRepository;
    @Autowired
    StopsMapper stopsMapper;

    public List<StopsDTO> findAll(){
        return stopsRepository
                .findAll()
                .stream()
                .map(stopsEntity -> stopsMapper.entityToDTO(stopsEntity))
                .collect(Collectors.toList());
    }
}
