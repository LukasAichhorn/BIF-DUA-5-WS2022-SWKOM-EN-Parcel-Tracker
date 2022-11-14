package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {HopArrivalMapper.class})
public interface ParcelMapper {

    //TODO: Mapping für trackinginformation umsetzen
    @Mapping(source = "p.weight", target = "weight")
    @Mapping(source = "p.recipient", target = "recipient")
    @Mapping(source = "p.sender", target = "sender")
    @Mapping(source = "npi.trackingId", target = "trackingId")
    @Mapping(source = "ti.visitedHops", target = "visitedHops")
    @Mapping(source = "ti.futureHops", target = "futureHops")
    @Mapping(source = "ti.state", target = "state")
    ParcelEntity fromParcelDtosToParcelEntity(Parcel p, NewParcelInfo npi, TrackingInformation ti);



}
