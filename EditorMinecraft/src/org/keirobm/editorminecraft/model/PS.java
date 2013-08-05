package org.keirobm.editorminecraft.model;

/**
 * Representa las posibles PS (Precious Stone) que se pueden colocar
 * @author Angel
 *
 */
public enum PS {
	REFUGIO(17,0,3,3),
	ORO(18,300,5,5),
	LAPIZ(19,1000,10,16),
	DIAMANTE(20,2500,20,30);
	
	
	//------- Definicion de Clase -------
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private int mId;
	private int mCoste;
	private int mRadio;
	private int mAltura;
	
	public static final int ID_INICIO_PS = 17;
	public static final int ID_FIN_PS = 20;
	
	
	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor
	 * @param id Id del bloque que representa la PS
	 * @param coste Coste de colocar la PS
	 * @param radio Radio en ancho y alto en bloques de la proteccion de la PS.
	 * @param altura Altura en bloques de la proteccion de la PS
	 */
	private PS (int id, int coste, int radio, int altura) {
		mId = id;
		mCoste = coste;
		mRadio = radio;
		mAltura = altura;
	}
	
	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * Obtiene la ID del bloque de la PS
	 * @return
	 */
	public int getId() {
		return mId;
	}
	
	/**
	 * Obtiene el coste de colocar la PS
	 * @return
	 */
	public int getCoste() {
		return mCoste;
	}
	
	/**
	 * Obtiene el radio de la proteccion de la PS
	 * @return
	 */
	public int getRadio() {
		return mRadio;
	}
	
	/**
	 * Obtiene la altura de la proteccion de la PS
	 * @return
	 */
	public int getAltura() {
		return mAltura;
	}
	
	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	/**
	 * Indica si el bloque dado es PS o no.
	 * @param idBloque Id del Bloque a comprobar si es PS
	 * @return Verdadero si el bloque dado es PS o falso en caso contrario
	 */
	public static boolean esPS(int idBloque) {
		if (idBloque>=ID_INICIO_PS && idBloque<=ID_FIN_PS)
			return true;
		else 
			return false;
	}
	
	/**
	 * Devuelve el PS Asociado segun su Id de Bloque.
	 * @param idBloque Id del Bloque de la supuesta PS
	 * @return La Ps asociada si existe una PS con el id de bloque pasado o null en caso contrario
	 */
	public static PS getPSAsociado(int idBloque) {
		if (esPS(idBloque)) {
			for (PS ps : PS.values()) {
				if (ps.getId()==idBloque)
					return ps;
			}
			return null;
		}
		return null;
	}
}
