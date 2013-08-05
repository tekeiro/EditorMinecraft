package org.keirobm.editorminecraft.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.*;

/**
 * Clase para comprimir y descomprimir cadenas de texto usando GZIP
 * @author Angel
 *
 */
public class StringCompresion {
	/**
	 * Comprime una cadena con el formato GZIP
	 * @param str Cadena a comprimir
	 * @return Cadena comprimida
	 */
	public static String compress(String str) {
		if (str==null || str.isEmpty()) {
			return str;
		}
		
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip  = new GZIPOutputStream(out);
			gzip.write(str.getBytes());
			gzip.close();
			return new String(out.toByteArray());
		}
		catch(IOException ex) {
			System.err.println("Compress String Error ocurred");
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Descomprime una cadena que haya sido comprimida con GZIP
	 * @param str Cadena que va a ser descomprimida
	 * @return Cadena descomprimida
	 */
	public static String decompress (String str) {
		if (str==null || str.isEmpty()) {
			return str;
		}
		
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
			GZIPInputStream gzip = new GZIPInputStream(in);
			ArrayList<Byte> bytes = new ArrayList<Byte>();
			int readed;
			while((readed = gzip.read())>-1) {
				if (readed>0) {
					bytes.add(new Byte((byte)readed));
				}
			}
			byte[] array = new byte [bytes.size()];
			for (int i=0; i<bytes.size(); i++)
				array[i]=bytes.get(i);
			String res = new String(array);
			return res;
		}
		catch(IOException ex) {
			System.err.println("Descompress String Error ocurred");
			ex.printStackTrace();
			return null;
		}
	}
}


