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
        return X;
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
        int counterO = 0;
        int counterX = 0;
        boolean tie = true;

        for(int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < this.matrix.length; j++) {
                if(this.matrix[i][j] == 'X') {
                    counterX++;
                } else if (this.matrix[i][j] == 'O') {
                    counterO++;
                }
            }   tie = counterX == counterO;
        }


        return tie;
    }

    public String getWinner() {

        return null;
    }

}
