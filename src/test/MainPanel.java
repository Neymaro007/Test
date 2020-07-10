package test;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {

    private JTextField Imie, Nazwisko, Numer_indeksu_studenta;
    private JButton Przycisk_test, Przycisk_koniec;
    private JLabel etykieta1, etykieta2, etykieta3;
    private JComboBox koszt;
    private JPanel contentPane;
    private String nextPanelIdentifier;

    public MainPanel(JPanel panel, String nextPanelIdentifier) {

        setVisible(true);
        this.nextPanelIdentifier = nextPanelIdentifier;
        contentPane = panel;
        setLayout(null);
        Imie = new JTextField("");
        addComponentAndSetBoundsAndActionListener(Imie, 200, 100, 180, 40, null);

        etykieta1 = new JLabel("Imie stuenta = ");
        addComponentAndSetBoundsAndActionListener(etykieta1, 20, 100, 100, 30, null);

        Nazwisko = new JTextField("");
        addComponentAndSetBoundsAndActionListener(Nazwisko, 200, 150, 180, 40, null);

        etykieta2 = new JLabel("Nazwisko studenta= ");
        addComponentAndSetBoundsAndActionListener(etykieta2, 20, 150, 150, 30, null);

        Numer_indeksu_studenta = new JTextField("");
        addComponentAndSetBoundsAndActionListener(Numer_indeksu_studenta, 200, 200, 180, 40, null);

        etykieta3 = new JLabel("Numer indeksu studenta = ");
        addComponentAndSetBoundsAndActionListener(etykieta3, 20, 200, 190, 30, null);

        Przycisk_test = new JButton("TEST");
        addComponentAndSetBoundsAndActionListener(Przycisk_test, 500, 400, 90, 40,
                (ActionEvent e) -> ((CardLayout) contentPane.getLayout()).show(contentPane, nextPanelIdentifier));
        Przycisk_koniec = new JButton("Koniec");
        addComponentAndSetBoundsAndActionListener(Przycisk_koniec, 500, 450, 90, 40, (ActionEvent e) -> System.exit(0));
    }

    private void addComponentAndSetBoundsAndActionListener(JComponent component, int x, int y, int width, int height,
            ActionListener listener) {
        add(component);
        component.setBounds(x, y, width, height);
        if (listener != null) {
            ((JButton) component).addActionListener(listener);
        }
    }

}
