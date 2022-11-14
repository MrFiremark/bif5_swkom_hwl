package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.validation.ValidatorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Slf4j
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private final RecipientRepository recipientRepository;

    @Autowired
    private final ValidatorUtil validatorUtil;
}
