
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * Klasa do stworzenia listy wybieralnych map w GUI
 */
public class MapList extends Akari{
    static Icon miniBlankSpaceIcon, miniBoxIcon;
    static String currentFileName;
    static ArrayList<String[]> naglowki;


    @SuppressWarnings("ThrowableResultIgnored")
    static LinkedList<String> readNames(){  //oraz naglowki
        ZapisOdczytMapy objektOdczytu = new ZapisOdczytMapy();

        LinkedList<String> listOfNames = new LinkedList<>();
        File folder = new File("src\\maps");
        File[] listOfFiles = folder.listFiles();

        naglowki = new ArrayList<>();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                listOfNames.add(listOfFile.getName());
                try {
                    objektOdczytu.read(listOfFile.getPath());
                    naglowki.add(objektOdczytu.getNaglowek());
                }catch (IOException e){
                    e.fillInStackTrace();
                }
            }
        }
        return listOfNames;
    }
    /**
     *tworzenie podlądu mapy przy wyborze map 
    */
    static void createMiniMap(){
        minimap.removeAll();
        Image rawImageBox = new ImageIcon("src\\Icon\\box.png").getImage();
        Image rawImageBlankSpace = new ImageIcon("src\\Icon\\blankSpace.png").getImage();
        int miniScaleFactor;
        
        ZapisOdczytMapy staticMapaRead = new ZapisOdczytMapy(); //konwersja non-static -> static  <dopiero teraz to odrkyłem>
        
        
        try {
            String[][] csv;
            staticMapaRead.read("src\\maps\\"+MapList.currentFileName);
            csv= staticMapaRead.getCsv();
            size = csv[0].length;
            minimap.setLayout(new GridLayout(size,size));
      
            //intSizeFactor = (int) 500/size;
            //scaleImages();
            miniScaleFactor = (int) 145/size;
            miniBlankSpaceIcon = new ImageIcon(rawImageBlankSpace.getScaledInstance(miniScaleFactor, miniScaleFactor, SCALE_SMOOTH));
            miniBoxIcon = new ImageIcon(rawImageBox.getScaledInstance(miniScaleFactor, miniScaleFactor, SCALE_SMOOTH));
            
            
            for (int i=0; i<size; i++){
               for (int j=0; j<size;j++){ //podwójne pętle wrrrrr
                JLabel label = new JLabel(); //tworzenie nowego przecisku
              
                //rysowanie ikon
                if (csv[i][j].equals(".")){
                    label.setIcon(miniBlankSpaceIcon);
                }
                else if (!(csv[i][j].equals("O"))){
                    label.setIcon(miniBoxIcon);
                }
                minimap.add(label);
               }
            }
        }catch (IOException ex) {
            Logger.getLogger(MapList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        minimap.revalidate();
        minimap.repaint();
    }
    /**
     *  metoda dodająca pasek postepu
     * */
    static void progressProgressBar(){
       
        
        LinkedList names = readNames();
        int max = names.size();
        int bar=0;
        Akari.progressBar.setMaximum(max);
         for (int i =0; i<names.size();i++){
            String time = naglowki.get(i)[3];
            if(!(naglowki.get(i)[3].equals("0"))){
            bar=bar+1;
        }
        progressBar.setValue(bar);
        progressBar.updateUI();
    }
    }
    
    /**
     * metoda tworząca listę map  
     */
     
    static void fillWithMaps(){
        mapListGUI.removeAll();
        LinkedList names = readNames();
        progressProgressBar();
        String[] headers = {"Numer","Nazwa","Trudnosc","Rozmiar","Wskazówki","Czas Przejścia"}; //listOfTrudnosc, listOfRozmiar ? albo getTrudnosc itd.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
            return c;
        }
        
        };
        DefaultTableModel model = new DefaultTableModel(headers,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        
        };
        
        
        
        JTable mapList = new JTable(model);
        mapList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mapList.setShowGrid(true);
        mapList.setDefaultRenderer(String.class, renderer);
        mapList.setVisible(true);
  
        
        ListSelectionModel selectionModel = mapList.getSelectionModel();

        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            String i = mapList.getValueAt(mapList.getSelectedRow(),0).toString();
            int foo = Integer.parseInt(i);
            currentFileName = (names.get(foo-1)).toString();
            createMiniMap();
        });
        
        for (int i =0; i<names.size();i++){
            String lp = i+1+"";
            model.addRow(new Object[]{lp,names.get(i),naglowki.get(i)[0],naglowki.get(i)[1],naglowki.get(i)[2],naglowki.get(i)[3]});
        }
        
        mapList.setSelectionModel(selectionModel);
        mapList.changeSelection(0,0,false,false);
        mapListGUI.add(new JScrollPane(mapList));
        mapListGUI.revalidate();
        mapListGUI.repaint();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
