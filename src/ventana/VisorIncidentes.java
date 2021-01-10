package ventana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author Alex
 */
public class VisorIncidentes extends javax.swing.JFrame {
                    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    JXMapViewer mapViewer = new JXMapViewer();
    Set<SwingWaypoint> waypoints = new HashSet();
    WaypointPainter<SwingWaypoint> swingWaypointPainter = new SwingWaypointOverlayPainter();
    Datos misdatos = new Datos();
    Datos seleccionados = new Datos();
    ArrayList<Integer> posiciones = new ArrayList<>();
    int posicion = 0;

   
    public VisorIncidentes() {

        misdatos.cargarFichero();
        this.setTitle("Visor de incidentes de Nueva York");
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField(); //Fecha inicial
        jTextField2 = new javax.swing.JTextField(); //Fecha final
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField(); //incidentes
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Create a TileFactoryInfo for OSM
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(8);

        //JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setTileFactory(tileFactory);

        GeoPosition nuevayork = new GeoPosition(40.71427, -74.00597);

        // Add interactions
        /*MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));*/
        // Set the focus
        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(nuevayork);
        mapViewer.setSize(503, 296);
        mapViewer.setLocation(60, 50);
        this.getContentPane().add(mapViewer);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("FECHA FINAL:");

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 153, 255));
        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 153, 255));
        jButton3.setText("<<");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 153, 255));
        jButton1.setText("CONSULTAR");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Mes:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("# incidentes:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Barrio:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("FECHA INICIAL:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("INCIDENTES");
        jLabel1.setAlignmentX(0.5F);

        jTextField2.setToolTipText("año-mes en formato: YYYY-MM");
        jTextField1.setToolTipText("año-mes en formato: YYYY-MM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 503, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 296, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(65, 65, 65)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(jLabel1)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTextField1.equals("") || jTextField2.equals("")) {
            System.out.println("vacío");
        }
        mapViewer.removeAll();
        waypoints.clear();
        seleccionados.borrarArray();
        posiciones.clear();
        posicion = 0;
        if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {

            int i = 0;
            while (i < misdatos.getLineasFichero().size()) {
                String fecha = misdatos.getLineasFichero().get(i).getFecha();
                //System.out.println("fecha " + fecha);
                if (fecha.compareTo(jTextField1.getText()) >= 0 && fecha.compareTo(jTextField2.getText()) < 0) {

                    GeoPosition geo_temp = new GeoPosition(misdatos.getLineasFichero().get(i).getLatitud(), misdatos.getLineasFichero().get(i).getLongitud());
                    SwingWaypoint sw = new SwingWaypoint(misdatos.getLineasFichero().get(i).getBarrio(), geo_temp);
                    waypoints.add(sw);
                    seleccionados.setLinea(misdatos.getLineasFichero().get(i)); 
                }
                i++;
            }
        }
        
        cargarCombobox();

        jTextField4.setText(String.valueOf(waypoints.size()));
        jTextField3.setText("");
        // Set the overlay painter
        swingWaypointPainter.setWaypoints(waypoints);
        mapViewer.setOverlayPainter(swingWaypointPainter);

        // Add the JButtons to the map viewer
        for (SwingWaypoint w : waypoints) {
            mapViewer.add(w.getButton());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        mapViewer.removeAll();
        waypoints.clear();
        String fecha = "", anio_actual = "", mes_actual = "";

        if (posicion == 0) {

            if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {

                int i = 0;
                boolean iguales = true;
                posiciones.add(posicion);

                int tam = seleccionados.getLineasFichero().size();
                while (iguales && i < tam) {
                    
                    if (i == 0) {
                        //Guardo el primero
                        fecha = seleccionados.getLineasFichero().get(i).getFecha();
                        //System.out.println("If posicion==0 Posicion: "+posicion+" fecha del primero: " + fecha);
                        anio_actual = fecha.substring(0, 4);
                        mes_actual = fecha.substring(5, 7);
                    }

                    if (anio_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(0, 4))
                            && mes_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(5, 7))) {

                        //System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " igual a " + anio_actual + "-" + mes_actual);
                        GeoPosition geo_temp = new GeoPosition(seleccionados.getLineasFichero().get(i).getLatitud(), seleccionados.getLineasFichero().get(i).getLongitud());
                        SwingWaypoint sw = new SwingWaypoint(seleccionados.getLineasFichero().get(i).getBarrio(), geo_temp);
                        waypoints.add(sw);
                        jTextField3.setText(mes_actual);
                        jTextField4.setText(String.valueOf(i + 1));
                    } else {

                        posicion++;
                        posiciones.add(i);
                        //System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " no igual a " + anio_actual + "-" + mes_actual);
                        iguales = false;

                    }

                    i++;
                }

            }
            swingWaypointPainter.setWaypoints(waypoints);
            mapViewer.setOverlayPainter(swingWaypointPainter);

            // Add the JButtons to the map viewer
            for (SwingWaypoint w : waypoints) {
                mapViewer.add(w.getButton());
            }

        } else {

            if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {

                if (seleccionados.getLineasFichero().get(posiciones.get(posicion)).getFecha().compareTo(jTextField2.getText()) < 0) {

                    int i = posiciones.get(posicion);
                    int inicial = i;
                    fecha = seleccionados.getLineasFichero().get(i).getFecha();
                    System.out.println("Else "+i+" posicion: "+posicion+" fecha : " + fecha);
                    anio_actual = fecha.substring(0, 4);
                    mes_actual = fecha.substring(5, 7);

                    boolean iguales = true;

                    int tam = seleccionados.getLineasFichero().size();
                    while (iguales && i < tam) {
                        System.out.println("i= "+posicion);

                        if (anio_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(0, 4))
                                && mes_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(5, 7))) {

                            System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " igual a " + anio_actual + "-" + mes_actual);
                            GeoPosition geo_temp = new GeoPosition(seleccionados.getLineasFichero().get(i).getLatitud(), seleccionados.getLineasFichero().get(i).getLongitud());
                            SwingWaypoint sw = new SwingWaypoint(seleccionados.getLineasFichero().get(i).getBarrio(), geo_temp);
                            waypoints.add(sw);
                            jTextField3.setText(mes_actual);
                            jTextField4.setText(String.valueOf(i-inicial+1));
                        } else {

                            posicion++;
                            //if (posiciones.get(i)==null){
                                posiciones.add(i);
                           // }
                            System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " no igual a " + anio_actual + "-" + mes_actual);
                            iguales = false;

                        }

                        i++;

                    }
                }
                else posicion--;

            }
            
            swingWaypointPainter.setWaypoints(waypoints);
            mapViewer.setOverlayPainter(swingWaypointPainter);

            // Add the JButtons to the map viewer
            for (SwingWaypoint w : waypoints) {
                mapViewer.add(w.getButton());
            }

        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        mapViewer.removeAll();
        waypoints.clear();
        String fecha = "", anio_actual = "", mes_actual = "";

        if (posicion == 0) {

            if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {

                int i = 0;
                boolean iguales = true;
                posiciones.add(posicion);

                int tam = seleccionados.getLineasFichero().size();
                while (iguales && i < tam) {
                    
                    if (i == 0) {
                        //Guardo el primero
                        fecha = seleccionados.getLineasFichero().get(i).getFecha();
                        System.out.println("If posicion==0 Posicion: "+posicion+" fecha del primero: " + fecha);
                        anio_actual = fecha.substring(0, 4);
                        mes_actual = fecha.substring(5, 7);
                    }

                    if (anio_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(0, 4))
                            && mes_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(5, 7))) {

                        System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " igual a " + anio_actual + "-" + mes_actual);
                        GeoPosition geo_temp = new GeoPosition(seleccionados.getLineasFichero().get(i).getLatitud(), seleccionados.getLineasFichero().get(i).getLongitud());
                        SwingWaypoint sw = new SwingWaypoint(seleccionados.getLineasFichero().get(i).getBarrio(), geo_temp);
                        waypoints.add(sw);
                        jTextField3.setText(mes_actual);
                        jTextField4.setText(String.valueOf(i + 1));
                    } else {

                        iguales = false;

                    }

                    i++;
                }

            }
            swingWaypointPainter.setWaypoints(waypoints);
            mapViewer.setOverlayPainter(swingWaypointPainter);

            // Add the JButtons to the map viewer
            for (SwingWaypoint w : waypoints) {
                mapViewer.add(w.getButton());
            }

        } else {

            if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {

                if (seleccionados.getLineasFichero().get(posiciones.get(posicion)).getFecha().compareTo(jTextField2.getText()) < 0) {
                    
                    int i = posiciones.get(posicion)-1;
                    fecha = seleccionados.getLineasFichero().get(i).getFecha();
                    System.out.println("Else "+i+" posicion: "+posicion+" fecha: " + fecha);
                    anio_actual = fecha.substring(0, 4);
                    mes_actual = fecha.substring(5, 7);

                    
                    int anterior = posiciones.get(posicion-1);
                    System.out.println("anterior es "+anterior);
                    jTextField3.setText(mes_actual);
                    jTextField4.setText(String.valueOf(i-anterior+1));
                    while (i >= anterior) {
                        System.out.println("i= "+i+" mayor que "+anterior);
                        mostrarPosiciones();
                        if (anio_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(0, 4))
                                && mes_actual.equals(seleccionados.getLineasFichero().get(i).getFecha().substring(5, 7))) {

                            System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " igual a " + anio_actual + "-" + mes_actual);
                            GeoPosition geo_temp = new GeoPosition(seleccionados.getLineasFichero().get(i).getLatitud(), seleccionados.getLineasFichero().get(i).getLongitud());
                            SwingWaypoint sw = new SwingWaypoint(seleccionados.getLineasFichero().get(i).getBarrio(), geo_temp);
                            waypoints.add(sw);

                                                       
                        } else {

                            posicion--;
                           
                            System.out.println(seleccionados.getLineasFichero().get(i).getFecha() + " no igual a " + anio_actual + "-" + mes_actual);
                           

                        }
                        i--;
                        

                    }
                   
                }
                posicion--;

            }
            
            swingWaypointPainter.setWaypoints(waypoints);
            mapViewer.setOverlayPainter(swingWaypointPainter);

            // Add the JButtons to the map viewer
            for (SwingWaypoint w : waypoints) {
                mapViewer.add(w.getButton());
            }

        }
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
          
    }  
    
    private void mostrarPosiciones(){
        for (int i = 0; i < posiciones.size(); i++) {
            System.out.println("posicion i: "+i+"="+posiciones.get(i));
        }
    }
    
    private void cargarCombobox(){
        
        ArrayList<String> temp = new ArrayList<>();
        
        for (int i = 0; i < seleccionados.getLineasFichero().size(); i++) {
            String s = seleccionados.getLineasFichero().get(i).getBarrio();
            if (!temp.contains(s)){
                temp.add(s);
            }
        }
        Collections.sort(temp);
        String[] temp_str = new String[temp.size()];
        
        for (int i = 0; i < temp_str.length; i++) {
            temp_str[i]=temp.get(i);
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(temp_str));
    }

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisorIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new VisorIncidentes().setVisible(true);
            }
        });
    }

}
