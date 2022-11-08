package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {
}