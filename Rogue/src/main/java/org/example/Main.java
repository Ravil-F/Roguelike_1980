package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

import domain.Player;

//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Создаем терминал
//            Terminal terminal = new DefaultTerminalFactory().createTerminal();
//            TerminalScreen screen = new TerminalScreen(terminal);
//
//            // Инициализация экрана
//            screen.startScreen();
//            screen.setCursorPosition(null); // Скрыть курсор
//
//            // Главный цикл для ожидания ввода
//            while (true) {
//                // Проверяем, есть ли ввод
//                KeyStroke keyStroke = screen.pollInput();
//
//                if (keyStroke != null) {
//                    // Обработка нажатой клавиши
//                    if (keyStroke.getKeyType() == KeyType.Character) {
//                        System.out.println("Нажата клавиша: " + keyStroke.getCharacter());
//                    } else if (keyStroke.getKeyType() == KeyType.Escape) {
//                        System.out.println("Escape нажат. Выход.");
//                        break; // Выход из цикла при нажатии Escape
//                    } else {
//                        System.out.println("Нажатая клавиша: " + keyStroke.getKeyType());
//                    }
//                }
//
//                // Обновление экрана
//                screen.pollInput();
//                screen.refresh();
//            }
//
//            // Завершение работы с экраном
//            screen.stopScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        try {
            int x = 5;
            int y = 5;
            Player player = new Player("Ravil", '@', (byte) 2, 100, 80, 60, 40);
//            System.out.printf(" name = %s\n symbol = %c\n color = %d\n max_health = %d\n health = %d\n agility = %d\n strength = %d",
//                    player.getName(), player.getSymbol(), player.getColor(), player.getMaxHealth(), player.getHealth(),
//                    player.getAgility(), player.getStrength());

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.startScreen();
            screen.setCursorPosition(null);
            screen.setCharacter(x, y, new TextCharacter(player.getSymbol()));
            screen.refresh();
            while (true) {
                KeyStroke key = screen.pollInput();
                if (key != null) {
                    if (key.getKeyType() == KeyType.Character) {
                        switch (key.getCharacter()) {
                            case 'w':
                                screen.clear();
                                --y;
                                break;
                            case 's':
                                screen.clear();
                                ++y;
                                break;
                            case 'a':
                                screen.clear();
                                --x;
                                break;
                            case 'd':
                                screen.clear();
                                ++x;
                                break;
                        }
                    } else if (key.getKeyType() == KeyType.Escape) {
                        break;
                    }
                    screen.setCharacter(x, y, new TextCharacter(player.getSymbol()));
                    screen.refresh();
                }
            }
            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}