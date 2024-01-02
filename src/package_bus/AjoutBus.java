package package_bus;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutBus extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5853804170404407418L;
	private JTextField idField;
    private JTextField nomField;
    private JTextField capaciteField;
    private JButton addButton;
    private InfoBus busInfo;

    public AjoutBus(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        idField = new JTextField();
        nomField = new JTextField();
        capaciteField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Capacité:"));
        panel.add(capaciteField);

        addButton = new JButton("Ajouter");
        addButton.addActionListener(this::addButtonClicked);

        panel.add(addButton);

        getContentPane().add(panel);
    }

    private void addButtonClicked(ActionEvent e) {
        // Valider et récupérer les informations du bus depuis le formulaire
        try {
            String id = idField.getText();
            String nom = nomField.getText();
            int capacite = Integer.parseInt(capaciteField.getText());

            // Créer un objet BusInfo avec les informations saisies
            busInfo = new InfoBus(id, nom, capacite);

            // Fermer la fenêtre de dialogue
            setVisible(false);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir une capacité valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public InfoBus getInfoBus() {
        return busInfo;
    }
}

