package org.keirobm.editorminecraft.model;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map.Entry;
import org.keirobm.editorminecraft.model.EtiquetaTexto.Estilo;
import org.keirobm.editorminecraft.util.Utils;



public class Plano {
    
	//###########################################################
	//##				MEMBERS                   ###
	//###########################################################
	private ArrayList<Capa> mCapas;	

	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor por defecto
	 */
	public Plano() {
		mCapas = new ArrayList<Capa>();
	}

	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * @return Obtiene el numero de capas
	 */
	public int cantidadCapas() {
		return mCapas.size();
	}

	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	//---------  Metodos para operar con Capas ---------------------
	/**
	 * A�ade una capa vacia (sin bloques, PS ni texto) al plano
	 */
	public void addCapaVacia() {
		Capa c = new Capa();
		mCapas.add(c);
	}
	
	/**
	 * A�ade una capa con el mismo contenido (bloques, PS y texto) al plano
	 * @param capa Capa de la cual se creara una copia y se a�adira al plano
	 */
	public void addCapaClonando(Capa capa) {
		Capa c2 = new Capa();
		c2.duplicarCapa(capa);
		mCapas.add(c2);
	}
	
	/**
	 * Obtiene la capa con indice dado
	 * @param indice Indice de la capa. Debe ser un indice valido.
	 * @return Devuelve el objeto Capa obtenido
	 */
	public Capa getCapa (int indice) {
		return mCapas.get(indice);
	}
	
	/**
	 * Quita la capa que habia en el indice dado y la sustituye por la capa pasada.
	 * @param indice Indice de la capa. Debe ser un indice valido
	 * @param capa Capa nueva que sustituye a la antigua y pasa a formar parte del plano
	 * @return Devuelve la capa que ha sido sustituida
	 */
	public Capa setCapa(int indice, Capa capa) {
		Capa old = mCapas.get(indice);
		mCapas.set(indice, capa);
		return old;
	}
	
	/**
	 * Intercambia la posicion en el plano de dos capas
	 * @param indice1 Indice de la primera capa. Debe ser un indice valido
	 * @param indice2 Indice de la segunda capa. Debe ser un indice valido
	 */
	public void intercambiarCapas(int indice1, int indice2) {
		Capa c1 = mCapas.get(indice1);
		mCapas.set(indice1, mCapas.get(indice2));
		mCapas.set(indice2, c1);
	}
	
	/**
	 * Quita la capa que se encuentra en el indice dado
	 * @param indice Indice de la capa. Debe ser un indice valido
	 * @return Devuelve la capa que ha quitado
	 */
	public Capa delCapa(int indice) {
		return mCapas.remove(indice);
	}
	
	/**
	 * Quita todas las capas del plano
	 */
	public void quitarCapas() {
		mCapas.clear();
	}
	
	/**
	 * Realiza una estadistica sobre la capa dada por su indice en el plano
	 * @param indice Indice de la capa. Debe ser un indice valido
	 * @return Objeto Estadistica con los parametros analizados
	 */
	public Estadistica analizarCapa(int indice) {
		Capa c = mCapas.get(indice);
		Estadistica e = new Estadistica();
		e.hacerEstadistica(c);
		return e;
	}
	
	//----------  Metodos de lectura y escritura en archivos  --------------------
	/**
	 * Guarda la informacion del plano en un archivo binario
	 * @param filename Ruta del archivo
	 */
	public void guardarAArchivo(String filename) throws Exception {
            try {

                //Generar arbol XML
                DataOutputStream writer = new DataOutputStream(new FileOutputStream(filename));
                writer.writeInt(mCapas.size());


                for (Capa capa : mCapas) {

                    //Guardar los bloques			
                    EntradaBloque[] bloques = capa.getBloques();
                    String cadBloques = "";
                    for (int i = 0; i < bloques.length; i++) {
                        EntradaBloque blq = bloques[i];
                        Bloque[] blqs = blq.getBloques();
                        cadBloques += blq.getFila() + "," + blq.getColumna();
                        if (blqs[0]!=null)  cadBloques += "," + blqs[0].getId();
                        if (blqs[1]!=null)  cadBloques += "," + blqs[1].getId();
                        if (i != bloques.length - 1) {
                            cadBloques += ";";
                        }
                    }
                    String compCadBloques = cadBloques; //StringCompresion.compress(cadBloques);
                    byte[] compCadBloques_bytes = compCadBloques.getBytes();
                    writer.writeInt(compCadBloques_bytes.length);
                    writer.write(compCadBloques_bytes);

                    //Guardar las etiquetas de texto
                    ArrayList<Entry<Posicion, EtiquetaTexto>> etiquetas = capa.getEtiquetas();
                    writer.writeInt(etiquetas.size());
                    for (Entry<Posicion, EtiquetaTexto> et : etiquetas) {
                        writer.writeInt(et.getKey().getFila());
                        writer.writeInt(et.getKey().getColumna());
                        writer.writeUTF(Utils.colorToString(et.getValue().getColor()));
                        writer.writeInt(et.getValue().getEstilo().ordinal());
                        writer.writeInt(et.getValue().getTam());
                        //eEtiqueta.setText("<![CDATA[" + StringCompresion.compress(et.getValue().getTexto()) + "]]>");
                        String compTexto = et.getValue().getTexto(); //StringCompresion.compress(et.getValue().getTexto());
                        byte[] compTexto_bytes = compTexto.getBytes();
                        writer.writeInt(compTexto_bytes.length);
                        writer.write(compTexto_bytes);

                    }
                }

                writer.close();
            } catch (Exception ex) {
                System.err.println("Error en la escritura del archivo del plano");
                ex.printStackTrace(System.err);
                throw new Exception("Error en el guardado del archivo del plano", ex);

            }
        }
	
	/**
	 * Carga el plano con la informacion del archivo que se encuentra en la ruta pasada por parametro
	 * @param filename Ruta del archivo
	 */
	public void cargarArchivo(String filename) throws Exception {           
            mCapas.clear();

            try {
                DataInputStream reader = new DataInputStream(new FileInputStream(filename));
                int numCapas = reader.readInt();

                for (int i = 0; i < numCapas; i++) {
                    Capa c = new Capa();

                    //Leer bloques
                    byte[] compBloques_bytes = new byte[reader.readInt()];
                    reader.read(compBloques_bytes);
                    String compBloques = new String(compBloques_bytes);
                    String cadBloques = compBloques; //StringCompresion.decompress(compBloques);
                    String[] sepBloques = cadBloques.split(";");
                    for (String blq : sepBloques) {
                        String[] b = blq.split(",");
                        if (b.length==3)
                            c.setBloque(Integer.valueOf(b[0]), Integer.valueOf(b[1]), Bloque.values()[Integer.valueOf(b[2])]);
                        if (b.length==4) {
                            c.setBloque(Integer.valueOf(b[0]), Integer.valueOf(b[1]), Bloque.values()[Integer.valueOf(b[2])]);
                            c.setBloque(Integer.valueOf(b[0]), Integer.valueOf(b[1]), Bloque.values()[Integer.valueOf(b[3])]);
                        }
                    }

                    //Leer etiquetas
                    int numEtiquetas = reader.readInt();
                    for (int j = 0; j < numEtiquetas; j++) {
                        int fila = reader.readInt();
                        int columna = reader.readInt();
                        Color color = Color.decode(reader.readUTF());
                        Estilo estilo = Estilo.values()[reader.readInt()];
                        int tam = reader.readInt();
                        byte[] compTexto_bytes = new byte[reader.readInt()];
                        reader.read(compTexto_bytes);
                        String compTexto = new String(compTexto_bytes);
                        String texto = compTexto; //StringCompresion.decompress(compTexto);
                        EtiquetaTexto et = new EtiquetaTexto(texto, color, estilo, tam);
                        c.setEtiqueta(fila, columna, et);
                    }
                    mCapas.add(c);
                }
                reader.close();
            } catch (Exception ex) {
                System.err.println("Error en la carga del archivo del plano");
                ex.printStackTrace();

                throw new Exception("Error en la carga del archivo del plano", ex);
            }
    }
}
