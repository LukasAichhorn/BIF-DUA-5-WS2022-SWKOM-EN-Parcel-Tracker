package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;

public interface WarehouseService {

    void importWarehouses(WarehouseEntity warehouseEntities);
}
