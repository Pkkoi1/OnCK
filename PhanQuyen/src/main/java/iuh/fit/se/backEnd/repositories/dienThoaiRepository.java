package iuh.fit.se.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iuh.fit.se.backEnd.models.DienThoai;

@Repository
public interface dienThoaiRepository extends JpaRepository<DienThoai, Long> {

}
