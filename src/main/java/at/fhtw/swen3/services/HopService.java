package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Service
public interface HopService {
    String getHopEntityByCode(String code) throws PersistenceException, JsonProcessingException;
}
