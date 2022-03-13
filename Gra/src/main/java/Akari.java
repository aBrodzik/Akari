
import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Desktop;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klasa, która w większości zawiera Listenery oraz wywołuje całą grę
 */
public class Akari extends javax.swing.JFrame {
    /**
     * Creates new form Menu
     */
    public Akari() {
        initComponents();
    }
    
    
    static public int size=7; 
    static public int sekundy;
    static public int minuty;
    private boolean exit;
    static public JButton[][] boardList;
    static private boolean editrOrCreate;
    
    private static boolean saveExists(){
        File saveFile = new File("src\\save");
        File[] listOfFiles = saveFile.listFiles();
        
        
        return !(listOfFiles.length==0);
    }
    
    //niżej jest wygenerowany kod, nie dotykać
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        mainPanel = new java.awt.Panel();
        menu = new javax.swing.JPanel();
        goToOpcje = new javax.swing.JButton();
        goToContinueGame = new javax.swing.JButton();
        goToMapSelect = new javax.swing.JButton();
        goToHelp = new javax.swing.JButton();
        goToExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        opcje = new javax.swing.JPanel();
        goToMenufromOpcje = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        saveOpt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        resetOpt = new javax.swing.JButton();
        iconChooser = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        selCol = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cIcon = new javax.swing.JLabel();
        exitCofirm = new javax.swing.JPanel();
        wantToExit = new javax.swing.JButton();
        noWantToExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        mapSelectToPLay = new javax.swing.JPanel();
        createMap = new javax.swing.JButton();
        goBack = new javax.swing.JButton();
        editMap = new javax.swing.JButton();
        deleteMap = new javax.swing.JButton();
        goToPlay = new javax.swing.JButton();
        goToQuickGame = new javax.swing.JButton();
        mapListGUI = new javax.swing.JPanel();
        minimap = new javax.swing.JPanel();
        sizeToGenerate = new javax.swing.JSpinner();
        levelToGenerate = new javax.swing.JComboBox<>();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        Play = new javax.swing.JPanel();
        timer = new javax.swing.JLabel();
        clueCounter = new javax.swing.JLabel();
        showClue = new javax.swing.JButton();
        nextMap = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        goToMenuFromPlay = new javax.swing.JButton();
        board = new javax.swing.JPanel();
        print = new javax.swing.JButton();
        Editor = new javax.swing.JPanel();
        saveGeneratedMapButton = new javax.swing.JButton();
        goToMenu = new javax.swing.JButton();
        generateRandomMap = new javax.swing.JButton();
        rozmiarSetter = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        levelSetter = new javax.swing.JComboBox<>();
        editableMap = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akar.io");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(834, 627));
        setName("frame"); // NOI18N
        setSize(new java.awt.Dimension(834, 627));

        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setMaximumSize(new java.awt.Dimension(834, 627));
        mainPanel.setName(""); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(834, 627));
        mainPanel.setLayout(new java.awt.CardLayout());

        menu.setMaximumSize(new java.awt.Dimension(834, 650));
        menu.setMinimumSize(new java.awt.Dimension(834, 650));
        menu.setPreferredSize(new java.awt.Dimension(834, 627));
        menu.setRequestFocusEnabled(false);

        goToOpcje.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToOpcje.setText("Opcje");
        goToOpcje.setPreferredSize(new java.awt.Dimension(100, 23));
        goToOpcje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToOpcjeActionPerformed(evt);
            }
        });

        goToContinueGame.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToContinueGame.setText("Kontynuuj");
        goToContinueGame.setEnabled(saveExists());
        goToContinueGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goToContinueGame.setPreferredSize(new java.awt.Dimension(100, 23));
        goToContinueGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToContinueGameActionPerformed(evt);
            }
        });

        goToMapSelect.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToMapSelect.setText("Wybór Map");
        goToMapSelect.setPreferredSize(new java.awt.Dimension(100, 23));
        goToMapSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMapSelectActionPerformed(evt);
            }
        });

        goToHelp.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToHelp.setText("Jak grać?");
        goToHelp.setPreferredSize(new java.awt.Dimension(100, 23));
        goToHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToHelpActionPerformed(evt);
            }
        });

        goToExit.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToExit.setText("Wyjdź");
        goToExit.setPreferredSize(new java.awt.Dimension(100, 23));
        goToExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToExitActionPerformed(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(650, 660));

        jLabel1.setIcon(new javax.swing.ImageIcon("src\\Icon\\Akari.png"));
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(goToHelp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(goToOpcje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goToContinueGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goToMapSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(615, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(goToContinueGame, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goToMapSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(goToOpcje, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goToHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 176, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.JLabel miejsceNaLogo = new javax.swing.JLabel();
        javax.swing.ImageIcon logo = new javax.swing.ImageIcon("src\\Icon\\Akari.png");
        miejsceNaLogo.setIcon(logo);
        jPanel1.add(miejsceNaLogo);

        mainPanel.add(menu, "menu");

        opcje.setMaximumSize(new java.awt.Dimension(834, 650));
        opcje.setMinimumSize(new java.awt.Dimension(834, 650));
        opcje.setPreferredSize(new java.awt.Dimension(834, 627));

        goToMenufromOpcje.setText("Powrót");
        goToMenufromOpcje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMenufromOpcjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        saveOpt.setText("Zapisz Ustawienia");
        saveOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        resetOpt.setText("Ustawienia Domyślne ");
        resetOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetOptActionPerformed(evt);
            }
        });

        iconChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bulb", "IDontWantoTosetTheWorldOnFire", "JustIgnoreThat", "LowGraphicConfig", "MrCandle", "XmasSpecial", "YouAreSafeNow" }));
        iconChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                iconChooserItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel5.setText("Wybierz żarówkę");

        selCol.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        selCol.setText("Wybierz kolor");
        selCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selColActionPerformed(evt);
            }
        });

        jPanel4.setBackground(Options.kolorZar);
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cIcon.setBackground(new java.awt.Color(255, 255, 255));
        cIcon.setForeground(new java.awt.Color(255, 255, 255));
        cIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cIcon.setMaximumSize(new java.awt.Dimension(169, 169));
        cIcon.setMinimumSize(new java.awt.Dimension(169, 169));
        cIcon.setPreferredSize(new java.awt.Dimension(169, 169));
        Image rawImageIcon = new ImageIcon("src\\bulbs\\bulb.png").getImage();
        Icon icon = new ImageIcon(rawImageIcon.getScaledInstance(169, 169, SCALE_SMOOTH));
        cIcon.setIcon(icon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout opcjeLayout = new javax.swing.GroupLayout(opcje);
        opcje.setLayout(opcjeLayout);
        opcjeLayout.setHorizontalGroup(
            opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcjeLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(selCol)
                        .addGap(223, 223, 223)
                        .addGroup(opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(resetOpt)
                    .addComponent(saveOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goToMenufromOpcje)
                    .addGroup(opcjeLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        opcjeLayout.setVerticalGroup(
            opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjeLayout.createSequentialGroup()
                .addGroup(opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcjeLayout.createSequentialGroup()
                        .addComponent(goToMenufromOpcje)
                        .addGap(70, 70, 70)
                        .addComponent(selCol))
                    .addGroup(opcjeLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82)
                .addGroup(opcjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcjeLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveOpt)
                .addGap(14, 14, 14)
                .addComponent(resetOpt)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        mainPanel.add(opcje, "opcje");

        exitCofirm.setMaximumSize(new java.awt.Dimension(834, 650));
        exitCofirm.setMinimumSize(new java.awt.Dimension(834, 650));
        exitCofirm.setPreferredSize(new java.awt.Dimension(834, 627));

        wantToExit.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        wantToExit.setText("Tak");
        wantToExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wantToExitActionPerformed(evt);
            }
        });

        noWantToExit.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        noWantToExit.setText("Nie");
        noWantToExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noWantToExitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jLabel4.setText("Czy na pewno chcesz wyjść?");

        javax.swing.GroupLayout exitCofirmLayout = new javax.swing.GroupLayout(exitCofirm);
        exitCofirm.setLayout(exitCofirmLayout);
        exitCofirmLayout.setHorizontalGroup(
            exitCofirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitCofirmLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(exitCofirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(exitCofirmLayout.createSequentialGroup()
                        .addComponent(wantToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(noWantToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(169, 169, 169))
        );
        exitCofirmLayout.setVerticalGroup(
            exitCofirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitCofirmLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(exitCofirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wantToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noWantToExit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        mainPanel.add(exitCofirm, "exitConfirm");

        mapSelectToPLay.setMaximumSize(new java.awt.Dimension(834, 650));
        mapSelectToPLay.setMinimumSize(new java.awt.Dimension(834, 650));
        mapSelectToPLay.setName(""); // NOI18N

        createMap.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        createMap.setText("Stwórz ");
        createMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMapActionPerformed(evt);
            }
        });

        goBack.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goBack.setText("Powrót");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        editMap.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        editMap.setText("Edytuj");
        editMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMapActionPerformed(evt);
            }
        });

        deleteMap.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        deleteMap.setLabel("Usuń");
        deleteMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMapActionPerformed(evt);
            }
        });

        goToPlay.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        goToPlay.setText("Graj");
        goToPlay.setToolTipText("");
        goToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToPlayActionPerformed(evt);
            }
        });

        goToQuickGame.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        goToQuickGame.setText("Losowa Mapa ");
        goToQuickGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToQuickGameActionPerformed(evt);
            }
        });

        mapListGUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mapListGUI.setLayout(new javax.swing.BoxLayout(mapListGUI, javax.swing.BoxLayout.LINE_AXIS));

        minimap.setBackground(new java.awt.Color(255, 255, 255));
        minimap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        minimap.setMaximumSize(new java.awt.Dimension(91, 91));
        minimap.setMinimumSize(new java.awt.Dimension(91, 91));
        minimap.setPreferredSize(new java.awt.Dimension(71, 71));
        minimap.setLayout(new java.awt.GridLayout(1, 0));

        sizeToGenerate.setModel(new javax.swing.SpinnerNumberModel(7, 7, 25, 1));

        levelToGenerate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Łatwy", "Średni", "Trudny" }));
        levelToGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelToGenerateActionPerformed(evt);
            }
        });

        progressBar.setForeground(new java.awt.Color(255, 255, 51));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Twój postęp");

        javax.swing.GroupLayout mapSelectToPLayLayout = new javax.swing.GroupLayout(mapSelectToPLay);
        mapSelectToPLay.setLayout(mapSelectToPLayLayout);
        mapSelectToPLayLayout.setHorizontalGroup(
            mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapSelectToPLayLayout.createSequentialGroup()
                .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(mapListGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(goBack)
                        .addGap(92, 92, 92)
                        .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapSelectToPLayLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(minimap, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                        .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(goToPlay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mapSelectToPLayLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(levelToGenerate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(sizeToGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(createMap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editMap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteMap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(goToQuickGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        mapSelectToPLayLayout.setVerticalGroup(
            mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(goBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mapListGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mapSelectToPLayLayout.createSequentialGroup()
                        .addComponent(minimap, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(deleteMap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editMap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createMap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(goToQuickGame, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(mapSelectToPLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sizeToGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelToGenerate))
                        .addGap(18, 18, 18)
                        .addComponent(goToPlay)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        progressBar.setStringPainted(true);
        progressBar.setForeground(java.awt.Color.blue);
        progressBar.updateUI();
        javax.swing.UIManager.put("ProgressBar.foreground",java.awt.Color.BLUE);

        mainPanel.add(mapSelectToPLay, "mapSelect");

        Play.setMaximumSize(new java.awt.Dimension(834, 650));
        Play.setMinimumSize(new java.awt.Dimension(834, 650));
        Play.setPreferredSize(new java.awt.Dimension(834, 627));

        timer.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer.setText("00:00"
        );
        timer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        clueCounter.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        clueCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clueCounter.setText(Board.clues +"");

        showClue.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        showClue.setLabel("Wskazówka");
        showClue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showClueActionPerformed(evt);
            }
        });

        nextMap.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        nextMap.setText("Powrót ");
        nextMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextMapActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        reset.setLabel("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        goToMenuFromPlay.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        goToMenuFromPlay.setText("Zapisz i wróc do menu");
        goToMenuFromPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMenuFromPlayActionPerformed(evt);
            }
        });

        board.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        board.setMaximumSize(null);
        board.setName(""); // NOI18N
        board.setRequestFocusEnabled(false);
        board.setLayout(new java.awt.GridLayout(1, 0));

        print.setText("Drukuj");
        print.setActionCommand("");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlayLayout = new javax.swing.GroupLayout(Play);
        Play.setLayout(PlayLayout);
        PlayLayout.setHorizontalGroup(
            PlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayLayout.createSequentialGroup()
                .addGroup(PlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PlayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clueCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PlayLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(goToMenuFromPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showClue, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextMap, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(588, Short.MAX_VALUE))
        );
        PlayLayout.setVerticalGroup(
            PlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayLayout.createSequentialGroup()
                        .addComponent(nextMap)
                        .addGap(18, 18, 18)
                        .addComponent(goToMenuFromPlay)
                        .addGap(12, 12, 12)
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(showClue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clueCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        mainPanel.add(Play, "board");

        Editor.setMaximumSize(new java.awt.Dimension(834, 650));
        Editor.setMinimumSize(new java.awt.Dimension(834, 650));

        saveGeneratedMapButton.setText("Zapisz");
        saveGeneratedMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGeneratedMapButtonActionPerformed(evt);
            }
        });

        goToMenu.setText("Powrót");
        goToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMenuActionPerformed(evt);
            }
        });

        generateRandomMap.setText("Losowa");
        generateRandomMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateRandomMapActionPerformed(evt);
            }
        });

        rozmiarSetter.setModel(new javax.swing.SpinnerNumberModel(7, 2, 25, 1));

        jLabel2.setText("Rozmiar");

        levelSetter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Łatwy", "Średni", "Trudny" }));
        levelSetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelSetterActionPerformed(evt);
            }
        });

        editableMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        editableMap.setPreferredSize(new java.awt.Dimension(534, 534));

        javax.swing.GroupLayout editableMapLayout = new javax.swing.GroupLayout(editableMap);
        editableMap.setLayout(editableMapLayout);
        editableMapLayout.setHorizontalGroup(
            editableMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        editableMapLayout.setVerticalGroup(
            editableMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Sprawdź");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditorLayout = new javax.swing.GroupLayout(Editor);
        Editor.setLayout(EditorLayout);
        EditorLayout.setHorizontalGroup(
            EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToMenu)
                    .addGroup(EditorLayout.createSequentialGroup()
                        .addComponent(editableMap, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveGeneratedMapButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateRandomMap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelSetter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditorLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rozmiarSetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        EditorLayout.setVerticalGroup(
            EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editableMap, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(EditorLayout.createSequentialGroup()
                        .addComponent(generateRandomMap, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(EditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rozmiarSetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(levelSetter)
                        .addGap(306, 306, 306)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(saveGeneratedMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        rozmiarSetter.addChangeListener(new javax.swing.event.ChangeListener(){

            @Override
            public void stateChanged(javax.swing.event.ChangeEvent e){
                editableMap.removeAll();
                MapEditor.fillWithEmptyButtons();
            }
        });

        mainPanel.add(Editor, "editor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void noWantToExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noWantToExitActionPerformed
    CardLayout card = (CardLayout)mainPanel.getLayout();
    card.show(mainPanel, "menu");
    }//GEN-LAST:event_noWantToExitActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
    cardLayout.show(mainPanel, "menu");
    }//GEN-LAST:event_goBackActionPerformed

    private void deleteMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMapActionPerformed
       String name = MapList.currentFileName;
       File saveFile = new File("src\\maps\\"+name);
       javax.swing.JOptionPane.showMessageDialog(null, "Mapa została usunięta");
       saveFile.delete();
       MapList.fillWithMaps();
        
    }//GEN-LAST:event_deleteMapActionPerformed

    @SuppressWarnings("ArrayHashCode")
    private void goToQuickGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToQuickGameActionPerformed
    
    //generowanie mapy  
    int level;
    String sLevel;
    size=(int) sizeToGenerate.getValue();
    String name;
    if(levelToGenerate.getSelectedItem().equals("Łatwy")){
        level=1;
        sLevel="easy";
        } else if (levelToGenerate.getSelectedItem().equals("Średni")){
            level=2;
            sLevel="medium";
        }else{level=3;
                sLevel="hard";}
    
    String[][] map;
    Generator o = new Generator(size,level); 
    o.newSolvedMap();
    map = o.getMap();
    
    name = map.hashCode()+"RandomMap"+size+size+sLevel;
    ZapisOdczytMapy zapisz = new ZapisOdczytMapy();
    zapisz.write("src\\maps\\"+name+".csv",map , sLevel, size);
    
    MapList.currentFileName=(name+".csv");
    Board.fillWithButtons(1);
    //wyświelenie planszy
    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
    cardLayout.show(mainPanel, "board");

    }//GEN-LAST:event_goToQuickGameActionPerformed

    private void goToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToPlayActionPerformed
    Board.fillWithButtons(1);  
    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
    cardLayout.show(mainPanel, "board");
    }//GEN-LAST:event_goToPlayActionPerformed

    private void goToExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToExitActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "exitConfirm");
    }//GEN-LAST:event_goToExitActionPerformed

    private void goToHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToHelpActionPerformed
       
    try {
        Desktop.getDesktop().browse(new URL("https://www.nikoli.co.jp/iphone/en/bj_tutorial.html").toURI());
    } catch (IOException | URISyntaxException e) {
       //ignore 
    }
      
    }//GEN-LAST:event_goToHelpActionPerformed

    private void goToMapSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMapSelectActionPerformed
        MapList.fillWithMaps();    
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "mapSelect");
    }//GEN-LAST:event_goToMapSelectActionPerformed

    private void goToContinueGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToContinueGameActionPerformed
       Board.fillWithButtons(0);//jeśli istnieje plik zapisu -> pozwól na wciśnięcie przycisku i przejdź do grania
       CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
       cardLayout.show(mainPanel, "board");

    }//GEN-LAST:event_goToContinueGameActionPerformed

    /* buttons (powtarzają się, niektóre robią to samo, poki co niech jest tak
       bo może później doda się do nich indywidualne metody, na koniec porządek
    */
    private void goToOpcjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToOpcjeActionPerformed
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "opcje");
    }//GEN-LAST:event_goToOpcjeActionPerformed

    private void saveGeneratedMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGeneratedMapButtonActionPerformed
    if(editrOrCreate){
        String[] nameWithoutCSV = MapList.currentFileName.split("\\.");
        MapEditor.save(nameWithoutCSV[0]);
    }
    else{
        MapEditor.save();
    }
    editrOrCreate=false;
    }//GEN-LAST:event_saveGeneratedMapButtonActionPerformed

    @SuppressWarnings("UnnecessaryBoxing")
    private void editMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMapActionPerformed
   editrOrCreate=true;
    ZapisOdczytMapy doEdycji = new ZapisOdczytMapy();
        try {
            doEdycji.read("src\\maps\\"+MapList.currentFileName);
        } catch (IOException ex) {
           //ignore
        }
      String[][] mapToEdit = doEdycji.getCsv();
      String[] head = doEdycji.getNaglowek();
      String level = head[0];
     levelSetter.setSelectedItem(head[0]);
     rozmiarSetter.setValue(Integer.valueOf(mapToEdit[0].length));
     MapEditor.fillWithEmptyButtons();
     MapEditor.setIcons(mapToEdit);
     CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
     cardLayout.show(mainPanel, "editor");
    }//GEN-LAST:event_editMapActionPerformed

    private void createMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMapActionPerformed
      MapEditor.fillWithEmptyButtons();
      CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
      cardLayout.show(mainPanel, "editor");
      
    }//GEN-LAST:event_createMapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     MapEditor.sprawdź();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void goToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMenuActionPerformed
    editrOrCreate=false; 
    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
    cardLayout.show(mainPanel,"menu"); // TODO add your handling code here:   // TODO add your handling code here:
    }//GEN-LAST:event_goToMenuActionPerformed

    private void levelSetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelSetterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelSetterActionPerformed

    private void generateRandomMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateRandomMapActionPerformed
    saveGeneratedMapButton.setEnabled(false);
    
    MapEditor.setIcons(MapEditor.randomMap());        // TODO add your handling code here:
    }//GEN-LAST:event_generateRandomMapActionPerformed

    private void wantToExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wantToExitActionPerformed
        dispose();
    }//GEN-LAST:event_wantToExitActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage bimage = (BufferedImage) board.createImage(board.getWidth(), board.getHeight());
        String[] name = Board.name.split("\\.");
        screenSize.getHeight();
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(board.getLocationOnScreen().x,board.getLocationOnScreen().y,board.getSize().height,board.getSize().width));
            ImageIO.write(image, "png", new File("src\\printables\\"+name[0]+"screenshot.png"));
            } catch (AWTException | IOException ex) {
                Logger.getLogger(Akari.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_printActionPerformed

    private void goToMenuFromPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMenuFromPlayActionPerformed
        Board.boardSave();

        board.removeAll();
        goToContinueGame.setEnabled(saveExists());
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        cardLayout.show(mainPanel,"menu"); // TODO add your handling code here:

    }//GEN-LAST:event_goToMenuFromPlayActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        Stopwatch.reset();

        Board.clearButtons();

        Board.clues=0;
        Board.clueCounter.setText(Board.clues+"");

    }//GEN-LAST:event_resetActionPerformed

    private void nextMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMapActionPerformed
        MapList.fillWithMaps();
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "mapSelect");
        board.removeAll();
        Stopwatch.getTime();
    }//GEN-LAST:event_nextMapActionPerformed

    private void showClueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showClueActionPerformed
        Board.showClue(boardList);
    }//GEN-LAST:event_showClueActionPerformed

    private void levelToGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelToGenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelToGenerateActionPerformed

    private void iconChooserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_iconChooserItemStateChanged
        String iconName=(String) iconChooser.getSelectedItem();
        Image rawImageIcon = new ImageIcon("src\\bulbs\\"+iconName+".png").getImage();
            Icon icon = new ImageIcon(rawImageIcon.getScaledInstance(169, 169, SCALE_SMOOTH));
            cIcon.setIcon(icon);
    }//GEN-LAST:event_iconChooserItemStateChanged

    private void resetOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetOptActionPerformed
        Options.kolorZar=Color.YELLOW;        // TODO add your handling code here:
        Options.swapIcons("bulb");
        jPanel4.setBackground(Color.YELLOW);
        Image rawImageIcon = new ImageIcon("src\\bulbs\\bulb.png").getImage();
        Icon icon = new ImageIcon(rawImageIcon.getScaledInstance(169, 169, SCALE_SMOOTH));
        cIcon.setIcon(icon);
        iconChooser.setSelectedIndex(0);
        
    }//GEN-LAST:event_resetOptActionPerformed

    private void saveOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptActionPerformed
        Options.kolorZar=Options.tempColor;
        Options.swapIcons((String) iconChooser.getSelectedItem());
    }//GEN-LAST:event_saveOptActionPerformed

    private void goToMenufromOpcjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMenufromOpcjeActionPerformed
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "menu");
    }//GEN-LAST:event_goToMenufromOpcjeActionPerformed

    private void selColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selColActionPerformed
        Window parentWindow = SwingUtilities.windowForComponent(selCol);
        JColorChooser jcc = new JColorChooser();
        jcc.getSelectionModel().addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                Options.tempColor=jcc.getColor();
                jPanel4.setBackground(Options.tempColor);
            }
        });
        JDialog dialog = new JDialog(parentWindow);
        dialog.add(jcc);
        dialog.pack();
        dialog.setVisible(true);
        
    }//GEN-LAST:event_selColActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Akari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Akari().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Editor;
    private javax.swing.JPanel Play;
    public static javax.swing.JPanel board;
    private javax.swing.JLabel cIcon;
    public static javax.swing.JLabel clueCounter;
    private javax.swing.JButton createMap;
    private javax.swing.JButton deleteMap;
    private javax.swing.JButton editMap;
    public static javax.swing.JPanel editableMap;
    private javax.swing.JPanel exitCofirm;
    private javax.swing.JButton generateRandomMap;
    private javax.swing.JButton goBack;
    protected static javax.swing.JButton goToContinueGame;
    private javax.swing.JButton goToExit;
    private javax.swing.JButton goToHelp;
    private javax.swing.JButton goToMapSelect;
    private javax.swing.JButton goToMenu;
    private javax.swing.JButton goToMenuFromPlay;
    private javax.swing.JButton goToMenufromOpcje;
    private javax.swing.JButton goToOpcje;
    private javax.swing.JButton goToPlay;
    private javax.swing.JButton goToQuickGame;
    private javax.swing.JComboBox<String> iconChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner jSpinner1;
    public static javax.swing.JComboBox<String> levelSetter;
    private javax.swing.JComboBox<String> levelToGenerate;
    protected static java.awt.Panel mainPanel;
    public static javax.swing.JPanel mapListGUI;
    public static javax.swing.JPanel mapSelectToPLay;
    private javax.swing.JPanel menu;
    public static javax.swing.JPanel minimap;
    private javax.swing.JButton nextMap;
    private javax.swing.JButton noWantToExit;
    private javax.swing.JPanel opcje;
    private javax.swing.JButton print;
    public static javax.swing.JProgressBar progressBar;
    private javax.swing.JButton reset;
    private javax.swing.JButton resetOpt;
    public static javax.swing.JSpinner rozmiarSetter;
    public static javax.swing.JButton saveGeneratedMapButton;
    private javax.swing.JButton saveOpt;
    private javax.swing.JButton selCol;
    private javax.swing.JButton showClue;
    private javax.swing.JSpinner sizeToGenerate;
    public static javax.swing.JLabel timer;
    private javax.swing.JButton wantToExit;
    // End of variables declaration//GEN-END:variables
}
