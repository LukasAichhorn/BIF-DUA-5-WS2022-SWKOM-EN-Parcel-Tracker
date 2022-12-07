package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ParcelService {

    //Post
    void submitParcelToLogisticsService(ParcelEntity newParcel);
    void reportParcelDelivery(String trackingId);
    void reportParcelArrivedAtHop(String trackingId,String hopCode);
    void transferParcelfromLogisticsPartner(String trackingId);

    //Get
    Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId);



}
