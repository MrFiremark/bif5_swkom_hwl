package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repository.HopRepository;
import at.fhtw.swen3.services.HopService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HopServiceImpl implements HopService {

    private HopRepository hopRepository;


}
