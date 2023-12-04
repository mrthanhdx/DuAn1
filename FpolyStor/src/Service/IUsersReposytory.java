/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Users;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IUsersReposytory {

    public List<Users> getAllNhanVien();

    boolean add(Users nv);

    boolean update(Users us, String id);

    boolean delete(String id);

    List<Users> SearchNVV(String Ten);

    boolean updateMK(Users us, String mail);

    String kiemtra(String mail);
    String kiemtrasdt(String sdt);
    String kiemtratk(String tk);

    Users getUserbytk(String tk);
    
   public List<Users> loadPaging(int pageNum,int fetchRow);
}
