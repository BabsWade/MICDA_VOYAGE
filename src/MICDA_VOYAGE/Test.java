/**
 * 
 */
package MICDA_VOYAGE;

/**
 * @author mouhamadoumansourndiaye
 *
 */
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Interface Graphique");
            frame.setSize(1500, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Panel en haut avec le texte "Migda Voyage"
            JPanel panelHaut = new JPanel();
            panelHaut.setPreferredSize(new Dimension(1300, 100));
            JLabel labelTitre = new JLabel("Migda Voyage");
            panelHaut.add(labelTitre);
            panelHaut.setBackground(Color.WHITE);
            panelHaut.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            // Panel au milieu avec une image
            JPanel panelMilieu = new JPanel();
            panelMilieu.setPreferredSize(new Dimension(500, 300));
            ImageIcon imageIcon = new ImageIcon("chemin/vers/votre/image.jpg"); // Remplacez par le chemin de votre image
            JLabel labelImage = new JLabel(imageIcon);
            panelMilieu.add(labelImage);
            panelMilieu.setBackground(Color.WHITE);
            panelMilieu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            // Panel en bas, centré, avec deux champs de texte
            JPanel panelBas = new JPanel(new GridLayout(2, 2));
            panelBas.setPreferredSize(new Dimension(500, 350));
            JTextField champTexte1 = new JTextField("Champ 1");
            JTextField champTexte2 = new JTextField("Champ 2");

            panelBas.add(new JLabel("Champ 1:"));
            panelBas.add(champTexte1);
            panelBas.add(new JLabel("Champ 2:"));
            panelBas.add(champTexte2);
            panelBas.setBackground(Color.WHITE);
            panelBas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            // Ajout des panneaux au content pane du cadre
            Container contentPane = frame.getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(panelHaut, BorderLayout.NORTH);
            contentPane.add(panelMilieu, BorderLayout.CENTER);
            contentPane.add(panelBas, BorderLayout.SOUTH);

            // Fond bleu pour le cadre
            contentPane.setBackground(Color.BLUE);

            // Affichage de la fenêtre
            frame.setVisible(true);
        });
    }
}
