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
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

import domain.Player;
import domain.Zombi;
import domain.enums.Color;
import domain.enums.EnemyType;

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
            Player player = new Player("Ravil", '@', Color.GREEN, 100, 80, 60, 40, x, y);

            System.out.printf(" name = %s\n symbol = %c\n color = %s\n max_health = %d\n health = %d\n agility = %d\n strength = %d\n x = %d\n y = %d\n",
                    player.getName(), player.getSymbol(), player.getColor(), player.getMaxHealth(), player.getHealth(),
                    player.getAgility(), player.getStrength(), player.getCoord().getX(), player.getCoord().getY());

        Zombi z = new Zombi(EnemyType.ZOMBI, x + 2, y + 2);
        System.out.printf(" name = %s\n symbol = %c\n color = %s\n max_health = %d\n health = %d\n agility = %d\n strength = %d\n hostility = %s\n",
                z.getName(), z.getSymbol(), z.getColor(), z.getMaxHealth(), z.getHealth(),
                z.getAgility(), z.getStrength(), z.getHostility());

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            TerminalScreen screen = new TerminalScreen(terminal);
            screen.startScreen();
            TextGraphics textGraphics = screen.newTextGraphics();

            // Установка цвета текста
            textGraphics.setForegroundColor(Color.GREEN.getColor());

            // Отображение символа на экране
            textGraphics.putString(player.getCoord().getX(), player.getCoord().getY(),String.valueOf(player.getSymbol()));

            textGraphics.putString(z.getCoord().getX(), z.getCoord().getY(),String.valueOf(z.getSymbol()));
            screen.refresh();
            while (true) {
                KeyStroke key = screen.pollInput();
                if (key != null) {
                    if (key.getKeyType() == KeyType.Character) {
                        switch (key.getCharacter()) {
                            case 'w':
                                screen.clear();
                                y = player.MovePlayer(y, false);
                                break;
                            case 's':
                                screen.clear();
                                y =player.MovePlayer(y, true);
                                break;
                            case 'a':
                                screen.clear();
                                x = player.MovePlayer(x, false);
                                break;
                            case 'd':
                                screen.clear();
                                x = player.MovePlayer(x, true);
                                break;
                        }
                    } else if (key.getKeyType() == KeyType.Escape) {
                        break;
                    }
                    player.setCoord(x, y);
                    System.out.printf(" x = %d\n y = %d\n", player.getCoord().getX(), player.getCoord().getY());
                    textGraphics.putString(player.getCoord().getX(), player.getCoord().getY(),String.valueOf(player.getSymbol()));
                    screen.refresh();
                }
            }
            screen.stopScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}