package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopRepository extends JpaRepository<HopEntity, Long> {
}
