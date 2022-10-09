
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class Grid extends JPanel {
  Cell[][] cells;
  List<Walkers> walker = new ArrayList<Walkers>();
  int winner = -1;
  int width;
  int height;
  int cellWidth;
  int cellHeight;
  int finished;
  
  Grid(int w, int h) {
    width = w;
    height = h;
    cellWidth = w/10;
    cellHeight = h/10;
    cells = new Cell[10][10];
    
    for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
        cells[x][y] = new Cell(this, x, y);
        
      }
    }
  }

  @Override
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    Graphics2D drawImage = (Graphics2D) g;
    
    for (int x = 0; x < 10; x++) { 
      for (int y = 0; y < 10; y++) {
        drawImage.setColor(Color.black);

        int posX = x*width-cellWidth/2;
        int posY = y*height-cellHeight/2;
		drawImage.drawRect(posX, posY, width, height);
        drawImage.setColor(cells[x][y].getColor());
        drawImage.fillRect(posX, posY, width, height);
      }}
 }
   
  
  void walkerWon(int id) 
 {
	  if (winner <= -1 ) {
        winner = id;
	  }
}

  
  int getWinner() 
  {
	  return winner;
  }
  
  void incrementFinished()
  {
	  finished++;
  }
  
  int getFinished()
  {
	  return finished;
  }
  
  Cell getCell(int x, int y) 
  {
	  Cell c = null;
	  if (x >= 0 && x < 10 && y >= 0 && y < 10)
	  {
		  c = cells[x][y];
	  	  
	  }
	  return c;
  }
  
  
  void drawGrid() 
  {
    repaint();
  }
}