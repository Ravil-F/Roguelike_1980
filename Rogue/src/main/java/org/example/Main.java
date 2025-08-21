package org.example;

import domain.Model;
import presentation.Controller;
import presentation.View;

import javax.swing.*;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        startGame();


//        try {
//            int x = 5;
//            int y = 5;
//            Player player = new Player("Ravil", '@', ColorE.GREEN, 100, 80, 60, 40, x, y);
//            System.out.printf(" name = %s\n symbol = %c\n color = %s\n max_health = %d\n health = %d\n agility = %d\n strength = %d\n x = %d\n y = %d\n",
//                    player.getName(), player.getSymbol(), player.getColor(), player.getMaxHealth(), player.getHealth(),
//                    player.getAgility(), player.getStrength(), player.getCoord().getX(), player.getCoord().getY());
//
//
//            Food bread = new Food(FoodE.MEAT_F, x + 5, y + 5);
//            System.out.printf(" name = %s\n symbol = %c\n increase = %d\n",
//                    bread.getName(), bread.getSymbol(), bread.getIncrease());
//            player.setBackpack(bread);
//            System.out.printf("increase Item: %d", player.getBackpack().getItemsIncrease());
//
//            Zombi z = new Zombi(EnemyE.ZOMBI, x + 2, y + 2);
//            System.out.printf(" name = %s\n symbol = %c\n color = %s\n max_health = %d\n health = %d\n agility = %d\n strength = %d\n hostility = %s\n",
//                    z.getName(), z.getSymbol(), z.getColor(), z.getMaxHealth(), z.getHealth(),
//                    z.getAgility(), z.getStrength(), z.getHostility());
//
//            Terminal terminal = new DefaultTerminalFactory().createTerminal();
//            TerminalScreen screen = new TerminalScreen(terminal);
//            screen.startScreen();
//            TextGraphics textGraphics = screen.newTextGraphics();
//
//            // Установка цвета текста
//            textGraphics.setForegroundColor(ColorE.GREEN.getColor());
//
//            // Отображение символа на экране
//            textGraphics.putString(player.getCoord().getX(), player.getCoord().getY(),String.valueOf(player.getSymbol()));
//            textGraphics.putString(bread.getCoord().getX(), bread.getCoord().getY(),String.valueOf(bread.getSymbol()));
//            textGraphics.putString(z.getCoord().getX(), z.getCoord().getY(),String.valueOf(z.getSymbol()));
//            screen.refresh();
//            while (true) {
//                KeyStroke key = screen.pollInput();
//                if (key != null) {
//                    if (key.getKeyType() == KeyType.Character) {
//                        switch (key.getCharacter()) {
//                            case 'w':
//                                screen.clear();
//                                y = player.MovePlayer(y, false);
//                                break;
//                            case 's':
//                                screen.clear();
//                                y =player.MovePlayer(y, true);
//                                break;
//                            case 'a':
//                                screen.clear();
//                                x = player.MovePlayer(x, false);
//                                break;
//                            case 'd':
//                                screen.clear();
//                                x = player.MovePlayer(x, true);
//                                break;
//                        }
//                    } else if (key.getKeyType() == KeyType.Escape) {
//                        break;
//                    }
//                    player.setCoord(x, y);
//                    textGraphics.putString(player.getCoord().getX(), player.getCoord().getY(),String.valueOf(player.getSymbol()));
//                    textGraphics.putString(bread.getCoord().getX(), bread.getCoord().getY(),String.valueOf(bread.getSymbol()));
//                    textGraphics.putString(z.getCoord().getX(), z.getCoord().getY(),String.valueOf(z.getSymbol()));
//                    screen.refresh();
//                }
//            }
//            screen.stopScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static void startGame() throws IOException {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller,20, 20);
        boolean flag = true;
        KeyStroke key;
        while (flag){
            view.startWindow();
            view.setKey();
            flag = controller.userInput(view.getKey(), flag);
        }
        view.stopWidows();


    }
}