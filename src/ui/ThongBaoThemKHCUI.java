package ui;

import java.util.Scanner;

public class ThongBaoThemKHCUI {
    private Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void thongBaoThemThanhCong() {
        showMessage("Khách hàng đã được thêm thành công!");
    }

    public void thongBaoThemThatBai() {
        showMessage("Thêm khách hàng không thành công. Vui lòng thử lại.");
    }
}
