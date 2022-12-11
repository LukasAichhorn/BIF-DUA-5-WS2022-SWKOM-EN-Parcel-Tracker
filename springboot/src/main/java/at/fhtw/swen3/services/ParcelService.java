package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ParcelService {

    //Post
    Optional<ParcelEntity> submitParcelToLogisticsService(ParcelEntity newParcel);
    void reportParcelDelivery(String trackingId);
    void reportParcelArrivedAtHop(String trackingId,String hopCode);
    void transferParcelFromLogisticsPartner(String trackingId);

    //Get
    Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId);



}
