package edu.unsj.fcefn.lcc.optimizacion.api.services;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FramesDTO;

import edu.unsj.fcefn.lcc.optimizacion.api.model.mappers.FramesMapper;
import edu.unsj.fcefn.lcc.optimizacion.api.model.repositories.FramesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FramesService {

    @Autowired
    FramesRepository framesRepository;
    @Autowired
    FramesMapper framesMapper;


    public List<FramesDTO> frames;

    @PostConstruct
    private void init(){
        this.frames = this.findAll();
    }

    public List<FramesDTO> getFrames(){
        return this.frames;
    }

    public List<FramesDTO> findByIdDepartureStopAndIdArrivalStop(Integer idDepartureStop, Integer idArrivalStop){
        return this.frames
                .stream()
                .filter(frameDTO -> frameDTO.getId_stop_departure().getId().equals(idDepartureStop))
                .filter(frameDTO -> frameDTO.getId_stop_arrival().equals(idArrivalStop))
                .collect(Collectors.toList());
    }

    public List<FramesDTO> findAll(){
        return framesRepository
                .findAll()
                .stream()
                .map(framesEntity -> framesMapper.entityToDTO(framesEntity))
                .collect(Collectors.toList());
    }
}
