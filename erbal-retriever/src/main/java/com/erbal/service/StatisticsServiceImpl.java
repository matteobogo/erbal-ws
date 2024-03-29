package com.erbal.service;

import com.erbal.client.CollectorClient;
import com.erbal.client.GreenhouseManagementClient;
import com.erbal.domain.dto.*;
import domain.*;
import domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private CollectorClient collectorClient;
    private GreenhouseManagementClient greenhouseManagementClient;

    @Autowired
    public StatisticsServiceImpl(
            CollectorClient collectorClient,
            GreenhouseManagementClient greenhouseManagementClient) {

        this.collectorClient = collectorClient;
        this.greenhouseManagementClient = greenhouseManagementClient;
    }

    @Override
    public BatchStatsDTO findNBatchBySinkId(String userId, String sinkId, long nBatch) {

        //check sinkId + UserId
        MessageDTO<Sink> sinkExist = greenhouseManagementClient.findSinkBySerialId(sinkId);

        if(sinkExist.getEntity() != null) {

            Sink sink = sinkExist.getEntity();
            if(sink.getUserId().equals(userId)) {

                //obtain sinkData from Collector
                List<SinkData> sinkDataList = collectorClient.findNBatchBySinkId(sinkId,nBatch);

                //extract by type
                List<NodeData> soilNodeDataList = new ArrayList<>();
                List<NodeData> indoorNodeDataList = new ArrayList<>();
                List<NodeData> outdoorNodeDataList = new ArrayList<>();

                int hashcode = 0;
                if(sinkDataList.size() > 0)
                    hashcode = sinkDataList.get(sinkDataList.size()-1).hashCode();

                sinkDataList.forEach(s -> {

                    Optional<Collection<NodeData>> nodeDataList = Optional.of(s.getSamples());
                    if(!nodeDataList.isPresent())
                        return;

                    nodeDataList.get().forEach(n -> {

                        if(n.getType() == null) return;

                        switch(n.getType().toUpperCase()) {

                            case "SOIL":

                                soilNodeDataList.add(n);
                                break;
                            case "INDOOR":

                                indoorNodeDataList.add(n);
                                break;
                            case "OUTDOOR":

                                outdoorNodeDataList.add(n);
                                break;
                        }
                    });
                });

                //build soil data
                SoilBatchDTO soilBatchDTO = new SoilBatchDTO();

                soilNodeDataList
                        .forEach( s -> {

                            SoilSampleData soilSampleData = (SoilSampleData) s.getSample();

                            soilBatchDTO.getTemperatureDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), soilSampleData.getSoilTemperatureData()));

                            soilBatchDTO.getMoistureDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), soilSampleData.getSoilMoistureData()));

                });

                //build indoor data
                OutdoorBatchDTO outdoorBatchDTO = new OutdoorBatchDTO();

                outdoorNodeDataList
                        .forEach( s -> {

                            AirSampleData airSampleData = (AirSampleData) s.getSample();

                            outdoorBatchDTO.getAirTemperatureDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirTemperatureData()));

                            outdoorBatchDTO.getAirHumidityDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirHumidityData()));

                            outdoorBatchDTO.getAirPhoto().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirPhotoData()));

                            outdoorBatchDTO.getAirRadiation().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirRadiationData()));
                        });

                //build outdoor data
                IndoorBatchDTO indoorBatchDTO = new IndoorBatchDTO();

                indoorNodeDataList
                        .forEach( s -> {

                            AirSampleData airSampleData = (AirSampleData) s.getSample();

                            indoorBatchDTO.getAirTemperatureDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirTemperatureData()));

                            indoorBatchDTO.getAirHumidityDTO().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirHumidityData()));

                            indoorBatchDTO.getAirPhoto().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirPhotoData()));

                            indoorBatchDTO.getAirRadiation().getTimestampValueDTOList().add(
                                    new TimestampValueDTO(
                                            s.getSectorId(), s.getTimestamp(), airSampleData.getAirRadiationData()));
                        });

                BatchStatsDTO batchStatsDTO = new BatchStatsDTO(
                        hashcode+"",
                        soilBatchDTO,
                        outdoorBatchDTO,
                        indoorBatchDTO
                );



                return batchStatsDTO;
            }
        }
        return null;
    }
}