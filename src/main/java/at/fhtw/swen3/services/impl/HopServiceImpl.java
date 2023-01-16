package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.services.HopService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class HopServiceImpl implements HopService {

    @Autowired
    private final HopRepository hopRepository;

    @Override
    public String getHopEntityByCode(String code) throws PersistenceException, JsonProcessingException {
        HopEntity hopEntity = hopRepository.findByCode(code);
        if(hopEntity == null){
            throw new PersistenceException();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(hopEntity);
    }
}
