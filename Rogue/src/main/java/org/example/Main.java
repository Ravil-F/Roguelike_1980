package org.example;

//import com.googlecode.lanterna.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;

import java.io.IOException;

import domain.Player;

public class Main {
    public static void main(String[] args) {
//        try {
//            Terminal terminal = new DefaultTerminalFactory().createTerminal();
//            terminal.setCursorPosition(10, 5);
//            terminal.putCharacter('H');
//            terminal.putCharacter('e');
//            terminal.putCharacter('l');
//            terminal.putCharacter('l');
//            terminal.putCharacter('o');
//            terminal.putCharacter('!');
//            terminal.setCursorPosition(0, 0);
//            terminal.enterPrivateMode();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }



        try {
            Player player = new Player("Ravil", '@', (byte)2, 100, 80, 60, 40);
            System.out.printf(" name = %s\n symbol = %c\n color = %d\n max_health = %d\n health = %d\n agility = %d\n strength = %d",
                    player.getName(), player.getSymbol(), player.getColor(), player.getMaxHealth(), player.getHealth(),
                    player.getAgility(), player.getStrength());

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            terminal.enterPrivateMode();
            terminal.setCursorPosition(10, 5);
            terminal.putCharacter(player.getSymbol());
            terminal.flush();
            terminal.setCursorPosition(0,0);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}