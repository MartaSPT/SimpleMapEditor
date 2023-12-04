import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int CELLSIZE = 20;
    public static final int PADDING = 10;
    private int col;
    private int row;
    private Cell [][] grid;
    private Controls controls;


    public Grid(){
        this.col = 20;
        this.row = 20;
        gridDraw();
    }

    public Controls getControls() {
        return controls;
    }

    public void setControls(Controls controls) {
        this.controls = controls;
    }

    private void gridDraw (){
        this.grid = new Cell[this.col][this.row];
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

    public void stringToGrid(String grid) {

        int index = 0;

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {

                Cell cell = this.grid[i][j];

                if (grid.charAt(index) == '0') {
                    cell.setPainted(false);
                } else {
                    cell.setPainted(true);
                }
                controls.painting(i,j);

                index++;
            }
            index++; // skip "\n" on each line
        }

    }
    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                strBuilder.append(grid[i][j]);
                //System.out.println(strBuilder.append(grid[i][j]));
            }
            strBuilder.append("\n");
        }
        System.out.println(strBuilder.toString());
        return strBuilder.toString();

    }

}
