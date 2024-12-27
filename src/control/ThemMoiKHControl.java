package control;

import entity.KhachHang;
import java.util.List;
import java.util.Scanner;

public class ThemMoiKHControl {
    // Phương thức thêm khách hàng
    public void themKhachHang(List<KhachHang> danhSachKhachHang) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập thông tin khách hàng
        System.out.print("Nhập mã khách hàng: ");
        String maKhachHang = scanner.nextLine();
        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập ngày ra hóa đơn (dd/MM/yyyy): ");
        String ngayRaHoaDon = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        double soLuong = scanner.nextDouble();
        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        
        // Tạo đối tượng KhachHang và thêm vào danh sách
        KhachHang kh = new KhachHang(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
        danhSachKhachHang.add(kh);
        
        System.out.println("Khách hàng đã được thêm thành công.");
    }
}
