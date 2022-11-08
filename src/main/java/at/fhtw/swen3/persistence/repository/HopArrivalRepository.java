package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Long> {
}
