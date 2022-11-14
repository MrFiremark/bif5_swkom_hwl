package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.services.HopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Slf4j
public class HopServiceImpl implements HopService {

    @Autowired
    private final HopRepository hopRepository;
}
