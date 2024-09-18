package org.example.beans;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Queue<Player> playerQueue;
    Board board;
    boolean gameRunning;

    public Game(){
        initialiseGame();
    }
    private void initialiseGame(){
        System.out.println("enter the size of board : ");
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        this.board= new Board(size);
        System.out.println("enter no. of players : ");
        int players= sc.nextInt();
        Piece[] pieces= Piece.values();
        playerQueue=new LinkedList<>();
        for(int i=0;i<players;i++){
            Player player =new Player();
            player.id=i+1;
            player.piece=pieces[i];
            playerQueue.add(player);
        }
        gameRunning=true;
    }

    public void start(){
        while(gameRunning){
            if(board.isSpaceAvailable()){
                board.display();
                Player currentPlayer = playerQueue.poll();
                System.out.println("player"+currentPlayer.id+ " enter position");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                int y= sc.nextInt();
                if(board.isPlaceEmpty(x,y)){
                    board.setPiece(x,y, currentPlayer.piece);
                    if(board.process(currentPlayer.piece)){
                        System.out.println("congratulations winner is player"+currentPlayer.id);
                        board.display();
                        gameRunning=false;
                    }
                    playerQueue.add(currentPlayer);
                }
                else{
                    System.out.println("Invalid Position try again");
                }
            }else {
                System.out.println("all places filled game draw");
                gameRunning=false;
            }
        }


    }
}
