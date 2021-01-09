package ventana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alex
 */
public class Datos {

    private final ArrayList<LineaFichero> lineasFichero = new ArrayList();

    public  ArrayList<LineaFichero> getLineasFichero() {
        return lineasFichero;
    }
    
    public void borrarArray(){
        lineasFichero.clear();
    }
    
    public void setLinea(LineaFichero lf){
        
        lineasFichero.add(lf);
    }
            

    public  void cargarFichero() {

        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Documents\\NetBeansProjects\\VisorIncidentes\\incidents2.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {

                String[] splited = strCurrentLine.split(",");

                String fecha = splited[0];
                double longitud = Double.parseDouble(splited[1]);
                double latitud = Double.parseDouble(splited[2]);
                String barrio = splited[3];
                LineaFichero lf = new LineaFichero();
                lf.setFecha(fecha);
                lf.setLongitud(longitud);
                lf.setLatitud(latitud);
                lf.setBarrio(barrio);
                lineasFichero.add(lf);

            }
        } catch (IOException e) {
        } finally {
            try {
                if (objReader != null) {
                    objReader.close();
                }
            } catch (IOException ex) {
            }

        }
        
           Collections.sort(lineasFichero, 
                        (o1, o2) -> o1.getFecha().compareTo(o2.getFecha()));
    }

    public  void mostrarLineasFichero() {

        for (int i = 0; i < lineasFichero.size(); i++) {
            System.out.println(lineasFichero.get(i).getFecha() + "  " + lineasFichero.get(i).getLongitud() + "  " + lineasFichero.get(i).getLatitud() + " " + lineasFichero.get(i).getBarrio());
        }
    }
}
