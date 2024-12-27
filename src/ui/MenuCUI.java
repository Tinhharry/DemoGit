package ui;

import control.QuanLyHoaDon;
import control.ThemMoiKHControl;
import entity.KhachHang;
import entity.KhachHangVN;
import entity.KhachHangNN;

import java.util.List;
import java.util.Scanner;

public class MenuCUI {
    private Scanner scanner = new Scanner(System.in);
    private QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
    private ThemMoiKHControl themMoiKHControl = new ThemMoiKHControl();

    // Phương thức nhập giá trị double hợp lệ
    private double getValidDoubleInput(String prompt) {
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                value = scanner.nextDouble();
                scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
                if (value <= 0) {
                    System.out.println("Giá trị phải là số dương. Vui lòng nhập lại.");
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu. Vui lòng nhập lại.");
                scanner.nextLine(); // Tiêu thụ ký tự sai
            }
        }
        return value;
    }

    // Phương thức thêm khách hàng
    private void themKhachHang() {
        System.out.println("Chọn loại khách hàng:");
        System.out.println("1. Khách hàng Việt Nam");
        System.out.println("2. Khách hàng Nước Ngoài");
        System.out.print("Nhập lựa chọn: ");
        int loaiKH = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng

        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập ngày ra hóa đơn (dd/MM/yyyy): ");
        String ngayRaHoaDon = scanner.nextLine();
        double soLuong = getValidDoubleInput("Nhập số điện tiêu thụ: ");
        double donGia = getValidDoubleInput("Nhập đơn giá: ");

        if (loaiKH == 1) {
            System.out.print("Nhập định mức: ");
            double dinhMuc = getValidDoubleInput("");
            quanLyHoaDon.themKhachHang(new KhachHangVN(maKH, hoTen, ngayRaHoaDon, soLuong, donGia, dinhMuc));
        } else if (loaiKH == 2) {
            System.out.print("Nhập quốc tịch: ");
            String quocTich = scanner.nextLine();
            quanLyHoaDon.themKhachHang(new KhachHangNN(maKH, hoTen, ngayRaHoaDon, soLuong, donGia, quocTich));
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // Phương thức xóa khách hàng
    private void xoaKhachHang() {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKhachHang = scanner.nextLine();
        if (quanLyHoaDon.xoaKhachHang(maKhachHang)) {
            System.out.println("Khách hàng đã được xóa.");
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }

    // Phương thức sửa thông tin khách hàng
    private void suaThongTinKhachHang() {
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String maKhachHang = scanner.nextLine();
        KhachHang khachHang = quanLyHoaDon.timKhachHang(maKhachHang);
        if (khachHang != null) {
            System.out.print("Nhập số điện tiêu thụ mới: ");
            double soLuongMoi = getValidDoubleInput("Số điện tiêu thụ mới: ");
            System.out.print("Nhập đơn giá mới: ");
            double donGiaMoi = getValidDoubleInput("Đơn giá mới: ");

            khachHang.setSoLuong(soLuongMoi);
            khachHang.setDonGia(donGiaMoi);
            System.out.println("Thông tin khách hàng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }

    // Phương thức in danh sách khách hàng
    private void inDanhSachKhachHang() {
        List<KhachHang> danhSachKhachHang = quanLyHoaDon.getDanhSachKhachHang();
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng hiện tại rỗng.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : danhSachKhachHang) {
                System.out.println(kh);
            }
        }
    }

    // Phương thức tìm kiếm hóa đơn
    private void timKiemHoaDon() {
        System.out.print("Nhập mã khách hàng hoặc tháng cần tìm (dd/MM/yyyy hoặc mã): ");
        String input = scanner.nextLine();

        List<KhachHang> danhSachKhachHang = quanLyHoaDon.getDanhSachKhachHang();
        boolean found = false;

        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equalsIgnoreCase(input) || kh.getNgayRaHoaDon().startsWith(input)) {
                System.out.println("Hóa đơn tìm thấy:");
                System.out.println(kh);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn với thông tin: " + input);
        }
    }

    // Phương thức tính tổng số lượng khách hàng theo loại
    private void tinhTongSoLuongKH() {
        List<KhachHang> danhSachKhachHang = quanLyHoaDon.getDanhSachKhachHang();
        double tongVN = danhSachKhachHang.stream()
            .filter(kh -> kh instanceof KhachHangVN)
            .mapToDouble(KhachHang::getSoLuong)
            .sum();
        double tongNN = danhSachKhachHang.stream()
            .filter(kh -> kh instanceof KhachHangNN)
            .mapToDouble(KhachHang::getSoLuong)
            .sum();
        System.out.println("Tổng số lượng khách hàng Việt Nam: " + tongVN);
        System.out.println("Tổng số lượng khách hàng Nước Ngoài: " + tongNN);
    }

    // Phương thức tính trung bình thành tiền khách hàng nước ngoài
    private void tinhTrungBinhThanhTienNN() {
        List<KhachHang> danhSachKhachHang = quanLyHoaDon.getDanhSachKhachHang();
        double tongThanhTien = danhSachKhachHang.stream()
            .filter(kh -> kh instanceof KhachHangNN)
            .mapToDouble(kh -> kh.getSoLuong() * kh.getDonGia())
            .sum();
        long soLuongNN = danhSachKhachHang.stream()
            .filter(kh -> kh instanceof KhachHangNN)
            .count();
        if (soLuongNN > 0) {
            System.out.println("Trung bình thành tiền khách hàng nước ngoài: " + (tongThanhTien / soLuongNN));
        } else {
            System.out.println("Không có khách hàng nước ngoài.");
        }
    }

    // Phương thức xuất hóa đơn theo tháng
    private void xuatHoaDonTheoThang() {
        System.out.print("Nhập tháng cần xuất hóa đơn (tháng dạng MM): ");
        String thangNhap = scanner.nextLine();

        List<KhachHang> danhSachKhachHang = quanLyHoaDon.getDanhSachKhachHang();
        boolean found = false;

        for (KhachHang kh : danhSachKhachHang) {
            String thangHoaDon = kh.getNgayRaHoaDon().substring(3, 5); // Lấy tháng từ ngày (dd/MM/yyyy)
            if (thangHoaDon.equals(thangNhap)) {
                System.out.println("Hóa đơn tháng " + thangNhap + ":");
                System.out.println(kh);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có hóa đơn nào trong tháng " + thangNhap);
        }
    }

    // Phương thức hiển thị menu và xử lý các lựa chọn
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n==== Menu Quản Lý Hóa Đơn ====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Xóa khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. In danh sách khách hàng");
            System.out.println("5. Tìm kiếm hóa đơn");
            System.out.println("6. Tính tổng số lượng khách hàng");
            System.out.println("7. Tính trung bình thành tiền khách hàng nước ngoài");
            System.out.println("8. Xuất hóa đơn theo tháng");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ ký tự xuống dòng

            switch (choice) {
                case 1:
                    themKhachHang();
                    break;
                case 2:
                    xoaKhachHang();
                    break;
                case 3:
                    suaThongTinKhachHang();
                    break;
                case 4:
                    inDanhSachKhachHang();
                    break;
                case 5:
                    timKiemHoaDon();
                    break;
                case 6:
                    tinhTongSoLuongKH();
                    break;
                case 7:
                    tinhTrungBinhThanhTienNN();
                    break;
                case 8:
                    xuatHoaDonTheoThang();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;  
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }
}
