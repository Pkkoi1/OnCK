package iuh.fit.se.backEnd.repositories;

import iuh.fit.se.backEnd.models.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XeRepository extends JpaRepository<Xe, Long> {
    @Query("SELECT x FROM Xe x inner join x.maLoai ml WHERE ml.id = ?1")
    List<Xe> findByMaXe(int loaiXe);
}
