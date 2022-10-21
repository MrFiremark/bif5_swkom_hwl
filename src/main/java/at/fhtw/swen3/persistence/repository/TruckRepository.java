package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<TruckEntity, Long> {
}
