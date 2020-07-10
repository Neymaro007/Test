package test;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Question extends JPanel {

    private JTextField imie;
    private JLabel pytanie;
    private ContentPanePanel contentPanePanel;
    private String nextPanelIdentifier;
    private JRadioButton odpowiedz1, odpowiedz2;
    private ButtonGroup odp;
    private JButton next;
    private String nextPanelIdentifier2;
    private String questionStr;
    private String firstAnswer;
    private String secondAnswer;
    private int correctAnswer;

    public Question(ContentPanePanel contentPanePanel, String nextPanelIdentifier, String questionStr, String firstAnswer,
            String secondAnswer, int correctAnswer, Result observerResult) {
        this.contentPanePanel = contentPanePanel;
        this.nextPanelIdentifier = nextPanelIdentifier;
        this.questionStr = questionStr;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.correctAnswer = correctAnswer;
        setLayout(null);

        pytanie = new JLabel(questionStr);
        addComponentAndSetBoundsAndActionListener(pytanie, 200, 100, 280, 40, null);

        odp = new ButtonGroup();

        odpowiedz1 = new JRadioButton(firstAnswer, false);
        odp.add(odpowiedz1);
        addComponentAndSetBoundsAndActionListener(odpowiedz1, 200, 150, 180, 40, null);

        odpowiedz2 = new JRadioButton(secondAnswer, false);
        odp.add(odpowiedz2);
        addComponentAndSetBoundsAndActionListener(odpowiedz2, 450, 150, 180, 40, null);

        next = new JButton("Nastepne");
        addComponentAndSetBoundsAndActionListener(next, 500, 400, 90, 40, (ActionEvent e) -> {
            if (odpowiedz1.isSelected() || odpowiedz2.isSelected()) {
                if (odpowiedz1.isSelected() && correctAnswer == 0) {
                    contentPanePanel.result += 1;
                } else if (odpowiedz2.isSelected() && correctAnswer == 1) {
                    contentPanePanel.result += 1;
                }
                observerResult.updateResult();
                ((CardLayout) contentPanePanel.getLayout()).show(contentPanePanel, nextPanelIdentifier);
            }
        });

    }

    private void addComponentAndSetBoundsAndActionListener(JComponent component, int x, int y, int width, int height,
            ActionListener listener) {
        add(component);
        component.setBounds(x, y, width, height);
        if (listener != null) {
            ((AbstractButton) component).addActionListener(listener);
        }
    }
}
