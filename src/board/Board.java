/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

/**
 *
 * @author USER
 */
public class Board {
    private int row;
    private int column;
    private Piece [][] piece;

    public Board(int row, int column) {
        if(row < 1 || column < 1 ){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.row = row;
        this.column = column;
        piece = new Piece[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    
    public Piece piece(int row,int column){
        if(!positionExists(row,column)){
            throw new BoardException("Position not on the board");
        }
        return piece[row][column];
    }
    
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece,Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position" + position);
        }
        this.piece[position.getRow()][position.getColumn()] = piece;
        piece.position= position;
    }
    public Piece removePiece(Position position){
        if(!positionExists(position)){
        throw new BoardException("Position not on the board");
        }
        if(piece(position)==null){
            return null;
        }
        Piece aux = piece(position);
        piece[position.getRow()][position.getColumn()]=null;
        return aux;
    }
    
    public boolean positionExists(int row,int column){
        return row >= 0 && row <this.row && column >= 0 && column < this.column; 
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());
    }
    
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
