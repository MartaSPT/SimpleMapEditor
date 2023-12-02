import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Move {
    private Grid grid;

    public Move(){
        this.grid = new Grid();
    }

    public void right(Cell cell){
        if (cell.getCol() >= grid.getCol()-1) {
            return;
        } else {
            cell.getCell().translate(grid.CELLSIZE,0);
            cell.setCol(cell.getCol()+1);

        }
    }

    public void left (Cell cell){
        if (cell.getCol() <= 0) {
            return;
        } else {
            cell.getCell().translate(-grid.CELLSIZE,0);
            cell.setCol(cell.getCol()-1);
        }
    }

    public void down (Cell cell){
        if (cell.getRow() >= grid.getRow()-1) {
            return;
        } else {
            cell.getCell().translate(0,grid.CELLSIZE);
            cell.setRow(cell.getRow()+1);
        }
    }

    public void up (Cell cell){
        if (cell.getRow()<=0) {
            return;
        } else {
            cell.getCell().translate(0,-grid.CELLSIZE);
            cell.setRow(cell.getRow()-1);
        }
    }

}
