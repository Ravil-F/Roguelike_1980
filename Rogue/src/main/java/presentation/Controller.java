package presentation;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import domain.Model;
import domain.utils.inputScan;

public class Controller {
    private Model model;
    private KeyStroke key;
    private inputScan scan;

    public Controller(Model model){
        this.model = model;

    }

    public boolean userInput(KeyStroke key, boolean flag){
        if(key!= null){
            if(key.getKeyType() == KeyType.Character){
                switch (key.getCharacter()){
                    case '1':
                        scan = new inputScan();
                        String namePlayer = scan.scanLine("Enter name Player: ");
                        model.gameSession(namePlayer);
                        break;
                    case '2':
                        System.out.println("world");
                        break;
                }
            } else if (key.getKeyType() == KeyType.Escape) {
                flag = false;
            }
        }
        return flag;
    }

    public Model getModel() {
        return model;
    }
}
