package iuh.fit.se.backEnd.repositories;

import iuh.fit.se.backEnd.models.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiXeRepository extends JpaRepository<LoaiXe, Long> {
}
