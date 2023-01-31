package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private HopRepository hopRepository;
    private WarehouseRepository warehouseRepository;

    @Override
    public void importWarehouses(WarehouseEntity warehouseEntities) {
        hopRepository.save(warehouseEntities);

    }

    @Override
    public Optional<HopEntity> findHop(String code) throws DALException {
        Optional<HopEntity> hopEntity =  hopRepository.findByCode(code);
        if(hopEntity.isPresent()){
            return hopEntity;
        }
        else{
            throw new DALException("Could not find Hop with code: " + code);
        }
    }

    @Override
    public Optional<WarehouseEntity> getAllWarehouses() throws DALException {
        Optional<WarehouseEntity> retValue = hopRepository.findByLevel(0);
        if(retValue.isPresent()){
            return retValue;
        }
        else{
            throw new DALException("Could not get List of Warehouses. Database error!");
        }
    }


}
