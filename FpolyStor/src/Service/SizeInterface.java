/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.Size;

/**
 *
 * @author H
 */
public interface SizeInterface {
    ArrayList<Size> getAll(int page, int limit);
    int add(Size s);
    int update(Size s, String id);

}
