package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.TransferwarehouseRepository;
import at.fhtw.swen3.services.TransferwarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Slf4j
public class TransferwarehouseServiceImpl implements TransferwarehouseService {

    @Autowired
    private final TransferwarehouseRepository transferwarehouseRepository;
}
