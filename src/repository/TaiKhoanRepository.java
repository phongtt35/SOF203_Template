/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.TaiKhoan;

/**
 *
 * @author phongtt
 */
public class TaiKhoanRepository {
    
    private static final List<TaiKhoan> DANH_SACH_TAI_KHOAN 
            = new ArrayList<TaiKhoan>();
    static {
        DANH_SACH_TAI_KHOAN.add(new TaiKhoan("dungna29", "123456"));
        DANH_SACH_TAI_KHOAN.add(new TaiKhoan("tiennh21", "123456"));
        DANH_SACH_TAI_KHOAN.add(new TaiKhoan("nguyenvv4", "123456"));
        DANH_SACH_TAI_KHOAN.add(new TaiKhoan("hangnt169", "123456"));
        DANH_SACH_TAI_KHOAN.add(new TaiKhoan("phongtt35", "123456"));
    }
    
    public List<TaiKhoan> layDanhSachTaiKhoan() {
        return DANH_SACH_TAI_KHOAN;
    }
    
    public TaiKhoan timTaiKhoanTheoTen(String tenCanTim) {
        TaiKhoan taiKhoanCanTim = null; // Chưa tìm được
        
        for(TaiKhoan taiKhoan : DANH_SACH_TAI_KHOAN) {
            if (taiKhoan.getTenTaiKhoan().equals(tenCanTim)) {
                taiKhoanCanTim = taiKhoan;
                break;
            }
        }
        
        return taiKhoanCanTim;
    }
}
