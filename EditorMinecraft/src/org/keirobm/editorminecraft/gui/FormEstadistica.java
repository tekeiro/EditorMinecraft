/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.keirobm.editorminecraft.gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.keirobm.editorminecraft.Main;
import org.keirobm.editorminecraft.model.Bloque;
import org.keirobm.editorminecraft.model.Capa;
import org.keirobm.editorminecraft.model.EntradaBloque;
import org.keirobm.editorminecraft.model.EntradaPS;
import org.keirobm.editorminecraft.model.Estadistica;
import org.keirobm.editorminecraft.model.Plano;

/**
 *
 * @author Angel
 */
public class FormEstadistica extends javax.swing.JDialog {
    //###########################################################
    //##		SUBCLASS                              ###
    //###########################################################
    public static class LocalizacionPS {
        int mCapa;
        EntradaPS mPS;
        
        public LocalizacionPS (int capa, EntradaPS ps) {
            mCapa=capa;
            mPS=ps;
        }
        
        public int getCapa() {
            return mCapa;
        }
        
        public EntradaPS getEntradaPS() {
            return mPS;
        }
    }
    
    //###########################################################
    //##		CONSTANTS                             ###
    //###########################################################
    private static final int TABLE_HEIGHT = 20;
    
    //###########################################################
    //##		MEMBERS                               ###
    //###########################################################
    private Plano mPlano;
    private Estadistica mEstadisticas;
    
    
    //###########################################################
    //##		CONSTRUCTORS                          ###
    //###########################################################
    /**
     * Creates new form FormEstadistica
     */
    public FormEstadistica(java.awt.Frame parent, boolean modal, Plano plano) {
        super(parent, modal);
        mPlano = plano;
        
        initComponents();
        initialize();
        
    }
    
    
    //###########################################################
    //##		PROPERTIES                            ###
    //###########################################################
    
    
    
    //###########################################################
    //##		METHODS                               ###
    //###########################################################
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btAceptar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBloques = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBloques = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbAncho = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbAlto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbCantidadPS = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCoste = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePS = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadisticas");
        setResizable(false);

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        tableBloques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Icono", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBloques.getTableHeader().setResizingAllowed(false);
        tableBloques.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableBloques);

        javax.swing.GroupLayout panelBloquesLayout = new javax.swing.GroupLayout(panelBloques);
        panelBloques.setLayout(panelBloquesLayout);
        panelBloquesLayout.setHorizontalGroup(
            panelBloquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        panelBloquesLayout.setVerticalGroup(
            panelBloquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bloques", null, panelBloques, "Numero de bloques por tipo de bloque");

        jLabel1.setText("Dimensiones");

        jLabel2.setText("Ancho (bloques)");

        lbAncho.setText("jLabel3");

        jLabel4.setText("Alto (bloques)");

        lbAlto.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlto)
                            .addComponent(lbAncho))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbAncho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbAlto))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informacion General", null, jPanel2, "Acerca de las dimensiones");

        jLabel3.setText("Cantidad de PS");

        lbCantidadPS.setText("jLabel5");

        jLabel5.setText("Coste total de los PS");

        lbCoste.setText("jLabel6");

        tablePS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Icono", "Capa", "Localizacion", "Coste"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePS);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(lbCantidadPS))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCoste)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbCantidadPS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbCoste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("PSs", null, jPanel3, "Coste y cantidad de PS");

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btAceptarActionPerformed

    /**
     * Inicializa las variables y demas cosas
     */
    private void initialize() {
        tablePS.setDefaultRenderer(Object.class, new IconCellRenderer());
        tablePS.setRowHeight(TABLE_HEIGHT);
        
        tableBloques.setDefaultRenderer(Object.class, new IconCellRenderer());
        tableBloques.setRowHeight(TABLE_HEIGHT);
        
        mEstadisticas = new Estadistica();
        mEstadisticas.hacerEstadisticaTotal(mPlano);
        
        updateEstadistica();
        updateTableBloques();
        updateTablePS();
    }
    
    /**
     * Rellena las etiquetas correspondientes
     */
    private void updateEstadistica() {
        lbAncho.setText(mEstadisticas.getAreaAncho() + " bloques");
        lbAlto.setText(mEstadisticas.getAreaAlto() + " bloques");
        
        int cantidadPS = 0;
        for (int i=0; i<mPlano.cantidadCapas(); i++) 
            cantidadPS += mPlano.getCapa(i).cantidadPS();
        lbCantidadPS.setText(cantidadPS+"");
        
        lbCoste.setText(mEstadisticas.getCosteTotal()+"$");
    }
    
    /**
     * Rellena la tabla de bloques
     */
    private void updateTableBloques() {
        //Recoge el modelo de la tabla y borra todas las filas existentes
        DefaultTableModel modelo = (DefaultTableModel) tableBloques.getModel();
        
        
        //Se recorre todos los bloques existentes
        for (Bloque blq : Bloque.values()) {
            //Coge la cantidad que hay del bloque
            int cantidad = mEstadisticas.getCantidadBloque(blq);
            
            //Solo se añade la fila a la tabla si la cantidad es superior a 0
            if (cantidad>0) {
                //Crear la fila de la tabla
                Object[] fila = new Object[3];

                //Rellenar el icono del bloque
                JLabel lbIcon = new JLabel("");
                lbIcon.setIcon(Main.getIcon("res/terrain.png", blq.getFila(), blq.getColumna()));
                fila[0] = lbIcon;
                fila[1] = blq.toString();
                fila[2] = cantidad + "";
                
                modelo.addRow(fila);
            }
        }       
    }
    
    
    /**
     * Rellena la tabla de PS
     */
    private void updateTablePS() {
        //Recoge el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablePS.getModel();
        
        //Obtener todas las PSs de todas las capas
        for (int i=0; i<mPlano.cantidadCapas(); i++) {
            EntradaPS[] pss = mPlano.getCapa(i).listarPS();
            for (EntradaPS ps : pss) {
                //Para cada PS encontrada, se inserta en la tabla con sus datos asociados
                Bloque blq = Bloque.values()[ps.getPS().getId()];
                Object[] fila = new Object [4];
                fila[0] = new JLabel("", Main.getIcon("res/terrain.png", blq.getFila(), blq.getColumna()), SwingConstants.LEFT);
                fila[1] = (i+1)+"";
                fila[2] = "En X:" + ps.getColumna() + " Y:" + ps.getFila();
                fila[3] = ps.getPS().getCoste();
                
                modelo.addRow(fila);
            }
        }
        
        
        
    }
    
    //###########################################################
    //##		EVENTS                                ###
    //###########################################################
    
    
    //###########################################################
    //##		CONTROLS                              ###
    //###########################################################
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbAlto;
    private javax.swing.JLabel lbAncho;
    private javax.swing.JLabel lbCantidadPS;
    private javax.swing.JLabel lbCoste;
    private javax.swing.JPanel panelBloques;
    private javax.swing.JTable tableBloques;
    private javax.swing.JTable tablePS;
    // End of variables declaration//GEN-END:variables
}
