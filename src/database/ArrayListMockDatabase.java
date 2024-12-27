package database;

import entity.KhachHang;
import entity.HoaDon;
import java.util.ArrayList;
import java.util.List;

public class ArrayListMockDatabase {

    private static List<KhachHang> danhSachKH = new ArrayList<>();
    private static List<HoaDon> danhSachHoaDon = new ArrayList<>();

    // Thêm khách hàng vào cơ sở dữ liệu
    public static void themKhachHang(KhachHang kh) {
        danhSachKH.add(kh);
    }

    // Lấy danh sách khách hàng
    public static List<KhachHang> getDanhSachKH() {
        return danhSachKH;
    }

    // Thêm hóa đơn vào cơ sở dữ liệu
    public static void themHoaDon(HoaDon hoaDon) {
        danhSachHoaDon.add(hoaDon);
    }

    // Lấy danh sách hóa đơn
    public static List<HoaDon> getDanhSachHoaDon() {
        return danhSachHoaDon;
    }

    // Xóa khách hàng khỏi cơ sở dữ liệu
    public static void xoaKhachHang(String maKH) {
        danhSachKH.removeIf(kh -> kh.getMaKhachHang().equals(maKH));
    }

    // Cập nhật thông tin khách hàng
    public static void capNhatKhachHang(KhachHang kh) {
        for (int i = 0; i < danhSachKH.size(); i++) {
            if (danhSachKH.get(i).getMaKhachHang().equals(kh.getMaKhachHang())) {
                danhSachKH.set(i, kh);
                break;
            }
        }
    }
}
