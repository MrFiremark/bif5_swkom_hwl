package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {
}
