/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_durand_fagart;

/**
 *
 * @author 33768
 */
public class Jeton {//*jc*//

    private String couleur;

    public Jeton(String couleur_jeton) {
        couleur = couleur_jeton;

    }

    public String lireCouleur() {
        return (couleur);
    }

    @Override
    public String toString() {
        if ("rouge".equals(couleur)) {
            return ("R");
        } else {
            return ("J");
        }
    }
}
