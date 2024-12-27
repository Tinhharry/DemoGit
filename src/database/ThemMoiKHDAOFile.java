package database;

import entity.KhachHang;

public class ThemMoiKHDAOFile {

    // Thêm mới khách hàng vào file
    public void themKhachHang(KhachHang kh) {
        InDSKHDAOFile daoFile = new InDSKHDAOFile();
        daoFile.themKhachHang(kh);
    }
}
