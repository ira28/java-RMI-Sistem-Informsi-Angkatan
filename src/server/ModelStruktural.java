/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class ModelStruktural implements Serializable{
    int id;
    String ketua, sekretaris, bendahara;

    public ModelStruktural(int id, String ketua, String sekretaris, String bendahara) {
        this.id = id;
        this.ketua = ketua;
        this.sekretaris = sekretaris;
        this.bendahara = bendahara;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKetua() {
        return ketua;
    }

    public void setKetua(String nama) {
        this.ketua = nama;
    }

    public String getSekretaris() {
        return sekretaris;
    }

    public void setSekretaris(String sekretaris) {
        this.sekretaris = sekretaris;
    }

    public String getBendahara() {
        return bendahara;
    }

    public void setBendahara(String bendahara) {
        this.bendahara = bendahara;
    }
    
}
