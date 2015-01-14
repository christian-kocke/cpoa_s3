/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import java.sql.Time;

/**
 *
 * @author Aïssa
 */
public class Creneau {
    
    private int id;
    private Time heure;
    private int duree;

    public Creneau(int id, Time heure, int duree) {
        this.id = id;
        this.heure = heure;
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

    public Time getHeure() {
        return heure;
    }

    public int getId() {
        return id;
    }
    
    
    
}
