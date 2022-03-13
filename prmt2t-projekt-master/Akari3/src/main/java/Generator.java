
import java.util.Random;

/**
 * Klasa opisująca generator map akari
 */
public class Generator {

    private Random losowaLiczba = new Random();
    private String[][] map;
    private int poziom;
    private int size;

    /**
     * Metoda, która zwraca rozwiązaną mapę
     * @return map
     */
    public String[][] getMap(){
        return map;
    }

    /**
     * Konstuktor tworzący tablicę dwuwymiarową w zależności od poziomu trudności oraz rozmiaru
     * @param size
     * @param poziom
     */
    public Generator(int size, int poziom){
        this.size = size;
        this.poziom = poziom;
        map = new String[size][size];
    }

    /**
     * Metoda, która ma za zadanie wywołać metodę makeSolveMap, a następnie ma zwracać mapę wygenerowaną
     * @return map
     */
    public String[][] newSolvedMap(){
        makeAndSolveMap();
        return map;
    }


    /**
     * Metoda, która generuje losową mapę.
     */
    private void makeAndSolveMap(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(czyWstawiacCzarnyKwadrat()) map[i][j]="X";
                else map[i][j]=".";
            }
        }
        Solver solver = new Solver(map);
        solver.toSolve();
        map = solver.getBoard();

        for(int i=0; i<size; i++){           //jak zła mapa to robi od nowa
            for(int j=0; j<size; j++){
                if(map[i][j].contains("!") || map[i][j].contains("*")) makeAndSolveMap();
            }
        }
        changeSqueresToSqueresWithNumbers();
    }

    /**
     * Metoda, która wstawia czarne kwadraty.
     * @return losowaLiczba
     */
    private boolean czyWstawiacCzarnyKwadrat(){
        float max = 0;
        switch (poziom) {
            case 1:
                max = (float) (size*size*0.25);
                break;
            case 2:
                max= (float) (size*size*0.2);
                break;
            case 3:
                max= (float) (size*size*0.14);
                break;
            default:
                break;
        }
        return losowaLiczba.nextInt(size*size)<max;
    }

    /**
     * Metoda, która decyduje czy wstawić liczbę w kwadracie
     * @return losowaLiczba
     */
    private boolean czyWstawiacLiczbeWKwadracie(){
        int max=0;
        switch (poziom) {
            case 1:
                max = 75;
                break;
            case 2:
                max= 50;
                break;
            case 3:
                max= 20;
                break;
            default:
                break;
        }
        return losowaLiczba.nextInt(100)<max;
    }

    /**
     * Metoda, która liczy ile jest żarówek wokół danego bloku
     * @param i rząd
     * @param j kolumna
     * @return zarowki          liczba
     */
    private int howManyLightsAround(int i, int j){
        int zarowki=0;
        if((i+1)!=size){
            if(map[i+1][j].contains("O")) zarowki++;
        }
        if((j+1)!=size){
            if(map[i][j+1].contains("O")) zarowki++;
        }
        if((i-1)!=-1){
            if(map[i-1][j].contains("O")) zarowki++;
        }
        if((j-1)!=-1){
            if(map[i][j-1].contains("O")) zarowki++;
        }
        return zarowki;
    }

    /**
     * Metoda, która zmienia czarne bloki na bloki z numerami w zależności ile ma żarówek wokół
     */
    private void changeSqueresToSqueresWithNumbers(){
        int zarowki =0;
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j].contains("X")) {
                    zarowki=howManyLightsAround(i,j);
                    if(zarowki==0){
                        if(czyWstawiacLiczbeWKwadracie()) map[i][j]=("0X");
                    }
                    else if(zarowki==1){
                        if(czyWstawiacLiczbeWKwadracie()) map[i][j]=("1X");
                    }
                    else if(zarowki==2){
                        if(czyWstawiacLiczbeWKwadracie()) map[i][j]=("2X");
                    }
                    else if(zarowki==3 && poziom<3){
                        if(czyWstawiacLiczbeWKwadracie()) map[i][j]=("3X");
                    }
                    else if(zarowki==4 && poziom<2){
                        if(czyWstawiacLiczbeWKwadracie()) map[i][j]=("4X");
                    }
                }
            }
        }
    }

    /**
     * Metoda testowa - not used
     * @param args
     */
    public static void main(String[] args) {
        Generator o = new Generator(25, 3);
        o.newSolvedMap();
    }
}
