import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
 
import javax.swing.JFrame;
 
/**
 * Pintando fantasminha do PacMan com Java 2D.
 * @author Vânio Meurer
 * @since 10/11/2009 11:38:12
 */
public class FantasmaPacMan extends JFrame {
 
	private static final long serialVersionUID = 8366583475473482894L;
 
	private final static int TAMANHO_X = 100;
	private final static int TAMANHO_Y = 50;
	private final static int TAMANHO_X_PATA = 20;
	private final static int TAMANHO_Y_PATA = 50;
	private final static int DISTANCIA_X_PATA = 6;
	private final static int RAIO_OLHO = 13;
	private final static int RAIO_OLHO_CRISTALINO = 5;
	private final static int DISTANCIA_X_OLHOS = (RAIO_OLHO<<1)+10;
 
	public FantasmaPacMan() {
 
		super("Fantasminha Pac Man");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
 
	}
 
	public static void main(String[] args) {
 
		final FantasmaPacMan fpm = new FantasmaPacMan();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				fpm.setVisible(true);
			}
		});
 
	}
 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
 
		Graphics2D g2d = (Graphics2D) g.create();
 
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0, 0,this.getSize().width, this.getSize().height);
 
		pintarFantasma(g2d, Color.RED, 50, 50);
 
		pintarFantasma(g2d, Color.MAGENTA, 85, 150);
 
 
	}
 
	public void pintarFantasma(Graphics2D g2d, Color color, int x, int y) {
		g2d.setPaint(color);
		g2d.fill(new Ellipse2D.Float(x, y, TAMANHO_X, TAMANHO_Y));
		g2d.fill(new Rectangle2D.Float(x,y+(TAMANHO_Y>>1),TAMANHO_X, TAMANHO_Y>>1));
 
		int xBkp = x;
 
		g2d.fill(new QuadCurve2D.Float(x, y+TAMANHO_Y, x+(TAMANHO_X_PATA>>1), y+TAMANHO_Y+TAMANHO_Y_PATA, x+TAMANHO_X_PATA, y+TAMANHO_Y));
		x = x+TAMANHO_X_PATA+DISTANCIA_X_PATA;
		g2d.fill(new QuadCurve2D.Float(x, y+TAMANHO_Y, x+(TAMANHO_X_PATA>>1), y+TAMANHO_Y+TAMANHO_Y_PATA, x+TAMANHO_X_PATA, y+TAMANHO_Y));
		x = x+TAMANHO_X_PATA+DISTANCIA_X_PATA;
		g2d.fill(new QuadCurve2D.Float(x, y+TAMANHO_Y, x+(TAMANHO_X_PATA>>1), y+TAMANHO_Y+TAMANHO_Y_PATA, x+TAMANHO_X_PATA, y+TAMANHO_Y));
		x = x+TAMANHO_X_PATA+DISTANCIA_X_PATA+1;
		g2d.fill(new QuadCurve2D.Float(x, y+TAMANHO_Y, x+(TAMANHO_X_PATA>>1), y+TAMANHO_Y+TAMANHO_Y_PATA, x+TAMANHO_X_PATA, y+TAMANHO_Y));
 
		x = xBkp;
 
		g2d.setPaint(Color.WHITE);
		g2d.fill(new Ellipse2D.Float((x+(TAMANHO_X/3))-RAIO_OLHO,y+(TAMANHO_Y>>1)-RAIO_OLHO,RAIO_OLHO<<1,RAIO_OLHO<<1));
		g2d.setPaint(Color.BLUE);
		g2d.fill(new Ellipse2D.Float((x+(TAMANHO_X/3))-RAIO_OLHO_CRISTALINO,y+(TAMANHO_Y>>1)-RAIO_OLHO_CRISTALINO,RAIO_OLHO_CRISTALINO<<1,RAIO_OLHO_CRISTALINO<<1));
		g2d.setPaint(Color.WHITE);
		g2d.fill(new Ellipse2D.Float((x+(TAMANHO_X/3))-RAIO_OLHO + DISTANCIA_X_OLHOS,y+(TAMANHO_Y>>1)-RAIO_OLHO,RAIO_OLHO<<1,RAIO_OLHO<<1));
		g2d.setPaint(Color.BLUE);
		g2d.fill(new Ellipse2D.Float((x+(TAMANHO_X/3))-RAIO_OLHO_CRISTALINO + DISTANCIA_X_OLHOS,y+(TAMANHO_Y>>1)-RAIO_OLHO_CRISTALINO,RAIO_OLHO_CRISTALINO<<1,RAIO_OLHO_CRISTALINO<<1));
 
	}
 
}