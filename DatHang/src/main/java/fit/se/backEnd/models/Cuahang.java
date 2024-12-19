package fit.se.backEnd.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuahang")
public class Cuahang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cua_hang", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @OneToMany(mappedBy = "maCuaHang")
    private List<Donhang> donhangs = new ArrayList<>();

}