import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private int col;
    private int row;
    private Rectangle cell;
    private boolean isPainted;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
        cell = new Rectangle(Grid.PADDING+col*Grid.CELLSIZE, Grid.PADDING+row*Grid.CELLSIZE, Grid.CELLSIZE, Grid.CELLSIZE);
        cell.draw();
        //cell.fill();
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Rectangle getCell() {
        return cell;
    }

    public void setCell(Rectangle cell) {
        this.cell = cell;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }
}
