package presentation;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import domain.Model;

public class Controller {
    private Model model;
    private KeyStroke key;

    public Controller(Model model){
        this.model = model;

    }

    public void userInput(KeyStroke key, boolean flag){
        if(key!= null){
            if(key.getKeyType() == KeyType.Character){
                switch (key.getCharacter()){
                    case 'w':
                    case 'W':
                        break;
                    case 's':
                    case 'S':
                        break;
                    case 'a':
                    case 'A':
                        break;
                    case 'd':
                    case 'D':
                        break;
                    case '1':
                    case '2':
                        System.out.println("world");
                        break;
                    default:
                        break;
                }
            } else if (key.getKeyType() == KeyType.Escape) {
                flag = false;
            }
        }
    }

    public void passName(String namePlayer){
        model.gameSession(namePlayer);
    }


    //GET-SET METOD
    public Model getModel() {
        return model;
    }
}
