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
        this.row = row;
        this.column = column;
        piece = new Piece[row][column];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Piece piece(int row,int column){
        return piece[row][column];
    }
    
    public Piece piece(Position position){
        return piece[position.getRow()][position.getColum()];
    }

}
