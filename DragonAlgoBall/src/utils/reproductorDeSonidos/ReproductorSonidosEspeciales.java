package utils.reproductorDeSonidos;

import java.util.HashMap;

import dab.estados.cell.CellBase;
import dab.estados.cell.CellPerfecto;
import dab.estados.cell.CellSemiPerfecto;
import dab.estados.freezer.FreezerBase;
import dab.estados.freezer.FreezerDefinitivo;
import dab.estados.freezer.FreezerSegundaForma;
import dab.estados.gohan.GohanBase;
import dab.estados.gohan.GohanSuperSayajinFase1;
import dab.estados.gohan.GohanSuperSayajinFase2;
import dab.estados.goku.GokuBase;
import dab.estados.goku.GokuKaioKen;
import dab.estados.goku.GokuSuperSayajin;
import dab.estados.majinBoo.MajinBooBase;
import dab.estados.majinBoo.MajinBooMalo;
import dab.estados.majinBoo.MajinBooOriginal;
import dab.estados.piccolo.PiccoloBase;
import dab.estados.piccolo.PiccoloFortalecido;
import dab.estados.piccolo.PiccoloProtector;

public class ReproductorSonidosEspeciales {
	
	@SuppressWarnings("serial")
	private final static HashMap<String, String> sonidera = new HashMap<String, String>() {{
		
	    put("ataqueNormal","/resources/sonidos/efectos/ataqueNormal.wav");
	    put("transformar","/resources/sonidos/efectos/transformacion.wav");
	    
	    put(CellBase.nombreId, "/resources/sonidos/efectos/absorcion.wav");
	    put(CellSemiPerfecto.nombreId, "/resources/sonidos/efectos/absorcion.wav");
	    put(CellPerfecto.nombreId, "/resources/sonidos/efectos/absorcion.wav");
	    
	    put(GokuBase.nombreId, "/resources/sonidos/efectos/kameHameHa.wav");
	    put(GokuKaioKen.nombreId, "/resources/sonidos/efectos/kameHameHa.wav");
	    put(GokuSuperSayajin.nombreId, "/resources/sonidos/efectos/kameHameHa.wav");
	    
	    put(MajinBooBase.nombreId, "/resources/sonidos/efectos/losHareChocolate.wav");
	    put(MajinBooMalo.nombreId, "/resources/sonidos/efectos/losHareChocolate.wav");
	    put(MajinBooOriginal.nombreId, "/resources/sonidos/efectos/losHareChocolate.wav");
	    
	    put(PiccoloBase.nombreId ,"/resources/sonidos/efectos/Makankosappo.wav");
	    put(PiccoloFortalecido.nombreId, "/resources/sonidos/efectos/Makankosappo.wav");
	    put(PiccoloProtector.nombreId, "/resources/sonidos/efectos/Makankosappo.wav");
	    
	    put(FreezerBase.nombreId, "/resources/sonidos/efectos/rayoMortal.wav");
	    put(FreezerDefinitivo.nombreId , "/resources/sonidos/efectos/rayoMortal.wav");
	    put(FreezerSegundaForma.nombreId, "/resources/sonidos/efectos/rayoMortal.wav");
	    
	    put(GohanBase.nombreId, "/resources/sonidos/efectos/masenko.wav");
	    put(GohanSuperSayajinFase1.nombreId, "/resources/sonidos/efectos/masenko.wav");
	    put(GohanSuperSayajinFase2.nombreId, "/resources/sonidos/efectos/masenko.wav");
	    
	    
	    
	    }
	};
	
	public static void reproducir(String identificadorSonido){
		
		ReproductorDeSonidos.playASound(sonidera.get(identificadorSonido));
		
	}
}