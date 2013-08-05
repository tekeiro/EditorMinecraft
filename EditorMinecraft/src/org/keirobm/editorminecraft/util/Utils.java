package org.keirobm.editorminecraft.util;

import java.awt.Color;

public class Utils {
	public static String colorToString (Color c) {
		String r = Integer.toHexString(c.getRed()).toUpperCase();
		if (r.length()<2)	r = "0" + r;
		String g = Integer.toHexString(c.getGreen()).toUpperCase();
		if (g.length()<2)	g = "0" + g;
		String b = Integer.toHexString(c.getBlue()).toUpperCase();
		if (b.length()<2)	b = "0" + b;
		return "0x" + r + g + b;
	}
}
