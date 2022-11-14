package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.services.HopArrivalService;
import at.fhtw.swen3.services.validation.ValidatorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Slf4j
public class HopArrivalServiceImpl implements HopArrivalService {

    @Autowired
    private final HopArrivalRepository hopArrivalRepository;

    @Autowired
    private final ValidatorUtil validatorUtil;

}
