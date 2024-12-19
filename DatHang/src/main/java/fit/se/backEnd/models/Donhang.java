package fit.se.backEnd.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fit.se.backEnd.enums.TrangThai;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "ma_don_hang", nullable = false, length = 50)
    private String maDonHang;

    @ColumnDefault("0")
    @Column(name = "ten_khach_hang", nullable = false, length = 50)
    private String tenKhachHang;

    @ColumnDefault("0")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "ngay_thang_dat")
    private LocalDate ngayThangDat;

    @ColumnDefault("0")
    @Column(name = "ten_san_pham", nullable = false, length = 50)
    private String tenSanPham;

    @Column(name = "trang_thai", nullable = false)
    private TrangThai trangThai;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ma_cua_hang", nullable = false)
    private Cuahang maCuaHang;

}