package org.example;

import com.googlecode.lanterna.input.KeyType;
import domain.Model;
import presentation.Controller;
import presentation.View;

import java.io.IOException;
    
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