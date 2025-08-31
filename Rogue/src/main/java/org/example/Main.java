package org.example;

import com.googlecode.lanterna.input.KeyType;
import domain.Model;
import presentation.Controller;
import presentation.View;

import java.io.IOException;

import static java.lang.Math.max;
import static java.lang.Math.min;
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
    }

    private static void startGame() throws IOException {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);

        view.startWindow();
        startGameLoop(view, controller, model);
        view.stopWidows();
    }

    private static void startGameLoop(View view, Controller controller, Model model) throws IOException{
        while (true) {
            view.setKey();
            if (view.getKey() != null) {
                if (view.getKey().getKeyType() == KeyType.Character) {
                    switch (view.getKey().getCharacter()) {
                        case '1':
                            view.getScreen().refresh();
                            String namePlayer = view.inputScan();
                            if (namePlayer.equals(" "))
                                view.passName(namePlayer);
                            view.gameLoop();
                            break;
                        case '2':
                            System.out.println("world");
                            break;
                        default:
                            break;
                    }
                }
                if (view.getKey().getKeyType() == KeyType.Escape) {
                    break;
                }
            }
        }
    }
}