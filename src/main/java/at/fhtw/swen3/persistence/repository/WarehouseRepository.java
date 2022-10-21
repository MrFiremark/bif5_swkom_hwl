package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {
}
