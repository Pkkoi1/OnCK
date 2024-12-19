package iuh.fit.se.backEnd.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "loai_dien_thoai")
public class LoaiDienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai", nullable = false)
    private Integer id;

    @Column(name = "ten_loai", nullable = false, length = 50)
    private String tenLoai;

    @Column(name = "mo_Ta", nullable = false, length = 50)
    private String moTa;

}