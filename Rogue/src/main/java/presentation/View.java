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
    private int width;
    private int height;
    private TextGraphics textGraphics;

    private Controller controller;
    private KeyStroke key;

    public View(Controller controller, int width, int height) {
        try {
            this.controller = controller;
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.width = width;
            this.height = height;
            textGraphics = screen.newTextGraphics();
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startWindow(){
        try {
            textGraphics.putString(1,2, ">>");
            textGraphics.putString(4, 2, "New game");
            textGraphics.putString(4, 3, "Load save game");
            textGraphics.putString(4, 4, "Exit game");
            screen.refresh();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
}
