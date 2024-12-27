package control;

import entity.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHoaDon {
    private List<KhachHang> danhSachKhachHang = new ArrayList<>();

    // Thêm khách hàng vào danh sách
    public void themKhachHang(KhachHang khachHang) {
        danhSachKhachHang.add(khachHang);
        System.out.println("Đã thêm khách hàng: " + khachHang.getHoTen());
    }

    // Xóa khách hàng theo mã
    public boolean xoaKhachHang(String maKhachHang) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equalsIgnoreCase(maKhachHang));
    }

    // Tìm khách hàng theo mã
    public KhachHang timKhachHang(String maKhachHang) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                return kh;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // Lấy danh sách khách hàng
    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    // Xuất hóa đơn theo tháng
    public List<KhachHang> xuatHoaDonTheoThang(String thang) {
        List<KhachHang> ketQua = new ArrayList<>();
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getNgayRaHoaDon().startsWith(thang)) {
                ketQua.add(kh);
            }
        }
        return ketQua;
    }

    // Tính tổng số lượng điện tiêu thụ theo loại khách hàng
    public double tinhTongSoLuongTheoLoai(Class<?> loaiKhachHang) {
        return danhSachKhachHang.stream()
            .filter(kh -> loaiKhachHang.isInstance(kh))
            .mapToDouble(KhachHang::getSoLuong)
            .sum();
    }

    // Tính trung bình thành tiền của khách hàng nước ngoài
    public double tinhTrungBinhThanhTienNN() {
        double tongThanhTien = 0;
        int soKhachHangNN = 0;

        for (KhachHang kh : danhSachKhachHang) {
            if (kh instanceof entity.KhachHangNN) {
                tongThanhTien += kh.getSoLuong() * kh.getDonGia();
                soKhachHangNN++;
            }
        }

        return soKhachHangNN > 0 ? tongThanhTien / soKhachHangNN : 0;
    }

    // In toàn bộ danh sách khách hàng
    public void inDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng hiện tại rỗng.");
            return;
        }
        System.out.println("Danh sách khách hàng:");
        for (KhachHang kh : danhSachKhachHang) {
            System.out.println(kh); // Gọi phương thức toString() của KhachHang
        }
    }
}
