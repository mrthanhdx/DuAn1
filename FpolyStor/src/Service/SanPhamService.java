/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.SanPham;
import java.util.List;

/**
 *
 * @author trant
 */
public interface SanPhamService {

    public boolean addSP(SanPham sp);


    public boolean updateSP(SanPham sp);
    
    public List<SanPham> getAllSanPham();

}
