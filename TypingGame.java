package finalproject;

public class TypingGame {

    //Instantiates all JFrames - Written by Justin Park
    private static TitleFrame titleFrame = new TitleFrame();
    private static GameOver gameOver = new GameOver();
    private static GameFrame gameFrame = new GameFrame(gameOver);

    //Makes one Frame visible and all other frams invisible - Written by Justin
    public static void titleFrameVisible() {
        titleFrame.setVisible(true);
        gameFrame.setVisible(false);
        gameOver.setVisible(false);
    }

    public static void gameFrameVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(true);
        gameOver.setVisible(false);
    }

    public static void gameOverVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(false);
        gameOver.setVisible(true);
    }

    //The main method of the Project
    public static void main(String[] args) {
        titleFrame.setVisible(true);
    }
}
