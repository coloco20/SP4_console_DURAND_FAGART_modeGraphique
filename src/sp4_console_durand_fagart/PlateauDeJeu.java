/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_durand_fagart;

/**
 *
 * @author 33768
 */
public class PlateauDeJeu {

    private CelluledeGrille[][] grille = new CelluledeGrille[6][7];

    public PlateauDeJeu() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grille[i][j] = new CelluledeGrille(null);
            }
        }

    }

    public int ajouterJetonDansColonne(Joueur joueurCourant, int indice) {
        int ligne = 0;
        for (int i = 0; i < 6; i++) {
            if (!this.presenceJeton(i, indice)) {
                ligne = i;
                break;
            }
        }
        if (this.presenceTrouNoir(ligne, indice)) {
            if (this.presenceDesintegrateur(ligne, indice)) {
                this.supprimerTrouNoir(ligne, indice);
                this.supprimeresentDegrateur(ligne, indice);
                joueurCourant.obtenirDesintegrateur();
                return (indice);
            } else {
                this.supprimerTrouNoir(ligne, indice);
            }
        }
        if (this.presenceDesintegrateur(ligne, indice)) {
            this.supprimeresentDegrateur(ligne, indice);
            joueurCourant.obtenirDesintegrateur();
            grille[ligne][indice].affecterJeton(joueurCourant.joueJeton());
            return (indice);
        } else {
            grille[ligne][indice].affecterJeton(joueurCourant.joueJeton());
            return(indice);
        }        
    }

    public boolean grilleRemplie() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (!grille[i][j].presenceJeton()) {
                    return (false);
                }
            }
        }
        return (true);
    }

    public boolean presenceJeton(int x, int y) {
        if (grille[x][y].presenceJeton() == true) {
            return (true);
        }
        return (false);
    }

    public String lireCouleurDuJeton(int x, int y) {
        return (grille[x][y].lireCouleurDuJeton());
    }

    public boolean ligneGagnantePourCouleur(String couleur_gagnante) {
        for (int i = 0; i < 6; i++) {//i ligne, j colone
            for (int j = 0; j < 4; j++) {
                if (grille[i][j].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i][j + 1].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i][j + 2].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i][j + 3].lireCouleurDuJeton().equals(couleur_gagnante)) {
                    return (true);
                }
            }

        }
        return (false);
    }

    public boolean colonneGagnantePourCouleur(String couleur_gagnante) {
        for (int i = 0; i < 3; i++) {//i ligne, j colone
            for (int j = 0; j < 7; j++) {
                if (grille[i][j].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i + 1][j].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i + 2][j].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i + 3][j].lireCouleurDuJeton().equals(couleur_gagnante)) {
                    return (true);
                }
            }

        }
        return (false);
    }

    public boolean diagonaleMontanteGagnantePourCouleur(String couleur_gagnante) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[i][j].lireCouleurDuJeton().equals(couleur_gagnante)
                        & grille[i + 1][j + 1].lireCouleurDuJeton().equals(couleur_gagnante)
                        & grille[i + 2][j + 2].lireCouleurDuJeton().equals(couleur_gagnante)
                        & grille[i + 3][j + 3].lireCouleurDuJeton().equals(couleur_gagnante)) {
                    return (true);
                }
            }

        }
        return (false);
    }

    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur_gagnante) {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[i][j].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i - 1][j + 1].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i - 2][j + 2].lireCouleurDuJeton().equals(couleur_gagnante) & grille[i - 3][j + 3].lireCouleurDuJeton().equals(couleur_gagnante)) {
                    return (true);
                }
            }

        }
        return (false);
    }

    public boolean etreGagnantePourCouleur(String couleur_gagnante) {
        if (diagonaleDescendanteGagnantePourCouleur(couleur_gagnante) == true | diagonaleMontanteGagnantePourCouleur(couleur_gagnante) == true | colonneGagnantePourCouleur(couleur_gagnante) == true | ligneGagnantePourCouleur(couleur_gagnante) == true) {
            return (true);
        }
        return (false);
    }

    public void tasserColonne(int col) {
        int nb_ligne = 0;
        for (int i = 0; i < 6; i++) {
            if (!grille[i][col].presenceJeton()) {
                nb_ligne = i;
                break;
            }
        }
        for (int i = nb_ligne; i < 6; i++) {
            if (grille[i][col].presenceJeton()) {                
                Jeton j = grille[i][col].recupererJeton();
                grille[i - 1][col].affecterJeton(j);
            }
        }
    }

    public boolean presenceTrouNoir(int x, int y) {
        return (grille[x][y].presenceTrouNoir());
    }

    public void placerTrouNoir(int x, int y) {
        grille[x][y].placeTrouNoir();
    }

    public void supprimerTrouNoir(int x, int y) {
        grille[x][y].supprimerTrouNoir();
    }

    public boolean presenceDesintegrateur(int x, int y) {
        return (grille[x][y].presenceDesintegrateur());
    }

    public void placerDesintegrateur(int x, int y) {
        grille[x][y].placerDesintegrateur();
    }

    public void supprimeresentDegrateur(int x, int y) {
        grille[x][y].supprimerDesintegrateur();
    }

    public void supprimerJeton(int x, int y) {
        grille[x][y].supprimerJeton();
    }

    public Jeton recupererJeton(int x, int y) {
        return (grille[x][y].recupererJeton());
    }

    public String lireJeton(int x, int y) {
        return (grille[x][y].lireCouleurDuJeton());
    }

    public void afficherGrilleSurConsole() {
        String afficher_ligne = "";
        for (int i = 0; i < 6; i++) {//i represente les ligne
            afficher_ligne = "";
            for (int j = 0; j < 7; j++) {//j represente les colonne
                afficher_ligne += "[" + grille[i][j].toString() + "]";
            }
            System.out.println(afficher_ligne);
        }
    }

    public void afficherGrille() {
        String afficher_ligne = "";
        for (int i = 0; i < 6; i++) {//i represente les ligne
            afficher_ligne = "";
            for (int j = 0; j < 7; j++) {//j represente les colonne
                afficher_ligne += "[" + i + "," + j + "]";
            }
            System.out.println(afficher_ligne);
        }
    }

    public CelluledeGrille accesseurGrille(int x, int y) {

        return (this.grille[x][y]);
    }

    public boolean colonneRemplie(int indice) {
        for (int i = 0; i < 6; i++) {
            if (!grille[i][indice].presenceJeton()) {
                return (false);
            }
        }
        return (true);
    }
    
   public void tasserGrille(){
       for(int i = 0; i < 6; i++){
           this.tasserColonne(i);
       }
   }

}
