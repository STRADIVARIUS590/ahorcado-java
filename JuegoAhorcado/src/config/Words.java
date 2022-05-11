package config;

public enum Words {
	 VALUES("ELEMENTO", "SECUENCIA", "MANZANA","GATO","ESTADIO","MESA","PERRO","GUITARRA",
//			 );
	"ORTOGONAL","TEMBLOR","CANTERA", "ORBITA", "TABLERO", "BATERIA","CUERDA","GALLO",
//			);
	"MARTILLO","MACETA","PERICO","VOLCAN", "TORMENTA", "RELOJ","BICICLETA", "ABRACADABRA", 
//	);
	"LIBRERO","JAVASCRIPT", "PUBLIC", "STATIC", "VOID", "GIGABIT", "PLASTICO", "OXIGENO","CARBONICO",
	
	"DINOSAURIO"
			 );
//	
	private final String[] palabras;
	
	Words(String... name) {
		this.palabras = name;
	}
	
	public String[] getArray(){
		return this.palabras;
	}
	
//	public void add(String r) {
//		this.palabras[this.palabras.length + 1] = r;
//	}
	 
}
