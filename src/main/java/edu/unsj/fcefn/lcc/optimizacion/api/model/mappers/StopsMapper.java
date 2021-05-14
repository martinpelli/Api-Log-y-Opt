package edu.unsj.fcefn.lcc.optimizacion.api.model.mappers;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopsDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.StopsEntity;
import org.springframework.stereotype.Component;

@Component
public class StopsMapper {

    public StopsDTO entityToDTO(StopsEntity stopsEntity){
        StopsDTO stopsDTO = new StopsDTO();
        stopsDTO.setId(stopsEntity.getId());
        stopsDTO.setCategory(stopsEntity.getCategory());
        stopsDTO.setCity(stopsEntity.getCity());
        stopsDTO.setCountry(stopsEntity.getCountry());
        stopsDTO.setName(stopsEntity.getName());
        stopsDTO.setLatitud(stopsEntity.getLatitud());
        stopsDTO.setLogitud(stopsEntity.getLogitud());
        stopsDTO.setProvince(stopsEntity.getProvince());
        stopsDTO.setRanking(stopsEntity.getRanking());

        return stopsDTO;
    }

    public StopsEntity dtoToEntity(StopsDTO stopsDTO){
        StopsEntity stopsEntity = new StopsEntity();
        stopsEntity.setId(stopsDTO.getId());
        stopsEntity.setCategory(stopsDTO.getCategory());
        stopsEntity.setCity(stopsDTO.getCity());
        stopsEntity.setCountry(stopsDTO.getCountry());
        stopsEntity.setName(stopsDTO.getName());
        stopsEntity.setLatitud(stopsDTO.getLatitud());
        stopsEntity.setLogitud(stopsDTO.getLogitud());
        stopsEntity.setProvince(stopsDTO.getProvince());
        stopsEntity.setRanking(stopsDTO.getRanking());


        return stopsEntity;
    }
}
