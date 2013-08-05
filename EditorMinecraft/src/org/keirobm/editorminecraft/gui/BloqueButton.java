package org.keirobm.editorminecraft.gui;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import org.keirobm.editorminecraft.model.Bloque;

public class BloqueButton extends JButton {
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private Bloque mBloque;

	

	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	public BloqueButton (String etiqueta, Bloque blq) {
		super(etiqueta);
		mBloque = blq;
	}

	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	public Bloque getBloque() {
		return mBloque;
	}

	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################


}
