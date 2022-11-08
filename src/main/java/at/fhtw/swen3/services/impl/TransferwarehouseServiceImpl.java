package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repository.TransferwarehouseRepository;
import at.fhtw.swen3.services.TransferwarehouseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransferwarehouseServiceImpl implements TransferwarehouseService {

    private TransferwarehouseRepository transferwarehouseRepository;
}
