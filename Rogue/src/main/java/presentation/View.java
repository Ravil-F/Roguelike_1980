package presentation;

import com.googlecode.lanterna.graphics.TextGraphics;
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

    public String SetViewNamePlaeyr(){
        String line;
        while (line.isEmpty()){
            textGraphics.putString("Enter name Player: ");
        }
    }

    public void ViewMap(){
        for(int x = 0; x < controller.getModel().getMap().getWidth(); ++x){
            for (int y = 0; y < controller.getModel().getMap().getHeight(); ++y){
                textGraphics.putString(x, y, controller.getModel().getMap().getMap(x, y));
            }
        }
    }
}
