package Service;

import Model.User;
import java.util.ArrayList;
import java.util.List;

public interface IUserRepostory {
    
//     public List<User> getUser();
     public ArrayList<User> getAllUsers();
      public int login(User u);
      public List<User> getUser(String TaiKhoan, String MatKhau);
}