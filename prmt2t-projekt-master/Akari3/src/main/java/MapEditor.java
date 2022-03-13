import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


/**
 * Klasa, która odzwierciedla edytowanie map w GUI
 */
public class MapEditor extends Akari {

    static JButton[][] buttonList;
    static Icon blankSpaceIcon, bulbIcon,xIcon,icon0,icon1,icon2,icon3,icon4,boxIcon,clueIcon;
    static public int intSizeFactor;
    static Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 1); //stworzenie ramki do przycisków
    static int level;
    static String[][] toSave;

    /**
     * Metoda, która skaluje zdjęcia
     */
    static void scaleImages(){
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
        
        
        blankSpaceIcon = new ImageIcon(rawImageBlankSpace.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        bulbIcon = new ImageIcon(rawImageBulb.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        xIcon = new ImageIcon(rawImageX.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        icon0 = new ImageIcon(rawImage0.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        icon1 = new ImageIcon(rawImage1.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        icon2 = new ImageIcon(rawImage2.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        icon3 = new ImageIcon(rawImage3.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        icon4 = new ImageIcon(rawImage4.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        boxIcon = new ImageIcon(rawImageBox.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
        clueIcon =  new ImageIcon(rawImageClueIcon.getScaledInstance(intSizeFactor, intSizeFactor, SCALE_SMOOTH));
    }

    /**
     * Metoda, która tworzy nową losową mapę
     * @return map
     */
    static public String[][] randomMap(){
        if(levelSetter.getSelectedItem().equals("Łatwy")){
        level=1;
        } else if (levelSetter.getSelectedItem().equals("Średni")){
            level=2;
        }else{level=3;}
        
        String[][] map;
        Generator o = new Generator(size, level); //oziom trudny
        o.newSolvedMap();
        map = o.getMap();
        return map;
    }


    /**
     * Metoda, która ustawia ikony
     * @param map
     */
    static public void setIcons(String[][] map){
      
        for (int i=0;i<size;i++){
            for (int j=0 ;j<size;j++){
                switch (map[i][j]) {
                    case "X":
                        buttonList[i][j].setIcon(boxIcon);
                        break;
                    case "1X":
                        buttonList[i][j].setIcon(icon1);
                        break;
                    case "2X":
                        buttonList[i][j].setIcon(icon2);
                        break;
                    case "3X":
                        buttonList[i][j].setIcon(icon3);
                        break;
                    case "4X":
                        buttonList[i][j].setIcon(icon4);
                        break;
                    case "0X":
                        buttonList[i][j].setIcon(icon0);
                        break;
                    default:
                        buttonList[i][j].setIcon(blankSpaceIcon);
                        break;
                }
            }
        }
       
    }

    /**
     * Metoda, która zapisuje mapę z rozgrywki w GUI na dwuwymiarową tablicę
     * @param buttons
     * @return csv          mapa[][]
     */
    static public String[][] buttonToCsv(JButton[][] buttons){
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
                }
                else {
                    csv[i][j]=".";
                }
            }}
        return csv;
    }


    /**
     * Metoda, która sprawdza, czy mapa jest rozwiązywalna
     */
    static public void sprawdź(){
        String[][] sprawdzCsv = buttonToCsv(buttonList);
        JOptionPane pane = new JOptionPane();
        Solver solver = new Solver(sprawdzCsv);
        if(solver.toSolve()){
           sprawdzCsv = solver.getBoard();
           pane.showMessageDialog(null, "Mapa jest rozwiązywalna, można ją zapisać");
           saveGeneratedMapButton.setEnabled(true);
           toSave = sprawdzCsv;
        }else{
            pane.showMessageDialog(null, "Mapa jest nierozwiązywalna, nie można jej zapisać");
        }   
    }

    /**
     * Metoda, która tworzy tablicę przycisków w zależności od wybranego rozmiaru
     */
    static public void fillWithEmptyButtons(){
       saveGeneratedMapButton.setEnabled(false);
       editableMap.removeAll();
       size=(int) rozmiarSetter.getValue();
      
       buttonList = new JButton[size][size];
       editableMap.setLayout(new GridLayout(size,size));
       intSizeFactor= (int) 500/size;
       scaleImages();
       
       for(int i=0;i<size;i++){
           for(int j=0;j<size;j++){
                JButton button = new JButton();
                button.setIcon(blankSpaceIcon);
                button.setBorder(buttonBorder);
                buttonList[i][j]=button;
                button.setPreferredSize(new Dimension (intSizeFactor,intSizeFactor));
                button.setMinimumSize(new Dimension (intSizeFactor,intSizeFactor));
                button.setMaximumSize(new Dimension(intSizeFactor,intSizeFactor));
                button.setBackground(Color.WHITE);
                
                button.addMouseListener(new MouseListener(){
                  
                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    saveGeneratedMapButton.setEnabled(false);
                        if(SwingUtilities.isLeftMouseButton(e)){ 
                        if(button.getIcon()==blankSpaceIcon){
                            button.setIcon(boxIcon);
                        }else if(button.getIcon()==boxIcon){
                            button.setIcon(icon0);
                        }else if(button.getIcon()==icon0){
                            button.setIcon(icon1);
                        }else if(button.getIcon()==icon1){
                            button.setIcon(icon2);
                        }
                        else if(button.getIcon()==icon2){
                            button.setIcon(icon3);
                        }
                        else if(button.getIcon()==icon3){
                            button.setIcon(icon4);
                        }else{
                            button.setIcon(blankSpaceIcon);
                        }
                        }  
                    }
                    @Override
                    public void mouseReleased(MouseEvent e){}
                    @Override
                    public void mouseEntered(MouseEvent e){}
                    @Override
                    public void mouseExited(MouseEvent e){}
                    @Override
                    public void mouseClicked(MouseEvent e){}

                    
                    
                    
                });
                buttonList[i][j]=button;
                editableMap.add((JButton) buttonList[i][j]);
           }
       }
       
      editableMap.revalidate(); 
    }

    /**
     *
     */
    static void save(){
      
        String sLevel;
        if(levelSetter.getSelectedItem().equals("Łatwy")){
        sLevel="easy";
        } else if (levelSetter.getSelectedItem().equals("Średni")){
            sLevel="medium";
        }else{sLevel="hard";}
        String name = buttonList.hashCode()+"RandomMap"+size+size+sLevel;
        ZapisOdczytMapy zapis = new ZapisOdczytMapy();
        zapis.write("src\\maps\\"+name+".csv",toSave , sLevel, size);
  
    }
    /**
     * Metoda, która zapisuje mapę do folderu maps
     * @param name 
     */
    static void save(String name){
   
        String sLevel;
        if(levelSetter.getSelectedItem().equals("Łatwy")){
        sLevel="easy";
        } else if (levelSetter.getSelectedItem().equals("Średni")){
            sLevel="medium";
        }else{sLevel="hard";}
       // String name = buttonList.hashCode()+"RandomMap"+size+size+sLevel;
        ZapisOdczytMapy zapis = new ZapisOdczytMapy();
        zapis.write("src\\maps\\"+name+".csv",toSave , sLevel, size);
    }


}
