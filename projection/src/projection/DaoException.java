/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projection;

/**
* Une exception levée par un DAO et liée à la persistance.
*/

public class DaoException extends Exception {

    /**
* Code de l'erreur.
* -1 s'il y a une exception chaînée ;
* 1 pour connexion pas ouverte ;
* 2 pour connexion déjà ouverte ;
* 4 si pas de transaction en cours ;
* ...
*/
    private int codeErreur;
    
    public DaoException() {
    }
    
    public DaoException(String message) {
    this(message, 0);
    }
    
    /**
    * Crée une nouvelle exception avec un message et une cause donnés.
    * @param message le message qui explique le problème.
    * @param cause une exception qui est la cause du problème. Le type de
    cette
    * exception doit être caché à l'utilisateur du DAO et ne pas apparaître
    * dans l'interface de la classe DaoException. Cette cause peut être
    * connue de l'utilisateur par l'appel de la méthode getCause() héritée
    * de Exception.
    * @param codeErreur code erreur du support de persistance.
    */
    
    public DaoException(String message, Throwable cause, int codeErreur) {
    super(message, cause);
    this.codeErreur = codeErreur;
    }

    public DaoException(String message, Throwable cause) {
    this(message, cause, -1);
    }
    
    public DaoException(Throwable cause) {
    this("Erreur liée aux DAO", cause, -1);
    }

    public DaoException(String message, int codeErreur) {
    this(message, null, codeErreur);
    }
    
    public int getCode() {
    return codeErreur;
    }
}