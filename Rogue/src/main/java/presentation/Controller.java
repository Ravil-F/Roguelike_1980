package presentation;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import domain.Model;

import javax.swing.*;

public class Controller {
    private Model model;
    private KeyStroke key;
    public Controller(Model model){
        this.model = model;
    }

    public boolean userInput(KeyStroke key, boolean flag){
        if(key!= null){
            if(key.getKeyType() == KeyType.Character){
                switch (key.getCharacter()){
                    case '1':
                        System.out.println("hello");
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
}
