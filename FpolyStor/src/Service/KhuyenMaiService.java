/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Model.KhuyenMai;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public interface KhuyenMaiService {

    public List<KhuyenMai> GetAll();

    public boolean Add(KhuyenMai km);

    public boolean Update(KhuyenMai km, String id);

    public boolean Delete(String id);

    public String checktrung(String ten);

    public List<KhuyenMai> GetOnebyBD(String date);

    public List<KhuyenMai> GetOnebyKT(String date);

    public List<KhuyenMai> GetOnebyALL(String datedb, String datekt);

    public List<KhuyenMai> GetOnebyten(String ten);

    public boolean UpdateTT();

    public boolean UpdateTT2();

    public KhuyenMai getbyid(int id);
    
    public List<KhuyenMai> loadPaging(int PageNum,int RowFetch);
}
