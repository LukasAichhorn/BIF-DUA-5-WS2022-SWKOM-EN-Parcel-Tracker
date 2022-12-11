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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private RecipientRepository recipientRepository;
    @Autowired
    private HopArrivalRepository hopArrivalRepository;

    @Override
    public Optional<ParcelEntity> submitParcelToLogisticsService(ParcelEntity newParcel) {

        //Optional<RecipientEntity> sender = recipientRepository.findById(newParcel.getSender().getId());
        //Optional<RecipientEntity> receiver = recipientRepository.findById(newParcel.getRecipient().getId());
        RecipientEntity recipientEntity = newParcel.getRecipient();
        RecipientEntity senderEntity = newParcel.getSender();
        recipientRepository.save(recipientEntity);
        recipientRepository.save(senderEntity);
        recipientRepository.flush();
        // TODO how to generate unique String for Parcel
        newParcel.setTrackingId("AAAAAAAAA");
        newParcel.setState(ParcelEntity.StateEnum.INTRANSPORT);
            ParcelEntity parcel = parcelRepository.save(newParcel);
            parcelRepository.flush();

            long id = parcel.getId();
        return parcelRepository.findById(id);
    }

    @Override
    public void reportParcelDelivery(String trackingId) {

    }

    @Override
    public void reportParcelArrivedAtHop(String trackingId, String hopCode) {
        Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
        Optional<HopArrivalEntity> hop = hopArrivalRepository.findById(hopCode);

        if (parcel.isPresent() && hop.isPresent()) {
            parcel.get().getFutureHops().remove(hop.get());
            parcel.get().getVisitedHops().add(hop.get());
            parcelRepository.save(parcel.get());
        }
    }

    @Override
    public void transferParcelFromLogisticsPartner(String trackingId) {
        //TODO ask what this should do.
    }

    @Override
    public Optional<ParcelEntity> getCurrentStateOfParcel(String trackingId) {
        return parcelRepository.findByTrackingId(trackingId);


    }
}
