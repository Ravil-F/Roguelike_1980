package presentation;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import domain.Model;
import domain.abstact.Items;
import domain.enums.StatusE;

import java.io.ObjectInputFilter;

public class Controller {
    private Model model;
    private KeyStroke key;

    public Controller(Model model){
        this.model = model;

    }

    public void userInput(KeyStroke key, boolean flag){
        if (key != null) {
            if (key.getKeyType() == KeyType.Character) {
                switch (Character.toLowerCase(key.getCharacter())) {
                    case 'w':
                        model.movePlayer(StatusE.UP);
                        break;
                    case 's':
                        model.movePlayer(StatusE.DOWN);
                        break;
                    case 'a':
                        model.movePlayer(StatusE.LEFT);
                        break;
                    case 'd':
                        model.movePlayer(StatusE.RIGHT);
                        break;
                    case 'h':
                        model.openBackpack('w');
                        break;
                    case 'j':
                        System.out.println("world");
                        break;
                    case 'k':
                        System.out.println("world");
                        break;
                    case 'e':
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

    public void userInputBackpack(KeyStroke key){
        if (key != null){
            if (key.getKeyType() == KeyType.Character){
                System.out.println("key: " + key.getCharacter());
                switch (key.getCharacter()){
                    case '0':
                        System.out.println("hekk");
                        model.getPlayer().setStrength(model.getSingleItemType().get(Character.getNumericValue(key.getCharacter())).getIncrease());
                        break;
                }
            }
        }
        model.getBackpack().getItems().remove(Character.getNumericValue(key.getCharacter()));
//        model.getBackpack().getItems().sort();
    }

    public void passName(String namePlayer){
        model.passName(namePlayer);
    }


    //GET-SET METOD
    public Model getModel() {
        return model;
    }
}
