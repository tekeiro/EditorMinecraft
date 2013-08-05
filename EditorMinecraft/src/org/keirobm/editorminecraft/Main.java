package org.keirobm.editorminecraft;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.keirobm.editorminecraft.gui.MainForm;
import org.keirobm.editorminecraft.model.Bloque;
import org.keirobm.editorminecraft.model.Capa;
import org.keirobm.editorminecraft.model.EtiquetaTexto;
import org.keirobm.editorminecraft.model.Plano;
import org.keirobm.editorminecraft.model.EtiquetaTexto.Estilo;
import org.keirobm.editorminecraft.util.StringCompresion;
import org.keirobm.editorminecraft.util.Utils;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
            /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	public static BufferedImage getImage(String file) {
		BufferedImage imagen = null;	
		//Le pedimos al ClassLoader que busque en el jar la url de nuestra imagen o recurso
		java.net.URL imageURL = Main.class.getResource(file);
                
		try{		
			imagen = ImageIO.read(imageURL);
		}catch(java.io.IOException e){
			System.out.println(e.getMessage());
		}
		return imagen;
	}
	
	public static Icon getIcon (String file, int fila, int col) {
		BufferedImage img = getImage(file);
		BufferedImage subico = img.getSubimage(col*16, fila*16, 16, 16);
		ImageIcon ico = new ImageIcon(subico);
		return ico;
	}
        
        public static Icon getColorIcon (Color color) {
            BufferedImage img = new BufferedImage (16, 16, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2D = (Graphics2D) img.getGraphics();
            g2D.setPaint(color);
            g2D.setColor(color);
            g2D.fillRect(0, 0, img.getWidth(), img.getHeight());
            ImageIcon ico = new ImageIcon(img);
            return ico;
        }
}
