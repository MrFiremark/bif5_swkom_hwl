package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repository.HopArrivalRepository;
import at.fhtw.swen3.services.HopArrivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class HopArrivalServiceImpl implements HopArrivalService {

    private HopArrivalRepository hopArrivalRepository;


}
