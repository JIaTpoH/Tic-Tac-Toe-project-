import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
  final JButton[][] buttons;
  char currentPlayer;

  public TicTacToe() {
    super("TicTacToe");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setLocationRelativeTo(null);


    buttons = new JButton[3][3];
    JPanel panel = new JPanel(new GridLayout(3, 3));
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        buttons[i][j] = new JButton("*");
        buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
        buttons[i][j].addActionListener(this);
        panel.add(buttons[i][j]);
      }
    }
    add(panel, BorderLayout.CENTER);
    currentPlayer = 'X';
    chooseSymbol();
    while (currentPlayer == '*') {
      chooseSymbol();
    }
    setVisible(true);
  }

  void chooseSymbol() {
    int option = JOptionPane.showOptionDialog(
        this,
        "                Choose your symbol:",
        "                     Symbol Selection",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null, new String[]{"X", "O"},
        "X"
    );

    currentPlayer = option == 0 ? 'X' : 'O';
  }

  public void makeMove(int row, int col) {
    JButton button = buttons[row][col];
    if (button.getText().equals("*")) {
      button.setText(Character.toString(currentPlayer));
      if (currentPlayer == 'X') {
        currentPlayer = 'O';
      } else {
        currentPlayer = 'X';
      }
    } else {
      JOptionPane.showMessageDialog(this,"Bro! select another window :)");
    }
  }

  public boolean checkForWin() {
    for (int i = 0; i < 3; i++) {
      if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
          buttons[i][1].getText().equals(buttons[i][2].getText()) &&
          !buttons[i][0].getText().equals("*")) {
        return true;
      }
    }

    for (int j = 0; j < 3; j++) {
      if (buttons[0][j].getText().equals(buttons[1][j].getText()) &&
          buttons[1][j].getText().equals(buttons[2][j].getText()) &&
          !buttons[0][j].getText().equals("*")) {
        return true;
      }
    }

    if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
        buttons[1][1].getText().equals(buttons[2][2].getText()) &&
        !buttons[0][0].getText().equals("*")) {
      return true;
    }
    return buttons[0][2].getText().equals(buttons[1][1].getText()) &&
        buttons[1][1].getText().equals(buttons[2][0].getText()) &&
        !buttons[0][2].getText().equals("*");
  }

  public boolean checkForDraw() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (buttons[i][j].getText().equals("*")) {
          return false;
        }
      }
    }
    return true;
  }


  public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    int row = -1, col = -1;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (buttons[i][j] == button) {
          row = i;
          col = j;
          break;
        }
      }
    }
    makeMove(row, col);

    if (checkForWin()) {
      JOptionPane.showMessageDialog(this, "Bro " + currentPlayer + " lost!");
      reset();
    } else if (checkForDraw()) {
      JOptionPane.showMessageDialog(this, "Oh NO: Draw!");
      reset();
    }
  }


  public void reset() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        buttons[i][j].setText("*");
      }
    }
    currentPlayer = 'X';
  }

  public static void main(String[] args) {
    new TicTacToe();
  }
}

