/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

/**
 *
 * @author Aïssa
 */
public class Film {
    
    private int id;
    private String titre;
    private int duree;
    
    public Film (int id, String titre, int duree) {
        this.id=id;
        this.titre=titre;
        this.duree=duree;   
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }
    
    
    
}
