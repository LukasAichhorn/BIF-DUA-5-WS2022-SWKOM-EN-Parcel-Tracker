package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.ParcelMapper;
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
            produces = { "application/json" }
    )
    @Override
    @ResponseBody
    public ResponseEntity<Warehouse> exportWarehouses() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse/{code}",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<Hop> getWarehouse(
            @Parameter(name = "code", description = "", required = true) @PathVariable("code") String code
    ) {
        System.out.println(code);
        return new ResponseEntity<>(HttpStatus.OK);

    }



    @RequestMapping(
            method = RequestMethod.POST,
            value = "/warehouse",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    @Override
    @ResponseBody
    public ResponseEntity<Void> importWarehouses(
            @Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse
    ) {
        System.out.println("sdsdsd");
        System.out.println(warehouse);
        WarehouseEntity warehouseEntities = WarehouseMapper.INSTANCE.warehouseDtoToWarehouseEntity(warehouse);
        warehouseService.importWarehouses(warehouseEntities);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}