package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParcelRepository extends JpaRepository<ParcelEntity,Long> {
    //@Modifying
    //@Query(value= "UPDATE ")
    void reportParcelDelivery(String trackingId);
}
