package database;

import entity.KhachHang;

public class ThemMoiKHDAO {

    // Thêm mới khách hàng vào database
    public void themKhachHang(KhachHang kh) {
        ArrayListMockDatabase.themKhachHang(kh);
    }
}
