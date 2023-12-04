/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.ThuongHieu;

/**
 *
 * @author H
 */
public interface ThuongHieuInterfacec {
    ArrayList<ThuongHieu> getAll(int page, int limit);
    int add(ThuongHieu th);
    int update(ThuongHieu th, String id);

}
