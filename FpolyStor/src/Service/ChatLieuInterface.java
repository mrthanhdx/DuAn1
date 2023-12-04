/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.ChatLieu;

/**
 *
 * @author H
 */
public interface ChatLieuInterface {
    ArrayList<ChatLieu> getAll(int page, int limit);
    int add(ChatLieu cl);
    int update(ChatLieu cl, String id);
}
