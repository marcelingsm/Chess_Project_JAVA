/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author USER
 */
public class Pawn extends ChessPiece {
    
    private ChessMatch chessMatch; 

    public Pawn(Board board, Color color, ChessMatch chessmatch) {
        super(board, color);
        this.chessMatch = chessmatch;
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //en passant white
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn()-1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable() ) {
                   mat[left.getRow()-1][left.getColumn()] = true; 
                }
            }
            if (position.getRow() == 3) {
                Position right = new Position(position.getRow(), position.getColumn()+1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable() ) {
                   mat[right.getRow()-1][right.getColumn()] = true; 
                }
            }
            
        } 
        else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

            }
            //en passant BLACK
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn()-1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable() ) {
                   mat[left.getRow()+1][left.getColumn()] = true; 
                }
            }
            if (position.getRow() == 4) {
                Position right = new Position(position.getRow(), position.getColumn()+1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable() ) {
                   mat[right.getRow()+1][right.getColumn()] = true; 
                }
            }
        }

        return mat;
    }

@Override
public String toString(){
    return "P";
}
}