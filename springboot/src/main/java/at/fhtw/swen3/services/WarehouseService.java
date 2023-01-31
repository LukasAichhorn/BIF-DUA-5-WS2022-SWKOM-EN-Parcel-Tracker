package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;

import java.util.Optional;

public interface WarehouseService {

    void importWarehouses(WarehouseEntity warehouseEntities);

    Optional<HopEntity> findHop(String code) throws DALException;

    Optional<WarehouseEntity> getAllWarehouses() throws DALException;
}
