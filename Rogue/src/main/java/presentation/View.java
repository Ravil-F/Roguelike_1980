package presentation;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import domain.enums.MapE;

import java.io.IOException;
import java.security.Key;


public class View {
    private Terminal terminal;
    private TerminalScreen screen;
    private TextGraphics textGraphics;

    private Controller controller;
    private KeyStroke key;

    public View(Controller controller) {
        try {
            this.controller = controller;
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            textGraphics = screen.newTextGraphics();
            screen.startScreen();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    // VIEW WINDOWS
    public void startWindow(){
        try {
            textGraphics.putString(4, 2, "1      - New game");
            textGraphics.putString(4, 3, "2      - Load save game");
            textGraphics.putString(4, 4, "Escape - Exit game");
            screen.refresh();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String inputScan() throws IOException{
        StringBuilder res = new StringBuilder();
        screen.clear();
        char symbol;
        int i = 23;
        textGraphics.putString(4, 2, "Enter name Player:");
        screen.refresh();
        do{
            key = screen.readInput();
            if((key.getCharacter() != ' ') && (key.getKeyType() == KeyType.Enter))
                break;
            symbol = key.getCharacter();
            textGraphics.putString(i, 2, String.valueOf(symbol));
            res.append(symbol);
            screen.refresh();
            ++i;
        }while (true);
        return res.toString().trim();
    }

    private void viewMap(){
        String tmp = "0";
        for(int x = 0; x < controller.getModel().getMap().getWidth(); ++x){
            for (int y = 0; y < controller.getModel().getMap().getHeight(); ++y){
                if (!controller.getModel().getMap().getMap(x, y).equals(tmp) && controller.getModel().getMap().getMapChar(x, y) != '0'){
                    textGraphics.putString(x, y, controller.getModel().getMap().convertIntToString(x, y));
                }
            }
        }
    }

    private void viewInfo(){
        int count  = 2;
        textGraphics.putString( 2, MapE.WIDTH_HEIGHT.getWidth() + count,"Max health: " + controller.getModel().getPlayer().getMaxHealth());
        textGraphics.putString( 2, MapE.WIDTH_HEIGHT.getWidth() + (count + 1),"Health: " + controller.getModel().getPlayer().getHealth());
        textGraphics.putString( 20, MapE.WIDTH_HEIGHT.getWidth() + count,"Agility: " + controller.getModel().getPlayer().getAgility());
        textGraphics.putString( 20, MapE.WIDTH_HEIGHT.getWidth() + (count + 1),"Strength: " + controller.getModel().getPlayer().getStrength());
    }

    private void viewGameOver(){
        try {
            screen.clear();
            textGraphics.putString(4, 2, "Game Over, " + controller.getModel().getPlayer().getName());
            screen.refresh();
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void viewSingleItemtype() throws IOException {
        System.out.println("Hello======================================");
        int tmpX = MapE.WIDTH_HEIGHT.getWidth();
        if (controller.getModel().getSingleItemType().isEmpty())
            textGraphics.putString(2, 2, "Not Items in Backpack");
        for(int i = 0; i < controller.getModel().getSingleItemType().size(); ++i){
            textGraphics.putString(tmpX + 4, 2 + i,+ i + "." +
                    " name-" + controller.getModel().getSingleItemType().get(i).getName() +
                    " increase-" + controller.getModel().getSingleItemType().get(i).getIncrease());
        }
        screen.refresh();
    }
    // END VIEW WINDOWS


    // GET-SET METOD
    public KeyStroke getKey() {
        return key;
    }

    public void setKey() throws IOException {
        KeyStroke tmp = screen.pollInput();
        if (tmp != null)
            this.key = tmp;
    }

        public TerminalScreen getScreen() {
        return screen;
    }

    public void setScreen(TerminalScreen screen) {
        this.screen = screen;
    }
    //END GET-SET METOD


    public void passName(String namePlayer){
        controller.passName(namePlayer);
    }

    public void gameLoop() throws IOException {
        controller.getModel().gameInitialization();
        try{
            while (true){
                screen.clear();
                setKey();
                if (key != null){
                    if (key.getKeyType() == KeyType.Escape){
                        viewGameOver();
                        break;
                    }
                    if (key.getKeyType() == KeyType.Character) {
                        controller.userInput(key, true);
                    }
                    viewGame(key);
                    screen.refresh();
                    key = null;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void viewGame(KeyStroke key) throws IOException {
        viewController(key);
        viewMap();
        viewInfo();
    }

    private void viewController(KeyStroke key) throws IOException {
        char tmp = Character.toLowerCase(key.getCharacter());
        if (tmp == 'h') {
            viewSingleItemtype();
//            screen.clear();
            key = null;
            setKey();
            if (key != null){
                if(key.getKeyType() == KeyType.Escape)
                    return;
                if(key.getKeyType() == KeyType.Character){
//                    char tmpInt = Character.toLowerCase(key.getCharacter());
                    System.out.println("tmpInt: ");
//                    try {
//                        int index = tmpInt - 'a';
//                        System.out.println("index: " + index);
                        controller.userInputBackpack(key);
//                    }catch (NumberFormatException e){
//                        textGraphics.putString(MapE.WIDTH_HEIGHT.getWidth() + 4, 15, e.getMessage());
//                    }
                }
            }
        }
    }

    public void stopWidows() throws IOException {
        screen.stopScreen();
    }

}
