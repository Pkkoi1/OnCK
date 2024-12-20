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
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_xe", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "ten_xe", nullable = false, length = 50)
    private String tenXe;

    @ColumnDefault("0")
    @Column(name = "gia", nullable = false)
    private Float gia;

    @ColumnDefault("0")
    @Column(name = "nam_sx", nullable = false)
    private Integer namSx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ma_loai", nullable = false)
    private LoaiXe maLoai;

}