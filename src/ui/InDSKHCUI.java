package ui;

import entity.KhachHang;

import java.util.List;

public class InDSKHCUI {

    public void inDanhSachKhachHang(List<KhachHang> danhSachKH) {
        System.out.println("\nDanh sách khách hàng:");
        for (KhachHang kh : danhSachKH) {
            System.out.println("Mã khách hàng: " + kh.getMaKhachHang() + ", Tên: " + kh.getHoTen());
        }
    }
}
