package org.keirobm.editorminecraft.model;

/**
 * Representa un bloque colocado en la capa en una posicion dada por fila y columna
 * @author Angel
 *
 */
public class EntradaBloque {
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private int mFila;
	private int mCol;
	private Bloque[] mBlqs;
	
	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa. Debe ser superior a 0.
	 * @param blq Bloque que se encuentra en la posicion
	 */
	public EntradaBloque(int fila, int columna, Bloque[] blqs) {
		mFila = (fila>=0) ? fila : 0;
		mCol = (columna>=0) ? columna : 0;
		mBlqs = blqs;
	}
	
	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * Obtiene la fila
	 * @return
	 */
	public int getFila() {
		return mFila;
	}
	
	/**
	 * Obtiene la columna
	 * @return
	 */
	public int getColumna() {
		return mCol;
	}
	
	/**
	 * Obtiene el bloque 
	 * @return
	 */
	public Bloque[] getBloques() {
		return mBlqs;
	}
	
	
	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################

}
