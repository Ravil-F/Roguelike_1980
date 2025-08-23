package presentation;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;


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
            e.printStackTrace();
        }

    }

    public void startWindow(){
        try {
            textGraphics.putString(4, 2, "1      - New game");
            textGraphics.putString(4, 3, "2      - Load save game");
            textGraphics.putString(4, 4, "Escape - Exit game");
            screen.refresh();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public KeyStroke getKey() {
        return key;
    }

    public void setKey() throws IOException {
        KeyStroke tmp = screen.pollInput();
        if (tmp != null)
            this.key = tmp;
    }

    public void stopWidows() throws IOException {
        screen.stopScreen();
    }

    public String inputScan() throws IOException{
        StringBuilder res = new StringBuilder();
        char symbol = ' ';
        int i = 5;
        textGraphics.putString(4, 2, "Enter name Player: ");
        do{
          key = screen.readInput();
          if((key.getCharacter() != ' ') && (key.getKeyType() == KeyType.Enter))
              break;
            symbol = key.getCharacter();
          textGraphics.putString(i, 2, String.valueOf(symbol));
          screen.refresh();
          ++i;
        }while (true);
        return res.toString().trim();
    }

    public void ViewMap(){
        String tmp = "0";
        for(int x = 0; x < controller.getModel().getMap().getWidth(); ++x){
            for (int y = 0; y < controller.getModel().getMap().getHeight(); ++y){
                if (controller.getModel().getMap().getMap(x, y) !=  tmp)
                    textGraphics.putString(x, y, controller.getModel().getMap().getMap(x, y));
            }
        }
    }
}
