/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_durand_fagart;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author colombe
 */
public class CelluleGraphique extends JButton {

    CelluledeGrille celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/Images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/Images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/Images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/Images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/Images/trouNoir.png"));

    public CelluleGraphique(CelluledeGrille uneCellule) {
        celluleAssociee = uneCellule;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        } else if (celluleAssociee.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        } else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "n":
                    setIcon(img_vide);
                    break;
                case "jaune":
                    setIcon(img_jetonJaune);
                    break;
                case "rouge":
                    setIcon(img_jetonRouge);
                    break;

            }
        }

    }
}
