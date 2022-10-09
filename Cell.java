import java.awt.Color;
import java.util.*;

public class Cell {
  Grid grid;
  List<Integer> marked = new ArrayList<Integer>();
  int posX;
  int posY;
  Color color;
  
  static final Color[] markedColors = {Color.pink,Color.ORANGE ,Color.magenta,  Color.darkGray, Color.white};
  
  Cell(Grid g, int x, int y) {
    grid = g;
    posX = x;
    posY = y;
    color = Color.black;
  }
  
  int getX() {
    return posX;
  }
  
  int getY() {
    return posY;
  }
  
  Color getColor() {
    return color;
  }
  
  //return 1 if cell is unmarked by id or 0 if cell was previously marked by id
  int markCell(int id) 
  {  
    if (marked.size() == 0) { 
      color = Walkers.colors[(id)];
    }
    else {
      color = Cell.markedColors[marked.size()];
    }
    //check if cell was marked before
    if (!marked.contains(id)) {
      marked.add(id);
      return 1;
    }
    else {
      return 0;
    }
  
  }
}