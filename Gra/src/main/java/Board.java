import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 * Klasa, która głównie opisuje GUI planszy 
 */
public class Board extends Akari{
   
  static private int intSizeFactor;  //współczynnik do skalowania obrazów i przycisków
  static public int currentColumn, currentRow;  //wielkosci ktore bedą przechowywać współrzędne przecisku, który został ostatnio wciśnięty 
  static public JButton[][] plansza; //do konwersji
  static public String name,level; //nazwa i poziom obecnej mapy
  static public Icon blankSpaceIcon, bulbIcon,xIcon,icon0,icon1,icon2,icon3,icon4,boxIcon,clueIcon; // ikony 
  static public int clues=0; // wskazówki 

    /**
     *  Metoda skalująca ikony, powinna być wywoływana przy każdej zmianie rozmiaru planszy
     * @param scaleFactor
     */
  static void scaleImages(int scaleFactor){
        Image rawImageBox = new ImageIcon("src\\Icon\\box.png").getImage();
        Image rawImage0 = new ImageIcon("src\\Icon\\0.png").getImage();
        Image rawImage1 = new ImageIcon("src\\Icon\\1.png").getImage();
        Image rawImage2 = new ImageIcon("src\\Icon\\2.png").getImage();
        Image rawImage3 = new ImageIcon("src\\Icon\\3.png").getImage();
        Image rawImage4 = new ImageIcon("src\\Icon\\4.png").getImage();
        Image rawImageX = new ImageIcon("src\\Icon\\X.png").getImage();
        Image rawImageBulb = new ImageIcon("src\\Icon\\bulb.png").getImage();
        Image rawImageBlankSpace = new ImageIcon("src\\Icon\\blankSpace.png").getImage();
        Image rawImageClueIcon = new ImageIcon("src\\Icon\\clueIcon.png").getImage();
        
        blankSpaceIcon = new ImageIcon(rawImageBlankSpace.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        bulbIcon = new ImageIcon(rawImageBulb.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        xIcon = new ImageIcon(rawImageX.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        icon0 = new ImageIcon(rawImage0.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        icon1 = new ImageIcon(rawImage1.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        icon2 = new ImageIcon(rawImage2.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        icon3 = new ImageIcon(rawImage3.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        icon4 = new ImageIcon(rawImage4.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        boxIcon = new ImageIcon(rawImageBox.getScaledInstance(scaleFactor, scaleFactor, SCALE_SMOOTH));
        clueIcon =  new ImageIcon(rawImageClueIcon.getScaledInstance(scaleFactor, intSizeFactor, SCALE_SMOOTH));
    }
    

    /**
     * Getter indexu kolumny
     * @param button przcisk którego kolumne chcemy dostać
     * @return index kolumny (int)
     */
    static int getColumnIndex(JButton button){
        int x=  (int) button.getClientProperty("kolumna");
        return x;
    }
    /**
     * Getter indexu wiersza
     * @param button przcisk którego wiersz chcemy dostać
     * @return index wiersza (int)
     */
    static int getRowIndex(JButton button){
        int y = (int) button.getClientProperty("wiersz");
        return y;
    }
    
    
    /**
     * Sprawdź, czy wszystkie pola są poprawne, czy wszystkie puste zapolone, czy nie ma źle postawionych żarówek
     * jeśli tak daj OptionPane z info, że rozwiązana
     * @param board 
     */
    static private void isSolved(JButton[][] board){
        boolean solved=true;
        for (int i=0; i<size; i++){
               for (int j=0; j<size;j++){
               if(((board[i][j].getBackground()==Color.WHITE || board[i][j].getBackground()==Color.RED)) && (board[i][j].getIcon() != boxIcon)){
                   solved=false;
               }
            }
        }
    if(solved){
        Stopwatch.stop = false;
        JOptionPane pane = new JOptionPane();
        File saveFile = new File("src\\save");
        File[] listOfFiles = saveFile.listFiles();
          for (File fil : listOfFiles){
              fil.delete();
          }
        pane.showMessageDialog(null, "GRATULACJE MAPA ROZWIĄZANA!!!");  
        ZapisOdczytMapy write = new ZapisOdczytMapy();
        int[] czas = Stopwatch.getTime();
        String czaS = czas[0]+":"+czas[1];
        write.write("src\\maps\\"+name, Board.buttonToCsvInBoard(board), level, size,czaS,clues);
        goToContinueGame.setEnabled(false);
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "menu");
        Akari.board.removeAll();
    
        }
    }
   
    
    /**
     * Sprawdzacz czy są dobrze żarówki wstawione, woła metodę isSolved
     * @param board 
     */
    static private void sprawdz(JButton[][] board){
       int required,given;
       for (int i=0; i<size; i++){
            for (int j=0; j<size;j++){
                if (board[i][j].getIcon() == icon0 ||
                    board[i][j].getIcon() == icon1 ||
                    board[i][j].getIcon() == icon2 ||
                    board[i][j].getIcon() == icon3 ||
                    board[i][j].getIcon() == icon4){
                    required = (int) boardList[i][j].getClientProperty("required");
                    given=0;
                    try{ 
                        if(board[i][j-1].getIcon()==bulbIcon){
                            given++;
                        }
                    }catch(ArrayIndexOutOfBoundsException exp){
                         //do nothing
                       }     
                    try{ 
                        if(board[i][j+1].getIcon()==bulbIcon){
                            given++;
                        } 
                    }catch(ArrayIndexOutOfBoundsException exp){
                           //do nothing
                       }
                    try{ 
                        if(board[i-1][j].getIcon()==bulbIcon){
                            given++;
                        }
                    }catch(ArrayIndexOutOfBoundsException exp){
                           //do nothing
                       }
                    try{ 
                        if(board[i+1][j].getIcon()==bulbIcon){
                            given++;
                        } 
                    }catch(ArrayIndexOutOfBoundsException exp){
                           //do nothing
                    }
                    if(required==given){
                       board[i][j].setBackground(Color.GRAY);
                    }
                    if(required < given){
                        board[i][j].setBackground(Color.RED);
                    }
                    if (required > given){
                       board[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }  
     isSolved(board);
    }
    
    
   /**
    * Metoda zapalajaca pola
    * @param row rzad wstawianej zarowki
    * @param column kolumna wstawianej zarowki
    * @param board plansza
    */
   static private void zapal(int row, int column, JButton [][] board){ //row i column od 0
        int zapalenia;
        board[row][column].putClientProperty("iloscZapalen",1);
        board[row][column].setBackground(Options.kolorZar);
        for(int i=column-1; i>=0;i--){//w lewo
            if(board[row][i].getIcon().equals(boxIcon)||
                board[row][i].getIcon().equals(icon0)||
                board[row][i].getIcon().equals(icon1)||
                board[row][i].getIcon().equals(icon2)||
                board[row][i].getIcon().equals(icon3)||
                board[row][i].getIcon().equals(icon4)
                ){
                break;
            }
            else{
                zapalenia=(int) board[row][i].getClientProperty("iloscZapalen")+1;
                board[row][i].putClientProperty("iloscZapalen",zapalenia);
                board[row][i].setBackground(Options.kolorZar);
            }
        }
       for(int i=column+1; i<size;i++){//w prawo
            if(board[row][i].getIcon().equals(boxIcon)||
                board[row][i].getIcon().equals(icon0)||
                board[row][i].getIcon().equals(icon1)||
                board[row][i].getIcon().equals(icon2)||
                board[row][i].getIcon().equals(icon3)||
                board[row][i].getIcon().equals(icon4)
                ){
                break;
            }
            else{
                zapalenia=(int) board[row][i].getClientProperty("iloscZapalen")+1;
                board[row][i].putClientProperty("iloscZapalen",zapalenia);
                board[row][i].setBackground(Options.kolorZar);
            }
       }
        for (int j=row+1;j<size;j++){ //dół
            if(board[j][column].getIcon().equals(boxIcon)||
                board[j][column].getIcon().equals(icon0)||
                board[j][column].getIcon().equals(icon1)||
                board[j][column].getIcon().equals(icon2)||
                board[j][column].getIcon().equals(icon2)||
                board[j][column].getIcon().equals(icon3)||
                board[j][column].getIcon().equals(icon4)){
                break;
            }
            else{
                zapalenia=(int) board[j][column].getClientProperty("iloscZapalen")+1;
                board[j][column].putClientProperty("iloscZapalen", zapalenia);
                board[j][column].setBackground(Options.kolorZar);
            }
        }
        for(int j=row-1; j>=0;j--){//w góre
             if(board[j][column].getIcon().equals(boxIcon)||
                board[j][column].getIcon().equals(icon0)||
                board[j][column].getIcon().equals(icon1)||
                board[j][column].getIcon().equals(icon2)||
                board[j][column].getIcon().equals(icon2)||
                board[j][column].getIcon().equals(icon3)||
                board[j][column].getIcon().equals(icon4)){
                break;
            }else{ zapalenia=(int) board[j][column].getClientProperty("iloscZapalen")+1;
             board[j][column].putClientProperty("iloscZapalen", zapalenia);
             board[j][column].setBackground(Options.kolorZar);}
        }
       }
   /**
    * Metoda, która gasi pola, które były wcześniej zapalone
    * @param row rzad gaszona
    * @param column kolumna gaszona
    * @param board plansza
    */
   static private void zgas(int row, int column, JButton[][] board){
       int zapalenia;
        board[row][column].putClientProperty("iloscZapalen",0);
        board[row][column].setBackground(Color.WHITE);
        for(int i=column-1; i>=0;i--){//w lewo
            if(board[row][i].getIcon().equals(boxIcon)||
                board[row][i].getIcon().equals(icon0)||
                board[row][i].getIcon().equals(icon1)||
                board[row][i].getIcon().equals(icon2)||
                board[row][i].getIcon().equals(icon3)||
                board[row][i].getIcon().equals(icon4)
                ){
                break;
            }
            else{
                zapalenia=(int) board[row][i].getClientProperty("iloscZapalen")-1;
                board[row][i].putClientProperty("iloscZapalen",zapalenia);
                if(board[row][i].getClientProperty("iloscZapalen").equals(0)){
                    board[row][i].setBackground(Color.WHITE);
                }
            }
        }
        for(int i=column+1; i<size;i++){//w prawo
            if(board[row][i].getIcon().equals(boxIcon)||
                    board[row][i].getIcon().equals(icon0)||
                    board[row][i].getIcon().equals(icon1)||
                    board[row][i].getIcon().equals(icon2)||
                    board[row][i].getIcon().equals(icon3)||
                    board[row][i].getIcon().equals(icon4)
                    ){
                break;
            }
           else{
                zapalenia=(int) board[row][i].getClientProperty("iloscZapalen")-1;
                board[row][i].putClientProperty("iloscZapalen",zapalenia);
                if(board[row][i].getClientProperty("iloscZapalen").equals(0)){
                     board[row][i].setBackground(Color.WHITE);
                }
            }
        }
        for (int j=row+1;j<size;j++){ //dół
            if(board[j][column].getIcon().equals(boxIcon)||
                 board[j][column].getIcon().equals(icon0)||
                 board[j][column].getIcon().equals(icon1)||
                 board[j][column].getIcon().equals(icon2)||
                 board[j][column].getIcon().equals(icon2)||
                 board[j][column].getIcon().equals(icon3)||
                 board[j][column].getIcon().equals(icon4)){
                break;
            }
            else{
                zapalenia=(int) board[j][column].getClientProperty("iloscZapalen")-1;
                board[j][column].putClientProperty("iloscZapalen", zapalenia);
                 if(board[j][column].getClientProperty("iloscZapalen").equals(0)){
                    board[j][column].setBackground(Color.WHITE);
                }
            }
        }
        for(int j=row-1; j>=0;j--){//w góre
             if(board[j][column].getIcon().equals(boxIcon)||
                 board[j][column].getIcon().equals(icon0)||
                 board[j][column].getIcon().equals(icon1)||
                 board[j][column].getIcon().equals(icon2)||
                 board[j][column].getIcon().equals(icon2)||
                 board[j][column].getIcon().equals(icon3)||
                 board[j][column].getIcon().equals(icon4)){
                break;
            }else{ zapalenia=(int) board[j][column].getClientProperty("iloscZapalen")-1;
             board[j][column].putClientProperty("iloscZapalen", zapalenia);
             if(board[j][column].getClientProperty("iloscZapalen").equals(0)){
                     board[j][column].setBackground(Color.WHITE);
                }
        }
   }    
   }
    
    /**
     * Metoda, która resetuje zawartość przycisków
     */
   static void clearButtons(){
       for (int i=0; i<(size); i++){
               for (int j=0; j<size;j++){
                   if (boardList[i][j].getIcon() != boxIcon &&
                       boardList[i][j].getIcon() != icon0 &&
                       boardList[i][j].getIcon() != icon1 &&
                       boardList[i][j].getIcon() != icon2 &&
                       boardList[i][j].getIcon() != icon3 &&
                       boardList[i][j].getIcon() != icon4){
                       boardList[i][j].setIcon(blankSpaceIcon);
                   }
              
               boardList[i][j].setBackground(Color.WHITE);
                boardList[i][j].putClientProperty("iloscZapalen",0);
                 }  
             }
   }
      /**
     * Metoda, która pokazuje i zapisuje wskazówki z properties
     */
    static void showClue(JButton[][] board){
        outerloop:
        for (int i=0; i<(size); i++){
               for (int j=0; j<size;j++){
                   if(board[i][j].getClientProperty("wskazówka").equals(true) && board[i][j].getIcon()!= bulbIcon && board[i][j].getIcon()!= clueIcon){
                       board[i][j].setIcon(clueIcon);
                       sprawdz(board);
                       clues++;
                       clueCounter.setText(clues+"");
                       break outerloop;
                   }
               }}
    }


    /**
     * Metoda, która wypełnia GUI przyciskami
     * @param tbc (0-wczytujemy zapis ; 1-wczytujemy mapę)
     */
    static void fillWithButtons(int tbc){
    String[][] csv,csvOrigin;
    String[] head;
    Stopwatch.getTime();
    clues=0;
    ZapisOdczytMapy staticMapaRead = new ZapisOdczytMapy(); //konwersja non-static -> static  <dopiero teraz to odrkyłem>
    try {
        if(tbc==0){ //jeśli wczytujemy zapis
        File save = new File("src\\save");
        File[] listFiles = save.listFiles();
        staticMapaRead.read(listFiles[0].getAbsolutePath()); 
        name=listFiles[0].getName();
        }else{
          name=MapList.currentFileName;
          staticMapaRead.read("src\\maps\\"+name);
        }
        
        csv= staticMapaRead.getCsv();
        head = staticMapaRead.getNaglowek();
        level = head[0];
        
        Stopwatch stopwatch = new Stopwatch();
        
        size = csv[0].length;
        intSizeFactor = (int) 500/size;
        scaleImages(intSizeFactor);
        
        plansza = new JButton[size][size];
        
        //ramka
        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 1); //stworzenie ramki do przycisków
        //tworzenie layoutu, który układa przyciski w siatce 
        board.setLayout(new java.awt.GridLayout(size,size));
        boardList = new JButton[size][size]; //lista przyciskow
        //wypelnianie planszy przyciskami
        for (int i=0; i<size; i++){
               for (int j=0; j<size;j++){ 
                JButton button = new JButton(); //tworzenie nowego przecisku
                   //rysowanie ikon
                   switch (csv[i][j]) {
                       case "0X":
                           button.setIcon(icon0);
                           button.putClientProperty("required", 0);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "1X":
                           button.setIcon(icon1);
                           button.putClientProperty("required", 1);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "2X":
                           button.setIcon(icon2);
                           button.putClientProperty("required", 2);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "3X":
                           button.setIcon(icon3);
                           button.putClientProperty("required", 3);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "4X":
                           button.setIcon(icon4);
                           button.putClientProperty("required", 4);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "X":
                           button.setIcon(boxIcon);
                           button.putClientProperty("wskazówka", false);
                           break;
                       case "O":
                           button.setIcon(blankSpaceIcon);
                           button.putClientProperty("wskazówka", true);
                           break;
                       default:
                           button.setIcon(blankSpaceIcon);
                           button.putClientProperty("wskazówka", false);
                           break;
                   }
                
                
                //dla pewnosci ustawiam wszystkie wymiary przycisku
                button.setPreferredSize(new Dimension (intSizeFactor,intSizeFactor));
                button.setMinimumSize(new Dimension (intSizeFactor,intSizeFactor));
                button.setMaximumSize(new Dimension(intSizeFactor,intSizeFactor));
                //kolor biały pewnie też będzie trzeba zmieniać w zależnosć od opcji
                button.setBackground(Color.WHITE);
                button.setBorder(buttonBorder); //przypisanie do ramki
                //putClientProperty zeby przysick był świadomy tego, w której kolumnie i w którym wiersz się znajduje
                button.putClientProperty("wiersz", new Integer(i));
                button.putClientProperty("kolumna",new Integer(j));
                //button.putClientProperty("iloscZapalen",new String(""));
                button.putClientProperty("iloscZapalen", new Integer(0));
                int a = (int) button.getClientProperty("iloscZapalen");
                button.addMouseListener(new MouseListener(){ //dodanie "sprawdzacza" kliknieć
                    @Override
                    public void mousePressed(MouseEvent e) { //jak wcisniete to zrob
                        currentColumn = getColumnIndex(button);
                        currentRow = getRowIndex(button);
                        
                         if(SwingUtilities.isRightMouseButton(e)){ //prawy daje X
                            
                            if(button.getIcon()==xIcon){ // jesli juz jest x to cofnij (daj puste pole)
                                button.setIcon(blankSpaceIcon);
                            }
                            else if(button.getIcon()==blankSpaceIcon){ //jesli puste to daj X
                                 button.setIcon(xIcon);
                            }
                        }

                        if(SwingUtilities.isLeftMouseButton(e)){ //lewy daje zarowke
                            if(button.getIcon()==bulbIcon){ //jak juz jest zarowka to daj puste
                                button.setIcon(blankSpaceIcon);
                                zgas(currentRow,currentColumn,boardList);
                                
                            }
                            else if( (button.getIcon()==blankSpaceIcon || button.getIcon()==clueIcon) && button.getBackground().equals(Color.WHITE)){ // jak jest puste wstaw zarowke
                                  button.setIcon(bulbIcon);
                                  zapal(currentRow,currentColumn,boardList);
                                  
                                  
                            } 
                            sprawdz(boardList);   
                        }
                        
                       plansza[currentRow][currentColumn] = button; 
                        
                    }
                    /*to metody ktore musza byc, klasa board (plansza na ktorej wyswietlamy przyciski
                      nie jest abstrakcyjna a MouseListener też jest abstrakcyjny
                      zachodzi konflikt miedzy nimi abstrakcyjne - nieabstrakcyjne
                      a wprowadzenie tych metod (uzupelnienie kazdego przypadku, powoduje że
                      obsluzone sa wszystkie przypadki co spelnia warunki abstrakcyjnosci
                    */
                    @Override 
                    public void mouseClicked(MouseEvent e) {}
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {}
                    @Override
                    public void mouseExited(MouseEvent e) {}});
            boardList[i][j] = button;
            board.add((JButton) boardList[i][j]);
            plansza[i][j]= button;
        }
       }
        
        //wczytywanie zapisu
        if (tbc==0){
            ZapisOdczytMapy staticMapaReadOrigin = new ZapisOdczytMapy();
            staticMapaReadOrigin.read("src\\maps\\"+name);
            csvOrigin = staticMapaReadOrigin.getCsv();
            
            String[] czas = head[3].split(":");
            
            Stopwatch.sekundy=Integer.parseInt(czas[1]);
            Stopwatch.minuty = Integer.parseInt(czas[0]);
            
            clues = Integer.parseInt(head[2]);
            
            for (int i=0; i<size; i++){
               for (int j=0; j<size;j++){ //podwójne pętle wrrrrr
                 if(csv[i][j].equals("O")){
                     zapal(i,j,boardList);
                     boardList[i][j].setIcon(bulbIcon);
                     sprawdz(boardList);   
                 }
                 if(csv[i][j].equals("W")){
                     boardList[i][j].setIcon(clueIcon);
                 }
                 if(csvOrigin[i][j].equals("O")){
                     boardList[i][j].putClientProperty("wskazówka", true);
                 }else{ boardList[i][j].putClientProperty("wskazówka", false);}
               }}
        }
        clueCounter.setText(clues+"");
      } catch (IOException ex) {
        // ignore
      }
    }

    /**
     * Metoda, która zapisuje przyciski z GUI do tablicy dwuwymiarowej
     * @param buttons
     * @return
     */
    static public String[][] buttonToCsvInBoard(JButton[][] buttons){
        String[][]csv = new String[size][size];
        for (int i=0;i<size;i++){
            for (int j=0 ;j<size;j++){
                if (buttons[i][j].getIcon().equals(boxIcon)){
                    csv[i][j]="X";
                } else if (buttons[i][j].getIcon().equals(icon0)){
                    csv[i][j]="0X";
                    
                } else if (buttons[i][j].getIcon().equals(icon1)){
                    csv[i][j]="1X";
                }
                else if (buttons[i][j].getIcon().equals(icon2)){
                    csv[i][j]="2X";
                }
                else if (buttons[i][j].getIcon().equals(icon3)){
                    csv[i][j]="3X";
                }
                else if (buttons[i][j].getIcon().equals(icon4)){
                    csv[i][j]="4X";
                }else if(buttons[i][j].getIcon().equals(bulbIcon)){
                    csv[i][j]="O";
                }else if(buttons[i][j].getIcon().equals(clueIcon)){
                    csv[i][j]="W";
                }
                else {
                    csv[i][j]=".";
                }
            }
        }
        
        return csv;
    }

    /**
     * Metoda, która zapisuje grę do pliku
     */
    public static void boardSave(){
        File saveFile = new File("src\\save");
        File[] listOfFiles = saveFile.listFiles();
        for (File files : listOfFiles){
            files.delete();
        }
        
        String[][] save;
        save = buttonToCsvInBoard(plansza);
        int[] saveTime =   Stopwatch.getTime();  
        String savedTime = saveTime[0]+":"+saveTime[1];
        String sLevel;
      switch (level) {
          case "Łatwy":
              sLevel="easy";
              break;
          case "Średni":
              sLevel="medium";
              break;
          default:
              sLevel="hard";
              break;
      }
    
        ZapisOdczytMapy zapisz = new ZapisOdczytMapy();
        zapisz.write("src\\save\\"+name, save,sLevel,size,savedTime,clues);
    }
}
