package test;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Result extends JPanel {

    private JTextField result;
    private JLabel wynik;
    private ContentPanePanel contentPanePanel;

    public Result(ContentPanePanel contentPanePanel) {

        this.contentPanePanel = contentPanePanel;
        setLayout(null);

        wynik = new JLabel("Wynik = " + String.valueOf(contentPanePanel.result));
        addComponentAndSetBoundsAndActionListener(wynik, 20, 100, 100, 30, null);

    }

    private void addComponentAndSetBoundsAndActionListener(JComponent component, int x, int y, int width, int height,
            ActionListener listener) {
        add(component);
        component.setBounds(x, y, width, height);
        if (listener != null) {
            ((JButton) component).addActionListener(listener);
        }
    }

    public void updateResult() {
        wynik.setText("Wynik = " + String.valueOf(contentPanePanel.result));
    }
}
