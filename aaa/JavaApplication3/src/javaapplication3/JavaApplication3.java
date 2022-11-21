package javaapplication3;

import java.awt.Image;
import javax.swing.*;
import java.awt.image.ImageObserver;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Max Salizar
 */
public class JavaApplication3 extends javax.swing.JFrame {
    String E;
    String n1,n2,s;
    public JavaApplication3() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setTitle("SIMULADOR ALU");   
    }

    @SuppressWarnings("unchecked")
                   
    private void initComponents() {
        //btn1ActionPerformed
        Conversiones = new javax.swing.ButtonGroup();
        numero1 = new javax.swing.JTextField();
        numero2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        opthex = new javax.swing.JRadioButton();
        optdec = new javax.swing.JRadioButton();
        optoct = new javax.swing.JRadioButton();
        optbin = new javax.swing.JRadioButton();
        convert1 = new javax.swing.JTextField();
        convert2 = new javax.swing.JTextField();     
        btnbin = new javax.swing.JButton();        
        buC = new javax.swing.JButton();       
        bumen = new javax.swing.JButton();
        buCE = new javax.swing.JButton();
        bumas = new javax.swing.JButton();
        buent = new javax.swing.JButton();
        buigu = new javax.swing.JButton();
        bumul = new javax.swing.JButton();
        btnoct = new javax.swing.JButton();
        btndec = new javax.swing.JButton();
        btnhex = new javax.swing.JButton();  
        Nombres = new javax.swing.JLabel();
        Nombre1 = new javax.swing.JLabel();
        Nombre2 = new javax.swing.JLabel();
        Nombre3 = new javax.swing.JLabel();
        Nombre4 = new javax.swing.JLabel();
        Nombre5 = new javax.swing.JLabel();
        Nombre6 = new javax.swing.JLabel();
        Nombre7 = new javax.swing.JLabel();
        Nombre8 = new javax.swing.JLabel();
        Nombre9 = new javax.swing.JLabel();
        Nombre10 = new javax.swing.JLabel();
        Nombre11 = new javax.swing.JLabel();
        Nombre12 = new javax.swing.JLabel();
        Nombre13 = new javax.swing.JLabel();
        Result = new javax.swing.JTextField();
        andinito = new javax.swing.JButton();
        
        btNombre= new javax.swing.JButton();
        btActivar = new javax.swing.JButton();
        
        /*Contenedor*/
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setPreferredSize(new java.awt.Dimension(730, 400));
        getContentPane().setLayout(null);
        getContentPane().setBackground(new java.awt.Color(150,150,150));

             //Boton IMA
        ImageIcon ima = new ImageIcon(getClass().getResource("/Img/UAC.png"));
        andinito.setIcon(ima);
        ima.getIconHeight(); 
        andinito.setSize(10, 10);
        setSize(50, 50);
        add(andinito);
        getContentPane().add(andinito);
        andinito.setBounds(310, 5, 70, 70);
        
        //Pantalla de ingreso de datos
        numero1.setFont(new java.awt.Font("Book Antiqua", 0, 15)); // NOI18N
        numero1.setForeground(new java.awt.Color(0, 0, 0));
        numero1.setBackground(new java.awt.Color(255,255,255));
        getContentPane().add(numero1);
        numero1.setHorizontalAlignment(JTextField.RIGHT);
        numero1.setBounds(10, 100, 130, 30);
        
        
        numero2.setFont(new java.awt.Font("Book Antiqua", 0, 15)); // NOI18N
        numero2.setForeground(new java.awt.Color(0, 0, 0));
        numero2.setBackground(new java.awt.Color(255,255,255));
        getContentPane().add(numero2);
        numero2.setHorizontalAlignment(JTextField.RIGHT);
        numero2.setBounds(10, 170, 130, 30);
        
        
        //Pantalla de conversion de datos
        convert1.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 17)); // NOI18N
        convert1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(convert1);
        convert1.setHorizontalAlignment(JTextField.RIGHT);
        convert1.setBounds(230, 100, 130, 30);
        
        convert2.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 17)); // NOI18N
        convert2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(convert2);
        convert2.setHorizontalAlignment(JTextField.RIGHT);
        convert2.setBounds(230, 170, 130, 30);
        
        
        //Pantalla de resultados
        Result.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 17)); // NOI18N
        Result.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(Result);
        Result.setBounds(540, 130, 170, 40);
        Result.setHorizontalAlignment(JTextField.CENTER);
        
        
        //Boton Nombre
        btNombre.setBackground(new java.awt.Color(0,0,0));
        btNombre.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 16)); // NOI18N
        btNombre.setForeground(new java.awt.Color(255,255, 255));
        btNombre.setText("Nombres");
        btNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre(evt);
            }
        });
        getContentPane().add(btNombre);
        btNombre.setBounds(291, 234, 118, 50);
        
        //Simulador
        btActivar.setBackground(new java.awt.Color(0,0,0));
        btActivar.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 16)); // NOI18N
        btActivar.setForeground(new java.awt.Color(255,255, 255));
        btActivar.setText("Simulador");
        btActivar.setVisible(false);
        btActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Activar(evt);
            }
        });
        getContentPane().add(btActivar);
        btActivar.setBounds(550, 300, 118, 50);
        
        
        //Nombres
        Nombres.setBackground(new java.awt.Color(0,0,0));
        Nombres.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 18)); // NOI18N
        Nombres.setForeground(new java.awt.Color(0,0,0));
        Nombres.setText("INTEGRANTES: ");
        getContentPane().add(Nombres);
        Nombres.setVisible(false);
        Nombres.setBounds(250, 10+40, 200, 50+30);
        Nombres.setHorizontalAlignment(JTextField.CENTER);
        
        Nombre1.setBackground(new java.awt.Color(0,0,0));
        Nombre1.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre1.setForeground(new java.awt.Color(255,255, 255));
        Nombre1.setText("AGUIRRE AGUIRRE, CRISTIAN");
        getContentPane().add(Nombre1);
        Nombre1.setVisible(false);
        Nombre1.setBounds(250, 30+40, 250, 50+30);
        
        Nombre2.setBackground(new java.awt.Color(0,0,0));
        Nombre2.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre2.setForeground(new java.awt.Color(255,255, 255));
        Nombre2.setText("ALEJO MEDINA, GIANFRANCO");
        getContentPane().add(Nombre2);
        Nombre2.setVisible(false);
        Nombre2.setBounds(250, 50+40, 250, 50+30);
        
        Nombre3.setBackground(new java.awt.Color(0,0,0));
        Nombre3.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre3.setForeground(new java.awt.Color(255,255, 255));
        Nombre3.setText("APAZA VALER, BORIS");
        getContentPane().add(Nombre3);
        Nombre3.setVisible(false);
        Nombre3.setBounds(250, 70+40, 200, 50+30);
        
        Nombre4.setBackground(new java.awt.Color(0,0,0));
        Nombre4.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre4.setForeground(new java.awt.Color(255,255, 255));
        Nombre4.setText("CRUZ HUAMAN, MIGUEL");
        getContentPane().add(Nombre4);
        Nombre4.setVisible(false);
        Nombre4.setBounds(250, 90+40, 200, 50+30);
        
        Nombre5.setBackground(new java.awt.Color(0,0,0));
        Nombre5.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre5.setForeground(new java.awt.Color(255,255, 255));
        Nombre5.setText("DIAZ CHAVEZ, MARICARMEN ");
        getContentPane().add(Nombre5);
        Nombre5.setVisible(false);
        Nombre5.setBounds(250, 110+40, 250, 50+30);
        
        Nombre6.setBackground(new java.awt.Color(0,0,0));
        Nombre6.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre6.setForeground(new java.awt.Color(255,255, 255));
        Nombre6.setText("HERRERA PUMA, CARLOS ");
        getContentPane().add(Nombre6);
        Nombre6.setVisible(false);
        Nombre6.setBounds(250, 130+40, 200, 50+30);
        
        Nombre7.setBackground(new java.awt.Color(0,0,0));
        Nombre7.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre7.setForeground(new java.awt.Color(255,255, 255));
        Nombre7.setText("LINO QUISPICHO, JOSEPH ");
        getContentPane().add(Nombre7);
        Nombre7.setVisible(false);
        Nombre7.setBounds(250, 150+40, 200, 50+30);
        
        Nombre8.setBackground(new java.awt.Color(0,0,0));
        Nombre8.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre8.setForeground(new java.awt.Color(255,255, 255));
        Nombre8.setText("MIRANDA ZAPATA, ANGELO ");
        getContentPane().add(Nombre8);
        Nombre8.setVisible(false);
        Nombre8.setBounds(250, 170+40, 250, 50+30);
        
        Nombre9.setBackground(new java.awt.Color(0,0,0));
        Nombre9.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre9.setForeground(new java.awt.Color(255,255, 255));
        Nombre9.setText("PACURI CARRION, SHAVELY");
        getContentPane().add(Nombre9);
        Nombre9.setVisible(false);
        Nombre9.setBounds(250, 190+40, 250, 50+30);
        
        Nombre10.setBackground(new java.awt.Color(0,0,0));
        Nombre10.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre10.setForeground(new java.awt.Color(255,255, 255));
        Nombre10.setText("QUISPE CHOQUE, MIGUEL");
        getContentPane().add(Nombre10);
        Nombre10.setVisible(false);
        Nombre10.setBounds(250, 210+40, 250, 50+30);
        
        Nombre11.setBackground(new java.awt.Color(0,0,0));
        Nombre11.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre11.setForeground(new java.awt.Color(255,255, 255));
        Nombre11.setText("QUISPE GONZALES, HECTOR");
        getContentPane().add(Nombre11);
        Nombre11.setVisible(false);
        Nombre11.setBounds(250, 230+40, 250, 50+30);
        
        Nombre12.setBackground(new java.awt.Color(0,0,0));
        Nombre12.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre12.setForeground(new java.awt.Color(255,255, 255));
        Nombre12.setText("RODRIGEZ SOLIS, ALONSO");
        getContentPane().add(Nombre12);
        Nombre12.setVisible(false);
        Nombre12.setBounds(250, 250+40, 200, 50+30);
        
        Nombre13.setBackground(new java.awt.Color(0,0,0));
        Nombre13.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 16)); // NOI18N
        Nombre13.setForeground(new java.awt.Color(255,255, 255));
        Nombre13.setText("SALIZAR ROZAS, MAX");
        getContentPane().add(Nombre13);
        Nombre13.setVisible(false);
        Nombre13.setBounds(250, 270+40, 200, 50+30);
        /**----------------------------------------------*/
     
        
        
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 90, 100), 0, true));
        jPanel2.setForeground(new java.awt.Color(255,255,255));
        jPanel2.setBackground(new java.awt.Color(150,150,150));
        jPanel2.setLayout(null);

        Conversiones.add(opthex);
        opthex.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 15)); // NOI18N
        opthex.setForeground(new java.awt.Color(0, 0, 0));
        opthex.setText("HEX");
        
        jPanel2.add(opthex);
        opthex.setBounds(95, 30, 120, 21);

        Conversiones.add(optdec);
        optdec.setFont(new java.awt.Font("Times new roman", 0, 15)); // NOI18N
        optdec.setForeground(new java.awt.Color(0, 0, 0));
        optdec.setText("DEC");
        optdec.setSelected(true);
        jPanel2.add(optdec);
        optdec.setBounds(12, 30, 83, 21);

        Conversiones.add(optoct);
        optoct.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 15)); // NOI18N
        optoct.setForeground(new java.awt.Color(0, 0, 0));
        optoct.setText("OCT");
        
        jPanel2.add(optoct);
        optoct.setBounds(95, 5, 67, 21);

        Conversiones.add(optbin);
        optbin.setFont(new java.awt.Font("TIMES NEW ROMAN", 0, 15)); // NOI18N
        optbin.setForeground(new java.awt.Color(0,0, 0));
        optbin.setText("BIN");
        
        jPanel2.add(optbin);
        optbin.setBounds(12, 5, 93, 21);

        //Marco de botones    
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 170, 50);

        

        
        //Boton CE (Borrado)
        buCE.setBackground(new java.awt.Color(170,60,75));
        buCE.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 16)); // NOI18N
        buCE.setForeground(new java.awt.Color(255,255, 255));
        buCE.setText("BORRAR");
        //buCE.setEnabled(false);
        buCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(buCE);
        buCE.setBounds(291, 300, 118, 50);

        //Boton *
        bumul.setBackground(new java.awt.Color(0,0,0));
        bumul.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 18)); // NOI18N
        bumul.setForeground(new java.awt.Color(255,255, 255));
        bumul.setText("*");

        bumul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(bumul);
        bumul.setBounds(420, 100, 60, 50);
        
        //Boton /
        buent.setBackground(new java.awt.Color(0,0,0));
        buent.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 18)); // NOI18N
        buent.setForeground(new java.awt.Color(255,255, 255));
        buent.setText("/");

        buent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(buent);
        buent.setBounds(360, 100, 60, 50);
        
        //Boton +
        bumas.setBackground(new java.awt.Color(0,0,0));
        bumas.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 18)); // NOI18N
        bumas.setForeground(new java.awt.Color(255,255, 255));
        bumas.setText("+");

        bumas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(bumas);
        bumas.setBounds(420, 150, 60, 50);
        
        //Boton -
        bumen.setBackground(new java.awt.Color(0,0,0));
        bumen.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 18)); // NOI18N
        bumen.setForeground(new java.awt.Color(255,255, 255));
        bumen.setText("-");

        bumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(bumen);
        bumen.setBounds(360, 150, 60, 50);
        
        //Boton =
        buigu.setBackground(new java.awt.Color(0,0,0));
        buigu.setFont(new java.awt.Font("TIMES NEW ROMAN ", 0, 18)); // NOI18N
        buigu.setForeground(new java.awt.Color(255,255, 255));
        buigu.setText("=");
        buigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(buigu);
        buigu.setBounds(480, 130, 60, 50);
        
        //Boton BIN
        btnbin.setBackground(new java.awt.Color(76,76,76));
        btnbin.setFont(new java.awt.Font("Bell MT", 0, 15)); // NOI18N
        btnbin.setForeground(new java.awt.Color(255,255, 255));
        btnbin.setText("BIN");
        btnbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbinActionPerformed(evt);
            }
        });
        getContentPane().add(btnbin);
        btnbin.setBounds(150, 90, 60, 30);       

       //Boton OCT
        btnoct.setBackground(new java.awt.Color(76,76,76));
        btnoct.setFont(new java.awt.Font("Bell MT", 0, 15)); // NOI18N
        btnoct.setForeground(new java.awt.Color(255,255, 255));
        btnoct.setText("OCT");
        btnoct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoctActionPerformed(evt);
            }
        });
        getContentPane().add(btnoct);
        btnoct.setBounds(150, 120, 60, 30);

        //Boton DEC
        btndec.setBackground(new java.awt.Color(76,76,76));
        btndec.setFont(new java.awt.Font("Bell MT", 0, 15)); // NOI18N
        btndec.setForeground(new java.awt.Color(255,255, 255));
        btndec.setText("DEC");
        btndec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndecActionPerformed(evt);
            }
        });
        getContentPane().add(btndec);
        btndec.setBounds(150,150, 60, 30);

        //Boton HEX
        btnhex.setBackground(new java.awt.Color(76,76,76));
        btnhex.setFont(new java.awt.Font("Bell MT", 0, 15)); // NOI18N
        btnhex.setForeground(new java.awt.Color(255,255, 255));
        btnhex.setText("HEX");
        btnhex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhexActionPerformed(evt);
            }
        });
        getContentPane().add(btnhex);
        btnhex.setBounds(150, 180, 60, 30);

        pack();
    }               

                                
//Boton = aqui se hace todo owo
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        if(E=="b"){
        restaBinaria();
        sumaBinaria();
        multiplicacionBinaria();
        divisionBinaria();
        }
        if(E=="o"){
        restaOctal();
        sumaOctal();
        multiplicacionOctal();
        divisionOctal();
        }
        if(E=="d"){
        restaDecimal();
        sumaDecimal();
        multiplicacionDecimal();
        divisionDecimal();
        }
        if(E=="h"){
        restaHexadecimal();
        sumaHexadecimal();
        multiplicacionHexadecimal();
        divisionHexadecimal();
        }
        
    }
    
    
    public void sumaHexadecimal(){
    String res,resh;
        Integer resultado,nh1,nh2;
        n2=convert2.getText();
        if(s.equals("+")){
        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,16)+Integer.parseInt(n2,16);
        res=Integer.toString(resultado,16);
        resh=res.toUpperCase();
        Result.setText(resh);
            }
        }
    }
    public void restaHexadecimal(){
    String res,resh;
        Integer resultado,nh1,nh2;
        n2=convert2.getText();
        if(s.equals("-")){
        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,16)-Integer.parseInt(n2,16);
        res=Integer.toString(resultado,16);
        resh=res.toUpperCase();
        Result.setText(resh);
            }
        }
    }
    public void multiplicacionHexadecimal(){
    String res,resh;
        Integer resultado,nh1,nh2;
        n2=convert2.getText();
        if(s.equals("*")){
        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,16)*Integer.parseInt(n2,16);
        res=Integer.toString(resultado,16);
        resh=res.toUpperCase();
        Result.setText(resh);
            }
        }
    }
    public void divisionHexadecimal(){
    String res,resh;
        Integer resultado,nh1,nh2;
        n2=convert2.getText();
        if(s.equals("/")){
        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,16)/Integer.parseInt(n2,16);
        res=Integer.toString(resultado,16);
        resh=res.toUpperCase();
        Result.setText(resh);
            }
        }
    }
    
    public void sumaOctal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("+")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,8)+Integer.parseInt(n2,8);
        res=Integer.toString(resultado,8);
        Result.setText(res);
            }
        }
    }
    public void restaOctal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("-")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,8)-Integer.parseInt(n2,8);
        res=Integer.toString(resultado,8);
        Result.setText(res);
            }
        }
    }
    public void multiplicacionOctal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("*")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,8)*Integer.parseInt(n2,8);
        res=Integer.toString(resultado,8);
        Result.setText(res);
            }
        }
    }
    public void divisionOctal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("/")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,8)/Integer.parseInt(n2,8);
        res=Integer.toString(resultado,8);
        Result.setText(res);
            }
        }
    }
    
    public void sumaDecimal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("+")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1)+Integer.parseInt(n2);
        res=Integer.toString(resultado);
        Result.setText(res);
            }
        }
    }
    public void restaDecimal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("-")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1)-Integer.parseInt(n2);
        res=Integer.toString(resultado);
        Result.setText(res);
            }
        }
    }
    public void multiplicacionDecimal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("*")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1)*Integer.parseInt(n2);
        res=Integer.toString(resultado);
        Result.setText(res);
            }
        }
    }
    public void divisionDecimal(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("/")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1)/Integer.parseInt(n2);
        res=Integer.toString(resultado);
        Result.setText(res);
            }
        }
    }
    
    
    public void sumaBinaria(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("+")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,2)+Integer.parseInt(n2,2);
        res=Integer.toString(resultado,2);
        Result.setText(res);
            }
        }
    }
    public void restaBinaria(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("-")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,2)-Integer.parseInt(n2,2);
        res=Integer.toString(resultado,2);
        Result.setText(res);
            }
        }
    }
    public void multiplicacionBinaria(){
    String res;
        Integer resultado;
        n2=convert2.getText();
                    if(s.equals("*")){

        if (!n2.equals("")){
        resultado=Integer.parseInt(n1,2)*Integer.parseInt(n2,2);
        res=Integer.toString(resultado,2);
        Result.setText(res);
            }
        }
    }
    public void divisionBinaria(){
        String res;
            Integer resultado;
            n2=convert2.getText();
                        if(s.equals("/")){

            if (!n2.equals("")){
            resultado=Integer.parseInt(n1,2)/Integer.parseInt(n2,2);
            res=Integer.toString(resultado,2);
            Result.setText(res);
                }
            }
        }
    
    
    // C
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //Boton para borrar caracteres presentes en Display (uno por uno)
        String c;
        c=numero1.getText();
        if (c.length()>0){
        c=c.substring(0,c.length()-1);
        numero1.setText(c);
        }
    }                                         

    //CE
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here: CE
        
        numero1.setText("");
        convert1.setText("");
        numero2.setText("");
        convert2.setText("");
        Result.setText("");
    }       
    
    //Nombres visibles
    private void Nombre(java.awt.event.ActionEvent evt) {                                          
        btNombre.setVisible(false);
        jPanel2.setVisible(false);
        numero1.setVisible(false);
        numero2.setVisible(false);
        convert1.setVisible(false);
        convert2.setVisible(false);
        Result.setVisible(false);
        
        buCE.setVisible(false);
        btnbin.setVisible(false);
        btndec.setVisible(false);
        btnhex.setVisible(false);
        btnoct.setVisible(false);
        
        buigu.setVisible(false);
        bumas.setVisible(false);
        bumen.setVisible(false);
        bumul.setVisible(false);
        buent.setVisible(false);  
        
        btActivar.setVisible(true);
        
        Nombres.setVisible(true);
        Nombre1.setVisible(true);
        Nombre2.setVisible(true);
        Nombre3.setVisible(true);
        Nombre4.setVisible(true);
        Nombre5.setVisible(true);
        Nombre6.setVisible(true);
        Nombre7.setVisible(true);
        Nombre8.setVisible(true);
        Nombre9.setVisible(true);
        Nombre10.setVisible(true);
        Nombre11.setVisible(true);
        Nombre12.setVisible(true);
        Nombre13.setVisible(true);
    }
    
    //Simulador Visible
    private void Activar(java.awt.event.ActionEvent evt)
    {
        btNombre.setVisible(true);
        jPanel2.setVisible(true);
        numero1.setVisible(true);
        numero2.setVisible(true);
        convert1.setVisible(true);
        convert2.setVisible(true);
        Result.setVisible(true);
        
        buCE.setVisible(true);
        btnbin.setVisible(true);
        btndec.setVisible(true);
        btnhex.setVisible(true);
        btnoct.setVisible(true);
        
        buigu.setVisible(true);
        bumas.setVisible(true);
        bumen.setVisible(true);
        bumul.setVisible(true);
        buent.setVisible(true);
        
        btActivar.setVisible(false);
        
        Nombres.setVisible(false);
        Nombre1.setVisible(false);
        Nombre2.setVisible(false);
        Nombre3.setVisible(false);
        Nombre4.setVisible(false);
        Nombre5.setVisible(false);
        Nombre6.setVisible(false);
        Nombre7.setVisible(false);
        Nombre8.setVisible(false);
        Nombre9.setVisible(false);
        Nombre10.setVisible(false);
        Nombre11.setVisible(false);
        Nombre12.setVisible(false);
        Nombre13.setVisible(false);
        
        
    }
    
    
    
    // Boton +
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        n1=convert1.getText();
        s="+";
        
        
    }                                         
    
    // Boton -
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        if (!convert1.getText().equals("")){
        n1=convert1.getText();
        comHex(n1);
        s="-";
        
        }
    }                                         
    
    // Boton *
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (!convert1.getText().equals("")){
        n1=convert1.getText();
        s="*";
       
        }
    }                                         
    
    // Boton /
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    if (!convert1.getText().equals("")){
        n1=convert1.getText();
        s="/";
        }        
    }   
    
    
    
    
    
    
    
    
    
    
    /*--------------------------------------------------------------------------------------------------*/
              
    
    // a binario
    private void btnbinActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        String n8,resh;
        Integer num8;
        E="b";
        if(optoct.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toBinaryString(num8);
        convert1.setText(n8);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toBinaryString(num8);
        convert2.setText(n8);
        
        }
        if(optdec.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toBinaryString(num8);
        convert1.setText(n8);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toBinaryString(num8);
        convert2.setText(n8);
        
        }
        if(opthex.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toBinaryString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toBinaryString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if (optbin.isSelected()){
        n8=numero1.getText();
        convert1.setText(n8);
        
        n8=numero2.getText();
        convert2.setText(n8);
        }
    }  
    
    // a octal
    private void btnoctActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        String n8,x,y,resh;
        Integer num8;
        E="o";
        if(optbin.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,2);
        n8=Integer.toOctalString(num8);
        convert1.setText(n8);
        
         x = numero2.getText();
        num8 = Integer.parseInt(x,2);
        x= Integer.toOctalString(num8);
        convert2.setText(x);
        }
        if(optdec.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toOctalString(num8);
        convert1.setText(n8);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toOctalString(num8);
        convert2.setText(n8);
        }
        if(opthex.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toOctalString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toOctalString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if (optoct.isSelected()){
        n8=numero1.getText();
        convert1.setText(n8);
        
        n8=numero2.getText();
        convert2.setText(n8);
        }
    }                                      
    
    // a decimal
    private void btndecActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:  
        String n8,resh;
        Integer num8;E="d";
        if(optoct.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toString(num8);
        convert1.setText(n8);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toString(num8);
        convert2.setText(n8);
        }
        if(optbin.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,2);
        n8=Integer.toString(num8);
        convert1.setText(n8);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,2);
        n8=Integer.toString(num8);
        convert2.setText(n8);
        }
        if(opthex.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,16);
        n8=Integer.toString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if (optdec.isSelected()){
        n8=numero1.getText();
        convert1.setText(n8);
        
        n8=numero2.getText();
        convert2.setText(n8);
        }
    }                                      
    
    // a hexadecimal
    private void btnhexActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        String n8,resh;
        Integer num8;
        E="h";
      
        if(optoct.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,8);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if(optdec.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if(optbin.isSelected()){
        n8=numero1.getText();
        num8=Integer.parseInt(n8,2);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert1.setText(resh);
        
        n8=numero2.getText();
        num8=Integer.parseInt(n8,2);
        n8=Integer.toHexString(num8);
        resh=n8.toUpperCase();
        convert2.setText(resh);
        }
        if (opthex.isSelected()){
        n8=numero1.getText();
        convert1.setText(n8);
        
        n8=numero2.getText();
        convert2.setText(n8);
        }
    }    
    
    
    /*--------------------------------------------------------------------------------------------------*/
    
    
    
    //Comparar Letras Hexadecimal
    public void comHex(String n1){
        if (n1.equals("A")){
        n1="10";
        }
        if (n1.equals("B")){
        n1="11";
        }
        if (n1.equals("C")){
        n1="12";
        }
        if (n1.equals("D")){
        n1="13";
        }
        if (n1.equals("E")){
        n1="14";
        }
        if (n1.equals("F")){
        n1="15";
        }
    }
    /**
     * @param args the command line arguments
     */
    /*-----------------------------------------------------------*/

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaApplication3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaApplication3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaApplication3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaApplication3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaApplication3().setVisible(true);
                
            }
        });
    }

    /*------------------------------------------------------*/
    
    
    
    
           
    
    
    // Pantalla de Respuestas 
    private javax.swing.JTextField numero1;
    private javax.swing.JTextField numero2;
    private javax.swing.JTextField convert1;
    private javax.swing.JTextField convert2;
    private javax.swing.JTextField Result;
   //private javax.swing.JTextField resultado;
    // Radio buttons
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton optbin;
    private javax.swing.JRadioButton optdec;
    private javax.swing.JRadioButton opthex;
    private javax.swing.JRadioButton optoct;
    // Botones de borrado, sigignos e igual 
    private javax.swing.JButton buC;
    private javax.swing.JButton bumen;
    private javax.swing.JButton buCE;
    private javax.swing.JButton bumas;
    private javax.swing.JButton buent;
    private javax.swing.JButton buigu;
    private javax.swing.JButton bumul;
    //botones de conversion
    private javax.swing.ButtonGroup Conversiones;
    private javax.swing.JButton btnbin;
    private javax.swing.JButton btndec;
    private javax.swing.JButton btnhex;
    private javax.swing.JButton btnoct;
    // Imagen
    private javax.swing.JButton andinito;
    
    // Nombres
    private javax.swing.JButton btNombre;
    private javax.swing.JButton btActivar;
    private javax.swing.JLabel Nombres;
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JLabel Nombre3;
    private javax.swing.JLabel Nombre4;
    private javax.swing.JLabel Nombre5;
    private javax.swing.JLabel Nombre6;
    private javax.swing.JLabel Nombre7;
    private javax.swing.JLabel Nombre8;
    private javax.swing.JLabel Nombre9;
    private javax.swing.JLabel Nombre10;
    private javax.swing.JLabel Nombre11;
    private javax.swing.JLabel Nombre12;
    private javax.swing.JLabel Nombre13;
    
}
