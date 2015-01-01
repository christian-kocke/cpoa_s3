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
public class Projection {
    
    private int id;
    private int id_type;
    private int id_salle;
    private int id_premier_creneau;
    private int duree;
    private String heure;
    
    public Projection(int id, int id_type, int id_salle, String heure, int duree) {
        this.id = id;
        this.id_type = id_type;
        this.id_salle = id_salle;
        this.heure=heure;
        this.duree=duree;
        
    }
    
    //Constructeur pour les Projections prévues
    public Projection(int id, int id_type, int id_salle, int id_premier_creneau) {
        this.id = id;
        this.id_type = id_type;
        this.id_salle = id_salle;
        this.id_premier_creneau=id_premier_creneau;
    }

    public int getId() {
        return id;
    }

    public int getId_type() {
        return id_type;
    }

    public int getId_salle() {
        return id_salle;
    }

    public int getId_premier_creneau() {
        return id_premier_creneau;
    }

    public int getDuree() {
        return duree;
    }

    public String getHeure() {
        return heure;
    }
}
