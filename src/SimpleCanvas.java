import java.awt.*;
import java.awt.event.*;
import java.lang.Runnable;
import javax.swing.*;
/**
 * Taken from studres.
 * Used to draw how the temperature changes.
 * Removed the methods that were not used.
 */
public class SimpleCanvas {
    static int CanvasCount = 0;

    private class CanvasCreator implements Runnable {
	private SimpleCanvas theCanvas;
	private CanvasCreator(SimpleCanvas c) {
	    super();
	    theCanvas = c;	    
	}
	public void run() {
	    JFrame f = new JFrame("Temperature changes over the next few da");
	    CanvasCount++;
	    f.add(new MyPanel(theCanvas));
	    f.pack();
	    f.setVisible(true);
	}
    }

    private Color pixels[][] = new Color[1000][1000];
    private int lastMouseClick[] = new int[2];
    private boolean mouseClickPending = false;
    protected int xsize, ysize;

    public SimpleCanvas(int xsize, int ysize) {
	this.xsize = xsize;
	this.ysize = ysize;
	for (int i = 0; i < xsize; i++) {
	    for (int j = 0; j < ysize; j++) {
		pixels[i][j] = Color.white;
	    }
	}
	SwingUtilities.invokeLater(new CanvasCreator(this));
    }

    public void setPointBlack(int x, int y) {
	setPointColour(x,y,Color.black);
    }
    
    public void setPointColour(int x, int y, Color c) {
	pixels[x][y] = 	c;
    }

    public synchronized void setMouseClick( int x, int y) {
	lastMouseClick[0] = x;
	lastMouseClick[1] = y;
	mouseClickPending = true;
	notifyAll();
    }
	
    class MyPanel extends JPanel {
	private SimpleCanvas theCanvas;
	public MyPanel(SimpleCanvas c) {
	    theCanvas = c;
	    addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
			theCanvas.setMouseClick(e.getX(), theCanvas.ysize-1-e.getY());
		    }
		});
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(theCanvas.xsize,theCanvas.ysize);
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw Text
	    for (int i = 0; i < theCanvas.xsize; i++) {
		for (int j = 0; j < theCanvas.ysize; j++) {
		    g.setColor(pixels[i][j]);
		    g.drawRect(i,theCanvas.ysize-1-j,1,1);
		}
	    }
	}
    }
    
}
