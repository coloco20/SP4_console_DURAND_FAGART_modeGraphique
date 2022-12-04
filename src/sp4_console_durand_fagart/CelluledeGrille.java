/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_durand_fagart;

/**
 *
 * @author 33768
 */
public class CelluledeGrille {

    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;

    public CelluledeGrille(Jeton jeton_courant) {
        jetonCourant = jeton_courant;
    }

    public void CelluleDeGrille() {
        jetonCourant = null;
    }

    public boolean presenceJeton() {
        if (jetonCourant == null) {
            return (false);
        } else {
            return (true);
        }
    }

    public String lireCouleurDuJeton() {
        if (presenceJeton() == true) {
            if (jetonCourant.lireCouleur() == "jaune") {
                return ("jaune");
            } else {
                return ("rouge");
            }

        } else {
            return ("n");
        }
    }

    public void affecterJeton(Jeton j) {
        jetonCourant = j;
    }

    public void placeTrouNoir() {
        avoirTrouNoir = true;
    }

    public void supprimerTrouNoir() {
        avoirTrouNoir = false;
    }

    public boolean presenceTrouNoir() {
        if (avoirTrouNoir) {
            return (true);
        } else {
            return (false);
        }
    }

    public Jeton recupererJeton() {
        Jeton temp_jeton;
        temp_jeton = jetonCourant;
        jetonCourant = null;
        return (temp_jeton);

    }

    public void supprimerJeton() {
        jetonCourant = null;
    }

    public boolean presenceDesintegrateur() {
        if (avoirDesintegrateur) {
            return (true);
        } else {
            return (false);
        }
    }

    public void placerDesintegrateur() {
        avoirDesintegrateur = true;
    }

    public void supprimerDesintegrateur() {
        avoirDesintegrateur = false;
    }

    public void activerTrouNoir() {
        this.supprimerJeton();
        this.supprimerTrouNoir();
    }

    @Override
    public String toString() {
        if (jetonCourant != null) {
            if (jetonCourant.lireCouleur().equals("jaune")) {
                return ("J");
            }
            if (jetonCourant.lireCouleur().equals("rouge")) {
                return ("R");
            }
        }
        if (avoirTrouNoir) {
            return ("@");
        }
        if (avoirDesintegrateur) {
            return ("D");
        }
        return (".");

    }
}
