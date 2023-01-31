package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-14T15:32:51.812001Z[Etc/UTC]")
@RestController
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;
    @Autowired
    private WarehouseService warehouseService;


    @Autowired
    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse",
            produces = {"application/json"}
    )
    @Override
    @ResponseBody
    public ResponseEntity<Warehouse> exportWarehouses() {
        try {
            Optional<WarehouseEntity> responseEntity = warehouseService.getAllWarehouses();
            Warehouse dto = WarehouseMapper.INSTANCE.warehouseEntitiyToWarehouseDto(responseEntity.get());
            log.info("Warehouses successfully exported.");
            return new ResponseEntity<Warehouse>(dto, HttpStatus.OK);
        }
        catch(DALException e){
            log.error(e.getMessage());
            return new ResponseEntity<Warehouse>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse/{code}",
            produces = {"application/json"}
    )
    @Override
    public ResponseEntity<Hop> getWarehouse(
            @Parameter(name = "code", description = "", required = true) @PathVariable("code") String code
    ) {
        try {
            Optional<HopEntity> responseEntity = warehouseService.findHop(code);

            String hopType = responseEntity.get().getHopType();
            Hop dto = HopMapper.INSTANCE.hopEntitiyToHopDto(responseEntity.get());
            dto.setHopType(hopType);
            log.info("Hop found with code: " + code);

            return new ResponseEntity<Hop>(dto, HttpStatus.OK);
        } catch (DALException e) {
            log.error(e.getMessage());
            return new ResponseEntity<Hop>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/warehouse",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @Override
    @ResponseBody
    public ResponseEntity<Void> importWarehouses(
            @Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse
    ) {
        try{

            WarehouseEntity warehouseEntities = WarehouseMapper.INSTANCE.warehouseDtoToWarehouseEntity(warehouse);
            warehouseService.importWarehouses(warehouseEntities);
            log.info("Warehouses imported!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}