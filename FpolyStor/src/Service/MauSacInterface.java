/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.MauSac;

/**
 *
 * @author H
 */
public interface MauSacInterface {
    ArrayList<MauSac> getAll(int page, int limit);
    public int them(MauSac ms);
    public int sua(MauSac ms, String id);
}
