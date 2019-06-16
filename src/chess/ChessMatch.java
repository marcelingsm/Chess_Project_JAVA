/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import board.Board;

/**
 *
 * @author USER
 */
public class ChessMatch {
    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
    }
    
    public ChessPiece[][] getPiece(){
        ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumn()];
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getColumn(); j++){
                mat[i][j] = (ChessPiece)board.piece(i,j);
            }
        }
    return mat;
    }
}
