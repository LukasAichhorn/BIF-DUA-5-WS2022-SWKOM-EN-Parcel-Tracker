package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ParcelService {

    //Post
    Optional<ParcelEntity> submitParcelToLogisticsService(ParcelEntity newParcel) throws DALException;
    void reportParcelDelivery(String trackingId) throws DALException;
    void reportParcelArrivedAtHop(String trackingId,String hopCode) throws DALException;
    void transferParcelFromLogisticsPartner(String trackingId);

    //Get
    Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId) throws DALException;



}
