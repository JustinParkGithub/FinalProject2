package finalproject;

import java.util.ArrayList;
import javax.swing.JLabel;

public class GenerateLabel extends Thread {

    //Variabels for labels - Written by Justin
    private GameFrame f;
    private RandomWords r;
    
    private int numOfLabels = 5;
    private int counter = 0;
    
    private ArrayList<JLabel> labelArr = new ArrayList<>();
    private ArrayList<String> labelArrWords = new ArrayList<>();
    
    private int speed = 50;   //speed of words falling (set at start button)
    
    public int getSpeed() {
        return speed;
    }

    //Class constructor, connects GameFrame and RandomWords to GenerateLabel, adds lables to ArrayList for ease of use, used in GameFrame - Written by Justin
    public GenerateLabel(GameFrame form, RandomWords randomWords) {
        f = form;
        r = randomWords;
        startGenerateLabel();
    }
    
    public void startGenerateLabel() {
        for (int i = 0; i < numOfLabels; i++) {
            labelArr.add(new JLabel(""));
        }
        for (int i = 0; i < labelArr.size(); i++) {
            f.add(labelArr.get(i));
        }
    }
    
    public int labelArrSize() {
        return labelArr.size();
    }

    //Divides Game Frame into sections and places a label in each section randomly, used in GameFrame - Written by Justin
    public void randomLocationLabel(int i, int randomNumber) {
        randomNumber = (int) (Math.random() * (labelArr.size() - 1 - 0 + 1) + 0);
        int max = ((815 - 6) / (labelArr.size())) * (randomNumber + 1) + 6;
        int min = ((815 - 6) / (labelArr.size())) * randomNumber + 6;
        int random = (int) (Math.random() * (max - min + 1) + min);
        labelArr.get(i).setBounds(random, 114, 100, 30);
        System.out.println(random);
    }
    
    public void randomLocationLabel(int i) {    //Try randomizing
        int max = ((815 - 6) / (labelArr.size())) * (i + 1) + 6;
        int min = ((815 - 6) / (labelArr.size())) * i + 6;
        int random = (int) (Math.random() * (max - min + 1) + min);
        labelArr.get(i).setBounds(random, 114, 100, 30);
        System.out.println(random);
    }

    //Accessor methods for labels, used in GameFrame - Written by Justin
    public String getLabelText(int i) {
        return labelArr.get(i).getText();
    }

    //Modifier methods for the labels, used in GameFrame - Written by Justin
    //Writes random words into labels, used in GameFrame - Written by Justin
    public void assignWords() {
        r.makeArrayList();
        for (int i = 0; i < labelArr.size(); i++) {
            labelArrWords.add(r.getRandomWords());
            labelArr.get(i).setText(labelArrWords.get(i));
        }
    }
    
    public void checkAnswer(String str) {
        if (labelArrWords.indexOf(str) != -1) {
            int currentLabel = labelArrWords.indexOf(str);
            System.out.println(currentLabel);
            labelArrWords.set(currentLabel, r.getRandomWords());
            labelArr.get(currentLabel).setText(labelArrWords.get(currentLabel));
            randomLocationLabel(currentLabel);
            f.addToWordsTyped(str);
        } else {
            
        }
    }

    //Checks if all labels are empty, used in GameFrame - Written by Justin
    public boolean allEmptyLabels() {
        counter = 0;
        for (int i = 0; i < labelArr.size(); i++) {
            if (labelArr.get(i).getText() == "") {
                counter++;
            } else {
            }
        }
        if (counter == labelArr.size()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void run() {
        while (true) {
            for (int i = 0; i < labelArr.size(); i++) {
                labelArr.get(i).setLocation(labelArr.get(i).getX(), labelArr.get(i).getY() + speed);
                if (labelArr.get(i).getY() >= 540) {
                    f.addToWordsMissed(labelArrWords.get(i));
                    r.addCurrentWord(labelArrWords.get(i));
                    labelArrWords.set(i, r.getRandomWords());
                    labelArr.get(i).setText(labelArrWords.get(i));
                    randomLocationLabel(i, 0);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                for (int i = 0; i < labelArr.size(); i++) {
                    labelArr.remove(0);
                    labelArrWords.remove(0);
                }
                counter = 0;
                r.resetRandomWords();
                return;                
            }            
        }
        
    }
}
