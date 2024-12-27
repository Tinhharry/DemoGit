package entity;

public class KhachHangNN extends KhachHang {
    private String quocTich;

    public KhachHangNN(String maKhachHang, String hoTen, String ngayRaHoaDon, double soLuong, double donGia, String quocTich) {
        super(maKhachHang, hoTen, ngayRaHoaDon, soLuong, donGia);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return super.toString() + ", quocTich = " + quocTich + "";
    }
}
