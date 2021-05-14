package edu.unsj.fcefn.lcc.optimizacion.api.model.mappers;


import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FramesDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.FramesEntity;
import org.springframework.stereotype.Component;


@Component
public class FramesMapper {
    public FramesDTO entityToDTO(FramesEntity framesEntity){
        FramesDTO framesDTO = new FramesDTO();
        framesDTO.setId(framesEntity.getId());
        framesDTO.setArrival_datetime(framesEntity.getArrival_datetime());
        framesDTO.setDeparture_datetime(framesEntity.getDeparture_datetime());
        framesDTO.setCategory(framesEntity.getCategory());
        framesDTO.setPrice(framesEntity.getPrice());
        framesDTO.setId_stop_arrival(framesEntity.getId_stop_arrival());
        framesDTO.setId_stop_departure(framesEntity.getId_stop_departure());
        framesDTO.setId_stop_company(framesEntity.getId_stop_company());

        return framesDTO;
    }

    public FramesEntity dtoToEntity(FramesDTO framesDTO){
        FramesEntity framesEntity = new FramesEntity();
        framesEntity.setId(framesDTO.getId());
        framesEntity.setArrival_datetime(framesDTO.getArrival_datetime());
        framesEntity.setDeparture_datetime(framesDTO.getDeparture_datetime());
        framesEntity.setCategory(framesEntity.getCategory());
        framesEntity.setPrice(framesDTO.getPrice());
        framesEntity.setId_stop_arrival(framesDTO.getId_stop_arrival());
        framesEntity.setId_stop_departure(framesDTO.getId_stop_departure());
        framesEntity.setId_stop_company(framesDTO.getId_stop_company());

        return framesEntity;
    }
}
