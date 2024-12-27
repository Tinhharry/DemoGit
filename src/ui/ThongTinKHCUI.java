package ui;

import entity.KhachHang;

public class ThongTinKHCUI {

    public void hienThiThongTinKhachHang(KhachHang kh) {
        if (kh == null) {
            System.out.println("Khách hàng không tồn tại.");
            return;
        }
        System.out.println("Thông tin khách hàng:");
        System.out.println("Mã khách hàng: " + kh.getMaKhachHang());
        System.out.println("Họ tên: " + kh.getHoTen());
        System.out.println("Ngày ra hóa đơn: " + kh.getNgayRaHoaDon());
        System.out.println("Số lượng: " + kh.getSoLuong());
        System.out.println("Đơn giá: " + kh.getDonGia());
        System.out.println("Thành tiền: " + kh.tinhThanhTien());
    }
}
