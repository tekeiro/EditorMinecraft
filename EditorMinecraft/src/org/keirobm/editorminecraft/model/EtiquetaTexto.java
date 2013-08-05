package org.keirobm.editorminecraft.model;

import java.awt.Color;
import java.awt.Font;

public class EtiquetaTexto {
	//###########################################################
	//##				ENUMERACIONES					  	  ###
	//###########################################################
	public static enum Estilo {
		NORMAL(Font.PLAIN),
		NEGRITA(Font.BOLD),
		CURSIVA(Font.ITALIC);
		
		
		//###########################################################
		//##				MEMBERS							  	  ###
		//###########################################################
		private int mStyle;
		
		//###########################################################
		//##				CONSTRUCTORS					  	  ###
		//###########################################################
		/**
		 * Constructor
		 * @param style Constante de estilo. Ver clase java.awt.Font
		 */
		Estilo (int style) {
			mStyle = style;
		}
		//###########################################################
		//##				PROPERTIES						  	  ###
		//###########################################################
		/**
		 * Obtiene la constante entera del estilo
		 * @return
		 */
		public int getFontStyle() {
			return mStyle;
		}
	}
	
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private String mTexto;
	private Color mColor;
	private Estilo mEstilo;
	private int mTam;
	
	public static final int DEFAULT_SIZE_TEXT = 10;

	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor
	 * @param texto Texto a escribir
	 */
	public EtiquetaTexto(String texto) {
		mTexto = texto;
		mColor = Color.black;
		mEstilo = Estilo.NORMAL;
		mTam = DEFAULT_SIZE_TEXT;
	}
	
	/**
	 * Constructor
	 * @param texto Texto a escribir
	 * @param color Color del texto
	 * @param estilo Estilo del texto. (Normal, cursiva o negrita)
	 * @param tamanyo Tamanyo de la letra del texto
	 */
	public EtiquetaTexto(String texto, Color color, Estilo estilo, int tamanyo) {
		mTexto = texto;
		mColor = color;
		mEstilo = estilo;
		mTam = (tamanyo>0) ? tamanyo : DEFAULT_SIZE_TEXT;
	}

	

	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * @return Obtiene el texto
	 */
	public String getTexto() {
		return mTexto;
	}

	/**
	 * Cambia la cadena de texto a escribir
	 * @param mTexto Nueva cadena de texto a escribir
	 */
	public void setTexto(String mTexto) {
		this.mTexto = mTexto;
	}

	/**
	 * @return Obtiene el color del texto
	 */
	public Color getColor() {
		return mColor;
	}

	/**
	 * Cambia el color del texto
	 * @param mColor Nuevo color del texto
	 */
	public void setColor(Color mColor) {
		this.mColor = mColor;
	}

	/**
	 * @return Obtiene el estilo del texto
	 */
	public Estilo getEstilo() {
		return mEstilo;
	}

	/**
	 * Cambia el estilo del texto
	 * @param mEstilo Nuevo estilo del texto
	 */
	public void setEstilo(Estilo mEstilo) {
		this.mEstilo = mEstilo;
	}

	/**
	 * @return Obtiene el tamanyo de letra del texto
	 */
	public int getTam() {
		return mTam;
	}

	/**
	 * Cambia el tamanyo de letra del texto
	 * @param mTam Nuevo tamanyo de letra del texto
	 */
	public void setTam(int mTam) {
		this.mTam = mTam;
	}

	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################


}
