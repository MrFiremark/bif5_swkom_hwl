package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.services.TruckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Slf4j
public class TruckServiceImpl implements TruckService {

    @Autowired
    private final TruckRepository truckRepository;
}
