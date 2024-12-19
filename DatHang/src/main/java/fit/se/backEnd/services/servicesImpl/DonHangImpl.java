package fit.se.backEnd.services.servicesImpl;

import fit.se.backEnd.enums.TrangThai;
import fit.se.backEnd.models.Donhang;
import fit.se.backEnd.repositories.DonHangRepository;
import fit.se.backEnd.services.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
class DonHangImpl implements DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;

    public List<Donhang> getAllDonHang() {
        return (List<Donhang>) donHangRepository.findAll();
    }

    public List<Donhang> findbyKey(String key)
    {
        List<Donhang> donhang = donHangRepository.findByKey(key);
        return donhang;

    }
    public String generateMaDonHang() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(formatter);
    }


    public String addDonHang(Donhang donhang) {
        if (donhang.getTenKhachHang().length() > 50 || donhang.getTenKhachHang().length() < 5) {
            return "Tên khách hàng phải từ 5 đến 50 ký tự";
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(donhang.getEmail()).matches()) {
            return "Email không hợp lệ";
        }

        if (donhang.getNgayThangDat().isBefore(LocalDate.now())) {
            return "Ngày đặt không hợp lệ";
        }
        if(checkDonHangDaDat(donhang.getEmail(), donhang.getNgayThangDat()) == false)
            return "Đơn hàng đã được đặt";
        donHangRepository.save(donhang);
        return "Thêm đơn hàng thành công";
    }

    public boolean checkDonHangDaDat(String email, LocalDate ngayThangDat) {
        List<Donhang> donhangs = donHangRepository.findByEmail(email);
        for (Donhang donhang : donhangs) {
            if (donhang.getNgayThangDat().equals(ngayThangDat)) {
                return false;
            }
        }
        return true;
    }


    public boolean deleteDonHang(Long id) {
        if (donHangRepository.findById(id).isPresent()) {
            donHangRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
