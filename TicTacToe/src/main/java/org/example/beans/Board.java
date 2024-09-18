package org.example.beans;

import java.io.IOException;

public class Board {
    Piece[][] playingPieces;
    int size;
    int emptyPlaces;

    Board(int size){
        this.size=size;
        this.playingPieces=new Piece[size][size];
        emptyPlaces=size*size;
    }
    public void display(){
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(playingPieces[i][j]!=null)
                    System.out.print(playingPieces[i][j]);
                else
                    System.out.print(" ");
                if(j!=size-1)
                    System.out.print(" | ");
            }
            System.out.println();
        }
    }
    public void setPiece(int x, int y, Piece piece){
        playingPieces[x][y]=piece;
        emptyPlaces--;

    }
    public boolean isPlaceEmpty(int x, int y){
        if(playingPieces[x][y]==null)
            return true;
        return false;
    }
    public boolean process(Piece piece){
        //check for columns
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(playingPieces[i][j]==null || !playingPieces[i][j].toString().equalsIgnoreCase(piece.toString()))
                    break;
                if(j==size-1)
                    return true;
            }
        }
        //check for rows

        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if(playingPieces[j][i]==null || !playingPieces[j][i].toString().equalsIgnoreCase(piece.toString()))
                    break;
                if(j==size-1)
                    return true;
            }
        }
        //check for diagonal1
        for(int i=0;i<size;i++){
                if(playingPieces[i][i]==null || !playingPieces[i][i].toString().equalsIgnoreCase(piece.toString()))
                    break;
                if(i==size-1)
                    return true;
        }
        //check for diagonal2
        for(int i=size-1;i>=0;i--){
            if(playingPieces[i][i]==null || !playingPieces[i][i].toString().equalsIgnoreCase(piece.toString()))
                break;
            if(i==0)
                return true;
        }
        return false;
    }
    public boolean isSpaceAvailable(){
        return !(emptyPlaces==0);
    }

}
