import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Controls implements KeyboardHandler {


    private Keyboard kb;
    private Cell cell;
    private Move move;
    private boolean status;

    private Grid grid;

    public Controls() {
        this.cell = new Cell(0, 0);
        this.cell.getCell().draw();
        this.cell.getCell().fill();
        this.move = new Move();
        this.grid = new Grid();
        keyboardInit();
    }

    public void painting(int i, int j) {
        if (grid.getGrid()[i][j].isPainted()) {
            grid.getGrid()[i][j].getCell().draw();
            grid.getGrid()[i][j].setPainted(false);
        } else {
            grid.getGrid()[i][j].getCell().fill();
            grid.getGrid()[i][j].getCell().setColor(Color.BLUE);
            grid.getGrid()[i][j].setPainted(true);
        }

    }


    public void keyboardInit() {

        kb = new Keyboard(this);
        //RIGHT KEY SETUP
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);

        //Add listener to keyboard to listen to right key when pressed
        kb.addEventListener(rightKeyPressed);

        //LEFT KEY SETUP
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);

        kb.addEventListener(leftKeyPressed);


        //UP KEY SETUP
        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);

        kb.addEventListener(upKeyPressed);

        //DOWN KEY SETUP
        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPressed.setKey(KeyboardEvent.KEY_DOWN);

        kb.addEventListener(downPressed);


        KeyboardEvent drawSquare = new KeyboardEvent();
        drawSquare.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        drawSquare.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(drawSquare);


        KeyboardEvent cleanAll = new KeyboardEvent();
        cleanAll.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        cleanAll.setKey(KeyboardEvent.KEY_A);

        kb.addEventListener(cleanAll);

        KeyboardEvent returnAll = new KeyboardEvent();
        returnAll.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        returnAll.setKey(KeyboardEvent.KEY_C);

        kb.addEventListener(returnAll);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(releasedSpace);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                move.right(this.cell);
                break;
            case KeyboardEvent.KEY_LEFT:
                move.left(this.cell);
                break;
            case KeyboardEvent.KEY_DOWN:
                move.down(this.cell);
                break;
            case KeyboardEvent.KEY_UP:
                move.up(this.cell);
                break;
            case KeyboardEvent.KEY_A:
                for(int i = 0; i < grid.getCol(); i++){
                    for(int j= 0; j < grid.getRow(); j++){
                        if(grid.getGrid()[i][j].isPainted()){
                            grid.getGrid()[i][j].getCell().draw();
                            grid.getGrid()[i][j].getCell().setColor(Color.BLACK);
                        }
                    }
                }
                break;
            case  KeyboardEvent.KEY_C:
                for(int i = 0; i < grid.getCol(); i++){
                    for(int j= 0; j < grid.getRow(); j++){
                        if(grid.getGrid()[i][j].isPainted()){
                            grid.getGrid()[i][j].getCell().fill();
                            grid.getGrid()[i][j].getCell().setColor(Color.BLUE);
                        }
                    }
                }
                    break;
            case KeyboardEvent.KEY_SPACE:
                status = true;
                if (status) {
                    painting(cell.getCol(), cell.getRow());
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        status = false;

    }
}
