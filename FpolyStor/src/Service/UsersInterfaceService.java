/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import Model.Users1;

/**
 *
 * @author H
 */
public interface UsersInterfaceService {
    ArrayList<Users1> getAllUsers();
    public int login(Users1 u);
    List<Users1> getUser(String TaiKhoan , String MatKhau);
}
