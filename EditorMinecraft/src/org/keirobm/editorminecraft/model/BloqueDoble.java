/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.keirobm.editorminecraft.model;

/**
 *
 * @author Angel
 */
public enum BloqueDoble {
    PUERTA_MADERA(Bloque.PUERTA_MADERA_1,Bloque.PUERTA_MADERA_2,Direccion.ARRIBA),
    PUERTA_HIERRO(Bloque.PUERTA_HIERRO_1,Bloque.PUERTA_HIERRO_2,Direccion.ARRIBA),
    PUERTA_MAD_IZQ(Bloque.PUERTA_MAD_IZQ_1,Bloque.PUERTA_MAD_IZQ_2,Direccion.DERECHA),    
    PUERTA_MAD_DRH(Bloque.PUERTA_MAD_DRH_1, Bloque.PUERTA_MAD_DRH_2, Direccion.IZQUIERDA),
    PUERTA_HRR_IZQ(Bloque.PUERTA_HRR_IZQ_1,Bloque.PUERTA_HRR_IZQ_2,Direccion.DERECHA),
    PUERTA_HRR_DRH(Bloque.PUERTA_HRR_DRH_1,Bloque.PUERTA_HRR_DRH_2,Direccion.IZQUIERDA),
    CAMA_IZQ(Bloque.CAMA_IZQ_1,Bloque.CAMA_IZQ_2,Direccion.DERECHA),
    CAMA_ARR(Bloque.CAMA_ARR_1,Bloque.CAMA_ARR_2,Direccion.ARRIBA),
    CAMA_ABJ(Bloque.CAMA_ABJ_1,Bloque.CAMA_ABJ_2,Direccion.ABAJO),
    CAMA_DRH(Bloque.CAMA_DRH_1,Bloque.CAMA_DRH_2,Direccion.IZQUIERDA),
    ;
    
    //###########################################################
    //##		ENUMERATIONS                          ###
    //###########################################################
    public static enum Direccion {
        ARRIBA,
        ABAJO,
        IZQUIERDA,
        DERECHA
    }
        
    //###########################################################
    //##		MEMBERS                               ###
    //###########################################################
    private Bloque mBloque1;
    private Bloque mBloque2;
    private Direccion mDireccion;
    
    //###########################################################
    //##		CONSTRUCTORS                          ###
    //###########################################################
    private BloqueDoble(Bloque bloque1, Bloque bloque2, Direccion direccion) {
        mBloque1 = bloque1;
        mBloque2 = bloque2;
        mDireccion = direccion;
    }
    
    //###########################################################
    //##		PROPERTIES                            ###
    //###########################################################
    public Bloque getBloque1() {
        return mBloque1;
    }
    
    public Bloque getBloque2() {
        return mBloque2;
    }
    
    public Direccion getDireccion() {
        return mDireccion;
    }
    
    //###########################################################
    //##		METHODS                               ###
    //###########################################################
    /**
     * Indica si el bloque pasado corresponde al primer bloque de un BloqueDoble
     * @param blq Bloque a comprobar
     * @return Verdadero si cumple la condicion, falso en caso contrario
     */
    public static boolean esPrimerBloqueDoble(Bloque blq) {
        for (BloqueDoble blq_dbl : values()) {
            if(blq_dbl.getBloque1()==blq)
                return true;
        }
        return false;
    }
    
    /**
     * Indica si el bloque pasado es un bloque doble
     * @param blq Bloque a comprobar
     * @return Verdadero si es un bloque doble, falso si no
     */
    public static boolean esBloqueDoble(Bloque blq) {
        return (get(blq)!=null);
    }
    
    /**
     * Devuelve el BloqueDoble asociado a un bloque dado
     * @param blq Bloque asociado a un posible BloqueDoble
     * @return El objeto BloqueDoble asociado o null si no existe
     */
    public static BloqueDoble get(Bloque blq) {
        for (BloqueDoble blq_dbl : values()) {
            if(blq_dbl.getBloque1()==blq || blq_dbl.getBloque2()==blq)
                return blq_dbl;
        }
        return null;
    }
    
    //###########################################################
    //##		EVENTS                                ###
    //###########################################################
}
