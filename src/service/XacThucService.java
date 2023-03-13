/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.TaiKhoan;
import repository.TaiKhoanRepository;

/**
 *
 * @author phongtt
 */
public class XacThucService {
    
    private final TaiKhoanRepository taiKhoanRepository
            = new TaiKhoanRepository();
    
    public Integer xacThucTaiKhoan(TaiKhoan taiKhoanCanXacThuc) {
        
        String tenTaiKhoanCanXacThuc = 
                taiKhoanCanXacThuc.getTenTaiKhoan();
        
        TaiKhoan taiKhoanTimKiem = 
                taiKhoanRepository.timTaiKhoanTheoTen(tenTaiKhoanCanXacThuc);
        if (taiKhoanTimKiem != null) { // khác null = có dữ liệu => Tìm thấy
            String matKhauCanXacThuc = taiKhoanCanXacThuc.getMatKhau();
            System.out.println(matKhauCanXacThuc);
            if (taiKhoanTimKiem.getMatKhau().equals(matKhauCanXacThuc)) {
                return 1; // Xác thực thành công
            } else {
                return -1; // Sai mật khẩu
            }
        }
        
        return 0; // Xác thực thất bại -> Tài khoản không tồn tại
    }
}
