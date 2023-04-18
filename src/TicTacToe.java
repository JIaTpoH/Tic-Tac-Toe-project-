import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
  private final JButton[][] buttons;
  private char currentPlayer;

  public TicTacToe() {
    super("Крестики-нолики");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setLocationRelativeTo(null);


    buttons = new JButton[3][3];
    JPanel panel = new JPanel(new GridLayout(3, 3));
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        buttons[i][j] = new JButton("-");
        buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
        buttons[i][j].addActionListener((ActionListener) this);
        panel.add(buttons[i][j]);
      }
    }
    add(panel, BorderLayout.CENTER);

    // Инициализация игрового поля
    currentPlayer = 'X';

    setVisible(true);
  }
}