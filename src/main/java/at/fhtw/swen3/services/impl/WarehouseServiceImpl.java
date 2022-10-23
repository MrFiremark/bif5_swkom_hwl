package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repository.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;
}
