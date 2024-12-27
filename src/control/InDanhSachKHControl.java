package control;

import entity.KhachHang;
import java.util.ArrayList;
import java.util.List;

public class InDanhSachKHControl {
    private List<KhachHang> danhSachKhachHang;

    public InDanhSachKHControl() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    // Thêm khách hàng
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }

    // Xóa khách hàng
    public void xoaKhachHang(String maKH) {
        danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equals(maKH));
    }

    // Sửa thông tin khách hàng
    public void suaKhachHang(KhachHang khMoi) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaKhachHang().equals(khMoi.getMaKhachHang())) {
                danhSachKhachHang.set(i, khMoi);
                return;
            }
        }
    }

    // Trả về danh sách khách hàng
    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    // In danh sách khách hàng ra màn hình
    public void inDanhSachKhachHang() {
        for (KhachHang kh : danhSachKhachHang) {
            System.out.println(kh);
        }
    }
}
