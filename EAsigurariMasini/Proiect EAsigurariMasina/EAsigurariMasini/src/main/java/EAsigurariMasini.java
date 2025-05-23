import Plan.*;
import Contract.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class EAsigurariMasini extends JFrame{

    Font myFont = new Font("SansSerif", Font.BOLD,20);
    Color myColor = Color.GRAY;

    // Panel 1
    JTextField nume;
    JTextField prenume;
    JTextField oras;
    JTextField telefon;
    JTextField accidente;
    // Panel 2
    JTextField anFabricatie;
    JTextField producator;
    JTextField nrInmatriculare;
    JTextField valEstimata;
    JRadioButton euro3;
    JRadioButton euro4;
    JRadioButton euro5;
    JRadioButton euro6;
    ButtonGroup G1;

    // Panel 3
    JCheckBox chkObligatoriu;
    JCheckBox chkToate;
    JCheckBox chkMasina;
    JCheckBox chkCoducator;
    JCheckBox chkAsistenta;
    List<String> listaAcoperireAsigurari = new ArrayList<>();
    List<Float> listaAsigurare = new ArrayList<>();
    List<Float> listaAcoperire = new ArrayList<>();
    List<Float> listaPlafon = new ArrayList<>();


    // Panel 4
    JRadioButton lunarRadio;
    JRadioButton semestrialRadio2;
    JRadioButton anualRadio3;
    ButtonGroup G2;
    JLabel LblAstazi;
    int lunaValabilitate = 0;
    SimpleDateFormat df;
    Date dataCurenta;

    // panel 6
    JTextArea txtAcoperiri;
    JTextField txtCauta;
    Map<Integer, Client> clientMap = new TreeMap<>();

    // panel 7
    JTextArea txtContract;

    // Panel 8
    JTextArea txtClient;


    // Panel 9
    JLabel txtCerere;
    JLabel txtCerere2;
    JTextField fdClientCerere;


    // Panel 10
    JLabel lblCerereNumeClient;
    JLabel lblStatusCerere;
    JTextArea areaCerereAsigurariAcoperite;
    JLabel lblCerereClientDataValabilitate;
    boolean cond1;
    boolean cond2;
    boolean cond3;


    // Panel 11
    JTextArea zonaAsezare;
    float totalAsiguarare = 0f;
    float totalAcoperire = 0f;
    float totalPlafon = 0f;

    // Panel 12
    JTextArea zonaAsezare2;
    // Constructor
    public EAsigurariMasini(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }
    private void CustomizePanel1(){
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Client  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        p1.setBorder(titledBorder);


        JLabel lblNume = new JLabel(" Nume");
        JLabel lblPrenume = new JLabel(" Prenume");
        JLabel lblOras = new JLabel(" Oras");
        JLabel lblTelefon = new JLabel(" Telefon");
        JLabel lblAccidente = new JLabel(" Accidente");
        

        nume = new JTextField();        nume.setOpaque(false);
        prenume = new JTextField();        prenume.setOpaque(false);
        oras = new JTextField();         oras.setOpaque(false);
        telefon = new JTextField();        telefon.setOpaque(false);
        accidente = new JTextField();      accidente.setOpaque(false);

        p1.add(lblNume);
        p1.add(nume);
        p1.add(lblPrenume);
        p1.add(prenume);
        p1.add(lblOras);
        p1.add(oras);
        p1.add(lblTelefon);
        p1.add(telefon);
        p1.add(lblAccidente);
        p1.add(accidente);


        p1.setBounds(15,15,300,230);
        p1.setLayout(new GridLayout(5,2));

        setLayout(null);
        add(p1);
    }
    private void CustomizePanel2(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Vehicul  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p2 = new JPanel();
        p2.setBorder(titledBorder);



        JLabel lblNrInmatriculare = new JLabel(" Nr. Inmatriculare");
        JLabel lblAnFabricatie = new JLabel(" An Fabricatie");
        JLabel lblProducator = new JLabel(" Producator");
        JLabel lblValEstimata = new JLabel(" Valoare Estimata");
        JLabel spaceLBL = new JLabel(" ");
        JLabel lblNormaPol = new JLabel(" Norma Poluare ");


        nrInmatriculare = new JTextField();       nrInmatriculare.setOpaque(false);
        anFabricatie = new JTextField();         anFabricatie.setOpaque(false);
        producator = new JTextField();          producator.setOpaque(false);
        valEstimata = new JTextField();      valEstimata.setOpaque(false);


        euro3 = new JRadioButton();
        euro3.setText(" Euro 3");
        euro4 = new JRadioButton();
        euro4.setText(" Euro 4");
        euro5 = new JRadioButton();
        euro5.setText(" Euro 5");
        euro6 = new JRadioButton();
        euro6.setText(" Euro 6");

        G1 = new ButtonGroup();
        G1.add(euro3);
        G1.add(euro4);
        G1.add(euro5);
        G1.add(euro6);


        p2.add(lblNrInmatriculare);
        p2.add(nrInmatriculare);
        p2.add(lblAnFabricatie);
        p2.add(anFabricatie);
        p2.add(lblProducator);
        p2.add(producator);
        p2.add(lblValEstimata);
        p2.add(valEstimata);
        p2.add(spaceLBL);
        p2.add(lblNormaPol);
        p2.add(euro3);
        p2.add(euro4);
        p2.add(euro5);
        p2.add(euro6);


        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));
        add(p2);
    }
    private void CustomizePanel3(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Plan  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p3 = new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,230);
        p3.setLayout(new GridLayout(6,1));

        JLabel lblPachet = new JLabel("Selecteaza Planul Dorit");

        chkObligatoriu = new JCheckBox("Obligatoriu");
        chkToate = new JCheckBox("Toate Asigurarile");
        chkMasina = new JCheckBox("Asigurare Masina");
        chkCoducator = new JCheckBox("Asigurare Conducator");
        chkAsistenta = new JCheckBox("Asistenta");


        GetAsigurariAcoperite();


        p3.add(lblPachet);
        p3.add(chkObligatoriu);
        p3.add(chkToate);
        p3.add(chkMasina);
        p3.add(chkCoducator);
        p3.add(chkAsistenta);

        add(p3);
    }
    private void CustomizePanel4(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Valabilitate  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,200);
        p4.setLayout(new GridLayout(6,1));


        JLabel spacer2 = new JLabel(" ");   spacer2.setOpaque(false);
        lunarRadio = new JRadioButton();
        lunarRadio.setText(" Lunar");
        semestrialRadio2 = new JRadioButton();
        semestrialRadio2.setText(" Semestrial");
        anualRadio3 = new JRadioButton();
        anualRadio3.setText(" Anual");

        lunarRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunaValabilitate =1;
            }
        });
        semestrialRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunaValabilitate = 3;
            }
        });
        anualRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunaValabilitate = 12;
            }
        });


        G2 = new ButtonGroup();
        G2.add(lunarRadio);
        G2.add(semestrialRadio2);
        G2.add(anualRadio3);

        LblAstazi = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        dataCurenta = new Date();
        LblAstazi.setText("Azi: " + df.format(dataCurenta));
        LblAstazi.setOpaque(false);


        Font font = LblAstazi.getFont();
        float size = font.getSize() + 3.0f;
        LblAstazi.setFont( font.deriveFont(size) );


        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(LblAstazi);
        p4.add(spacer2);
        p4.add(lunarRadio);
        p4.add(semestrialRadio2);
        p4.add(anualRadio3);

        add(p4);
    }
    private void CustomizePanel5(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Actiuni  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p5 = new JPanel();
        p5.setBounds(330,470,300,280);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(9,1));

        JButton btnSalveaza = new JButton("Salveaza Client");
        JButton btnArata = new JButton("Arata detalii contract");
        JButton btnIncarca = new JButton("Incarca Client");
        JButton btnNou = new JButton("Client Nou");
        txtCauta = new JTextField("Introdu Nr. Telefon");
        txtCauta.setOpaque(false);

        btnArata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = "";
                for (int i =0; i< listaAcoperireAsigurari.size();i++){
                    str += listaAcoperireAsigurari.get(i) + "\n";
                }
                txtAcoperiri.setText(str);


                try{
                    txtContract.setText(GetDateContract().toString());
                    afiseazaDetaliiAsigurare();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });


        btnSalveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    SaveClientMapToDisk();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        btnIncarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CautaClientDupaNrAsigurare();

            }
        });


        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        btnNou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCustomer();
            }
        });

        p5.add(spacer3);
        p5.add(btnArata);
        p5.add(spacer4);
        p5.add(btnSalveaza);
        p5.add(spacer5);
        p5.add(btnNou);
        p5.add(spacer6);
        p5.add(txtCauta);
        p5.add(btnIncarca);

        add(p5);
    }
    private void CustomizePanel6(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Acoperiri  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,230);

        txtAcoperiri = new JTextArea(7, 1);
        txtAcoperiri.setEditable(false);
        txtAcoperiri.setOpaque(false);
        txtAcoperiri.setLineWrap(true);

        Font font = txtAcoperiri.getFont();
        float size = font.getSize() + 3.0f;
        txtAcoperiri.setFont( font.deriveFont(size) );

        p6.add(txtAcoperiri);

        p6.setLayout(new GridLayout(1,1));
        add(p6);    
    }
    private void CustomizePanel7(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Detalii Asigurare  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p7 = new JPanel();
        p7.setBounds(645,250,300,200);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));

        txtContract = new JTextArea(20,1);
        txtContract.setEditable(false);
        txtContract.setOpaque(false);
        txtContract.setLineWrap(true);

        Font font = txtContract.getFont();
        float size  = font.getSize() + 3.0f;
        txtContract.setFont(font.deriveFont(size));


        p7.add(txtContract);
        p7.setLayout(new GridLayout(1,1));
        add(p7);  
    }
    public void CustomizePanel8(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Detalii Client  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(645, 470, 300, 280);
        p8.setLayout(new GridLayout(6, 1));

        txtClient = new JTextArea(20, 1);
        txtClient.setEditable(false);
        txtClient.setOpaque(false);
        txtClient.setLineWrap(true);

        Font font = txtClient.getFont();
        float size = font.getSize() + 3.0f;
        txtClient.setFont( font.deriveFont(size) );

        p8.add(txtClient);

        p8.setLayout(new GridLayout(1,1));
        add(p8);



    }
    public void CustomizePanel9(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Cereri  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);


        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(960, 15, 300, 485);

        txtCerere = new JLabel("Introdu Nr Telefon al Clientului");
        JLabel spacer99 = new JLabel("                                                         ");
        txtCerere2 = new JLabel("Selecteaza tipul de accident sau asistenta necesar");

        fdClientCerere = new JTextField();
        fdClientCerere.setPreferredSize(new Dimension(250, 30));
        fdClientCerere.setOpaque(false);

        String[] items = {
            "Incendiu",
            "Furt",
            "Accidentarea altui conducator",
            "Accidentarea masinii",
            "Accidentare conducator",
            "Transport",
            "Inlocuirea masinii"
        };

        final JList listaOptiuni = new JList(items);

        listaOptiuni.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listaOptiuni.setOpaque(false);

        listaOptiuni.setPreferredSize(new Dimension(250, 150));

        JButton cautaClient = new JButton("Cauta Client");
        List<String> listaAsigurariAcoperiteDupaUser = new ArrayList<>();
        cautaClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false;          // Clientul este deja inregistrat in DB
                cond2 = false;          // Asiguararea acopera planul selectat
                cond3 = false;          // Este valabila asigurarea

                try{
                    listaAsigurariAcoperiteDupaUser.clear();
                    Client c = CautaSumePlataClient();
                    lblCerereNumeClient.setText("Client: "+ c.getNume() + " " +c.getPrenume());
                    cond1 = true;


                    String str7 = "";
                    for (int i=0 ; i<c.getContract().getListaAcoperireAsigurari().size();i++){
                        str7 += c.getContract().getListaAcoperireAsigurari().get(i) + " \n";
                        listaAsigurariAcoperiteDupaUser.add(c.getContract().getListaAcoperireAsigurari().get(i));
                    }

                    LocalDate valabilitateaAsigurari = c.getContract().getDataContractului();
                    int lunaValabilitateAsigurare = c.getContract().getLunaValabilitate();
                    valabilitateaAsigurari = valabilitateaAsigurari.plusMonths(lunaValabilitateAsigurare);

                    VerificaValabilitateContract(valabilitateaAsigurari);

                    areaCerereAsigurariAcoperite.setText("Asigurari acoperite de contract:\n"+str7);
                    lblCerereClientDataValabilitate.setText("Data valabilitatii contractului: " +valabilitateaAsigurari+"  || " +VerificaValabilitateContract(valabilitateaAsigurari));

                    if (c.getContract().getListaAcoperireAsigurari().size() >=5){
                        // daca clientul are asigurare totala
                        cond2 = true;
                    }

                }catch (Exception re){
                    lblCerereNumeClient.setText("Clientul nu a fost gasit");
                }

            }
        });

        JButton btnConfirmaOptiunea = new JButton("   Confirma Optiunea");
        btnConfirmaOptiunea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get index al tuturor elementelor selectate
                int[] selectedIx = listaOptiuni.getSelectedIndices();
                List<String> lista_optiuni = new ArrayList<>();


                if (listaOptiuni.getSelectedIndex() != -1) {
                    for (int i= 0; i< selectedIx.length; i++) {
                        String k = "" + listaOptiuni.getModel().getElementAt(selectedIx[i]) + " ";
                        lista_optiuni.add(""+listaOptiuni.getModel().getElementAt(selectedIx[i]));
                        System.out.print("" + k);
                    }
                }

                // Verificare asigurari incluse
                if (cond2 == false){
                    cond2 = lista_optiuni.containsAll(listaAsigurariAcoperiteDupaUser);
                }


                ValabilitateCerere();

                Client c = CautaSumePlataClient();
                if (ValabilitateCerere()){
                    int claims_nb = lista_optiuni.size();
                    if (lista_optiuni.contains("Incendiu")){
                        zonaAsezare2.setText("Daune incendiu: " +
                                c.getContract().getVehicul().getValoareEstimata()*0.25 + " RON");

                    }else if (lista_optiuni.contains("Furt")){
                        zonaAsezare2.setText("Daune furt: " +
                                c.getContract().getVehicul().getValoareEstimata()*1 + " RON");

                    }else if  (lista_optiuni.contains("Accidentarea altui conducator")){
                        zonaAsezare2.setText("Conducator acccidentat: " + 2000 + " RON");

                    }else if (lista_optiuni.contains("Accidentarea masinii")){
                        zonaAsezare2.setText("Aaccidentare masina: " +
                                c.getContract().getVehicul().getValoareEstimata()*1+ " RON");

                    }else if (lista_optiuni.contains("Accidentare conducator")) {
                        zonaAsezare2.setText("Accidentare conducator: " +
                                c.getContract().getVehicul().getValoareEstimata()*10+ " RON");

                    }else if (lista_optiuni.contains("Transport")){
                        zonaAsezare2.setText("Companie transport: " +
                                c.getContract().getVehicul().getValoareEstimata()*0.5+ " RON");

                    }else if (lista_optiuni.contains("Inlocuirea masinii")){
                        zonaAsezare2.setText("Inchiriere masina " +
                                c.getContract().getVehicul().getValoareEstimata()*0.2+ " RON");

                    }else if (claims_nb > 2){
                        zonaAsezare2.setText("Conducator "
                                + c.getContract().getVehicul().getValoareEstimata()*4+ " RON"+
                                "Spital " + c.getContract().getVehicul().getValoareEstimata()*4
                                + " RON "+

                                "Inchiriere masina "
                                + c.getContract().getVehicul().getValoareEstimata()*0.2 + " RON "+
                                "Conducator acccidentat " +
                                c.getContract().getVehicul().getValoareEstimata()*2
                        );

                    }else{

                    }
                }
            }
        });


        p9.add(txtCerere);
        p9.add(fdClientCerere);
        p9.add(cautaClient);
        p9.add(spacer99);
        p9.add(txtCerere2);
        p9.add(listaOptiuni);
        p9.add(btnConfirmaOptiunea);

        add(p9);
    }
    public void CustomizePanel10(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Status Cerere", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(960, 520, 300, 230);
        p10.setLayout(new GridLayout(4, 1));


        lblCerereNumeClient = new JLabel("Client cerere: ");
        lblCerereClientDataValabilitate = new JLabel("Valabilitate cerere: ");
        lblStatusCerere = new JLabel("Status cerere: ");


        areaCerereAsigurariAcoperite = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(areaCerereAsigurariAcoperite);
        areaCerereAsigurariAcoperite.setOpaque(false);


        p10.add(lblCerereNumeClient);
        p10.add(lblCerereClientDataValabilitate);
        p10.add(pictureScrollPane);
        p10.add(lblStatusCerere);

        add(p10);

    }
    public void CustomizePanel11(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Plati  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1275, 15, 250, 230);
        p11.setLayout(new GridLayout(2, 1));

        zonaAsezare = new JTextArea();
        zonaAsezare.setOpaque(false);

        Font font = zonaAsezare.getFont();
        float size = font.getSize() + 4.0f;
        zonaAsezare.setFont( font.deriveFont(size) );

        p11.add(zonaAsezare);
        add(p11);


    }
    public void CustomizePanel12(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        "  Suma de plata  ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel  p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        zonaAsezare2 = new JTextArea();
        zonaAsezare2.setOpaque(false);
        p12.add(zonaAsezare2);

        Font font = zonaAsezare2.getFont();
        float size = font.getSize() + 4.0f;
        zonaAsezare2.setFont(font.deriveFont(size));

        add(p12);

    }
    
    /***************METODE*****************/
    /**************************************/
    public Client GetDateClient() throws ParseException{
        Client client = new Client(
                nume.getText(),
                prenume.getText(),
                oras.getText(),
                Integer.parseInt(telefon.getText()),
                Integer.parseInt(accidente.getText()),
                GetDateContract()
        );
        return  client;
    }
    public Vehicul GetDateVehicul() throws  ParseException{
        Vehicul vehicul = new Vehicul(
                nrInmatriculare.getText(),
                Integer.parseInt(anFabricatie.getText()),
                producator.getText(),
                Integer.parseInt(valEstimata.getText()),
                GetNormaPoluare());
        return vehicul;
    }
    public Contract GetDateContract() throws ParseException{
        dataCurenta = new Date();

        LocalDate now = LocalDate.now();
        Contract contract = new Contract(
                GetDateVehicul(),
                listaAcoperireAsigurari,
                listaAsigurare,
                listaAcoperire,
                listaPlafon,
                lunaValabilitate,
                now );

        return contract;
    };
    public int GetNormaPoluare(){

        if (euro3.isSelected()){
            return 3;
        }else if (euro4.isSelected()){
            return 4;
        }else if (euro5.isSelected()){
            return 5;
        }else if (euro6.isSelected()){
            return 6;
        }else
            return 0;

    };
    public void GetAsigurariAcoperite(){
        ToateAsigurarile toateAsigurarile = new ToateAsigurarile();
        AsigurareObligatorie asigurareObligatorie = new AsigurareObligatorie();
        chkToate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chkCoducator.setEnabled(false);
                chkMasina.setEnabled(false);
                chkAsistenta.setEnabled(false);
                chkObligatoriu.setEnabled(false);


                for (int i = 0; i< toateAsigurarile.acoperireToateAsigurarile.length;i++){
                    listaAcoperireAsigurari.add(toateAsigurarile.acoperireToateAsigurarile[i]);
                }
                listaAsigurare.add(toateAsigurarile.getAsigurare());
                listaAcoperire.add(toateAsigurarile.getAcoperire());
                listaPlafon.add(toateAsigurarile.getPlafon());
            }
        });

        chkObligatoriu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaAcoperireAsigurari.add(asigurareObligatorie.acoperireAsigurareObligatorie[0]);
                listaAsigurare.add(asigurareObligatorie.getAsigurare());
                listaAcoperire.add(asigurareObligatorie.getAcoperire());
                listaPlafon.add(asigurareObligatorie.getPlafon());

            }
        });

        chkMasina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsigurareMasina asigurareMasina = new AsigurareMasina();

                listaAcoperireAsigurari.add(asigurareMasina.acoperireAsigurareMasina[0]);
                listaAsigurare.add(asigurareMasina.getAsigurare());
                listaAcoperire.add(asigurareMasina.getAcoperire());
                listaPlafon.add(asigurareMasina.getPlafon());

            }
        });

        chkCoducator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conducator conducator = new Conducator();
                listaAcoperireAsigurari.add(conducator.acoperireAsigurareConducator[0]);
                listaAsigurare.add(conducator.getAsigurare());
                listaAcoperire.add(conducator.getAcoperire());
                listaPlafon.add(conducator.getPlafon());

            }
        });

        chkAsistenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Asistenta asistenta = new Asistenta();

                // Adaugare detalii asigurare
                for (int i = 0; i< asistenta.acoperireAsigurareAsistenta.length; i++) {
                    listaAcoperireAsigurari.add(asistenta.acoperireAsigurareAsistenta[i]);
                }
                listaAsigurare.add(asistenta.getAsigurare());
                listaAcoperire.add(asistenta.getAcoperire());
                listaPlafon.add(asistenta.getPlafon());
            }
        });

    }
    public void SaveClientMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("F:/myfile.txt");
        int numarTelefon = Integer.parseInt(telefon.getText());

        if (!file.exists()) {
            // crearea unui nou fisier
            System.out.println("Nu exista");
            file.createNewFile();

            SaveClientMaptoNewFile(numarTelefon, file);
        } else {
            // fisierul exista
            TreeMap<Integer, Client> newMaptoSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Client> mapInFile = (TreeMap<Integer, Client>) ois.readObject();
            ois.close();
            is.close();

            // Vechea mapa
            for (Map.Entry<Integer, Client> m : mapInFile.entrySet()) {
                newMaptoSave.put(m.getKey(), m.getValue());
            }

            // Update mapa: Adaugare client nou mapa
            newMaptoSave.put(numarTelefon, GetDateClient());

            // Salvare updateuri in fisiere
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMaptoSave);
            oos.flush();
            oos.close();

        }

    }
    private void SaveClientMaptoNewFile(int numarTelefon, File file) throws ParseException, IOException {

        TreeMap<Integer, Client> newMaptoSave = new TreeMap<>();

        // Adaugare client nou in mapa
        newMaptoSave.put(numarTelefon, GetDateClient());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }
    private void NewCustomer(){
        listaAcoperireAsigurari.clear();
        listaAsigurare.clear();
        listaAcoperire.clear();
        listaPlafon.clear();
        cond1= false;
        cond2= false;
        cond3= false;

        nume.setText("");
        prenume.setText("");
        oras.setText("");
        telefon.setText("");
        accidente.setText("");
        nrInmatriculare.setText("");
        anFabricatie.setText("");
        producator.setText("");
        valEstimata.setText("");

        G1.clearSelection();
        G2.clearSelection();

        chkObligatoriu.setSelected(false);
        chkToate.setSelected(false);
        chkCoducator.setSelected(false);
        chkMasina.setSelected(false);
        chkAsistenta.setSelected(false);

        chkCoducator.setEnabled(true);
        chkMasina.setEnabled(true);
        chkAsistenta.setEnabled(true);
        chkObligatoriu.setEnabled(true);
    }
    private void CautaClientDupaNrAsigurare(){
        File file = new File("F:/myfile.txt");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer,Client> mapInFile = (TreeMap<Integer,Client>)ois.readObject();

            Client c_finded = mapInFile.get(Integer.parseInt(txtCauta.getText()));
            txtClient.setText(c_finded.toString());
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private Client CautaSumePlataClient(){
        Client client = new Client();
        File file = new File("F:/myfile.txt");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Client> mapInFile =  (TreeMap<Integer,Client>)ois.readObject();

            ois.close();
            is.close();

            client = mapInFile.get(Integer.parseInt(fdClientCerere.getText()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return client;
    }
    private boolean VerificaValabilitateContract (LocalDate valabilitateAsigurare){
        LocalDate now = LocalDate.now();

        if (now.isBefore(valabilitateAsigurare)){
            cond3 = true;
            return true;
        }else{
            cond3 = false;
            return false;
        }
    }
    private boolean ValabilitateCerere(){
        if (cond1 == true && cond2 == true && cond3 == true){
            lblStatusCerere.setText("Status cerere: Poti sa inregistrezi cererea");
            return true;
        }else{
            lblStatusCerere.setText("Status cerere: Nu poti sa inregistrezi cererea");
            return false;
        }
    }
    private void afiseazaDetaliiAsigurare(){

        for (int i = 0; i< listaAsigurare.size(); i++){
            totalAsiguarare += listaAsigurare.get(i);
            totalAcoperire += listaAcoperire.get(i);
            totalPlafon += listaPlafon.get(i);
        }

        float valoareAsigurare = totalAsiguarare*Integer.parseInt(valEstimata.getText());
        String producatorMasina = producator.getText();
        int numarAccidente = Integer.parseInt(accidente.getText());
        int anFabricatieMasina = Integer.parseInt(anFabricatie.getText());

        //Adaugare valoare asigurare daca producatorul este unul premium
        if (producatorMasina.matches("BMW") || producatorMasina.matches("Mercedes") || producatorMasina.matches("Audi")){
            valoareAsigurare += 200;
        }
        //Adaugare valoare asigurare daca masina are o norma de poluare mai veche
        if(GetNormaPoluare() == 3){
            valoareAsigurare += 200;
        }else if(GetNormaPoluare() == 4){
            valoareAsigurare += 100;
        }else if(GetNormaPoluare() == 5){
            valoareAsigurare += 50;
        }else if(GetNormaPoluare() == 6){
            valoareAsigurare += 25;
        }
        //Adaugare valoare asigurare daca conducatorul are mai mult de 2 accidente in ultimii cinci ani
        if(numarAccidente > 2){
            valoareAsigurare += 50;
        }
        //Adaugare valoare asigurare daca masina este mai veche decat 2010
        if(anFabricatieMasina < 2010){
            valoareAsigurare += 50;
        }
        //Reducere asigurare daca incheie contract pe o perioada mai mare
        if(lunaValabilitate == 1){
            valoareAsigurare *= 0.65;
        }else if(lunaValabilitate == 3){
            valoareAsigurare *= 0.8;
        }else if(lunaValabilitate == 12){
            valoareAsigurare *= 0.85;
        }

        zonaAsezare.setText(
                "Total Asigurare: "+valoareAsigurare + " RON \n "+
                "Total Acoperire: " + totalAcoperire*Integer.parseInt(valEstimata.getText()) + " RON \n"+
                "Max Plafon: "+totalPlafon*Integer.parseInt(valEstimata.getText()) + " RON \n"
        );
    }
    public static void main(String[] args) {
        EAsigurariMasini eAsigurariMasini = new EAsigurariMasini();
        eAsigurariMasini.setVisible(true);
        eAsigurariMasini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eAsigurariMasini.setTitle("E-Asigurari Masini");
        eAsigurariMasini.setBounds(0,0,1560,810);
    }
}
