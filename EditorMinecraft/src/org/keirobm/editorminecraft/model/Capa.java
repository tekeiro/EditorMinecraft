package org.keirobm.editorminecraft.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Representa una capa del plano
 * @author Angel
 *
 */
public class Capa {
	
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private HashMap<Posicion,int[]> mBloques;
	private HashMap<Posicion,EtiquetaTexto> mTextos;
	private HashMap<Posicion,PS> mPs;
        
        private Dimension capaDim;
	
	
	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################7
	/**
	 * Constructor por defecto
	 */
	public Capa() {
		mBloques = new HashMap<Posicion,int[]>();
		mTextos = new HashMap<Posicion,EtiquetaTexto>();
		mPs = new HashMap<Posicion,PS>();
                capaDim = new Dimension(0, 0);
	}
	
	
	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * Devuelve la cantidad de bloques colocados en la capa
	 * @return
	 */
	public int cantidadBloques() {
		return mBloques.size();
	}
	
	/**
	 * Devuelve la cantidad de PS contenidas en la capa
	 * @return
	 */
	public int cantidadPS() {
		return mPs.size();
	}
	
	public int cantidadEtiquetas() {
		return mTextos.size();
	}
        
        /**
         * Devuelve el tamaño de la capa en numero de bloques
         * @return Objeto Dimension
         */
        public Dimension getCapaSize() {
            return new Dimension(capaDim.width, capaDim.height);
        }
        
        /**
         * Devuelve el tamaño de la capa en numero de pixels
         * @return Objeto Dimension
         */
        public Dimension getCapaSizePixels() {
            return new Dimension(capaDim.width*Bloque.ANCHO, capaDim.height*Bloque.ALTO);
        }
	
	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	
	//------------- Metodos para operar con la Capa  ----------------------
               
	/**
	 * Pone un bloque en la posicion dada por fila y columna. 
	 * Si en esa posicion no habia ningun bloque coloca el bloque dado, en caso de que existiera un bloque en la 
	 * posicion dada, lo reemplaza con el bloque dado. Por ultimo, si como bloque se da null entonces lo que hace 
	 * es eliminar cualquier bloque que haya en esa posicion.
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa. Debe ser superior a 0
	 * @param blq Bloque a colocar
	 * @return Devuelve verdadero si se ha podido anyadir, en caso contrario devuelve falso.
	 */
	public boolean setBloque(int fila, int columna, Bloque blq) {
		if (fila<0 || columna<0)
			return false;
		else {
                    if (blq==null) 
                        return delBloque(fila, columna);

                    //Si existe una PS en el cuadro, habra que quitarla
                    if (mPs.containsKey(new Posicion(fila,columna))) {
                            mPs.remove(new Posicion(fila,columna));
                    }

                    //Si el nuevo bloque es una PS hay que registrarla
                    if (PS.esPS(blq.getId())) {
                            PS ps = PS.getPSAsociado(blq.getId());
                            mPs.put(new Posicion(fila,columna), ps);
                    }


                    Bloque[] bloques = getBloque(fila, columna);
                    if (bloques!=null) {
                        int[] blqs = mBloques.get(new Posicion(fila, columna));
                        if (bloques.length > 0) {
                            //Si el que estaba es BASE y el nuevo es APILABLE, se pone encima
                            if (bloques[0].getTipo() == Bloque.Tipo.BASE && blq.getTipo() == Bloque.Tipo.APILABLE) {
                                blqs[1] = blq.getId();
                            } else {                                
                                mBloques.put(new Posicion(fila, columna), new int[]{blq.getId(), -1});
                            }
                        }
                    } else {
                        mBloques.put(new Posicion(fila, columna), new int[]{blq.getId(), -1});
                    }

                    //Si es un bloque doble 
                    if (BloqueDoble.esPrimerBloqueDoble(blq)) {
                        BloqueDoble blq_dbl = BloqueDoble.get(blq);
                        switch(blq_dbl.getDireccion()) {
                            case ABAJO:
                                setBloque(fila+1, columna, blq_dbl.getBloque2());
                                break;
                            case ARRIBA:
                                setBloque((fila>0) ? fila-1 : 0, columna, blq_dbl.getBloque2());
                                break;
                            case IZQUIERDA:
                                setBloque(fila, (columna>0) ? columna-1 : 0, blq_dbl.getBloque2());
                                break;
                            case DERECHA:
                                setBloque(fila, columna+1, blq_dbl.getBloque2());
                                break;
                        }
                    }
                    
                    //Actualizar la dimension del bloque
                    if (blq.getFila()>capaDim.height)   capaDim.height=blq.getFila();
                    if (blq.getColumna()>capaDim.width) capaDim.width=blq.getColumna();


                    return true;
		}
	}
	
	/**
	 * Obtiene el bloque que se encuentra en la posicion dada por fila y columna
	 * @param fila Fila en la capa. Debe ser superior a 0
	 * @param columna Columna en la capa. Debe ser superior a 0
	 * @return Devuelve el bloque o null si no hay ningun bloque en esa posicion
	 */
	public Bloque[] getBloque(int fila, int columna) {
		int[] res = mBloques.get(new Posicion(fila, columna));                
                
		if (res!=null) {
                    Bloque[] blqs = new Bloque[res.length];
                    for (int i=0; i<res.length; i++) {
                        blqs[i] = (res[i]!=-1) ? Bloque.values()[res[i]] : null;
                    }
                    return blqs;
                }
		else				
                    return null;
	}
        
        /**
         * Quita el bloque que este mas superficial en la posicion dada por fila y columna
         * @param fila Fila en la capa. Debe ser superior a 0
         * @param columna Columna en la capa. Debe ser superior a 0
         * @return Devuelve verdadero si se ha podido quitar, en caso contrario devuelve falso.
         */
        public boolean popBloque(int fila, int columna) {
            boolean actualizar=false;
            
            if (fila<0 || columna<0) {
                    return false;
            }
            else {
                    if (mPs.containsKey(new Posicion(fila,columna))) {
                            mPs.remove(new Posicion(fila, columna));
                            actualizar=true;
                    }

                    Bloque[] blqs = getBloque(fila, columna);
                    if (blqs!=null) {
                        if (blqs[0]!=null && BloqueDoble.esBloqueDoble(blqs[0])) {
                            BloqueDoble blq_dbl = BloqueDoble.get(blqs[0]);
                            if (blq_dbl.getBloque1()==blqs[0]) {
                                int f=fila, c=columna;
                                switch(blq_dbl.getDireccion()) {
                                    case ABAJO:
                                        f+=1;
                                        break;
                                    case ARRIBA:
                                        f = (fila>0) ? fila-1 : 0;
                                        break;
                                    case IZQUIERDA:
                                        c = (columna>0) ? columna-1 : 0;
                                        break;
                                    case DERECHA:
                                        c+=1;
                                        break;                                           
                                }
                                Bloque[] bs2 = getBloque(f, c);
                                if (bs2!=null) {
                                    if (bs2[0]!=null && blq_dbl.getBloque2()==bs2[0]) {
                                        mBloques.remove(new Posicion(f, c));
                                        actualizar=true;
                                    }
                                }
                            }                            
                        }
                        
                        if (blqs[1]!=null && blqs[0]!=null) {
                            mBloques.get(new Posicion(fila, columna))[1]=-1;
                            if (actualizar) actualizarDimension();
                            return true;
                        }
                        else {
                            mBloques.remove(new Posicion(fila, columna));
                            actualizarDimension();
                            return true;
                        }
                    }
                    if(actualizar) actualizarDimension();
                    return false;
            }
        }
	
	/**
	 * Quita todos los bloques de la capa que se encuentra en la posicion dada por fila y columna
	 * @param fila Fila en la capa. Debe ser superior a 0
	 * @param columna Columna en la capa. Debe ser superior a 0
	 * @return Devuelve verdadero si se ha podido quitar, en caso contrario devuelve falso.
	 */
	public boolean delBloque(int fila, int columna) {
		if (fila<0 || columna<0) {
			return false;
		}
		else {
			if (mPs.containsKey(new Posicion(fila,columna))) {
				mPs.remove(new Posicion(fila, columna));
			}
			
                        Bloque[] blqs = getBloque(fila, columna);
                        if (blqs!=null) {
                            if (blqs[0]!=null && BloqueDoble.esBloqueDoble(blqs[0])) {
                                BloqueDoble blq_dbl = BloqueDoble.get(blqs[0]);
                                if (blq_dbl.getBloque1()==blqs[0]) {
                                    int f=fila, c=columna;
                                    switch(blq_dbl.getDireccion()) {
                                        case ABAJO:
                                            f+=1;
                                            break;
                                        case ARRIBA:
                                            f = (fila>0) ? fila-1 : 0;
                                            break;
                                        case IZQUIERDA:
                                            c = (columna>0) ? columna-1 : 0;
                                            break;
                                        case DERECHA:
                                            c+=1;
                                            break;                                           
                                    }
                                    Bloque[] bs2 = getBloque(f, c);
                                    if (bs2!=null) {
                                        if (bs2[0]!=null && blq_dbl.getBloque2()==bs2[0]) {
                                            mBloques.remove(new Posicion(f, c));
                                        }
                                    }
                                }
                            }
                        }
                        
			mBloques.remove(new Posicion(fila, columna));
                        actualizarDimension(); //Actualiza la dimension
			return true;
		}
	}
	
	/**
	 * Quita todos los bloques de la capa
	 */
	public void clearBloques() {
		mBloques.clear();
		mPs.clear();
                capaDim.setSize(0, 0);
	}
	
	/**
	 * Obtiene todos los bloques colocados en la capa
	 * @return Array con los bloques incluyendo su posicion en la capa
	 */
	public EntradaBloque[] getBloques() {
		Set<Posicion> claves = mBloques.keySet();
		
		EntradaBloque[] res = new EntradaBloque [claves.size()];
		int indice = 0;
		for (Posicion pos : claves) {
                    EntradaBloque e = new EntradaBloque(pos.getFila(), pos.getColumna(), getBloque(pos.getFila(), pos.getColumna()));
                    res[indice] = e;
                    indice++;
		}
		
		return res;
	}
	
	/**
	 * Indica si hay bloque en la posicion dada
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa. Debe ser superior a 0
	 * @return Devuelve verdadero si hay un bloque en la posicion dada o falso en caso contrario
	 */
	public boolean hayBloque(int fila, int columna) {
		return mBloques.containsKey(new Posicion(fila,columna));
	}
        
        //------------  Otros metodos para operar con bloques ---------------------
        public boolean noHayBloqueoEsIgualA(int fila, int columna, Bloque blq) {            
            Bloque[] bloques = getBloque(fila, columna);
            if (blq==null)
                return bloques==null;
            else
                return (bloques!=null && bloques[1]==blq) || (bloques!=null && bloques[1]==null && bloques[0]==blq);
        }
        
        private void actualizarDimension() {
            capaDim=new Dimension(0, 0);
            
            //Recorre todos los bloques buscando los que esten mas alejados del punto origen (0,0)
            Set<Posicion> pos = mBloques.keySet();
            for (Posicion p : pos) {
                capaDim.height = (p.getFila()>capaDim.height) ? p.getFila() : capaDim.height;
                capaDim.width = (p.getColumna()>capaDim.width) ? p.getColumna(): capaDim.width;
            }
        }
        
	
	//---------------  Metodos para operar con las PS             ------------------------
	/**
	 * Obtiene una lista de todas las PS colocadas en la capa junto con sus posiciones
	 * @return Array de objetos EntradaPS con todas las PS y la posicion en las que estan colocadas
	 */
	public EntradaPS[] listarPS() {
		Set<Posicion> claves = mPs.keySet();
		EntradaPS[] res = new EntradaPS[claves.size()];
		int indice=0;
		
		for (Posicion pos : claves) {
			EntradaPS p = new EntradaPS(pos.getFila(), pos.getColumna(), mPs.get(pos));
			res[indice] = p;
			indice++;
		}
		
		return res;
	}
	
	//---------------  Metodos para operar con las etiquetas de texto ------------------------
	/**
	 * Obtiene una etiqueta de texto que haya sido colocada en la posicion indicada
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa.
	 * @return Objeto EtiquetaTexto con la etiqueta o null si no existe la etiqueta
	 */
	public EtiquetaTexto getEtiqueta(int fila, int columna) {
		if (fila<0 || columna<0) {
			return null;
		}
		else {
			return mTextos.get(new Posicion(fila,columna));
		}
	}
	
	/**
	 * Pone una etiqueta en la capa en la posicion indicada
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa. Debe ser superior a 0
	 * @param etiqueta Objeto EtiquetaTexto con la etiqueta del texto
	 * @return Devuelve verdadero si se pudo anyadir la etiqueta a la capa o falso en caso contrario
	 */
	public boolean setEtiqueta(int fila, int columna, EtiquetaTexto etiqueta) {
		if (fila<0 || columna<0 || etiqueta==null) {
			return false;
		}
		else {
			mTextos.put(new Posicion(fila,columna), etiqueta);
			return true;
		}
	}
	
	/**
	 * Borra una etiqueta de la capa de la posicion indicada
	 * @param fila Fila de la capa. Debe ser superior a 0
	 * @param columna Columna de la capa. Debe ser superior a 0
	 * @return Devuelve verdadero si se pudo eliminar la etiqueta de la capa o falso en caso contrario
	 */
	public boolean delEtiqueta(int fila, int columna) {
		if (fila<0 || columna<0) {
			return false;
		}
		else {
			mTextos.remove(new Posicion(fila,columna));
			return true;
		}
	}
	
	/**
	 * Quita todas las etiquetas de la capa
	 */
	public void clearEtiquetas() {
		mTextos.clear();
	}
	
	/**
	 * Obtiene una lista con todas las etiquetas
	 * @return Objeto ArrayList que contiene todas las etiquetas como objetos Entry con la Posicion 
	 * y la cadena de texto de la entrada
	 */
	public ArrayList<Entry<Posicion,EtiquetaTexto>> getEtiquetas() {
		ArrayList<Entry<Posicion,EtiquetaTexto>> etiqs = new ArrayList<Entry<Posicion,EtiquetaTexto>>();
		Set<Entry<Posicion,EtiquetaTexto>> cjo_etiqs = mTextos.entrySet();
		
		for (Entry<Posicion,EtiquetaTexto> entrada : cjo_etiqs) {
			etiqs.add(entrada);
		}
		
		return etiqs;
	}
	
	//---------------  Otros metodos  ------------------------	
	/**
	 * Todo el contenido actual es borrado y duplica el contenido (bloques, PS y etiquetas) de la capa pasada como parametro
	 * @param c Capa de la que es copiada el contenido
	 */
	public void duplicarCapa(Capa c) {
		clearBloques();
		clearEtiquetas();
		
		
		EntradaBloque[] bloques = c.getBloques();
		ArrayList<Entry<Posicion,EtiquetaTexto>> etiqs = c.getEtiquetas();
		
		for (EntradaBloque blq : bloques) {
                        Bloque[] blqs = blq.getBloques();
                        int[] res = new int[]{ (blqs[0]!=null) ? blqs[0].getId() : -1, (blqs[1]!=null) ? blqs[1].getId() : -1};
                        
			mBloques.put(new Posicion(blq.getFila(),blq.getColumna()), res);
		}
		
		for (Entry<Posicion,EtiquetaTexto> etq : etiqs) {
			setEtiqueta(etq.getKey().getFila(), etq.getKey().getColumna(), etq.getValue());
		}
	}
	
	
}
