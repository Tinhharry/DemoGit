package database;

import entity.KhachHang;
import java.util.List;

public interface InDSKHDAO {
    List<KhachHang> getDanhSachKhachHang();  // Lấy danh sách khách hàng
    void themKhachHang(KhachHang kh);         // Thêm khách hàng mới
    void capNhatKhachHang(KhachHang kh);      // Cập nhật khách hàng
    void xoaKhachHang(String maKH);           // Xóa khách hàng
}
