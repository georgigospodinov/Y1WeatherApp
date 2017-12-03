import javax.swing.ImageIcon;

/**
 * Defines interaction with user.
 *
 * @version 2.0
 * @author 150009974
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main () {
        initComponents ();

        super.setLocationRelativeTo ( null );
        super.setTitle ( "Weather information" );
        super.setResizable ( false );
        super.getRootPane ().setDefaultButton ( getWeatherButton );
        super.setDefaultCloseOperation ( EXIT_ON_CLOSE );

        enterCityNameLabel.setVisible ( false );
        cityTextField.setVisible ( false );
        longitudeTextField.setVisible ( false );
        lonLabel.setVisible ( false );

    }

    // This method is called from within the constructor to initialize the form. 
    @SuppressWarnings ("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionButtonGroup = new javax.swing.ButtonGroup();
        typeButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        getWeatherButton = new javax.swing.JButton();
        enterCityNameLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        resultsLabel = new javax.swing.JLabel();
        cityRadioButton = new javax.swing.JRadioButton();
        coordinatesRadioButton = new javax.swing.JRadioButton();
        locationChoosingLabel = new javax.swing.JLabel();
        chooseInformationTypeLabel = new javax.swing.JLabel();
        weatherRadioButton = new javax.swing.JRadioButton();
        forecastRadioButton = new javax.swing.JRadioButton();
        lonLabel = new javax.swing.JLabel();
        longitudeTextField = new javax.swing.JTextField();
        imgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getWeatherButton.setText("Get weather!");
        getWeatherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getWeatherButtonMousePressed(evt);
            }
        });
        getWeatherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getWeatherButtonActionPerformed(evt);
            }
        });

        enterCityNameLabel.setText("Enter city name:");

        cityTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cityTextFieldMousePressed(evt);
            }
        });

        resultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultsLabel.setText("Ready to receive a query");
        resultsLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        optionButtonGroup.add(cityRadioButton);
        cityRadioButton.setText("City");
        cityRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cityRadioButtonStateChanged(evt);
            }
        });

        optionButtonGroup.add(coordinatesRadioButton);
        coordinatesRadioButton.setText("Coordinates");
        coordinatesRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                coordinatesRadioButtonStateChanged(evt);
            }
        });

        locationChoosingLabel.setText("<html>\nWhat would you like to<br>\nretrieve information about?\n<html>");

        chooseInformationTypeLabel.setText("Choose information type:");

        typeButtonGroup.add(weatherRadioButton);
        weatherRadioButton.setText("<html>\nCurrent<br>\nweather\n<html>");

        typeButtonGroup.add(forecastRadioButton);
        forecastRadioButton.setText("<htmL>5-day<br>forecast<html>");

        lonLabel.setText("Longitude:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cityTextField)
                                    .addComponent(locationChoosingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(chooseInformationTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterCityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cityRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weatherRadioButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(forecastRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(coordinatesRadioButton)))
                                    .addComponent(longitudeTextField)
                                    .addComponent(lonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(getWeatherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(chooseInformationTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weatherRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forecastRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationChoosingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinatesRadioButton)
                    .addComponent(cityRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterCityNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(longitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(getWeatherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getWeatherButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getWeatherButtonMousePressed
        resultsLabel.setText ( getWeatherResult () );
    }//GEN-LAST:event_getWeatherButtonMousePressed

    private void cityTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cityTextFieldMousePressed
        cityTextField.selectAll ();
    }//GEN-LAST:event_cityTextFieldMousePressed

    private void getWeatherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getWeatherButtonActionPerformed
        resultsLabel.setText ( getWeatherResult () );
    }//GEN-LAST:event_getWeatherButtonActionPerformed

    private void cityRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cityRadioButtonStateChanged
        boolean selected = cityRadioButton.isSelected ();
        if ( !selected )//already clicked
            return;

        String labelTxt = "<html>Enter city<br>";
        labelTxt += "(enter country code<br>if needed)";
        labelTxt += "<html>";

        if ( enterCityNameLabel.getText ().equals ( labelTxt ) )//values are already set
            return;

        cityTextField.setText ( "" );
        enterCityNameLabel.setText ( labelTxt );
        cityTextField.setVisible ( selected );
        enterCityNameLabel.setVisible ( selected );

        longitudeTextField.setText ( "" );
        longitudeTextField.setVisible ( !selected );
        lonLabel.setVisible ( !selected );
    }//GEN-LAST:event_cityRadioButtonStateChanged

    private void coordinatesRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_coordinatesRadioButtonStateChanged
        boolean selected = coordinatesRadioButton.isSelected ();
        if ( !selected )//already clicked
            return;

        if ( enterCityNameLabel.getText ().equals ( "Latitude" ) )//values are already set
            return;

        cityTextField.setText ( "" );
        enterCityNameLabel.setText ( "Latitude" );
        cityTextField.setVisible ( selected );
        enterCityNameLabel.setVisible ( selected );

        longitudeTextField.setText ( "" );
        longitudeTextField.setVisible ( selected );
        lonLabel.setVisible ( selected );
    }//GEN-LAST:event_coordinatesRadioButtonStateChanged

    public static void main ( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels () )
                if ( "Nimbus".equals ( info.getName () ) ) {
                    javax.swing.UIManager.setLookAndFeel ( info.getClassName () );
                    break;
                }
        }
        catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger ( Main.class.getName () ).log ( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater ( new Runnable () {
            public void run () {
                Main m = new Main ();
                m.setVisible ( true );
            }

        } );
    }

    private String getWeatherResult () {

        //if rest of values are set
        //weather=1 day
        //forecast=5 days
        String option;

        if ( weatherRadioButton.isSelected () )
            option = "weather";
        else if ( forecastRadioButton.isSelected () )
            option = "forecast";
        else
            return "Please, select an inforamtion type.";

        RESTClient client;

        if ( cityRadioButton.isSelected () ) {
            String location = cityTextField.getText ();

            if ( location != null && !location.equals ( "" ) ) {
                resultsLabel.setText ( "Location accepted! Loading..." );
                client = new RESTClient ( option, location );
            }
            else
                return "Please, enter a location";
        }
        else if ( coordinatesRadioButton.isSelected () ) {
            double lat, lon;
            try {
                lat = Double.parseDouble ( cityTextField.getText () );
                lon = Double.parseDouble ( longitudeTextField.getText () );
                resultsLabel.setText ( "Coordinates accepted! Loading..." );
                client = new RESTClient ( option, lat, lon );
            }
            catch ( NumberFormatException e ) {
                return "Incorrect number format. Please, try again.";
            }
        }
        else
            return "Please, select an input option";

        String information = client.processReadData ();
        if ( client.getStatus () != null )
            switch ( client.getStatus () ) {
                case RAIN:
                    imgLabel.setIcon ( new ImageIcon ( "rain.jpg" ) );
                    break;
                case CLOUDS:
                    imgLabel.setIcon ( new ImageIcon ( "clouds.jpg" ) );
                    break;
                case SUNNY:
                    imgLabel.setIcon ( new ImageIcon ( "sunny.jpg" ) );
                    break;
                default:
                    //imgLabel.setIcon ( new ImageIcon ("graph.jpg"));
                    int[] yCoords = client.getScaledTemps ();
                    showTempChange ( yCoords );

                    break;
            }
        return information;

    }

    /**
     * Uses Canvas to show the temperature change over five days.
     *
     * @param yCoords - the temperatures converted to scale 0 to 500
     */
    private void showTempChange ( int[] yCoords ) {
        int width = 450;
        int height = 500;
        SimpleCanvas sc = new SimpleCanvas ( width, height );
        sc.setPointBlack ( 50, yCoords[0] );
        for ( int i = 1; i < 5; i++ ) {

            int x = ( i + 1 ) * 100 - 50;
            int y = yCoords[i];
            sc.setPointBlack ( x, y );

            int previousX = i * 100 - 50;
            int previousY = yCoords[i - 1];

            //build the line from previous point to current point (a.x + b)
            double a = ( ( y - previousY ) * 1.0 ) / ( ( x - previousX ) * 1.0 );
            double b = y - a * x;

            for ( int xi = previousX; xi < x; xi++ ) {
                int yi = (int) ( a * xi + b );
                sc.setPointBlack ( xi, yi );
            }
        }
    }

    //generated
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseInformationTypeLabel;
    private javax.swing.JRadioButton cityRadioButton;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JRadioButton coordinatesRadioButton;
    private javax.swing.JLabel enterCityNameLabel;
    private javax.swing.JRadioButton forecastRadioButton;
    private javax.swing.JButton getWeatherButton;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel locationChoosingLabel;
    private javax.swing.JLabel lonLabel;
    private javax.swing.JTextField longitudeTextField;
    private javax.swing.ButtonGroup optionButtonGroup;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    private javax.swing.JRadioButton weatherRadioButton;
    // End of variables declaration//GEN-END:variables
}
