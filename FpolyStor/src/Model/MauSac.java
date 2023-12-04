/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author H
 */
public class MauSac {
     private String idMau;
    private String tenMau;

    public MauSac() {
    }

    public MauSac(String idMau, String tenMau) {
        this.idMau = idMau;
        this.tenMau = tenMau;
    }

    public String getIdMau() {
        return idMau;
    }

    public void setIdMau(String idMau) {
        this.idMau = idMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return "MauSac{" + "idMau=" + idMau + ", tenMau=" + tenMau + '}';
    }
    
}
