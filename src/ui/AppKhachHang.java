package ui;

import entity.KhachHang;
import entity.KhachHangVN;
import entity.KhachHangNN;
import entity.HoaDon;
import control.QuanLyHoaDon;
import control.ThemMoiKHControl;

import java.util.Scanner;

public class AppKhachHang {

    private static QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
    private static ThemMoiKHControl themMoiKHControl = new ThemMoiKHControl();

    public static void main(String[] args) {
        MenuCUI menu = new MenuCUI();
        menu.showMenu();
    }
}
