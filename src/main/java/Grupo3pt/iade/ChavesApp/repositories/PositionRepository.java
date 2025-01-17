package Grupo3pt.iade.ChavesApp.repositories;

import Grupo3pt.iade.ChavesApp.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
