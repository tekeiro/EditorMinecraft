package org.keirobm.editorminecraft.gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.swing.JScrollBar;
import javax.swing.Scrollable;

import org.keirobm.editorminecraft.Main;
import org.keirobm.editorminecraft.model.Bloque;
import org.keirobm.editorminecraft.model.Capa;
import org.keirobm.editorminecraft.model.EntradaBloque;
import org.keirobm.editorminecraft.model.EntradaPS;
import org.keirobm.editorminecraft.model.EtiquetaTexto;
import org.keirobm.editorminecraft.model.Posicion;

/**
 * Area de dibujo donde se dibujara el plano 2D del Editor
 * @author Angel
 */
public class CanvasPlano extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460137953423315477L;
	
	
	//###########################################################
	//##				MEMBERS			  ###
	//###########################################################
	int mOrigenFila;
	int mOrigenColumna;
	Capa mCapa = new Capa();
        
        //---------- Variables para visualizar protecciones de PS --------------
        boolean mVerPS = false;
        
        //----------  Variables para visualizar drag & drop  -------------------
        int x1, y1, x2, y2;
        MainForm.TipoHerramientas herramientaActual = null;
        Bloque blq = null;
        EtiquetaTexto et = null;
	

	//###########################################################
	//##				CONSTRUCTORS		  ###
	//###########################################################
	public CanvasPlano() {
		super();
		mOrigenFila = mOrigenColumna = 0;
		mCapa = new Capa();
                addKeyListener(KeyActions);
                
	}

	//###########################################################
	//##				PROPERTIES		  ###
	//###########################################################
	
	public int getFilaOrigen() {
		return mOrigenFila;
	}
	
	public int getColumnaOrigen() {
		return mOrigenColumna;
	}
	
	public Capa getCapa() {
		return mCapa;
	}
	
	public void setFilaOrigen(int origenFila) {
		mOrigenFila = origenFila;
	}
	
	public void setColumnaOrigen(int origenColumna) {
		mOrigenColumna = origenColumna;
	}
	
	public void setCapa (Capa capa) {
		mCapa = capa;
	}
        
        public boolean verProteccionPS() {
            return mVerPS;
        }
        
        public void setVerProteccionPS(boolean verPS) {
            mVerPS = verPS;
        }
        
        public KeyListener getKeyListener() {
            return KeyActions;
        }

	//###########################################################
	//##				METHODS			  ###
	//###########################################################
        /**
         * Dibujar en un area grafica el plano 2D y las etiquetas del texto
         * @param g2D Area grafica donde se dibujara
         * @param img Imagen con los tiles de los bloques del Minecraft
         * @param area Dimension de la capa que se quiere dibujar. Se mide en pixeles.
         */
        private void dibujar(Graphics2D g2D, BufferedImage img, Rectangle area) {
            dibujarPlano(g2D, img, area);
            dibujarTexto(g2D, area);
            dibujarProteccionPS(g2D, area);
        }
        
        /**
         * Dibujar en un area grafica el plano 2D
         * @param g2D Area grafica donde se dibujara
         * @param img Imagen con los tiles de los bloques del Minecraft
         * @param area Dimension de la capa que se quiere dibujar. Se mide en pixeles.
         */
	private void dibujarPlano(Graphics2D g2D, BufferedImage img, Rectangle area) {
		//Dimension tam = getSize();
                int filaInicial = (int) (area.getY() / Bloque.ALTO);
                int colInicial = (int) (area.getX() / Bloque.ANCHO);
		int numFilas = (int)(area.getHeight() / Bloque.ALTO);
		int numCols = (int)(area.getWidth() / Bloque.ANCHO);
                
                
			
		for (int i=0; i<numFilas; i++) {
			for (int j=0; j<numCols; j++) {
                            int fila = i; //mOrigenFila + i;
                            int col = j; //mOrigenColumna + j;
                            Bloque[] blqs = mCapa.getBloque(fila+filaInicial, col+colInicial);
                            if (blqs!=null) {
                                for (Bloque blq : blqs) {
                                    if (blq != null) {
                                        int blq_fila = (blq != null) ? blq.getFila() : 15;
                                        int blq_col = (blq != null) ? blq.getColumna() : 15;

                                        g2D.drawImage(img, j * Bloque.ANCHO, i * Bloque.ALTO, (j + 1) * Bloque.ANCHO, (i + 1) * Bloque.ALTO, blq_col * Bloque.ANCHO, blq_fila * Bloque.ALTO, (blq_col + 1) * Bloque.ANCHO, (blq_fila + 1) * Bloque.ALTO, null);
                                    }
                                }
                            }
                            else {
                                g2D.drawImage(img, j * Bloque.ANCHO, i * Bloque.ALTO, (j + 1) * Bloque.ANCHO, (i + 1) * Bloque.ALTO, 15 * Bloque.ANCHO, 15 * Bloque.ALTO, (15 + 1) * Bloque.ANCHO, (15 + 1) * Bloque.ALTO, null);
                            }
			}
		}
	}
	
        /**
         * Dibujar en un area grafica las etiquetas de texto
         * @param g2D Area grafica donde se dibujara
         * @param area Dimension de la capa que se quiere dibujar. Se mide en pixeles.
         */
	private void dibujarTexto(Graphics2D g2D, Rectangle area) {
		//Dimension tam = getSize();
		int filaInicial = (int) (area.getY() / Bloque.ALTO);
                int colInicial = (int) (area.getX() / Bloque.ANCHO);
		
		Color color_old = g2D.getColor();
		Font font_old = g2D.getFont();
                
                ArrayList<Entry<Posicion,EtiquetaTexto>> etiqs = mCapa.getEtiquetas();
                for (Entry<Posicion,EtiquetaTexto> entrada : etiqs) {
                    int i = entrada.getKey().getFila()-filaInicial;
                    int j = entrada.getKey().getColumna()-colInicial;
                    g2D.setColor(entrada.getValue().getColor());
                    g2D.setFont(new Font("Comic Sans",entrada.getValue().getEstilo().getFontStyle(), entrada.getValue().getTam()));
                    g2D.drawString(entrada.getValue().getTexto(), j*Bloque.ANCHO, (i+1)*Bloque.ALTO);
                }
		
		g2D.setColor(color_old);
		g2D.setFont(font_old);
	}
        
        private void dibujarProteccionPS(Graphics2D g2D, Rectangle area) {
            int numFilas = (int)(area.getHeight() / Bloque.ALTO);
            int numCols = (int)(area.getWidth() / Bloque.ANCHO);
            
            if (mVerPS) {
                Color old_color = g2D.getColor();
                Stroke old_stroke = g2D.getStroke();
                EntradaPS[] ps = mCapa.listarPS();
                for (EntradaPS entPS : ps) {
                    int filaRelativa = entPS.getFila()-mOrigenFila;
                    int colRelativa = entPS.getColumna()-mOrigenColumna;
                    
                    int fila_ini_rectangulo = filaRelativa-entPS.getPS().getRadio();  //Math.max(0, filaRelativa-entPS.getPS().getRadio());
                    int col_ini_rectangulo = colRelativa-entPS.getPS().getRadio();    //Math.max(0, colRelativa-entPS.getPS().getRadio());
                    
                    int fila_fin_rectangulo = filaRelativa+entPS.getPS().getRadio();  //Math.min(mOrigenFila+numFilas, filaRelativa+entPS.getPS().getRadio());
                    int col_fin_rectangulo = colRelativa+entPS.getPS().getRadio();    //Math.min(mOrigenColumna+numCols, colRelativa+entPS.getPS().getRadio());
                    
                    int alto = (fila_fin_rectangulo-fila_ini_rectangulo+1)*Bloque.ALTO;
                    int ancho = (col_fin_rectangulo-col_ini_rectangulo+1)*Bloque.ANCHO;
                    
                    Color colorPS = Color.BLACK;
                    switch(entPS.getPS()) {
                        case REFUGIO:   colorPS= Color.GREEN; break;
                        case ORO:       colorPS= Color.YELLOW; break;
                        case LAPIZ:     colorPS= Color.BLUE; break;
                        case DIAMANTE:  colorPS= Color.CYAN; break;
                    }
                    g2D.setColor(colorPS);
                    g2D.setStroke(new BasicStroke(3.0f));
                    
                    g2D.drawRect(col_ini_rectangulo*Bloque.ANCHO, fila_ini_rectangulo*Bloque.ALTO, ancho, alto);
                    
                }
                g2D.setColor(old_color);
                g2D.setStroke(old_stroke);
            }
        }
	
	/**
	 * Redibuja el area del plano
	 */
	public void redibujar() {
		repaint();
	}
	
        /**
         * Rellena con un bloque un area de la capa dada por su fila y columna
         * @param blq Bloque a rellenar
         * @param fila Fila de la capa. Debe ser una posicion valida.
         * @param columna Columna de la capa. Debe ser una posicion valida
         */
	public void rellenarConBloque(Bloque blqAnterior, Bloque blq, int fila, int columna) {
		Dimension tam = getSize();
		int numFilas = (int)(tam.getHeight() / 16.0) + mOrigenFila;
		int numCols = (int)(tam.getWidth() / 16.0) + mOrigenColumna;
		
                Bloque[] bloques = mCapa.getBloque(fila, columna);                
		if (mCapa.noHayBloqueoEsIgualA(fila, columna, blqAnterior))  {
			mCapa.setBloque(fila, columna, blq);
			redibujar();
		}
		
		int f,c;
		
		f = (fila<numFilas-1) ? fila+1 : numFilas-1; c = columna;
		if (mCapa.noHayBloqueoEsIgualA(f, c, blqAnterior))
			rellenarConBloque(blqAnterior, blq, f, c);
		
		f = fila; c = (columna<numCols-1) ? columna+1 : numCols-1;
		if (mCapa.noHayBloqueoEsIgualA(f, c, blqAnterior))
			rellenarConBloque(blqAnterior, blq, f, c);
		
		f = (fila>0) ? fila-1 : 0; c = columna;
		if (mCapa.noHayBloqueoEsIgualA(f, c, blqAnterior))
			rellenarConBloque(blqAnterior, blq, f, c);
		
		f = fila; c = (columna>0) ? columna-1 : 0;
		if (mCapa.noHayBloqueoEsIgualA(f, c, blqAnterior))
			rellenarConBloque(blqAnterior, blq, f, c);
		
	}
        
        
        //-------------  Metodos para visualizar el drag & drop ----------------
        public void marcarDragDrop(int cursor_x, int cursor_y, MainForm.TipoHerramientas herramientaActual, Bloque bloque, EtiquetaTexto etiqueta) {
            x1 = x2 = cursor_x;
            y1 = y2 = cursor_y;
            
            this.herramientaActual = herramientaActual;
            blq = bloque;
            et = etiqueta;
        }
        
        public void posicionActualCursor(int cursor_x, int cursor_y) {
            x2 = cursor_x;
            y2 = cursor_y;
        }
        
        public void quitarDragDrop() {
            herramientaActual=null;
        }
        
        private void dibujarRastroDragDrop(Graphics2D g2D, BufferedImage img) {
            if (herramientaActual!=null) {
                switch (herramientaActual) {
                    case MOVER_BLOQUES:
                        if (blq != null) {
                            g2D.drawImage(img, x2, y2, x2 + 16, y2 + 16, blq.getColumna() * 16, blq.getFila() * 16, (blq.getColumna() + 1) * 16, (blq.getFila() + 1) * 16, null);
                        }
                        break;
                    case MOVER_TEXTO:
                        if (et != null) {
                            Color old_c = g2D.getColor();
                            Font old_f = g2D.getFont();
                            g2D.setColor(et.getColor());
                            g2D.setFont(new Font("Comic Sans", et.getEstilo().getFontStyle(), et.getTam()));
                            g2D.drawString(et.getTexto(), x2, y2);
                            g2D.setFont(old_f);
                            g2D.setColor(old_c);
                        }
                        break;
                    case MEDIR:
                    case EXPORTAR_IMAGEN:
                        AlphaComposite old_ac = (AlphaComposite) g2D.getComposite();
                        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
                        g2D.setComposite(ac);
                        Paint old_p = g2D.getPaint();
                        g2D.setPaint(Color.BLUE);
                        g2D.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                        g2D.setComposite(old_ac);
                        g2D.setPaint(old_p);
                        break;
                }
            }
        }
        
        //--------------- Metodos para exportar imagenes ---------------------
        public BufferedImage exportarAreaSeleccionada(int xInicial, int yInicial, int xFinal, int yFinal) {
            if (yInicial>=yFinal || xInicial>=xFinal) {
                System.err.println("Error en la exportacion: La fila/columna inicial es mayor que la fila/columna final");
                return null;
            }
            
            BufferedImage image = Main.getImage("res/terrain.png");
            int ancho = xFinal-xInicial+1;
            int alto = yFinal-yInicial+1;
            BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_4BYTE_ABGR);
            dibujar((Graphics2D)img.getGraphics(), image, new Rectangle(xInicial, yInicial, ancho, alto));
            return img;
        }
        
        public BufferedImage exportarAreaVisible() {
            Dimension tam = getSize();
            return exportarAreaSeleccionada(mOrigenColumna*Bloque.ANCHO, mOrigenFila*Bloque.ALTO, 
                    mOrigenColumna*Bloque.ANCHO + (int)tam.getWidth(), mOrigenFila*Bloque.ALTO + (int)tam.getHeight());
        }
        
        // TODO public BufferedImage exportarCapa()
        public BufferedImage exportarCapa() {
            //Encontrar maxFila y maxCol de los bloques de la capa
            EntradaBloque[] bloques = mCapa.getBloques();
            int maxFila=-1, maxCol=-1;
            
            for (EntradaBloque blq : bloques) {
                maxFila = (blq.getFila()>maxFila || maxFila==-1) ? blq.getFila() : maxFila;
                maxCol = (blq.getColumna()>maxCol || maxCol==-1) ? blq.getColumna() : maxCol;
            }
            
            BufferedImage img = new BufferedImage(maxCol*Bloque.ANCHO, maxFila*Bloque.ALTO, BufferedImage.TYPE_4BYTE_ABGR);
            BufferedImage image = Main.getImage("res/terrain.png");
            dibujar((Graphics2D)img.getGraphics(), image, new Rectangle(0, 0, maxCol*Bloque.ANCHO, maxFila*Bloque.ALTO));
            return img;
        }
        
	
	//###########################################################
	//##				EVENTS							  	  ###
	//###########################################################
	/**
	 * Pinta en la superficie
	 */
	@Override
	public void paint(Graphics g) {
		
		BufferedImage image = Main.getImage("res/terrain.png");
                Graphics2D g2D = (Graphics2D) g;
		
                //Utilizo tecnica de double buffering para eliminar parpadeo
                Dimension d = getSize();
                Image mOffImage = createImage(d.width, d.height);
                Graphics2D offG = (Graphics2D)mOffImage.getGraphics();
                offG.setColor(g2D.getBackground());
                
		//Dibujo el area del plano en el otro buffer
		dibujar(offG, image, new Rectangle(mOrigenColumna*Bloque.ANCHO, mOrigenFila*Bloque.ALTO, (int)getSize().getWidth(), (int)getSize().getHeight()));                
                dibujarRastroDragDrop(offG, image);
                
                //Dibujo el otro buffer
                g2D.drawImage(mOffImage, 0, 0, null);
		
		//super.paint(g);
	}
	
	/**
	 * Actualiza el area de dibujo
	 */
	@Override
	public void update(Graphics g) {
		
		paint(g);
		super.update(g);
        }
        
        private KeyListener KeyActions = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int filaOrigen = getFilaOrigen();
            int colOrigen = getColumnaOrigen();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    filaOrigen = (filaOrigen > 0) ? filaOrigen - 1 : filaOrigen;
                    break;
                case KeyEvent.VK_S:
                    filaOrigen++;
                    break;
                case KeyEvent.VK_A:
                    colOrigen = (colOrigen > 0) ? colOrigen - 1 : colOrigen;
                    break;
                case KeyEvent.VK_D:
                    colOrigen++;
                    break;
            }

            setFilaOrigen(filaOrigen);
            setColumnaOrigen(colOrigen);
            redibujar();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    };
    
}
