package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    // instance variable
    Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        int counterO = 0;
        int counterX = 0;
        boolean X = false;

        for(int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < this.matrix.length; j++ ) {
                if(this.matrix[i][j] == 'X') {
                    counterX++;
                } else if (this.matrix[i][j] == 'O') {
                    counterO++;
                }
            }   X = counterX > counterO;
        }
        return getWinner().equals("X");
    }

    public Boolean isInFavorOfO() {
        int counterO = 0;
        int counterX = 0;
        boolean O = false;

        for(int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < this.matrix.length; j++) {
                if(this.matrix[i][j] == 'O') {
                    counterO++;
                } else if (this.matrix[i][j] == 'X') {
                    counterX++;
                }
            }   O = counterO > counterX;
        }
        return O;
    }

    public Boolean isTie() {
        if(getWinner() == "") {
            return true;
        }
        return false;
    }

    public String getWinner() {
        String winner = "";
        // check rows
       String rowWinner = checkRow(matrix);
        // check columns
        String columnWinner = checkColumn(matrix);
        // check diagonal left to right and right to left
        // 0,0 first corner top left - 1,1 midpoint, 2,2 last point right corner
        // 0,2 top right corner, 1,1 midpoint, 2,0 bottom left
        winner = checkDiagonal(matrix);
      if(columnWinner != "" && isLetter(columnWinner.charAt(0))) {
            winner = columnWinner;
       }
      else if(rowWinner != "" && isLetter(rowWinner.charAt(0))) {
                winner = rowWinner;
            }

        return winner;
    }

    private String checkDiagonal(Character[][] matrix) {

        String winner = "";
        if((matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2])|| (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0])) {
            winner = String.valueOf(matrix[1][1]);
        }
        return winner;
    }

    public String checkRow(Character[][] matrix) {
        if(matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && isLetter(matrix[0][0])) {
           return String.valueOf(matrix[0][0]);
        }
        else if(matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2] && isLetter(matrix[1][0])) {
            return String.valueOf(matrix[1][0]);
        }
        else if(matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2] && isLetter(matrix[2][0])) {
            return String.valueOf(matrix[2][0]);
        }
        return "";

    }

    public  String checkColumn(Character[][] matrix) {
            String output = "";


        if (matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0] && isLetter(matrix[0][0])) {
            return output + matrix[0][0];
        }
         else if (matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1] && isLetter(matrix[0][1])) {
            return output + matrix[0][1];
        }
        else if (matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2]  && isLetter(matrix[0][2])) {
            return output + matrix[0][2];
        }
        return "";
    }

    public boolean isLetter(Character character) {
        return character == 'X' || character == 'O';
    }

    }
