package edu.unsj.fcefn.lcc.optimizacion.api.algorithm;


import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FramesDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopsDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.services.AlgorithmService;
import edu.unsj.fcefn.lcc.optimizacion.api.services.FramesService;
import edu.unsj.fcefn.lcc.optimizacion.api.services.StopsService;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.Permutation;
import org.moeaframework.problem.AbstractProblem;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RoutingProblem extends AbstractProblem {

    @Autowired
    private StopsService stopsService;
    @Autowired
    private FramesService framesService;
    @Autowired
    private AlgorithmService algorithmService;

    private List<StopsDTO> stops;


    public RoutingProblem(){
        super(1,2);
        stops = stopsService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(StopsDTO::getRanking).reversed())
                .collect(Collectors.toList())
                .subList(0,20);
    }



    @Override
    public void evaluate(Solution solution) {
        solution.setObjective(0,totalPrice(solution.getVariable(0)));
        solution.setObjective(1,totalTime(solution.getVariable(0)));
    }

    private double totalPrice(Variable variable){
        Permutation permutation = (Permutation)variable;

        double totalPrice = 0;

        for (int i = 0; i< permutation.size()-1;i++){
            StopsDTO departureStop = stops.get(permutation.get(i));
            StopsDTO arrivalStop = stops.get(permutation.get(i+1));
            List<FramesDTO> frames = framesService.findByIdDepartureStopAndIdArrivalStop(departureStop.getId(),arrivalStop.getId());

            FramesDTO bestPriceFrame = frames
                    .stream().min(Comparator.comparing(FramesDTO::getPrice))
                    .orElse(null);

            if (Objects.isNull(bestPriceFrame)){
                return Double.MAX_VALUE;
            }


            totalPrice +=  frames.get(0).getPrice();
        }



        return totalPrice;
    }


    private double totalTime(Variable variable){
        Permutation permutation = (Permutation)variable;
        List<StopsDTO> stops = algorithmService.getStops();

        double totalTime = 0;

        for(int i = 0;i < permutation.size() - 1;i++){
            StopsDTO departureStop = stops.get(permutation.get(i));
            StopsDTO arrivalStop = stops.get(permutation.get(i + 1));

            List<FramesDTO> frames = framesService
                    .findByIdDepartureStopAndIdArrivalStop(departureStop.getId(), arrivalStop.getId());

            Map<Integer, Long> mapTime = getTimeMaps(frames);
            Map.Entry<Integer, Long> frameIdTimeToArrival = mapTime
                    .entrySet()
                    .stream()
                    .min(Map.Entry.comparingByValue())
                    .orElse(null);

            if(Objects.isNull(frameIdTimeToArrival)){
                return Double.MAX_VALUE;
            }

            FramesDTO frameDTO = frames
                    .stream()
                    .filter(frame -> frame.getId().equals(frameIdTimeToArrival.getKey()))
                    .findFirst()
                    .orElse(null);

            if(Objects.isNull(frameDTO)){
                return Double.MAX_VALUE;
            }

            totalTime += frameIdTimeToArrival.getValue();
        }

        return totalTime;
    }



    private Map<Integer, Long> getTimeMaps(List<FramesDTO> frames){
        Map<Integer, Long> mapTime = new HashMap<>();
        for(FramesDTO frame : frames){
            if(frame.getDeparture_datetime().isBefore(frame.getArrival_datetime())){
                Long timeToArrival = Duration.between(frame.getDeparture_datetime(), frame.getArrival_datetime()).getSeconds();
                mapTime.put(frame.getId(), timeToArrival);
            } else {
                Long timeToArrivalRange1 = Duration.between(frame.getDeparture_datetime(), LocalTime.MIDNIGHT).getSeconds();
                Long timeToArrivalRange2 = Duration.between(LocalTime.MIDNIGHT, frame.getArrival_datetime()).getSeconds();
                Long timeToArrival = timeToArrivalRange1 + timeToArrivalRange2;
                mapTime.put(frame.getId(), timeToArrival);
            }
        }

        return mapTime;
    }



    @Override
    public Solution newSolution() {
        Solution solution = new Solution(1,2);
        solution.setVariable(0, EncodingUtils.newPermutation(20));
        return solution;
    }
}
