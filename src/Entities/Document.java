/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author oussama_arch
 */
public class Document implements Serializable{
    
    
    public String path;
    public String centreInt;

    public Document(String path, String centreInt) {
        this.path = path;
        this.centreInt = centreInt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCentreInt() {
        return centreInt;
    }

    public void setCentreInt(String centreInt) {
        this.centreInt = centreInt;
    }
    
    
    
    
    
}