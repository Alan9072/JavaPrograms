
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JPanel lightPanel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 400);
        setLocationRelativeTo(null); // Center the frame

        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        lightPanel = new JPanel();
        lightPanel.setPreferredSize(new Dimension(100, 300));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(greenButton);

        add(radioPanel, BorderLayout.WEST);
        add(lightPanel, BorderLayout.CENTER);

        redButton.setSelected(true);
        updateLight(Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            updateLight(Color.RED);
        } else if (e.getSource() == yellowButton) {
            updateLight(Color.YELLOW);
        } else if (e.getSource() == greenButton) {
            updateLight(Color.GREEN);
        }
    }

    private void updateLight(Color color) {
        lightPanel.removeAll();
        lightPanel.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillOval(25, 50, 50, 50); // Red light
                g.fillOval(25, 150, 50, 50); // Yellow light
                g.fillOval(25, 250, 50, 50); // Green light
            }
        });
        lightPanel.revalidate();
        lightPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrafficLightSimulator().setVisible(true);
        });
    }
}
