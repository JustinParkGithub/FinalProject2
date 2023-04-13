package finalproject;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameFrame extends javax.swing.JFrame {

    //Instantiates all the game thread classes - Written by Justin
    private RandomWords randomWords = new RandomWords();
    private GenerateLabel generateLabel = new GenerateLabel(this, randomWords);
    private GameOver gameOver;
    private GameThread gameThread = new GameThread(this);
    //User input - Written by Hajin
    private String answer;

    //List of words user typed - Written by Justin Park
    private ArrayList<String> wordsTyped = new ArrayList<>();
    private ArrayList<String> wordsMissed = new ArrayList<>();

    private int health;

    public int getHealth(){
        health = healthBar.getValue();
        return health;
  }
    
    /**
     * Creates new form GameFrame
     */
    public GameFrame(GameOver g) {
        initComponents();
        gameOver = g;
        System.out.println(jRadioButton1.getX() + ", " + jRadioButton1.getY());
    }
    
    public void addToWordsTyped(String str) {
        wordsTyped.add(str);
    }

    public void addToWordsMissed(String str) {
        wordsMissed.add(str);
    }


    //For updating the stopwatch label, used in GameThread - Written by Paul
    public void updateStopwatch(String time) {
        stopwatchLabel.setText(time);
    }

    //For updating the health bar, used in GameThread- Written by Paul
    public void updateHealth(int health) {
        healthBar.setValue(health);
    }

    //For writting the 3, 2, 1, Start when openning the GameFrame, used in GameThread - Written by Justin
    public void updateStartCountdown(String str) {
        startCountdown.setText(str);
    }

    //For making the starting countdown label invisible after the Start, used in GameThread - Written by Justin
    public void deleteStartCountdown() {
        startCountdown.setText("");
    }

    //For generating the initial labels - Written by Justin
    public void startGame() {
        generateLabel.assignWords();
        for(int i=0; i<generateLabel.labelArrSize(); i++) {
            generateLabel.randomLocationLabel(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        healthBar = new javax.swing.JProgressBar();
        userInput = new javax.swing.JTextField();
        stopwatchLabel = new javax.swing.JLabel();
        currentScore = new javax.swing.JLabel();
        typehere = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        startCountdown = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Screen");
        setFocusable(false);
        setResizable(false);

        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
        });
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInputKeyPressed(evt);
            }
        });

        stopwatchLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        stopwatchLabel.setText("00:00.00");
        stopwatchLabel.setFocusable(false);

        currentScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currentScore.setText("SCORE:");
        currentScore.setFocusable(false);

        typehere.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        typehere.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typehere.setText("TYPE HERE:");
        typehere.setToolTipText("");
        typehere.setFocusable(false);

        jRadioButton1.setFocusable(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        startCountdown.setFont(new java.awt.Font("Segoe UI", 1, 150)); // NOI18N
        startCountdown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startCountdown.setAlignmentY(0.0F);
        startCountdown.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stopwatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jRadioButton1))
                    .addComponent(currentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(typehere)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(startCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopwatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(startCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typehere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void userInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyPressed
        //For checking user input and replacing the words in the labels - Written by Hajin, modified by Justin 
        if (evt.getKeyCode() == 10) {
            answer = userInput.getText();
            userInput.setText("");
            
            generateLabel.checkAnswer(answer);

            //Opens Game Over frame when all labels are empty - Written by Justin
            if (generateLabel.allEmptyLabels() == true) {
                gameThread.interrupt();
                gameOver.setTimeLabel(stopwatchLabel.getText());
                gameOver.setScoreLabel(currentScore.getText());
                for(int i=0; i<wordsTyped.size(); i++) {
                    gameOver.setTextAreaTyped(wordsTyped.get(i));
                }
                for(int i=0; i<wordsMissed.size(); i++){
                    gameOver.setTextAreaMissed(wordsMissed.get(i));
                }
                generateLabel.interrupt();
                TypingGame.gameOverVisible();
            }
        }
    }//GEN-LAST:event_userInputKeyPressed

    private void userInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusGained
        //Starts the game and GameThread when the Game Frame opens and automatically gives focus to userInput - Written by Justin
        gameThread.start();
        generateLabel.start();
    }//GEN-LAST:event_userInputFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentScore;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel startCountdown;
    private javax.swing.JLabel stopwatchLabel;
    private javax.swing.JLabel typehere;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
}
