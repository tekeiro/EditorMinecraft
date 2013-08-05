package org.keirobm.editorminecraft.model;

public class EntradaPS {
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private int mFila;
	private int mColumna;
	private PS mPs;

	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	public EntradaPS(int fila, int columna, PS ps) {
		mFila = (fila>=0) ? fila : 0;
		mColumna = (columna>=0) ? columna : 0;
		mPs = ps;
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
	
	/**
	 * Obtiene la PS
	 * @return
	 */
	public PS getPS() {
		return mPs;
	}

	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################


}
