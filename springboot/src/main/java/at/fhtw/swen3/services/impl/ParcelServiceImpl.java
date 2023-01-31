package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private RecipientRepository recipientRepository;
    @Autowired
    private HopRepository hopRepository;
    @Autowired
    private HopArrivalRepository hopArrivalRepository;


    @Override
    public Optional<ParcelEntity> submitParcelToLogisticsService(ParcelEntity newParcel) throws DALException {

        RecipientEntity recipientEntity = newParcel.getRecipient();
        RecipientEntity senderEntity = newParcel.getSender();
        recipientRepository.save(recipientEntity);
        recipientRepository.save(senderEntity);
        recipientRepository.flush();
        newParcel.setTrackingId("REVIEW001");
        newParcel.setState(ParcelEntity.StateEnum.INTRANSPORT);
        ParcelEntity parcel = parcelRepository.save(newParcel);
        parcelRepository.flush();
        long id = parcel.getId();
        Optional<ParcelEntity> retValue = parcelRepository.findById(id);
        if (retValue.isPresent()){
            return retValue;
        }
        else{
            throw new DALException("Parcel could not be created! Database entry failed!");
        }
    }

    @Override
    public void reportParcelDelivery(String trackingId) throws DALException {
        Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
        if (parcel.isPresent()) {
            ParcelEntity parcelEntity = parcel.get();
            parcelEntity.setState(ParcelEntity.StateEnum.DELIVERED);
            parcelRepository.save(parcelEntity);
        } else {
            throw new DALException("Unable to find Parcel with tracking ID: " + trackingId);
        }

    }

    @Override
    public void reportParcelArrivedAtHop(String trackingId, String hopCode) throws DALException {
        Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
        Optional<HopEntity> hop = hopRepository.findByCode(hopCode);

        if (parcel.isPresent() && hop.isPresent()) {
            HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
            hopArrivalEntity.setParcel(parcel.get());
            hopArrivalEntity.setCode(hop.get().getCode());
            hopArrivalEntity.setDescription(hop.get().getDescription());
            hopArrivalEntity.setDateTime(OffsetDateTime.now());

            hopArrivalRepository.save(hopArrivalEntity);


        } else {
            throw new DALException("Could not find parcel with TrackinID: " + trackingId + " or Hop with HopCode: " + hopCode);
        }

    }

    @Override
    public void transferParcelFromLogisticsPartner(String trackingId) {
        //TODO ask what this should do.
    }

    @Override
    public Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId) throws DALException {
        Optional<ParcelEntity> retValue = parcelRepository.findByTrackingId(trackingId);
        if (retValue.isPresent()) {

            return parcelRepository.findByTrackingId(trackingId);
        } else {
            throw new DALException("Could not find parcel with trackingID: " + trackingId);
        }


    }
}
