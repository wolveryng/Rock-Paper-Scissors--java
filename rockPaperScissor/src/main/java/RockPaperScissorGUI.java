import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener {
    // Player images
    ImageIcon rockImage, paperImage, scissorImage;
    JLabel computerChoice;
    JLabel computerScore;
    JLabel playerScore;
    RockPaperScissor rockPaperScissor;

    public RockPaperScissorGUI() {
        super("Rock Paper Scissor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 574);
        setLayout(null);
        setLocationRelativeTo(null); // Center window

        rockPaperScissor = new RockPaperScissor();

        AddGuiComponents();
        setVisible(true);
    }

    private void AddGuiComponents() {
        computerScore = new JLabel("Computer Score: 0");
        computerScore.setBounds(0, 43, 450, 30);
        computerScore.setFont(new Font("Times New Roman", Font.BOLD, 26));
        computerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScore);

        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 120, 110, 30);
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setFont(new Font("Times New Roman", Font.BOLD, 30));
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        playerScore = new JLabel("Player Score: 0");
        playerScore.setBounds(0, 400, 450, 30);
        playerScore.setFont(new Font("Times New Roman", Font.BOLD, 26));
        playerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScore);

        // Load and scale images
        rockImage = loadImage("rock.jpg", 90, 80);
        paperImage = loadImage("paper.png", 100, 80);
        scissorImage = loadImage("scissors.jpg", 100, 80);

        // Create buttons with images
        JButton rockButton = new JButton(rockImage);
        rockButton.setBounds(60, 270, 90, 81);
        rockButton.setBorderPainted(false);
        rockButton.setFocusPainted(false);
        rockButton.setContentAreaFilled(false);
        rockButton.setActionCommand("Rock");
        rockButton.addActionListener(this);
        add(rockButton);

        JButton paperButton = new JButton(paperImage);
        paperButton.setBounds(165, 270, 90, 81);
        paperButton.setBorderPainted(false);
        paperButton.setFocusPainted(false);
        paperButton.setContentAreaFilled(false);
        paperButton.setActionCommand("Paper");
        paperButton.addActionListener(this);
        add(paperButton);

        JButton scissorButton = new JButton(scissorImage);
        scissorButton.setBounds(280, 270, 110, 81);
        scissorButton.setBorderPainted(false);
        scissorButton.setFocusPainted(false);
        scissorButton.setContentAreaFilled(false);
        scissorButton.setActionCommand("Scissor");
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    private ImageIcon loadImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + path)); // Load from resources
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // Message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));

        resultDialog.setLayout(new FlowLayout());
        resultDialog.add(resultLabel);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand();

        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        computerChoice.setText(rockPaperScissor.getComputerChoice());


        computerScore.setText("Computer Score: " + rockPaperScissor.getComputerScore());
        playerScore.setText("Player Score: " + rockPaperScissor.getPlayerScore());

        showDialog(result);
    }
}
