/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.HoaDon1;
import Model.HoaDonChiTiet;


/**
 *
 * @author H
 */
public interface HoaDonInterface {
    ArrayList<HoaDon1> getAllHoaDon(int page, int limit);
    ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(String ma);
}
