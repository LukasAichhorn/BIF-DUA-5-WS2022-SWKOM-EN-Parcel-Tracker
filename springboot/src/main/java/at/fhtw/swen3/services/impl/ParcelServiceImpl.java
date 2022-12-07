package at.fhtw.swen3.services.impl;

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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {
    private ParcelRepository parcelRepository;
    private RecipientRepository recipientRepository;
    private HopArrivalRepository hopArrivalRepository;

    @Override
    public void submitParcelToLogisticsService(ParcelEntity newParcel) {
        Optional<RecipientEntity> sender = recipientRepository.findById(newParcel.getSender().getId());
        Optional<RecipientEntity> receiver = recipientRepository.findById(newParcel.getRecipient().getId());

        if(sender.isPresent() && receiver.isPresent()){
            parcelRepository.save(newParcel);
        }
    }

    @Override
    public void reportParcelDelivery(String trackingId) {
        Optional<ParcelEntity> parcel = parcelRepository.findById(trackingId);

        if(parcel.isPresent()){
            parcel.get().setState(ParcelEntity.StateEnum.DELIVERED);
            parcelRepository.save(parcel.get());
        }
    }

    @Override
    public void reportParcelArrivedAtHop(String trackingId, String hopCode) {
        Optional<ParcelEntity> parcel = parcelRepository.findById(trackingId);
        Optional<HopArrivalEntity> hop = hopArrivalRepository.findById(hopCode);

        if(parcel.isPresent() && hop.isPresent()){
            parcel.get().getFutureHops().remove(hop.get());
            parcel.get().getVisitedHops().add(hop.get());
            parcelRepository.save(parcel.get());
        }
    }

    @Override
    public void transferParcelfromLogisticsPartner(String trackingId) {
   //TODO ask what this should do.
    }

    @Override
    public Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId) {
       return parcelRepository.findById(trackingId);


    }
}
