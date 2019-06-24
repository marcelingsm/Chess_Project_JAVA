/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import board.Board;
import board.Piece;
import board.Position;

/**
 *
 * @author USER
 */
public abstract class ChessPiece extends Piece{
    
    private Color color;
    private int moveCount;

    public ChessPiece(Board board,Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public int getMoveCount(){
        return moveCount;
    }
    
    public void incresedMoveCount(){
        moveCount++;
    }
    
    public void decresedMoveCount(){
        moveCount--;
    }
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
    protected boolean isThereOpponentPiece(Position position){
      ChessPiece p = (ChessPiece)getBoard().piece(position);
     return p != null && p.getColor() != color;
    }
     
}
