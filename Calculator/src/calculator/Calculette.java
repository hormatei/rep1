/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author stag
 */
public class Calculette extends JFrame {

    private final JPanel content;
    private final JPanel panneauEcran;
    private final JPanel panneauBoutons;
    private final JPanel panneauOperations;
    private final Dimension chiffreDimension;
    private final Dimension operateurDimension;
    public double a, b, rezultat;
    public int i = 0;
    public boolean c = true;

    // Constructeur
    public Calculette() {

        // La dimension des boutons
        this.operateurDimension = new Dimension(100, 80);
        this.chiffreDimension = new Dimension(120, 60);
        // Instanciation des variables
        this.content = new JPanel();
        this.panneauEcran = new JPanel();
        this.panneauBoutons = new JPanel();
        this.panneauOperations = new JPanel();

        // Comportement par défaut à la fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Titre
        this.setTitle("Calculette");
        // Mise en place du contenu
        this.initComponents();
        this.pack();
        // Affichage
        this.setVisible(true);
    }

    private void initComponents() {
        // L'affichage : on crée des bordures autour du panneau d'affichage de l'écran
        panneauEcran.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5), // Le padding
                BorderFactory.createLineBorder(Color.BLACK, 1) // La bordure
        ));
        panneauEcran.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel ecran = new JLabel("0");
        panneauEcran.add(ecran);

        // Les chiffres
        String[] boutonsLabel = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".", "="
        };
        panneauBoutons.setLayout(new GridLayout(4, 3, 2, 2));
        for (String s : boutonsLabel) {
            JButton jb = new JButton(s);
            jb.setPreferredSize(this.chiffreDimension);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (jb.getText()) {
                        case "=":

                            if (i == 1) {
                                rezultat = rezultat + Double.parseDouble(ecran.getText());

                                ecran.setText("" + rezultat);


                            }
                            if (i == 2) {
                                rezultat = rezultat - Double.parseDouble(ecran.getText());

                                ecran.setText("" + rezultat);


                            }
                            if (i == 3) {

                                rezultat = rezultat * Double.parseDouble(ecran.getText());

                                ecran.setText("" + rezultat);

                            }
                            if (i == 4) {
                                rezultat = rezultat / Double.parseDouble(ecran.getText());

                                ecran.setText("" + rezultat);

                            }

                            break;

                        case ".":
                            if (ecran.getText().contains(".")) {
                                ecran.setText(ecran.getText() + "");
                            } else {
                                ecran.setText(ecran.getText() + jb.getText());
                            }
                            break;

                        default:

                    if (ecran.getText().equals("0")) {
                        ecran.setText(jb.getText());
                    } else {
                        ecran.setText(ecran.getText() + jb.getText());
                            }
                            break;
                    }
                }
            });
            panneauBoutons.add(jb);
        }

        // Les opérations
        String[] operationsLabel = {"CE", "C", "+", "-", "x", "/"};
        panneauOperations.setLayout(new GridLayout(3, 2, 3, 3));
        for (String s : operationsLabel) {
            JButton jb = new JButton(s);
            jb.setPreferredSize(this.operateurDimension);
            panneauOperations.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (jb.getText()) {
                        case "+":

                            if (i == 0) {
                                rezultat = Double.parseDouble(ecran.getText());

                            }
                            if (i == 1) {
                                rezultat = rezultat + Double.parseDouble(ecran.getText());
                            }
                            if (i == 2) {
                                rezultat = rezultat - Double.parseDouble(ecran.getText());
                            }
                            if (i == 3) {

                                rezultat = rezultat * Double.parseDouble(ecran.getText());
                            }
                            if (i == 4) {
                                rezultat = rezultat / Double.parseDouble(ecran.getText());
                            }

                            i = 1;
                            ecran.setText("0");

                            break;

                        case "-":

                            if (i == 0) {
                                rezultat = Double.parseDouble(ecran.getText());

                            }
                            if (i == 1) {
                                rezultat = rezultat + Double.parseDouble(ecran.getText());
                            }
                            if (i == 2) {
                                rezultat = rezultat - Double.parseDouble(ecran.getText());
                            }
                            if (i == 3) {

                                rezultat = rezultat * Double.parseDouble(ecran.getText());
                            }
                            if (i == 4) {
                                rezultat = rezultat / Double.parseDouble(ecran.getText());
                            }
                            i = 2;

                            ecran.setText("0");

                            break;

                        case "x":

                            if (i == 0) {
                                rezultat = Double.parseDouble(ecran.getText());
                                c = false;
                            }
                            if (i == 1) {
                                rezultat = rezultat + Double.parseDouble(ecran.getText());
                            }
                            if (i == 2) {
                                rezultat = rezultat - Double.parseDouble(ecran.getText());
                            }
                            if (i == 3) {

                                rezultat = rezultat * Double.parseDouble(ecran.getText());
                            }
                            if (i == 4) {
                                rezultat = rezultat / Double.parseDouble(ecran.getText());
                            }
                            i = 3;

                            ecran.setText("0");

                            break;

                        case "/":

                            if (i == 0) {
                                rezultat = Double.parseDouble(ecran.getText());
                                c = false;
                            }
                            if (i == 1) {
                                rezultat = rezultat + Double.parseDouble(ecran.getText());
                            }
                            if (i == 2) {
                                rezultat = rezultat - Double.parseDouble(ecran.getText());
                            }
                            if (i == 3) {

                                rezultat = rezultat * Double.parseDouble(ecran.getText());
                            }
                            if (i == 4) {
                                rezultat = rezultat / Double.parseDouble(ecran.getText());
                            }

                            i = 4;
                            ecran.setText("0");
                            break;

                        default:
                            ecran.setText("0");
                            c = false;
                            i = 0;


                    }
                    }
                    
            });

        }

        // Le contenu global
        content.setLayout(new BorderLayout(5, 5));
        content.add(panneauEcran, BorderLayout.NORTH);
        content.add(panneauBoutons, BorderLayout.CENTER);
        content.add(panneauOperations, BorderLayout.EAST);
        this.setContentPane(content);
    }

}
