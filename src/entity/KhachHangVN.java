package entity;

public class KhachHangVN extends KhachHang {
    private double dinhMuc;

    // Constructor đầy đủ
    public KhachHangVN(String maKhachHang, String hoTen, String ngayRaHoaDon, double soLuong, double donGia, double dinhMuc) {
        super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia); // Gọi constructor của lớp cha KhachHang
        this.dinhMuc = dinhMuc; // Khởi tạo thuộc tính riêng dinhMuc
    }

    // Getter và Setter cho dinhMuc
    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    // Override phương thức toString để thêm thông tin dinhMuc
    @Override
    public String toString() {
        return super.toString() + ", Định mức: " + dinhMuc;
    }
}
