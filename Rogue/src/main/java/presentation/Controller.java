package presentation;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import domain.Model;
import domain.enums.StatusE;

import java.io.ObjectInputFilter;

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
                        model.movePlayer(StatusE.UP.ordinal());
                        break;
                    case 's':
                    case 'S':
                        model.movePlayer(StatusE.DOWN.ordinal());
                        break;
                    case 'a':
                    case 'A':
                        model.movePlayer(StatusE.LEFT.ordinal());
                        break;
                    case 'd':
                    case 'D':
                        model.movePlayer(StatusE.RIGHT.ordinal());
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
        model.gameSession();
    }

    public void passName(String namePlayer){
        model.passName(namePlayer);
    }


    //GET-SET METOD
    public Model getModel() {
        return model;
    }
}
