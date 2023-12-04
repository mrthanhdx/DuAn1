/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Users;
import Model.UsersViewmodel;
import java.util.List;


/**
 *
 * @author Admin
 */
public interface IUsersService {

    public List<UsersViewmodel> getAllNhanVien();

    boolean add(UsersViewmodel nv);

    boolean update(UsersViewmodel us,String id);

    boolean delete(String id);

    List<UsersViewmodel> SearchNVV(String Ten);

    boolean updateMK(UsersViewmodel us, String mail);

    String kiemtra(String mail);
    
    Users getUserbytk(String tk);

    String kiemtrasdt(String sdt);

    String kiemtratk(String tk);

}
