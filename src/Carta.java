
import java.applet.AudioClip;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GX505DT
 */
public class Carta extends Thread {

    Ventana puntero;

    public Carta(Ventana p) {
        puntero = p;
    }

    String[] carta = {"El Gallo", "El Diablito", "La Dama", "El Catrín", "El Paraguas", "La Sirena",
        "La Escalera", "La Botella", "El Barril", "El Árbol", "El Melón", "El Valiente", "El Gorrito",
        "La Muerte", "La Pera", "La Bandera", "El Bandolón", "El Violoncello", "La Garza", "El Pájaro",
        "La Mano", "La Bota", "La Luna", "El Cotorro", "El Borracho", "El Negrito", "El Corazón", "La Sandía",
        "El Tambor", "El Camarón", "Las Jaras", "El Músico", "La Araña", "El Soldado", "La Estrella", "El Cazo",
        "El Mundo", "El Apache", "El Nopal", "El Alacrán", "La Rosa", "La Calavera", "La Campana", "El Cantarito",
        "El Venado", "El Sol", "La Corona", "La Chalupa", "El Pino", "El Pescado", "La Palma", "La Maceta",
        "El Arpa", "La Rana"};
    int contador;
    boolean[] repetido = new boolean[54];
    boolean ini, ej, desp;
    int[] mazo = new int[54];
    AudioClip audio[];
    String imagen[];
    
    private void desc(int val) {
        try {
            sleep(val);
        } catch (InterruptedException ex) {
        }
    }
    
    private boolean yaHay(int valor) {
        for (int dato : mazo) {
            if (valor == dato) {
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < 54; i++) {
            repetido[i] = true;
        }

        while (contador < 54) {
            int valor = (int) (Math.random() * 54 + 1);

            if (!yaHay(valor)) {

                mazo[contador] = valor;
                contador++;

            }
            puntero.jLabel1.setText("BARAJEANDO CARTA " + (contador) + " de 54");
            desc(20);

        }

        audio = new AudioClip[54];
        imagen = new String[54];

        for (int i = 0; i < 54; i++) {
            //int v = i++;
            String nombre = "/Sonidos/" + mazo[i] + ".wav";

            audio[i] = java.applet.Applet.newAudioClip(getClass().getResource(nombre));
            imagen[i] = "/Imágenes/" + mazo[i] + ".png";

            if (imagen[i].equals("/Imágenes/25.png")) {
                imagen[i] = "/cartas/imagen/25.jpg";
            }
        }

        contador = 0;
        while (contador < 53) {

            if (ini) {

                audio[contador].play();
                puntero.imagen (imagen[contador], carta[contador]);
                desc(2000);
                contador++;
            }
            desc(20);
        }

    }
}
