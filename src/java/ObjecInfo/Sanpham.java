package ObjecInfo;

import java.sql.Date;

/**
 *
 * @author khanhvh
 */
public class Sanpham {
    int sp_ma;
    String sp_ten;
    long sp_giaGoc;
    long sp_giaBan;
    String sp_hinh;
    String sp_thongTin;
    String sp_danhGia;
    Date sp_taoMoi;
    Date sp_capNhat;
    int sp_trangThai;
    int l_ma;
    String l_ten;

    public Sanpham(int sp_ma, String sp_ten, long sp_giaGoc, long sp_giaBan, String sp_hinh, String sp_thongTin, String sp_danhGia, Date sp_taoMoi, Date sp_capNhat, int sp_trangThai, int l_ma) {
        this.sp_ma = sp_ma;
        this.sp_ten = sp_ten;
        this.sp_giaGoc = sp_giaGoc;
        this.sp_giaBan = sp_giaBan;
        this.sp_hinh = sp_hinh;
        this.sp_thongTin = sp_thongTin;
        this.sp_danhGia = sp_danhGia;
        this.sp_taoMoi = sp_taoMoi;
        this.sp_capNhat = sp_capNhat;
        this.sp_trangThai = sp_trangThai;
        this.l_ma = l_ma;
    }

    public int getSp_ma() {
        return sp_ma;
    }

    public void setSp_ma(int sp_ma) {
        this.sp_ma = sp_ma;
    }

    public String getSp_ten() {
        return sp_ten;
    }

    public void setSp_ten(String sp_ten) {
        this.sp_ten = sp_ten;
    }

    public long getSp_giaGoc() {
        return sp_giaGoc;
    }

    public void setSp_giaGoc(long sp_giaGoc) {
        this.sp_giaGoc = sp_giaGoc;
    }

    public long getSp_giaBan() {
        return sp_giaBan;
    }

    public void setSp_giaBan(long sp_giaBan) {
        this.sp_giaBan = sp_giaBan;
    }

    public String getSp_hinh() {
        return sp_hinh;
    }

    public void setSp_hinh(String sp_hinh) {
        this.sp_hinh = sp_hinh;
    }

    public String getSp_thongTin() {
        return sp_thongTin;
    }

    public void setSp_thongTin(String sp_thongTin) {
        this.sp_thongTin = sp_thongTin;
    }

    public String getSp_danhGia() {
        return sp_danhGia;
    }

    public void setSp_danhGia(String sp_danhGia) {
        this.sp_danhGia = sp_danhGia;
    }

    public Date getSp_taoMoi() {
        return sp_taoMoi;
    }

    public void setSp_taoMoi(Date sp_taoMoi) {
        this.sp_taoMoi = sp_taoMoi;
    }

    public Date getSp_capNhat() {
        return sp_capNhat;
    }

    public void setSp_capNhat(Date sp_capNhat) {
        this.sp_capNhat = sp_capNhat;
    }

    public int getSp_trangThai() {
        return sp_trangThai;
    }

    public void setSp_trangThai(int sp_trangThai) {
        this.sp_trangThai = sp_trangThai;
    }

    public int getL_ma() {
        return l_ma;
    }

    public void setL_ma(int l_ma) {
        this.l_ma = l_ma;
    }

    public String getL_ten() {
        return l_ten;
    }

    public void setL_ten(String l_ten) {
        this.l_ten = l_ten;
    }
    
    
}
