package org.keirobm.editorminecraft.model;

/**
 * Representa los bloques que pueden colocarse
 * @author Angel
 *
 */
public enum Bloque {
	//--------- TERRENO ----------
	TIERRA(0,0,2,Categorias.TERRENO,Tipo.BASE),
	CESPED(1,11,8,Categorias.TERRENO,Tipo.BASE),
	GRAVA(2,1,3,Categorias.TERRENO,Tipo.BASE),
	PIEDRA(3,0,1,Categorias.TERRENO,Tipo.BASE),
	ARENA(4,1,2,Categorias.TERRENO,Tipo.BASE),
	NIEVE(5,4,2,Categorias.TERRENO,Tipo.BASE),
	AGUA_CLARA(6,13,8,Categorias.TERRENO,Tipo.BASE),
	AGUA_PROFUNDA(7,12,8,Categorias.TERRENO,Tipo.BASE),
	HIELO(8,13,7,Categorias.TERRENO,Tipo.BASE),
	ROCA_MUSGO(9,2,4,Categorias.TERRENO,Tipo.BASE),
	LAVA(10,14,13,Categorias.TERRENO,Tipo.BASE),
	ARENISCA(11,12,0,Categorias.TERRENO,Tipo.BASE),
	ROCA_END(12,10,15,Categorias.TERRENO,Tipo.BASE),
	ROCA_NETHER(13,6,7,Categorias.TERRENO,Tipo.BASE),
	SOUL_SAND(14,6,8,Categorias.TERRENO,Tipo.BASE),
	BEDROCK(15,1,1,Categorias.TERRENO,Tipo.BASE),
	MICELIO(16,4,14,Categorias.TERRENO,Tipo.BASE),
	HIERBA(17,0,3,Categorias.TERRENO,Tipo.BASE),
	
	//----- MINERALES ------	
	BL_ORO(18,1,7,Categorias.MINERALES),
	BL_LAPIZ(19,9,0,Categorias.MINERALES),
	BL_DIAMANTE(20,1,8,Categorias.MINERALES),
	BL_ESMERALDA(21,1,9,Categorias.MINERALES),
	BL_HIERRO(22,1,6,Categorias.MINERALES),
        ORE_HIERRO(23,1,1,Categorias.MINERALES,Tipo.BASE),
        ORE_CARBON(24,1,2,Categorias.MINERALES,Tipo.BASE),
        ORE_ORO(25,2,0,Categorias.MINERALES,Tipo.BASE),
        ORE_LAPIZ(26,10,0,Categorias.MINERALES,Tipo.BASE),
        ORE_REDSTONE(27,3,3,Categorias.MINERALES,Tipo.BASE),
        ORE_DIAMANTE(28,3,2,Categorias.MINERALES,Tipo.BASE),
        ORE_ESMERALDA(29,10,11,Categorias.MINERALES,Tipo.BASE),
        OBSIDIANA(30,2,5,Categorias.MINERALES,Tipo.BASE),
    
        
        //-----  CONSTRUCCION -----
        LADRILLO(31,0,7,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_DOBLE(32,0,5,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_PIEDRA(33,3,6,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_ESPIRAL(34,13,5,Categorias.CONSTRUCCION,Tipo.BASE),
        ROCA(35,1,0,Categorias.CONSTRUCCION,Tipo.BASE),
        MADERA(36,0,4,Categorias.CONSTRUCCION,Tipo.BASE),
        MADERA_OSCURA(37,12,6,Categorias.CONSTRUCCION,Tipo.BASE),
        MADERA_SELVA(38,12,7,Categorias.CONSTRUCCION,Tipo.BASE),
        MADERA_CLARA(39,13,6,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_ARENA(40,14,5,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_NETHER(41,14,0,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_MUSGO(42,6,4,Categorias.CONSTRUCCION,Tipo.BASE),
        LADRILLO_ROTO(43,6,5,Categorias.CONSTRUCCION,Tipo.BASE),
        TRONCO_SETA(44,8,13,Categorias.CONSTRUCCION,Tipo.BASE),
        BLQ_SETA_ROJA(45,7,13,Categorias.CONSTRUCCION,Tipo.BASE),
        BLQ_SETA_MARRON(46,7,14,Categorias.CONSTRUCCION,Tipo.BASE),
        TRONCO_MADERA(47,1,4,Categorias.CONSTRUCCION,Tipo.BASE),
        TRONCO_MADERA_OSCURA(48,7,4,Categorias.CONSTRUCCION,Tipo.BASE),
        TRONCO_MADERA_BLANCA(49,7,5,Categorias.CONSTRUCCION,Tipo.BASE),
        TRONCO_MADERA_SELVA(50,9,9,Categorias.CONSTRUCCION,Tipo.BASE),
        CRISTAL(51,3,1,Categorias.CONSTRUCCION),
        
        //------  MUEBLES ---------
        MESA_CRAFTING(52,3,12,Categorias.MUEBLES),
        HORNO(53,3,13,Categorias.MUEBLES),
        LIBRERIA(54,2,3,Categorias.MUEBLES),
        DISPENSADOR(55,2,14,Categorias.MUEBLES),
        TOCADISCOS(56,4,10,Categorias.MUEBLES),
        TRAMPILLA(57,5,4,Categorias.MUEBLES,Tipo.APILABLE),
        ESCALERA(58,5,3,Categorias.MUEBLES,Tipo.APILABLE),
        MESA_ENCANTAMIENTOS(59,11,6,Categorias.MUEBLES,Tipo.APILABLE),
        COFRE(60,0,14,Categorias.MUEBLES),
        VALLA_HIERRO(61,5,5,Categorias.MUEBLES,Tipo.APILABLE),
        ESCALON_MADERA_IZQ(62,11,13,Categorias.MUEBLES,Tipo.APILABLE),
        ESCALON_MADERA_DRH(63,11,14,Categorias.MUEBLES,Tipo.APILABLE),
        ESCALON_ROCA_IZQ(64,12,13,Categorias.MUEBLES,Tipo.APILABLE),
        ESCALON_ROCA_DRH(65,12,14,Categorias.MUEBLES,Tipo.APILABLE),
        ANTORCHA(66,5,0,Categorias.MUEBLES,Tipo.APILABLE),
        LAMPARA(67,6,9,Categorias.MUEBLES),
        LAMPARA_REDSTONE(68,13,4,Categorias.MUEBLES),
        MESA_BREBAJES(69,9,13,Categorias.MUEBLES,Tipo.APILABLE),
        PISTON(70,6,13,Categorias.MUEBLES),
        PUERTA_MADERA_1(71,6,1,Categorias.MUEBLES),
        PUERTA_MADERA_2(72,5,1,Categorias.MUEBLES),
        PUERTA_HIERRO_1(73,6,2,Categorias.MUEBLES),
        PUERTA_HIERRO_2(74,5,2,Categorias.MUEBLES),
        PUERTA_MAD_IZQ_1(75,11,9,Categorias.MUEBLES),
        PUERTA_MAD_IZQ_2(76,11,10,Categorias.MUEBLES),
        PUERTA_MAD_DRH_1(77,12,10,Categorias.MUEBLES),
        PUERTA_MAD_DRH_2(78,12,9,Categorias.MUEBLES),
        PUERTA_HRR_IZQ_1(79,13,9,Categorias.MUEBLES),
        PUERTA_HRR_IZQ_2(80,13,10,Categorias.MUEBLES),
        PUERTA_HRR_DRH_1(81,14,10,Categorias.MUEBLES),
        PUERTA_HRR_DRH_2(82,14,9,Categorias.MUEBLES),
        CAMA_IZQ_1(83,8,6,Categorias.MUEBLES),
        CAMA_IZQ_2(84,8,7,Categorias.MUEBLES),
        CAMA_ARR_1(85,12,11,Categorias.MUEBLES),
        CAMA_ARR_2(86,11,11,Categorias.MUEBLES),
        CAMA_ABJ_1(87,11,12,Categorias.MUEBLES),
        CAMA_ABJ_2(88,12,12,Categorias.MUEBLES),
        CAMA_DRH_1(89,13,12,Categorias.MUEBLES),
        CAMA_DRH_2(90,13,11,Categorias.MUEBLES),
        FUENTE(91,9,10,Categorias.MUEBLES,Tipo.APILABLE),
        
        //---------  INGENIERIA  -------------
        ANTORCHA_REDSTONE(92,6,3,Categorias.INGENIERIA,Tipo.APILABLE),
        RAIL(93,8,0,Categorias.INGENIERIA,Tipo.APILABLE),
        RAIL_IZQ(94,15,0,Categorias.INGENIERIA,Tipo.APILABLE),
        SPAWNER(95,4,1,Categorias.INGENIERIA,Tipo.APILABLE),
        REPETIDOR(96,9,3,Categorias.INGENIERIA),
        RAIL_RDS(97,11,3,Categorias.INGENIERIA,Tipo.APILABLE),
        RAIL_RDS_IZQ(98,15,1,Categorias.INGENIERIA,Tipo.APILABLE),
        RAIL_DETECTOR(99,12,3,Categorias.INGENIERIA,Tipo.APILABLE),
        RAIL_DETECTOR_IZQ(100,15,2,Categorias.INGENIERIA,Tipo.APILABLE),
        TNT(101,0,8,Categorias.INGENIERIA),
        CABLE(102,15,4,Categorias.INGENIERIA,Tipo.APILABLE),
        CABLE_IZQ(103,15,3,Categorias.INGENIERIA,Tipo.APILABLE),
        CABLE_CRUCE(104,15,5,Categorias.INGENIERIA,Tipo.APILABLE),
        
        //-----------  JARDINERIA  ---------------
        FLOR_ROJA(105,0,12,Categorias.JARDINERIA,Tipo.APILABLE),
        FLOR_AMARILLA(106,0,13,Categorias.JARDINERIA,Tipo.APILABLE),
        BROTE_ARBOL(107,0,15,Categorias.JARDINERIA,Tipo.APILABLE),
        BROTE_ARBOL_SELVA(108,1,14,Categorias.JARDINERIA,Tipo.APILABLE),
        SETA_ROJA(109,1,12,Categorias.JARDINERIA,Tipo.APILABLE),
        SETA_MARRON(110,1,13,Categorias.JARDINERIA,Tipo.APILABLE),
        BROTE_ARBOL_OSCURO(111,3,15,Categorias.JARDINERIA,Tipo.APILABLE),
        BROTE_ARBOL_CLARO(112,4,15,Categorias.JARDINERIA,Tipo.APILABLE),
        CACTUS(113,4,6,Categorias.JARDINERIA,Tipo.APILABLE),
        CAÑA(114,4,9,Categorias.JARDINERIA,Tipo.APILABLE),
        TRIGO(115,5,15,Categorias.JARDINERIA,Tipo.APILABLE),
        BROTE_SECO(116,3,7,Categorias.JARDINERIA,Tipo.APILABLE),
        TIERRA_CULTIVADA(117,5,6,Categorias.JARDINERIA),
        CALABAZA(118,7,7,Categorias.JARDINERIA),
        JACKOLANTERN(119,7,8,Categorias.JARDINERIA),
        MELON(120,8,8,Categorias.JARDINERIA),
        VERRUGAS(121,14,4,Categorias.JARDINERIA,Tipo.APILABLE),
        CACAO(122,15,6,Categorias.JARDINERIA,Tipo.APILABLE),
        TARTA(123,7,9,Categorias.JARDINERIA,Tipo.APILABLE),
        
        
        //------------  GANADERIA  -------------------
        LANA_NEGRA(124,7,1,Categorias.GANADERIA),
        LANA_GRIS(125,7,2,Categorias.GANADERIA),
        LANA_ROJA(126,8,1,Categorias.GANADERIA),
        LANA_ROSA(127,8,2,Categorias.GANADERIA),
        LANA_VERDE_OSC(128,9,1,Categorias.GANADERIA),
        LANA_VERDE(129,9,2,Categorias.GANADERIA),
        LANA_CACAO(130,10,1,Categorias.GANADERIA),
        LANA_AMARILLA(131,10,2,Categorias.GANADERIA),
        LANA_LAPIZ(132,11,1,Categorias.GANADERIA),
        LANA_AZUL_CLARO(133,11,2,Categorias.GANADERIA),
        LANA_PURPURA(134,12,1,Categorias.GANADERIA),
        LANA_FUCSIA(135,12,2,Categorias.GANADERIA),
        LANA_CYAN(136,13,1,Categorias.GANADERIA),
        LANA_NARANJA(137,13,2,Categorias.GANADERIA),
        LANA_GRIS_OSC(138,14,1,Categorias.GANADERIA),
        LANA_BLANCA(139,4,0,Categorias.GANADERIA),
        POLLO(140,1,15,Categorias.GANADERIA,Tipo.APILABLE),
        OVEJA(141,2,15,Categorias.GANADERIA,Tipo.APILABLE),
        CERDO(142,8,15,Categorias.GANADERIA,Tipo.APILABLE),
        VACA(143,11,15,Categorias.GANADERIA,Tipo.APILABLE),
	//TODO Seguir con los demas bloques
        
        
        //------ Nuevos bloques v1.1------------
        EMBUDO(144,16,0,Categorias.INGENIERIA,Tipo.APILABLE),
	BEACON(145,16,1,Categorias.INGENIERIA,Tipo.APILABLE),
        ZANAHORIAS(146,16,2,Categorias.JARDINERIA,Tipo.APILABLE),
        ARCILLA(147,16,3,Categorias.CONSTRUCCION,Tipo.BASE),
        BLQ_CARBON(148,16,4,Categorias.MINERALES,Tipo.BASE),
        BLQ_COMANDO(149,16,5,Categorias.INGENIERIA,Tipo.NORMAL),
        COMPARADOR_OFF(150,16,6,Categorias.INGENIERIA,Tipo.NORMAL),
        COMPARADOR_ON(151,16,7,Categorias.INGENIERIA,Tipo.NORMAL),
        DETECTOR_LUZ_OFF(152,16,8,Categorias.INGENIERIA,Tipo.NORMAL),
        DETECTOR_LUZ_ON(153,16,9,Categorias.INGENIERIA,Tipo.NORMAL),
        ARBUSTO(154,16,10,Categorias.JARDINERIA,Tipo.APILABLE),
        SOLTADOR(155,16,12,Categorias.INGENIERIA,Tipo.NORMAL),
        MACETA(156,16,13,Categorias.JARDINERIA,Tipo.APILABLE),
        ARCILLA_DURA(157,16,14,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_NEGRA(158,16,15,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_AZUL(159,17,0,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_MARRON(160,17,1,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_CYAN(161,17,2,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_GRIS(162,17,3,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_VERDE(163,17,4,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_AZULCLARO(164,17,5,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_LIMA(165,17,6,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_MAGENTA(166,17,7,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_NARANJA(167,17,8,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_ROSA(168,17,9,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_MORADA(169,17,10,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_ROJA(170,17,11,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_PLATEADA(171,17,12,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_BLANCA(172,17,13,Categorias.CONSTRUCCION,Tipo.BASE),
        ARCILLA_DURA_AMARILLA(173,17,14,Categorias.CONSTRUCCION,Tipo.BASE),
        HENO(174,17,15,Categorias.JARDINERIA,Tipo.NORMAL),
        HENO_TOP(175,18,0,Categorias.JARDINERIA,Tipo.NORMAL),
        MARCO(176,18,1,Categorias.MUEBLES,Tipo.NORMAL),
        PATATA(177,18,2,Categorias.JARDINERIA,Tipo.APILABLE),
        CUARZO(178,18,3,Categorias.MINERALES,Tipo.BASE),
        CUARZO_LAB_1(179,18,4,Categorias.CONSTRUCCION,Tipo.BASE),
        CUARZO_LAB_2(180,18,5,Categorias.CONSTRUCCION,Tipo.BASE),
        CUARZO_RAYAS(181,18,6,Categorias.CONSTRUCCION,Tipo.BASE),
        CUARZO_FIG(182,18,7,Categorias.CONSTRUCCION,Tipo.BASE),
        CUARZO_2(183,18,8,Categorias.MINERALES,Tipo.BASE),
        CUARZO_ORE(184,18,9,Categorias.MINERALES,Tipo.BASE),
        BLQ_REDSTONE(185,18,10,Categorias.MINERALES,Tipo.BASE)
        
        ;
        
	
	
	//------- Definicion de Clase ----------
        //###########################################################
	//##				ENUMERATIONS		  ###
	//###########################################################
        public static enum Tipo {
            NORMAL,
            BASE,
            APILABLE
        }
        
	//###########################################################
	//##				MEMBERS							  	  ###
	//###########################################################
	private int mId = 0;
	private int mFila = 0;
	private int mColumna = 0;
	private Categorias mCategoria = Categorias.TERRENO;
        private Tipo mTipo = Tipo.NORMAL;
	
	public static final int ANCHO = 16;
	public static final int ALTO = 16;
	
	
	//###########################################################
	//##				CONSTRUCTORS					  	  ###
	//###########################################################
	/**
	 * Constructor del Bloque
	 * @param id Id del bloque
	 * @param fila Fila del bloque en el spritesheet de los bloques
	 * @param columna Columna del bloque en el spritesheet de los bloques
	 * @param categoria Categoria del bloque
	 */
	private Bloque (int id, int fila, int columna, Categorias categoria) {
		mId = id;
		mFila = fila;
		mColumna = columna;
		mCategoria = categoria;
	}
        
        /**
	 * Constructor del Bloque
	 * @param id Id del bloque
	 * @param fila Fila del bloque en el spritesheet de los bloques
	 * @param columna Columna del bloque en el spritesheet de los bloques
	 * @param categoria Categoria del bloque
         * @param tipo_bloque Tipo del Bloque
	 */
	private Bloque (int id, int fila, int columna, Categorias categoria, Tipo tipo_bloque) {
		mId = id;
		mFila = fila;
		mColumna = columna;
		mCategoria = categoria;
                mTipo = tipo_bloque;
	}
	
	//###########################################################
	//##				PROPERTIES						  	  ###
	//###########################################################
	/**
	 * Obtiene el ID del Bloque
	 * @return Id del Bloque
	 */
	public int getId() {
		return mId;
	}
	
	/**
	 * Obtiene la fila del Bloque
	 * @return Fila del Bloque
	 */
	public int getFila() {
		return mFila;
	}
	
	/**
	 * Obtiene la columna del Bloque
	 * @return Columna del Bloque
	 */
	public int getColumna() {
		return mColumna;
	}
	
	/**
	 * Obtiene la categoria del Bloque
	 * @return Categoria del Bloque
	 */
	public Categorias getCategoria() {
		return mCategoria;
	}
        
        public Tipo getTipo() {
            return mTipo;
        }
	
	//###########################################################
	//##				METHODS							  	  ###
	//###########################################################
	
	
}
