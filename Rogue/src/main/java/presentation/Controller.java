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
        int x = model.getPlayer().getCoord().getX();
        int y = model.getPlayer().getCoord().getY();
        if(key!= null){
            if(key.getKeyType() == KeyType.Character){
                switch (key.getCharacter()){
                    case 'w':
                    case 'W':
//                        y = model.getPlayer().Move(y, false);
//                        model.getPlayer().setCoord(x, y);
                        model.movePlayer(StatusE.DOWN.ordinal());
                        break;
                    case 's':
                    case 'S':
                        y = model.getPlayer().Move(y, true);
                        model.getPlayer().setCoord(x, y);
                        break;
                    case 'a':
                    case 'A':
                        x = model.getPlayer().Move(x, false);
                        model.getPlayer().setCoord(x, y);
                        break;
                    case 'd':
                    case 'D':
                        x = model.getPlayer().Move(x, true);
                        model.getPlayer().setCoord(x, y);
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
