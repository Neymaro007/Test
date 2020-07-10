package test;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    CardLayout cl = new CardLayout();
    ContentPanePanel contentPanePanel = new ContentPanePanel();
    String panelIdentifiers[] = new String[5];
    MainPanel mainPanel = new MainPanel(contentPanePanel, "Question1");
    Question questions[] = new Question[5];
    Result result;
    String questionsStr[] = {"1. Kto jest twórc¹ jêzyka C++ ?", "2. Kto opracowa³ jêzyk ada ?", "3. Kto jest twórc¹ jêzyka C ?",
            " 4. Kto jest twórc¹ jêzyka Pascal?", "5. Kto jest twórc¹ jêzyka Java?"};
    String firstAnswers[] = {"a) Bjarne Stroustrup", "a) Jean Ichbiaha", "a) Donald Trump", "a) Niklaus Wirth", "a) Richard Nixon"};
    String secondAnswers[] = {"b) Steve Jobs", "b) Barack Obama", "b) Dennis Ritchie", "b) Gerald Ford", "b)James Gosling"};
    int correctAnswers[] = {0, 0, 1, 0, 1};

    public Test() {

        super("Quiz");

        setSize(900, 750);
        setVisible(true);

        contentPanePanel.setLayout(cl);

        for (int i = 0; i < panelIdentifiers.length; i++) {
            panelIdentifiers[i] = "Question" + String.valueOf(i + 1);
        }

        contentPanePanel.add(mainPanel, "Quiz");
        result = new Result(contentPanePanel);
        for (int i = 0; i < questions.length; i++) {
            if (i < questions.length - 1) {
                questions[i] = new Question(contentPanePanel, panelIdentifiers[i + 1], questionsStr[i], firstAnswers[i], secondAnswers[i],
                        correctAnswers[i], result);
            } else {
                questions[i] = new Question(contentPanePanel, "Result", questionsStr[i], firstAnswers[i], secondAnswers[i],
                        correctAnswers[i], result);
            }
            contentPanePanel.add(questions[i], panelIdentifiers[i]);
        }
        contentPanePanel.add(result, "Result");

        add(contentPanePanel);

        cl.show(contentPanePanel, "Quiz");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test());
    }

}
