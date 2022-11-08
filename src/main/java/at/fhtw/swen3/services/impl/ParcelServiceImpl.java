package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repository.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private ParcelRepository parcelRepository;
}
