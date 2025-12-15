package gui;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    private final JPanel contentPanel;

    public Frame() {
        super("Knights Requiem");
        setSize(816, 639);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPanel = new JPanel(new CardLayout());
        setContentPane(contentPanel);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public CardLayout getCardLayout() {
        return (CardLayout) contentPanel.getLayout();
    }
}
