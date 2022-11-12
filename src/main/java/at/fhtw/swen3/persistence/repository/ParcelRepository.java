package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {
    ParcelEntity findByTrackingId(String trackingId);
}
