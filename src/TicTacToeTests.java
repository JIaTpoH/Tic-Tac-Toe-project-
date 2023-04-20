import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.*;

public class TicTacToeTests {


  @Test
  public void testCheckForWin() {
    TicTacToe game = new TicTacToe();
    JButton[][] buttons = game.buttons;
    buttons[0][0].setText("X");
    buttons[1][1].setText("X");
    buttons[2][2].setText("X");
    assertTrue(game.checkForWin());
  }
  @Test
  public void testCheckForDraw() {
    TicTacToe game = new TicTacToe();
    JButton[][] buttons = game.buttons;
    buttons[0][0].setText("X");
    buttons[0][1].setText("O");
    buttons[0][2].setText("X");
    buttons[1][0].setText("X");
    buttons[1][1].setText("O");
    buttons[1][2].setText("O");
    buttons[2][0].setText("O");
    buttons[2][1].setText("X");
    buttons[2][2].setText("O");
    assertTrue(game.checkForDraw());
  }
  @Test
  public void testReset() {
    TicTacToe game = new TicTacToe();
    JButton[][] buttons = game.buttons;
    buttons[0][0].setText("X");
    buttons[0][1].setText("O");
    buttons[1][1].setText("O");
    game.reset();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        JButton button = buttons[i][j];
        assertEquals("*", button.getText());
      }
    }
    assertEquals('X', game.currentPlayer);
  }
}
