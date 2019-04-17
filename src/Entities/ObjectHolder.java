/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    package Entities;

/**
 *
 * @author may islem
 */



/**
 *
 * @author may islem
 */
public class ObjectHolder {
   public String videor;

   

    public ObjectHolder() {
        
    }

    public String getVideor() {
        return videor;
    }

    public void setVideor(String videor) {
        this.videor = videor;
    }
    static  ObjectHolder instance;

    public static ObjectHolder getInstance() {
        if (instance == null) {
            instance = new ObjectHolder();
        }
        return instance;
    }
}
    

