package org.example;

import org.example.beans.Game;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Tic tac toe");
        Game newGame= new Game();
        newGame.start();

    }
}