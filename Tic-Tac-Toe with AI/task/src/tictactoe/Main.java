package tictactoe;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Input command: ");
            String comm = scanner.nextLine();
            if (comm.startsWith("exit")) {
                System.exit(0);
            } else if (comm.length() <= 10) {
                System.out.println("Bad parameters!");
            } else {
                if (comm.substring(6, 10).equals("easy") && comm.substring(11, 15).equals("easy")) {
                    char usr2 = ' ';
                    FieldGame fieldGame = new FieldGame();
                    Random rnd = new Random();
                    boolean flag1 = true;
                    while (flag1) {
                        char usr = ' ';
                        usr = fieldGame.checkNextMove();
                        if(usr == 'X'){
                            usr2 = 'O';
                        }else{
                            usr2 = 'X';
                        }
                        fieldGame.computerGame(usr, usr2, "easy");
                        if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                            System.out.println(fieldGame.checkGame());
                            flag1 = false;
                        }
                    }
                } else if (comm.substring(6, 10).equals("easy") && comm.substring(11, 15).equals("user")) {
                    System.out.println(userAiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("user") && comm.substring(11, 15).equals("hard")) {
                    System.out.println(userAiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("hard") && comm.substring(11, 15).equals("user")) {
                    System.out.println(userAiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("hard") && comm.substring(11, 15).equals("hard")) {
                    System.out.println(aiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("easy") && comm.substring(11, 15).equals("hard")) {
                    System.out.println(aiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("hard") && comm.substring(11, 15).equals("easy")) {
                    System.out.println(aiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("user") && comm.substring(11, 15).equals("easy")){
                    System.out.println(userAiGame(comm.substring(6, 10), comm.substring(11, 15)));
                }else if (comm.substring(6, 10).equals("user") && comm.substring(11, 15).equals("user")){
                    FieldGame fieldGame = new FieldGame();
                    boolean flag1 = true;
                    while (flag1){
                        System.out.print("Enter the coordinates: ");
                        String move = scanner.nextLine();
                        char a = move.charAt(0);
                        char b = move.charAt(2);
                        int c = Character.getNumericValue(a);
                        int d = Character.getNumericValue(b);

                        char usr = fieldGame.checkNextMove();

                        boolean flag = true;
                        while (flag){
                            if (move.charAt(1) != ' '){
                                System.out.println("You should enter numbers!");
                                System.out.print("Enter the coordinates: ");
                                move = scanner.nextLine();

                            }else if (c > 3 || d > 3){
                                System.out.println("Coordinates should be from 1 to 3!");
                                System.out.print("Enter the coordinates: ");
                                move = scanner.nextLine();
                            }else{
                                flag = false;
                            }
                            a = move.charAt(0);
                            b = move.charAt(2);
                            c = Character.getNumericValue(a);
                            d = Character.getNumericValue(b);
                        }
                        fieldGame.Move(c, d, usr);
                        if(fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw"){
                            System.out.println(fieldGame.checkGame());
                            flag1 = false;
                        }
                    }
                }else if (comm.substring(6, 10).equals("user") && comm.substring(11, 17).equals("medium")) {
                    System.out.println(userAiGame(comm.substring(6, 10), comm.substring(11, 17)));
                }else if (comm.substring(6, 12).equals("medium") && comm.substring(13, 17).equals("user")) {
                    System.out.println(userAiGame(comm.substring(6, 12), comm.substring(13, 17)));
                }else if (comm.substring(6, 10).equals("easy") && comm.substring(11, 17).equals("medium")) {
                    System.out.println(aiGame(comm.substring(6, 10), comm.substring(11, 17)));
                }else if (comm.substring(6, 12).equals("medium") && comm.substring(13, 17).equals("easy")) {
                    System.out.println(aiGame(comm.substring(6, 12), comm.substring(13, 17)));
                }else if (comm.substring(6, 12).equals("medium") && comm.substring(13, 17).equals("hard")) {
                    System.out.println(aiGame(comm.substring(6, 12), comm.substring(13, 17)));
                }else if (comm.substring(6, 10).equals("hard") && comm.substring(11, 17).equals("medium")) {
                    System.out.println(aiGame(comm.substring(6, 10), comm.substring(11, 17)));
                }else if (comm.substring(6, 12).equals("medium") && comm.substring(13, 19).equals("medium")) {
                    System.out.println(aiGame(comm.substring(6, 12), comm.substring(13, 19)));
                }
            }
        }

    }

    public static String userAiGame(String usr1, String usr2) {
        FieldGame fieldGame = new FieldGame();
        char user1 = 'n';
        char user2 = 'n';
        if (usr1.equals("easy") && usr2.equals("user")) {
            user1 = 'O';
            user2 = 'X';
            fieldGame.computerMove(user2);
        } else if (usr1.equals("user") && usr2.equals("easy")) {
            user1 = 'X';
            user2 = 'O';
        } else if (usr1.equals("user") && usr2.equals("medium")) {
            user1 = 'X';
            user2 = 'O';
        } else if (usr1.equals("medium") && usr2.equals("user")) {
            user1 = 'O';
            user2 = 'X';
            fieldGame.computerGame(user2, user1, "medium");
        }else if (usr1.equals("user") && usr2.equals("hard")) {
            user1 = 'X';
            user2 = 'O';
        }else if (usr1.equals("hard") && usr2.equals("user")) {
            user1 = 'O';
            user2 = 'X';
            Random rnd = new Random();
            fieldGame.HardGame(user2);
        }
        while (true) {
            System.out.print("Enter the coordinates: ");
            String move = scanner.nextLine();
            char a = move.charAt(0);
            char b = move.charAt(2);
            int c = Character.getNumericValue(a);
            int d = Character.getNumericValue(b);

            boolean flag = true;
            while (flag) {
                if (move.charAt(1) != ' ') {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                    move = scanner.nextLine();

                }else if (c > 3 || d > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                    move = scanner.nextLine();
                }else if (fieldGame.Move(c, d, user1).equals("This cell is occupied! Choose another one!")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: ");
                    move = scanner.nextLine();
                } else {
                    flag = false;
                }
                a = move.charAt(0);
                b = move.charAt(2);
                c = Character.getNumericValue(a);
                d = Character.getNumericValue(b);
            }

            if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                return fieldGame.checkGame();

            }
            if(usr1.equals("easy") || usr2.equals("easy")){
                fieldGame.computerMove(user2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }else if(usr1.equals("medium") || usr2.equals("medium")){
                fieldGame.computerGame(user2, user1, "medium");
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }else if(usr1.equals("hard") || usr2.equals("hard")){
                fieldGame.HardGame(user2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }
        }
    }

    public static String aiGame(String level_1, String level_2) {
        char usr = 'X';
        char usr2 = 'O';
        FieldGame fieldGame = new FieldGame();
        Random rnd = new Random();
        boolean flag1 = true;
        if((level_1.equals("easy") && level_2.equals("easy")) ||
                (level_1.equals("easy") && level_2.equals("medium")) ||
                (level_1.equals("medium") && level_2.equals("medium")) ||
                (level_1.equals("medium") && level_2.equals("easy"))){
        while (flag1) {
            if (fieldGame.checkNextMove() == 'X') {
                fieldGame.computerGame(usr, usr2, level_1);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame().equals("Draw")) {
                    return fieldGame.checkGame();
                }
            } else if (fieldGame.checkNextMove() == 'O') {
                fieldGame.computerGame(usr2, usr, level_2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }
        }
        }else if(level_1.equals("hard") && level_2.equals("hard")){
            while (true) {
                fieldGame.HardGame(usr);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
                fieldGame.HardGame(usr2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }
        }else if((level_1.equals("easy") || level_1.equals("medium")) && level_2.equals("hard")){
            while(true){
                fieldGame.computerGame(usr, usr2, level_1);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
                fieldGame.HardGame(usr2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }
        }else if(level_1.equals("hard") && (level_2.equals("easy") || level_2.equals("medium"))){
            while (true) {
                fieldGame.HardGame(usr);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
                fieldGame.computerGame(usr2,usr, level_2);
                if (fieldGame.checkGame() == "X wins" || fieldGame.checkGame() == "O wins" || fieldGame.checkGame() == "Draw") {
                    return fieldGame.checkGame();
                }
            }
        }
        return "";
    }

}

class FieldGame {

    private char[][] field = new char[3][3];

    public FieldGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = '_';
            }
        }
        PrintGame();
    }

    public void PrintGame() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ('_')) {
                    System.out.print("  ");
                } else {
                    System.out.print(field[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public String computerGame(char user, char user2, String level){
        Random rnd = new Random();
        int cont_X = 0;
        int cont_O = 0;
        int cont = 0;
        boolean flag = true;
        boolean flag1 = true;
        if (level.equals("medium")) {
            System.out.println("Making move level \"medium\"");
            while (flag) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (field[i][j] == user2) {
                            cont++;
                            if(cont == 2){
                                for(int k = 0; k < 3; k++){
                                    if (field[i][k] == '_') {
                                        field[i][k] = user;
                                        PrintGame();
                                        return "";
                                    }
                                }
                            }
                        }
                    }
                    cont = 0;
                }

                cont = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (field[j][i] == user2) {
                            cont++;
                            if (cont == 2) {
                                for (int k = 0; k < 3; k++){
                                    if(field[k][i] == '_'){
                                        field[k][i] = user;
                                        PrintGame();
                                        return "";
                                    }
                                }
                            }
                        }
                    }
                    cont = 0;
                }

                cont = 0;

                for (int i = 0; i < 3; i++){
                    if(field[i][i] == user2){
                        cont++;
                        if(cont == 2){
                            for (int j = 0; j < 3; j++){
                                if(field[j][j] == '_'){
                                    field[j][j] = user;
                                    PrintGame();
                                    return "";
                                }
                            }
                        }
                    }
                }

                cont = 0;

                for (int i = 0; i < 3; i++){
                    if(field[i][2-i] == user2){
                        cont++;
                        if(cont == 2){
                            for (int j = 0; j < 3; j++){
                                if(field[j][2-j] == '_'){
                                    field[j][2-j] = user;
                                    PrintGame();
                                    return "";
                                }
                            }
                        }
                    }
                }


                    while (flag1) {
                        int a = rnd.nextInt(3);
                        int b = rnd.nextInt(3);
                        if (field[a][b] == '_') {
                            field[a][b] = user;
                            PrintGame();
                            return "";
                        }
                    }

            }
        }else if(level.equals("easy")){
            System.out.println("Making move level \"easy\"");
            while (flag1) {
                int a = rnd.nextInt(3);
                int b = rnd.nextInt(3);
                if (field[a][b] == '_') {
                    field[a][b] = user;
                    PrintGame();
                    return "";
                }
            }
            return "";
        }
        return "";
    }

    public void computerMove(char usr){
        Random rnd = new Random();
        System.out.println("Making move level \"easy\"");
        for (int i = 0; i < 100; i++){
            int a = rnd.nextInt(3);
            int b = rnd.nextInt(3);
            if (field[a][b] == '_'){
                field[a][b] = usr;
                PrintGame();
                break;
            }
        }
    }

    public String Move(int a, int b, char usr) {
        if (b == 3) {
            b = 0;
        } else if (b == 2) {
            b = 1;
        } else {
            b = 2;
        }
        if (field[b][a - 1] == '_') {
            field[b][a - 1] = usr;
            PrintGame();
        } else {
            return  "This cell is occupied! Choose another one!";
        }
        return " ";
    }


    public char checkNextMove() {
        int cont_X = 0;
        int cont_O = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field[i][j] == 'X'){
                    cont_X++;
                }else if (field[i][j] == 'O'){
                    cont_O++;
                }
            }
        }
        if (cont_X == cont_O){
            return 'X';
        }else if (cont_X < cont_O){
            return  'X';
        }else if (cont_X > cont_O){
            return  'O';
        }
        return 'u';
    }

    public String checkGame(){
        if (
                (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') ||
                        (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') ||
                        (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') ||
                        (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') ||
                        (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') ||
                        (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') ||
                        (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') ||
                        (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X')
        ) {
            return "X wins";
        } else if (
                (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') ||
                        (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') ||
                        (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') ||
                        (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') ||
                        (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') ||
                        (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') ||
                        (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') ||
                        (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O')
        ) {
            return "O wins";
        }

        int cont = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(field[i][j] == 'X' || field[i][j] == 'O'){
                    cont++;
                    if(cont == 9){
                        return "Draw";
                    }
                }
            }
        }
        return "";
    }

    public void HardGame(char usr) {
        System.out.println("Making move level \"hard\"");
        char usr2 = ' ';
        if(usr == 'X'){
            usr2 = 'O';
        }else{
            usr2 = 'X';
        }
        int aux = -5000;
        int score = 0;
        int[] move = new int[2];
        char[][] copyField = field;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(field[i][j] == '_'){
                    field[i][j] = usr;
                    score = minimax(0, false, usr, usr2);
                    field[i][j] = '_';
                    if(score > aux) {
                        aux = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        field[move[0]][move[1]] = usr;
        PrintGame();
    }

    public int minimax(int depth, boolean isMax, char usr, char usr2) {
        if(winning(usr, usr2) != 3){
            return winning(usr, usr2);
        }
        if(isMax) {
            int aux = -5000;
            int score = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if(field[i][j] == '_'){
                        field[i][j] = usr;
                        score = minimax(depth+1, false, usr, usr2);
                        field[i][j] = '_';
                        if(score > aux) {
                            aux = score;
                        }
                    }
                }
            }
            return aux;
        }else {
            int aux = 5000;
            int score = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if(field[i][j] == '_'){
                        field[i][j] = usr2;
                        score = minimax(depth+1, true, usr, usr2);
                        field[i][j] = '_';
                        if(score < aux) {
                            aux = score;
                        }
                    }
                }
            }
            return aux;
        }
    }

    public int winning(char usr, char usr2){
        if (
                (field[0][0] == usr && field[0][1] == usr && field[0][2] == usr) ||
                        (field[1][0] == usr && field[1][1] == usr && field[1][2] == usr) ||
                        (field[2][0] == usr && field[2][1] == usr && field[2][2] == usr) ||
                        (field[0][0] == usr && field[1][0] == usr && field[2][0] == usr) ||
                        (field[0][1] == usr && field[1][1] == usr && field[2][1] == usr) ||
                        (field[0][2] == usr && field[1][2] == usr && field[2][2] == usr) ||
                        (field[0][0] == usr && field[1][1] == usr && field[2][2] == usr) ||
                        (field[0][2] == usr && field[1][1] == usr && field[2][0] == usr)
        ) {
            return 10;
        } else if (
                (field[0][0] == usr2 && field[0][1] == usr2 && field[0][2] == usr2) ||
                        (field[1][0] == usr2 && field[1][1] == usr2 && field[1][2] == usr2) ||
                        (field[2][0] == usr2 && field[2][1] == usr2 && field[2][2] == usr2) ||
                        (field[0][0] == usr2 && field[1][0] == usr2 && field[2][0] == usr2) ||
                        (field[0][1] == usr2 && field[1][1] == usr2 && field[2][1] == usr2) ||
                        (field[0][2] == usr2 && field[1][2] == usr2 && field[2][2] == usr2) ||
                        (field[0][0] == usr2 && field[1][1] == usr2 && field[2][2] == usr2) ||
                        (field[0][2] == usr2 && field[1][1] == usr2 && field[2][0] == usr2)
        ) {
            return -10;
        }else{
        int cont = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(field[i][j] == 'X' || field[i][j] == 'O'){
                    cont++;
                    if(cont == 9){
                        return 0;
                    }
                }
            }
        }
        }
        return 3;
    }
}