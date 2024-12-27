package database;

import entity.KhachHang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InDSKHDAOFile implements InDSKHDAO {

    private final String FILE_PATH = "danhSachKhachHang.dat";

    @Override
    public List<KhachHang> getDanhSachKhachHang() {
        List<KhachHang> danhSachKH = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("File không tồn tại.");
            return danhSachKH;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            danhSachKH = (List<KhachHang>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return danhSachKH;
    }

    @Override
    public void themKhachHang(KhachHang kh) {
        List<KhachHang> danhSachKH = getDanhSachKhachHang();
        danhSachKH.add(kh);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(danhSachKH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void capNhatKhachHang(KhachHang kh) {
        List<KhachHang> danhSachKH = getDanhSachKhachHang();
        for (int i = 0; i < danhSachKH.size(); i++) {
            if (danhSachKH.get(i).getMaKhachHang().equals(kh.getMaKhachHang())) {
                danhSachKH.set(i, kh);
                break;
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(danhSachKH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaKhachHang(String maKH) {
        List<KhachHang> danhSachKH = getDanhSachKhachHang();
        danhSachKH.removeIf(kh -> kh.getMaKhachHang().equals(maKH));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(danhSachKH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
