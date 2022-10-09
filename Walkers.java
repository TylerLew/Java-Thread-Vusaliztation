
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.*;
public class Walkers extends Thread {
  Grid grid;
  Main main;
  int walkerId;
  int posX;
  int posY;
  Color color;
  int round = 1;
  int markedCells = 0;
  static final Color[] colors = {Color.red, Color.blue, Color.yellow, Color.green, Color.magenta};
  
  Walkers(Grid g, int id, int x, int y) 
  {
    grid = g;
    walkerId = id;
    posX = x;
    posY = y;
    color = colors[(id)%4];
    
    Cell currentCell = grid.getCell(posX,posY);
    

    int status = currentCell.markCell(id%4);
    markedCells = status;
  }
  
  Color getColor() 
  {
    return color;
  }
  

  void move() 
  {
    boolean moved = false;
    while (!moved) 
    {
      int direction = (int) (Math.random()*4);
      if (direction == 0 && grid.getCell(posX, posY+1) != null) 
      { 
        posY += 1;
        moved = true;
      }
      else if (direction == 1 && grid.getCell(posX, posY-1) != null) 
      { 
        posY -= 1;
        moved = true;
      }
      else if (direction == 2 && grid.getCell(posX+1, posY) != null) 
      { 
        posX += 1;
        moved = true;
      }
      else if (direction == 3 && grid.getCell(posX-1, posY) != null) 
      { 
        posX -= 1;
        moved = true;
      }
    }

    Cell newCell = grid.getCell(posX, posY);
    int status = newCell.markCell(walkerId);
    if (status == 1) 
    {
      markedCells++;
    }
    grid.drawGrid();
    if (markedCells == 100 ) 
    {
      grid.walkerWon(walkerId);
    }
    
  }
  
  int getid() 
  {
    return walkerId;
  }
  
  int getX() 
  {
    return posX;
  }
  
  int getY() 
  {
    return posY;
  }
  
  public void run() {
    while (markedCells != 100) 
    {
    	move();
    	try 
      	{
			Thread.sleep(10);
		} catch (InterruptedException e) 
      	{
			e.printStackTrace();
		}
     
    }
    grid.incrementFinished();
    if(grid.getFinished()==4 && round == 1 )
    {
    	Scanner in = new Scanner(System.in);
		System.out.println("The winner is Thread "+grid.getWinner());
		System.out.println("Type 1 if you are ready for phase 2. Or, if you have already witnessed the victory lap, type 2. ");
		int status = in.nextInt();
		if(status == 1)
		{
			new Main(2,grid.getWinner());
		}
		else if(status == 2)
		{
			System.out.println("Goodbye!");
			System.exit(status);
		}
		
    }
    
    
   
  }
  public void end()
  {
  	System.exit(1);
  }

}
