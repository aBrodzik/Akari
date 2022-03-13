import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Klasa, która umożliwia zapis oraz odczyt mapy razem z nagłówkami.
 * Są tutaj 2 metody write, ze względu na ilość parametrów
 */
public class ZapisOdczytMapy {

    private String[][] csv = null;
    private String[] naglowek = null;

    /**
     * Metoda, która pozwala nam czytać mapę razem z nagłówkiem z pliku CSV
     * @param plik1
     * @throws IOException
     */
    public void read(String plik1) throws IOException {
        List<String[]> przejsciowaLista = new ArrayList<>();
        String line = null;
        int wymiar = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(plik1))) {
            while ((line = br.readLine()) != null) {
                String[] lista = line.split(";");
                przejsciowaLista.add(lista);
                wymiar++;
            }
            csv=new String[wymiar-1][wymiar-1];
            int i=0;
            for(String[] wiersz:przejsciowaLista){
                if(i==wymiar-1) break;
                for(int j=0; j<wiersz.length; j++){
                    csv[i][j]=wiersz[j];
                }
                i++;
            }
            naglowek = przejsciowaLista.get(wymiar-1);


        } catch (IOException ioe) {
        }
    }

    /**
     * Metoda, która zwraca mapę jako tablicę dwuwymiarową
     * @return csv
     */
    public String[][] getCsv(){
        return csv;
    }

    /**
     * Metoda, która zwraca nagłówek jako tablicę
     * @return
     */
    public String[] getNaglowek(){
        return naglowek;
    }

    /**
     * Metoda która zapisuje do pliku csv daną mapę
     * @param plik2 nazwa - mapa zapisywana do pliku csv bez rozszerzenia podawana
     * @param mapaPlansza tablica modyfikowana w gui
     * @param level
     * @param size
     */
    public void write(String plik2, String[][] mapaPlansza, String level, int size){    //musimy mieć już planszę z X, O oraz kropkami
        try (BufferedWriter bw= new BufferedWriter(new FileWriter(plik2))){
            for (String[] mapaPlansza1 : mapaPlansza) {
                for (int j = 0; j<mapaPlansza.length; j++) {
                    if (j==(mapaPlansza.length-1)) {
                        bw.write(mapaPlansza1[j]);
                        bw.newLine();
                    } else {
                        bw.write(mapaPlansza1[j] + ";");
                    }
                }
            }
            bw.write(level+";"+size+";"+"0"+";"+"0"); //trzeba wziąć skądś nagłówek, skąd bierzemy czy easy czy nie itd
        } catch (IOException e) {
        }
    }

    /**
     * Metoda zapisu plików. Taka sama jak wyżej tylko ma rozszerzenie w postaci zapisu rekordu oraz wskazowek
     * @param plik2
     * @param mapaPlansza
     * @param level
     * @param size
     * @param rekord
     * @param wskazowki
     */
 public void write(String plik2, String[][] mapaPlansza, String level, int size,String rekord, int wskazowki){    //musimy mieć już planszę z X, O oraz kropkami
        try (BufferedWriter bw= new BufferedWriter(new FileWriter(plik2))){
            for (String[] mapaPlansza1 : mapaPlansza) {
                for (int j = 0; j<mapaPlansza.length; j++) {
                    if (j==(mapaPlansza.length-1)) {
                        bw.write(mapaPlansza1[j]);
                        bw.newLine();
                    } else {
                        bw.write(mapaPlansza1[j] + ";");
                    }
                }
            }
            bw.write(level+";"+size+";"+wskazowki+";"+rekord); //trzeba wziąć skądś nagłówek, skąd bierzemy czy easy czy nie itd
        } catch (IOException e) {
        }
    }
}
