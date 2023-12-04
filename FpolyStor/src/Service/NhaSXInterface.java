/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.NhaSX;

/**
 *
 * @author H
 */
public interface NhaSXInterface {
    ArrayList<NhaSX> getAll(int page, int limit);
    int add(NhaSX ns);
    int update(NhaSX ns, String id);

}
