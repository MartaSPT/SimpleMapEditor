import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int CELLSIZE = 20;
    public static final int PADDING = 10;
    private int col;
    private int row;
    private Cell [][] grid;


    public Grid(){
        this.col = 20;
        this.row = 20;
        this.grid = new Cell[this.col][this.row];
        gridDraw();

    }

    private void gridDraw (){
        for (int i = 0; i < col; i++){
           for (int j = 0; j < row; j++){
                grid[i][j] = new Cell(i,j);
            }
        }
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Cell[][] getGrid() {
        return grid;
    }

}
