package fit.se.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fit.se.backEnd.models.Donhang;
import java.util.List;
import java.util.Optional;

@Repository
public interface DonHangRepository extends JpaRepository<Donhang, Long> {

    @Query("SELECT d FROM Donhang d inner join d.maCuaHang c WHERE UPPER(d.maDonHang) LIKE UPPER(?1) " +
            "OR UPPER(c.ten) LIKE UPPER(?1) ")
    List<Donhang> findByKey(String key);

    @Query("SELECT d FROM Donhang d WHERE d.email = ?1")
    List<Donhang> findByEmail(String email);
}
