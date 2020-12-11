/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author kasmira
 */
public class ModelSejarah implements Serializable{
    int id;
    String sejarah;

    public ModelSejarah(int id, String sejarah) {
        this.id = id;
        this.sejarah = sejarah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSejarah() {
        return sejarah;
    }

    public void setSejarah(String sejarah) {
        this.sejarah = sejarah;
    }
    
    
}
