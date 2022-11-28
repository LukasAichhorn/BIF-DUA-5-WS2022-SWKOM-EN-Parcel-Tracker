package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService{
    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public void reportParcelDelivery(String trackingId) {
        parcelRepository.reportParcelDelivery(trackingId);
    }
}
