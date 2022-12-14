package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    private ParcelRepository parcelRepository;

    @Override
    public void reportParcelDelivery(String trackingId) {
        parcelRepository.reportParcelDelivery(trackingId);
    }
}
