/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.util.List;
/**
 *
 * @author may islem
 * 
 */
public interface ISinistre<T>{

    
    void Insert(T t);
    void Delete(int id);
    void update(T t);
    List<T> getall();
    
}
