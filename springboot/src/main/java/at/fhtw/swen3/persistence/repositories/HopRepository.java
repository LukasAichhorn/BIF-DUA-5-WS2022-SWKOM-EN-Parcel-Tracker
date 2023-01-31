package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HopRepository extends JpaRepository<HopEntity, String> {
    Optional<HopEntity> findByCode(String code);
    Optional<WarehouseEntity> findByLevel(int level);

}
