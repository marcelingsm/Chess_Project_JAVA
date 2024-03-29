/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author USER
 */
public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void cleanScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading Chess Position");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPiece());
        System.out.println();
        printCapturedPiece(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        if (!chessMatch.getCheckMate()) {
            System.out.println("Wating player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!!!");
            System.out.println("WINNER:" + chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][] piece) {
        for (int i = 0; i < piece.length; i++) {
            System.out.print((8 - i) + "| ");
            for (int j = 0; j < piece.length; j++) {
                printPiece(piece[i][j], false);
            }
            System.out.println();
        }
        System.out.println("   A B C D E F G H");
    }

    public static void printBoard(ChessPiece[][] piece, boolean[][] possibleMoves) {
        for (int i = 0; i < piece.length; i++) {
            System.out.print((8 - i) + "| ");
            for (int j = 0; j < piece.length; j++) {
                printPiece(piece[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("   A B C D E F G H");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_RED + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_BLACK + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPiece(List<ChessPiece> captured) {
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());

        System.out.println("Captured Piece: ");
        System.out.print("White: ");
        System.out.print(ANSI_RED);
        System.out.println(Arrays.toString(white.toArray()));

        System.out.print(ANSI_RESET);
        System.out.print("Black: ");
        System.out.print(ANSI_BLACK);
        System.out.println(Arrays.toString(black.toArray()));
    }
}
