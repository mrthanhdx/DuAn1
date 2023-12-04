/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trant
 */
public class GioHang {
    private int id;
    private int idSP;
    private int soLuong;
    private float tongTien;

    public int getId() {
        return id;
    }

    public int getIdSP() {
        return idSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(float donGia) {
        this.tongTien = this.soLuong*donGia;
    }
    
    
}
