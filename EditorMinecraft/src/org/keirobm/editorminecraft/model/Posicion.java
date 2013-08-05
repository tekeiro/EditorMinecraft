package org.keirobm.editorminecraft.model;

/**
 * Representa la fila y columna de un bloque dentro de la capa
 * @author Angel
 *
 */
public class Posicion {
	//###########################################################
	//##				MEMBERS								  ###
	//###########################################################
	private int mFila = 0;
	private int mColumna = 0;
	
	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor
	 * @param fila Fila dentro de la capa
	 * @param columna Columna dentro de la capa
	 */
	public Posicion (int fila, int columna) {
		mFila = (fila<0) ? 0 : fila;
		mColumna = (columna<0) ? 0 : columna;
	}
	
	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	/**
	 * Compara dos objetos para comprobar si son iguales
	 * @param obj Objeto a comparar
	 * @return Devuelve verdadero si son iguales y falso en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Posicion.class) {
			Posicion p = (Posicion) obj;
			return p.mFila==mFila && p.mColumna==mColumna;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(mFila).hashCode() ^ Integer.valueOf(mColumna).hashCode();
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
		return mColumna;
	}
}
