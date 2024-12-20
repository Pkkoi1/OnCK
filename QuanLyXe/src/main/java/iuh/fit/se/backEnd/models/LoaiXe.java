package iuh.fit.se.backEnd.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "loai_xe")
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "ten_loai", nullable = false, length = 50)
    private String tenLoai;

}