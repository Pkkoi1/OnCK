package iuh.fit.se.backEnd.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "dien_thoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "ten_dien_loai", nullable = false, length = 50)
    private String tenDienLoai;

    @ColumnDefault("0")
    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @ColumnDefault("0")
    @Column(name = "gia_von", nullable = false)
    private Double giaVon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "loai", nullable = false)
    private LoaiDienThoai loai;

    @ColumnDefault("0")
    @Column(name = "nha_cung_cap", nullable = false, length = 50)
    private String nhaCungCap;

}