/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_durand_fagart;

import java.util.Scanner;

/**
 *
 * @author 33768
 */
public class Partie {

    private Joueur tab[] = new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;

    public Partie(Joueur r, Joueur j) {
        tab[0] = r;
        tab[1] = j;
        plateau = new PlateauDeJeu();

    }

    public void attribuerCouleurAuxJoueurs() {

        tab[0].affecterCouleur("r");
        tab[1].affecterCouleur("j");

    }

    public void creeEtAffecterJeton(Joueur jr) {
        for (int i = 0; i < 31; i++) {
            Jeton j = new Jeton(jr.lireCouleur());
            jr.ajouterJeton(j);
        }
    }

    public void placerTrouNoirEtDesintegrateur() {
        int n;
        int m;
        int o;
        int p;
        for (int i = 0; i < 5; i++) {
            n = (int) (Math.random() * 6);
            m = (int) (Math.random() * 7);
            o = (int) (Math.random() * 6);
            p = (int) (Math.random() * 7);
            if (i < 3) {
                plateau.placerTrouNoir(n, m);
                plateau.placerDesintegrateur(o, p);
                System.out.println("a" + i);
            }

            if (i > 2) {
                plateau.placerTrouNoir(n, m);
                plateau.placerDesintegrateur(n, m);
                System.out.println("b" + i);
            }

        }

    }

    public void initialiserPartie() {
        attribuerCouleurAuxJoueurs();
        creeEtAffecterJeton(tab[0]);
        creeEtAffecterJeton(tab[1]);
        placerTrouNoirEtDesintegrateur();
    }

    public void lancerPartie() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!plateau.grilleRemplie()) {
                for (int p = 0; p < 2; p++) {
                    plateau.afficherGrilleSurConsole();
                    boolean choix = true;
                    int rep_1 = 0;
                    joueurCourant = tab[p];
                    while (choix) {
                        System.out.println("Au tour du joueur : " + joueurCourant.lireCouleur());
                        System.out.println("Que souhaitez vous faire ?"
                                + "\n1) Jouer un jeton\n2) Recuperer un jeton"
                                + "\n3) Utiliser un Desintegrateur");
                        rep_1 = sc.nextInt();
                        if (!(rep_1 < 4) | !(rep_1 > 0)) {
                            System.out.println("Option non valide, choisir un nombre entre 1 et 3, exemple : 1");
                        } else {
                            int nb_des = joueurCourant.nombreDesintegrateur();
                            if (rep_1 == 3 & nb_des == 0) {
                                System.out.println("Vous n'avez pas de desintegrateur, joue une autre action");
                            } else {
                                choix = false;
                            }
                        }
                    }
                    switch (rep_1) {
                        case 0:
                            System.out.println("Une erreur c'est produite, veuillez réessayer");
                        case 1:
                            int ligne = 0;
                            Jeton jetonCourant = null;
                            System.out.println("Sur qu'elle colonne voulez vous jouez ?"
                                    + "\nEntrer un chiffre entre 1 et 7");
                            int col = sc.nextInt() - 1;
                            if (col > 6 | col < 0) {
                                System.out.println("Cette colonne n'existe pas, Choisisser une autre colonne");
                            } else {
                                if (plateau.presenceJeton(0, col)) {
                                    System.out.println("La colonne est plein"
                                            + "\nIl faut choisir une autre colonne");
                                } else {
                                    for (int i = 5; i > 0; i--) {
                                        if (!plateau.presenceJeton(i, col)) {
                                            ligne = i;
                                            break;
                                        }
                                    }
                                    if (plateau.presenceTrouNoir(ligne, col)) {
                                        if (plateau.presenceDesintegrateur(ligne, col)) {
                                            joueurCourant.obtenirDesintegrateur();
                                            joueurCourant.joueJeton();
                                            plateau.supprimerTrouNoir(ligne, col);
                                            plateau.supprimeresentDegrateur(ligne, col);
                                            System.out.println("Votre jeton c'est fait detruire par un trou noir");
                                            System.out.println("Vous avez ganger un desintegrateur");
                                            break;
                                        } else {
                                            joueurCourant.joueJeton();
                                            plateau.supprimerTrouNoir(ligne, col);
                                            System.out.println("Votre jeton c'est fait detruire par un trou noir");
                                            break;
                                        }
                                    }
                                    if (plateau.presenceDesintegrateur(ligne, col)) {
                                        joueurCourant.obtenirDesintegrateur();
                                        jetonCourant = joueurCourant.joueJeton();
                                        plateau.supprimeresentDegrateur(ligne, col);
                                        plateau.ajouterJetonDansColonne(jetonCourant, col);
                                        System.out.println("Vous avez gagner un desintegrateur");
                                        System.out.println("Votre jeton a ete joue");
                                        break;
                                    } else {
                                        jetonCourant = joueurCourant.joueJeton();
                                        plateau.ajouterJetonDansColonne(jetonCourant, col);
                                        System.out.println("Votre jeton a ete joue");
                                        break;
                                    }
                                }
                            }

                        case 2:
                            System.out.println("Choisiser un de vos jeton"
                                    + "\nExprimer la en cooreonnee \nLigne \nColonne");
                            int ligne_r = sc.nextInt() - 1;
                            int col_r = sc.nextInt() - 1;
                            if (ligne_r < 6 | ligne_r > -1 | col_r < 7 | col_r > -1) {
                                if (plateau.lireJeton(ligne_r, col_r).equals(joueurCourant.lireCouleur())) {
                                    joueurCourant.ajouterJeton(plateau.recupererJeton(ligne_r, col_r));
                                    System.out.println("Le Jeton à été récupérer");
                                    plateau.tasserColonne(col_r);
                                    break;
                                } else if (plateau.lireJeton(ligne_r, col_r).equals("n")) {
                                    System.out.println("Il n'y à aucun jeton sur cette case");
                                } else {
                                    System.out.println("Ce n'est pas un de vos jeton");
                                }
                            } else {
                                System.out.println("C'est coordonnee ne sont pas valide");
                                System.out.println("Exprimer au format \nLigne(compris entre 1 et 6) \nColonne(Compris entre 1 et 7)");
                            }
                        case 3:

                            System.out.println("Choisiser une case"
                                    + "\nExprimer la en coordonnée \nLigne \nColonne");
                            int ligne_d = sc.nextInt() - 1;
                            int col_d = sc.nextInt() - 1;
                            if (ligne_d < 6 | ligne_d > -1 | col_d < 7 | col_d > -1) {
                                if (plateau.presenceJeton(ligne_d, col_d)) {
                                    plateau.supprimerJeton(ligne_d, col_d);
                                    joueurCourant.utiliserDesintegrateur();
                                    plateau.tasserColonne(col_d);
                                    break;
                                } else {
                                    System.out.println("Il n'y à pas de jeton sur cette case");

                                }
                            } else {
                                System.out.println("C'est coordonnee ne sont pas valide");
                                System.out.println("Exprimer au format \nLigne(compris entre 1 et 6) \nColonne(Compris entre 1 et 7)");
                            }
                    }
                }
                if (plateau.etreGagnantePourCouleur(joueurCourant.lireCouleur())) {
                    System.out.println("Le Joueur " + joueurCourant.obtenirNom() + " a gagner");
                    break;
                }
            } else {
                System.out.println("La grille est plein");
                System.out.println("Match null");
                break;
            }
        }
    }
}
