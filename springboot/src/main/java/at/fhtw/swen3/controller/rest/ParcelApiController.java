package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-14T15:32:51.812001Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    @Autowired
    private ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel/{trackingId}/reportDelivery/",
            produces = {"application/json"}
    )
    @Override
    public ResponseEntity<?> reportParcelDelivery(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 "
                    , required = true) @PathVariable("trackingId") String trackingId) {
        try{
        parcelService.reportParcelDelivery(trackingId);
        log.info("Parcel delivered with ID: " + trackingId);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (DALException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel/{trackingId}/reportHop/{code}",
            produces = {"application/json"}
    )
    @Override
    public ResponseEntity<Void> reportParcelHop(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
            @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$") @Parameter(name = "code", description = "The Code of the hop (Warehouse or Truck).", required = true) @PathVariable("code") String code
    ) {
        try{

        parcelService.reportParcelArrivedAtHop(trackingId, code);
        log.info("Parcel with ID: " + trackingId + " arrived at Hop with code: " + code);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (DALException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(
            @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ) {
        try{
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.fromParcelDtoToParcelEntity(parcel);
        Optional<ParcelEntity> response = parcelService.submitParcelToLogisticsService(parcelEntity);

            NewParcelInfo dto = ParcelMapper.INSTANCE.fromParcelEntityToNewParcelInfo(response.get());
            log.info("Parcel created with ID: " + dto.getTrackingId());
            return new ResponseEntity<NewParcelInfo>(dto, HttpStatus.CREATED);
        }
        catch(DALException e){
            log.error(e.getMessage());
            return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/parcel/{trackingId}",
            produces = {"application/json"}
    )
    @Override
    public ResponseEntity<TrackingInformation> trackParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId
    ) {
        try{

            Optional<ParcelEntity> parcelEntity = parcelService.getCurrentStateOfParcel(trackingId);
            TrackingInformation trackingInformation = ParcelMapper.INSTANCE.fromParcelEntityToTrackingInformation(parcelEntity.get());
            log.info("Parcel tracked with ID: " + trackingId);
            return new ResponseEntity<TrackingInformation>(trackingInformation, HttpStatus.OK);

        }
        catch (DALException e){
            log.error(e.getMessage());
            return new ResponseEntity<TrackingInformation>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel/{trackingId}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
            @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
