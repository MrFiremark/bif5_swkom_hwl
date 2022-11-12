package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repository.RecipientRepository;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.dto.Recipient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {

    private RecipientRepository recipientRepository;
}
