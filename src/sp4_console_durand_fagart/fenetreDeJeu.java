/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_console_durand_fagart;

/**
 *
 * @author colombe
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    private Joueur tab[] = new Joueur[2];
    private Joueur joueurCourant;
    PlateauDeJeu plateau = new PlateauDeJeu();

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
        panneau_info_joueur.setVisible(false);
        panneau_info_partie.setVisible(false);
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(plateau.accesseurGrille(i, j));

                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jTextArea1.setText("Un bouton a ete clique");
                        CelluledeGrille c = cellGraph.celluleAssociee;
                        if (!c.presenceJeton()) {
                            return;
                        }
                        if (c.lireCouleurDuJeton().equals(joueurCourant.lireCouleur())) {
                            jTextArea1.setText("Le joueur" + joueurCourant.obtenirNom() + " récupere un jeton");
                            joueurCourant.ajouterJeton(c.recupererJeton());
                            joueurSuivant();
                        } else {
                            if (joueurCourant.nombreDesintegrateur() > 0) {
                                jTextArea1.setText("Le joueur" + joueurCourant.obtenirNom() + " a desintegre un jeton");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                joueurSuivant();
                            } else {
                                return;
                            }
                        }
                        plateau.tasserGrille();
                        panneau_grille.repaint();
                        lbl_j1_desint.setText(tab[0].nombreDesintegrateur() + "");
                        lbl_j2_desint.setText(tab[1].nombreDesintegrateur() + "");

                        boolean v_j1 = plateau.etreGagnantePourCouleur(tab[0].lireCouleur());
                        boolean v_j2 = plateau.etreGagnantePourCouleur(tab[1].lireCouleur());

                        if (v_j1 & !v_j2) {
                            jTextArea1.setText("Victoire de " + tab[0].obtenirNom());
                        }
                        if (v_j2 & !v_j1) {
                            jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
                        }

                        if (v_j2 & v_j1) {
                            if (joueurCourant == tab[0]) {
                                jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
                            } else {
                                jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
                            }
                        }

                    }
                });
                panneau_grille.add(cellGraph);

            }
        }
    }

    public void initialiserPartie() {
        String nomJoueur1 = nom_joueur1.getText();
        Joueur J1 = new Joueur(nomJoueur1);
        String nomJoueur2 = nom_joueur2.getText();
        Joueur J2 = new Joueur(nomJoueur2);
        tab[0] = J1;
        tab[1] = J2;

        attribuerCouleurAuxJoueurs();
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j1_couleur.setText(J1.lireCouleur());
        lbl_j2_couleur.setText(J2.lireCouleur());
        lbl_j1_desint.setText(J1.nombreDesintegrateur() + "");
        lbl_j2_desint.setText(J2.nombreDesintegrateur() + "");
        creeEtAffecterJeton(tab[0]);
        creeEtAffecterJeton(tab[1]);
        placerTrouNoirEtDesintegrateur();
        int n;
        n = (int) (Math.random() * 2);
        joueurCourant = tab[n];
        lbl_jcourant.setText(joueurCourant.obtenirNom());
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
        plateau.viderGrille();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur1 = new javax.swing.JTextField();
        nom_joueur2 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        lbl_j1_desint = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_j2_desint = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        panneau_info_joueur = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btn_col_0 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 672, 576));

        panneau_creation_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom Joueur 2:");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setText("Nom Joueur 1:");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 290, 110));

        panneau_info_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_desint.setText("nbdesintjoueur1");
        panneau_info_partie.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel6.setText("couleur:");
        panneau_info_partie.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setText("désintégrateurs :");
        panneau_info_partie.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lbl_j1_couleur.setText("couleurjoueur1");
        panneau_info_partie.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));
        panneau_info_partie.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, -1));

        lbl_j2_desint.setText("nbdesintjoueur2");
        panneau_info_partie.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jLabel8.setText("joueur 2 :");
        panneau_info_partie.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel9.setText("couleur:");
        panneau_info_partie.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel10.setText("désintégrateurs :");
        panneau_info_partie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lbl_j2_nom.setText("nomjoueur2");
        panneau_info_partie.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        lbl_j2_couleur.setText("couleurjoueur2");
        panneau_info_partie.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel4.setText("infos joueurs");
        panneau_info_partie.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setText("joueur 1 :");
        panneau_info_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lbl_j1_nom.setText("nomjoueur1");
        panneau_info_partie.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 20));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 290, 240));

        panneau_info_joueur.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel3.setText("infos joueurs");
        panneau_info_joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setText("joueur courant :");
        panneau_info_joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_jcourant.setText("nomjoueur");
        panneau_info_joueur.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 70, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        message.setViewportView(jTextArea1);

        panneau_info_joueur.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 240, 70));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 290, 170));

        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 20, -1, -1));

        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 20, -1, -1));

        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 20, -1, -1));

        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 20, -1, -1));

        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 20, -1, -1));

        setBounds(0, 0, 1042, 671);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        joueurSuivant();
        jouerDansColonne(3);// TODO add your handling code here:
        if (plateau.colonneRemplie(3)) {
            btn_col_3.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        joueurSuivant();
        jouerDansColonne(5);// TODO add your handling code here:
        if (plateau.colonneRemplie(5)) {
            btn_col_5.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        joueurSuivant();
        jouerDansColonne(0);// TODO add your handling code here:
        if (plateau.colonneRemplie(0)) {
            btn_col_0.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        panneau_info_joueur.setVisible(true);
        panneau_info_partie.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        btn_start.setEnabled(false);
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        joueurSuivant();
        jouerDansColonne(1);// TODO add your handling code here:
        if (plateau.colonneRemplie(1)) {
            btn_col_1.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        joueurSuivant();
        jouerDansColonne(2);// TODO add your handling code here:
        if (plateau.colonneRemplie(2)) {
            btn_col_2.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        joueurSuivant();
        jouerDansColonne(4);// TODO add your handling code here:
        if (plateau.colonneRemplie(4)) {
            btn_col_4.setEnabled(false);
        }
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        joueurSuivant();
        jouerDansColonne(6);
        if (plateau.colonneRemplie(6)) {
            btn_col_6.setEnabled(false);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btn_col_6ActionPerformed
    public boolean jouerDansColonne(int indice_colonne) {

        int resulta = plateau.ajouterJetonDansColonne(joueurCourant, indice_colonne);
        panneau_grille.repaint();
        lbl_j1_desint.setText(tab[0].nombreDesintegrateur() + "");
        lbl_j2_desint.setText(tab[1].nombreDesintegrateur() + "");

        boolean v_j1 = plateau.etreGagnantePourCouleur(tab[0].lireCouleur());
        boolean v_j2 = plateau.etreGagnantePourCouleur(tab[1].lireCouleur());

        if (v_j1 & !v_j2) {
            jTextArea1.setText("Victoire de " + tab[0].obtenirNom());
        }
        if (v_j2 & !v_j1) {
            jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
        }

        if (v_j2 & v_j1) {
            if (joueurCourant == tab[0]) {
                jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
            } else {
                jTextArea1.setText("Victoire de " + tab[1].obtenirNom());
            }
        }
        if (resulta == 9) {
            return (false);
        }
        return (true);
    }

    public void joueurSuivant() {
        if (joueurCourant == tab[0]) {
            joueurCourant = tab[1];
            lbl_jcourant.setText(joueurCourant.obtenirNom());
        } else {
            joueurCourant = tab[0];
            lbl_jcourant.setText(joueurCourant.obtenirNom());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueur;
    private javax.swing.JPanel panneau_info_partie;
    // End of variables declaration//GEN-END:variables
}
