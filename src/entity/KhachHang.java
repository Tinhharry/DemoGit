package entity;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String ngayRaHoaDon;
    private double soLuong;
    private double donGia;

    // Constructor
    public KhachHang(String maKhachHang, String hoTen, String ngayRaHoaDon, double soLuong, double donGia) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Getters và Setters
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(String ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "Mã KH: " + maKhachHang +
                ", Họ tên: " + hoTen +
                ", Ngày hóa đơn: " + ngayRaHoaDon +
                ", Số lượng: " + soLuong +
                ", Đơn giá: " + donGia;
    }

    // Phương thức tính thành tiền
    public double tinhThanhTien() {
        return soLuong * donGia; // Thành tiền = Số lượng * Đơn giá
    }
}
