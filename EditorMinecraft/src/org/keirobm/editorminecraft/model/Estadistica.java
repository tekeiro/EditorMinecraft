package org.keirobm.editorminecraft.model;

public class Estadistica {
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private int mCoste_total;
	private int[] mCantidad_bloques;
	private int mArea_ancho;
	private int mArea_alto;

	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	public Estadistica() {
	}

	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	public int getCosteTotal() {
		return mCoste_total;
	}
	
	public int getCantidadBloque(Bloque blq) {
		if (blq!=null)
			return mCantidad_bloques[blq.getId()];
		else
			return -1;
	}
	
	public int getAreaAncho() {
		return mArea_ancho;
	}
	
	public int getAreaAlto() {
		return mArea_alto;
	}
	
	/*public void setCosteTotal(int coste) {
		mCoste_total = (coste>=0) ? coste : 0;
	}
	
	public void setCantidadBloques(Bloque blq, int cantidad) {
		if (blq!=null && cantidad>=0) {
			mCantidad_bloques[blq.getId()] = cantidad;
		}
	}
	
	public void setAreaAncho(int area_ancho) {
		mArea_ancho = (area_ancho>=0) ? area_ancho : 0;
	}
	
	public void setAreaAlto(int area_alto) {
		mArea_alto = (area_alto>=0) ? area_alto : 0;
		
	}*/
	
	
	//###########################################################
	//##				METHODS		          ###
	//###########################################################
	/**
	 * Hace la estadistica sobre: <br>
	 * 	- Coste total de colocar las PSs de la capa <br>
	 * 	- Cantidad de bloques por tipo colocados en la capa <br>
	 *  - Ancho en bloques de la construccion realizada en la capa. <br>
	 *  - Alto en bloques de la construccion realizada en la capa. <br>
	 * Al realizar la estadistica se rellenan los parametros en el propio objeto Estadistica para su 
	 * posterior consulta
	 * @param c Capa a la cual se realiza la estadistica.
	 */
	public void hacerEstadistica(Capa c) {
		//Cantidad de bloques de cada tipo
		mCantidad_bloques = new int [Bloque.values().length];
		//Inicializar a 0
		for (int i=0; i<mCantidad_bloques.length; i++)
			mCantidad_bloques[i]=0;
                
                //Poner el coste a 0
		mCoste_total = 0;
                //Se inicializa el area a 0
                mArea_alto=0;
                mArea_ancho=0;		
		
		acumularEstadisticaCapa(c);	
	}
        
        /**
         * Hace la estadistica de un Plano entero
         * @param plano Plano del cual realizara la estadistica
         */
        public void hacerEstadisticaTotal(Plano plano) {
            //Cantidad de bloques de cada tipo
            mCantidad_bloques = new int [Bloque.values().length];
            //Inicializar a 0
            for (int i=0; i<mCantidad_bloques.length; i++)
                    mCantidad_bloques[i]=0;

            //Poner el coste a 0
            mCoste_total = 0;
            //Se inicializa el area a 0
            mArea_alto=0;
            mArea_ancho=0;
            
            //Para cada capa
            for (int i=0; i<plano.cantidadCapas(); i++) {
                //Se coge la capa i-esima
                Capa c = plano.getCapa(i);
                
                //Se resguarda los datos del area de la capa anterior
                int area_ancho = mArea_ancho;
                int area_alto = mArea_alto;
                
                acumularEstadisticaCapa(c);
                
                if ((mArea_ancho*mArea_alto) < (area_alto*area_ancho)) {
                    mArea_ancho=area_ancho;
                    mArea_alto=area_alto;
                }
            }
        }
        
        
        /**
         * Realiza la estadistica sobre una capa y acumula los resultados con los que ya hay en este objeto
         * @param c Capa de la cual realizara la estadistica
         */
        private void acumularEstadisticaCapa(Capa c) {
            EntradaBloque[] bloques = c.getBloques();
            
            //Cantidad de bloques de cada tipo
            for (EntradaBloque blq : bloques) {
                Bloque[] blqs = blq.getBloques();
                if(blqs[0]!=null)   mCantidad_bloques[blqs[0].getId()]++;
                if(blqs[1]!=null)   mCantidad_bloques[blqs[1].getId()]++;
            }
            
            //Hallar coste total de las PSs.
            EntradaPS[] list_ps = c.listarPS();
            for (EntradaPS ps : list_ps) {
                    mCoste_total += ps.getPS().getCoste();
            }
            
            //Hallar el ancho y el alto de la capa
            int minFila=-1, maxFila=-1, minCol=-1, maxCol=-1;
            for (EntradaBloque blq : bloques) {
                    minFila = (blq.getFila()<minFila || minFila==-1) ? blq.getFila() : minFila;
                    maxFila = (blq.getFila()>maxFila || maxFila==-1) ? blq.getFila() : maxFila;
                    minCol = (blq.getColumna()<minCol || minCol==-1) ? blq.getColumna() : minCol;
                    maxCol = (blq.getColumna()>maxCol || maxCol==-1) ? blq.getColumna() : maxCol;
            }
            mArea_alto = maxFila - minFila + 1;
            mArea_ancho = maxCol - minCol + 1;
        }

}
