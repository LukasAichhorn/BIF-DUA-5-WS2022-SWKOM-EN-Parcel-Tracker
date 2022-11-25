package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {HopArrivalMapper.class, RecipientMapper.class})
public interface ParcelMapper {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "p.weight", target = "weight")
    @Mapping(source = "p.recipient", target = "recipient")
    @Mapping(source = "p.sender", target = "sender")
    @Mapping(source = "npi.trackingId", target = "trackingId")
    @Mapping(source = "ti.visitedHops", target = "visitedHops")
    @Mapping(source = "ti.futureHops", target = "futureHops")
    @Mapping(source = "ti.state", target = "state")
    ParcelEntity fromParcelDtosToParcelEntity(Parcel p, NewParcelInfo npi, TrackingInformation ti);

    @Mapping(source = "p.weight", target = "weight")
    @Mapping(source = "p.recipient", target = "recipient")
    @Mapping(source = "p.sender", target = "sender")
    ParcelEntity fromParcelDtoToParcelEntity(Parcel p);

    @Mapping(source = "pe.weight", target = "weight")
    @Mapping(source = "pe.recipient", target = "recipient")
    @Mapping(source = "pe.sender", target = "sender")
    Parcel fromParcelEntityToParcel(ParcelEntity pe);

    @Mapping(source = "pe.trackingId", target = "trackingId")
    NewParcelInfo fromParcelEntityToNewParcelInfo(ParcelEntity pe);

    @Mapping(source = "pe.visitedHops", target = "visitedHops")
    @Mapping(source = "pe.futureHops", target = "futureHops")
    @Mapping(source = "pe.state", target = "state")
    TrackingInformation fromParcelEntityToTrackingInformation(ParcelEntity pe);




}
