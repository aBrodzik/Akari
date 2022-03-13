import java.util.Arrays;
import java.util.Stack;

/**
 * Solver map, przewaznie generowanych.
 */
public class Solver {


    private String[][] board;
    private static int size;
    private Stack stack = new Stack();

    /**
     * Konstruktor tworzący tablicę dwuwymiarową.
     * @param board
     */
    public Solver(String[][] board) {
        size = board.length;
        this.board = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    /**
     * Metoda, która ma za zadanie rozwiązywać mapę
     * @return boolean
     */
    public boolean toSolve(){
        boolean easySquares = true;
        while(easySquares){
            easySquares = easyBlackSquares();
        }
        stack.push(board);
        isSolution();
        if(czyPoprawne()){
            mapaBezPodswietlen();
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metoda, która kopiuję mapę
     * @param plansza mapa
     * @return temporaryMap
     */
    private String[][] przepisanieMapy(String [][]  plansza) {
        String[][] temporaryMap = new String[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(plansza[i], 0, temporaryMap[i], 0, size);
        }
        return temporaryMap;
    }

    /**
     * Metoda, która zwraca mapę
     * @return board
     */
    public String[][] getBoard(){
        return board;
    }

    /**
     * metoda, która wstawia żarówkę i rozświetla pola wzdłuż i wszerz
     * @param row wiersz
     * @param column kolumna
     */
    private void zapal(int row, int column){
        board[row][column]="O";
        for(int i=column-1; i>=0;i--){//w górę zapalamy (zapalmy przez "*")
            if(board[row][i].contains("X")){
                break;
            }else{ board[row][i]+="*";}
        }
        for(int i=column+1; i<size;i++){//w dół
            if(board[row][i].contains("X")){
                break;
            }else{ board[row][i]+="*";}
        }
        for(int j=row+1; j<size;j++){//w prawo
            if(board[j][column].contains("X")){
                break;
            }else{ board[j][column]+="*";}
        }
        for(int j=row-1; j>=0;j--){//w lewo
            if(board[j][column].contains("X")){
                break;
            }else{ board[j][column]+="*";}
        }
    }

    /**
     * Mapa, która zwraca true, jeżeli wstawiono lampę koło łatwych kwadratów. False, jeżeli nic nie zminiono
     * @return true/false
     */
    private boolean easyBlackSquares(){
        for(int row=0; row<size; row++){
            for (int column=0; column<size; column++){
                if(board[row][column].contains("X")){
                    if(board[row][column].contains("1") || board[row][column].contains("2") || board[row][column].contains("3") || board[row][column].contains("4")){
                        int lampy=0;
                        int wolne=0;
                        if((row+1)!=size){
                            if(board[row+1][column].contains("O")){
                                lampy++;
                            }else if(isAvailible(row+1,column)){
                                wolne++;
                            }
                        }
                        if((row-1)!=-1){
                            if(board[row-1][column].contains("O")){
                                lampy++;
                            }else if(isAvailible(row-1,column)){
                                wolne++;
                            }
                        }
                        if((column+1)!=size){
                            if(board[row][column+1].contains("O")){
                                lampy++;
                            }else if(isAvailible(row,column+1)){
                                wolne++;
                            }
                        }
                        if((column-1)!=-1){
                            if(board[row][column-1].contains("O")){
                                lampy++;
                            }else if(isAvailible(row,column-1)){
                                wolne++;
                            }
                        }
                        if(board[row][column].contains("1")){
                            if(lampy==0){
                                if(wolne==1){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                            return true;
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                            return true;
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                            return true;
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                        if(board[row][column].contains("2")){
                            if(lampy==1){
                                if(wolne==1){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                            return true;
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                            return true;
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                            return true;
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                            return true;
                                        }
                                    }
                                }
                            }
                            else if(lampy ==0){
                                if(wolne==2){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                        }
                                    }return true;
                                }
                            }
                        }
                        if(board[row][column].contains("3")){
                            if(lampy==2){
                                if(wolne==1){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                            return true;
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                            return true;
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                            return true;
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                            return true;
                                        }
                                    }
                                }
                            }
                            else if(lampy ==1){
                                if(wolne==2){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                        }
                                    }return true;
                                }
                            }
                            else if(lampy ==0){
                                if(wolne==3){
                                    if((row+1)!=size){
                                        if(isAvailible(row+1,column)){
                                            zapal(row+1,column);
                                        }
                                    }
                                    if((row-1)!=-1){
                                        if(isAvailible(row-1,column)){
                                            zapal(row-1, column);
                                        }
                                    }
                                    if((column+1)!=size){
                                        if(isAvailible(row,column+1)){
                                            zapal(row,column+1);
                                        }
                                    }
                                    if((column-1)!=-1){
                                        if(isAvailible(row,column-1)){
                                            zapal(row, column-1);
                                        }
                                    }return true;
                                }
                            }
                        }
                        if(board[row][column].contains("4")){
                            if(lampy==0 && wolne==4){
                                zapal(row+1,column);
                                zapal(row-1, column);
                                zapal(row, column-1);
                                zapal(row, column+1);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metoda, która sprawdza czy w dane miejsce można wstawić lampę
     * @param row
     * @param column
     * @return true/false
     */
    private boolean isAvailible(int row, int column){
        if(!board[row][column].contains(".")) return false;
        if((row+1)!=size) {
            if (board[row + 1][column].contains("X")) {
                if(board[row+1][column].contains("0")){
                    return false;
                }
                int check1 = 0;
                if ((row + 2) != size) {
                    if (board[row + 2][column].contains("O")) {
                        check1++;
                    }
                }
                if ((column + 1) != size) {
                    if (board[row + 1][column + 1].contains("O")) {
                        check1++;
                    }
                }
                if ((column - 1) != -1) {
                    if (board[row + 1][column - 1].contains("O")) {
                        check1++;
                    }
                }
                if (board[row + 1][column].contains("3")) {
                    if (check1 >= 3) {
                        return false;
                    }
                }
                if (board[row + 1][column].contains("2")) {
                    if (check1 >= 2) {
                        return false;
                    }
                }
                if (board[row + 1][column].contains("1")) {
                    if (check1 >= 1) {
                        return false;
                    }
                }
            }
        }
        if((row-1)!=-1){
            if(board[row-1][column].contains("X")){
                if(board[row-1][column].contains("0")){
                    return false;
                }
                int check1= 0;
                if((row-2)!=-1){
                    if(board[row-2][column].contains("O")){
                        check1++; }
                }
                if((column+1)!=size) {
                    if (board[row - 1][column + 1].contains("O")) {
                        check1++;
                    }
                }
                if((column-1)!=-1){
                    if(board[row-1][column-1].contains("O")){
                        check1++; }
                }
                if(board[row-1][column].contains("3")){
                    if(check1>=3){ return false;}
                }if(board[row-1][column].contains("2")){
                    if(check1>=2){ return false;}
                }if(board[row-1][column].contains("1")){
                    if(check1>=1){ return false;}
                }
            }
        }

        if((column+1)!=size){
            if(board[row][column+1].contains("X")){
                if(board[row][column+1].contains("0")){
                    return false;
                }
                int check1= 0;
                if((row+1)!=size){
                    if(board[row+1][column+1].contains("O")){
                        check1++; }
                }
                if((row-1)!=-1){
                    if(board[row-1][column+1].contains("O")){
                        check1++; }
                }
                if((column+2)!=size) {
                    if (board[row][column + 2].contains("O")) {
                        check1++;
                    }
                }
                if(board[row][column+1].contains("3")){
                    if(check1>=3){ return false;}
                }if(board[row][column+1].contains("2")){
                    if(check1>=2){ return false;}
                }if(board[row][column+1].contains("1")){
                    if(check1>=1){ return false;}
                }
            }
        }

        if((column-1)!=-1){
            if(board[row][column-1].contains("X")){
                if(board[row][column-1].contains("0")){
                    return false;
                }
                int check1= 0;
                if((row+1)!=size){
                    if(board[row+1][column-1].contains("O")){
                        check1++; }
                }
                if((row-1)!=-1){
                    if(board[row-1][column-1].contains("O")){
                        check1++; }
                }
                if((column-2)!=-1){
                    if(board[row][column-2].contains("O")){
                        check1++; }
                }
                if(board[row][column-1].contains("3")){
                    if(check1>=3){ return false;}
                }if(board[row][column-1].contains("2")){
                    if(check1>=2){ return false;}
                }if(board[row][column-1].contains("1")){
                    if(check1>=1){ return false;}
                }
            }
        }
        return true;
    }

    /**
     * Metoda, która sprawdza czy mapa została poprawnie zrobiona
     * @return true/false
     */
    private boolean czyPoprawne(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(!(board[i][j].contains("O") || board[i][j].contains("X") || board[i][j].contains("*"))){ //sprawdzanie czy jakieś pole jest nieoświetlone
                    return false;
                }
            }
        }
        for(int row=0; row<size; row++) {
            for (int column = 0; column < size; column++) {
                if(board[row][column].contains("O")){
                    for(int i=column-1; i>=0;i--){//w górę
                        if(board[row][i].contains("X")){
                            break;
                        }else{
                            if(board[row][i].contains("O")){
                                return false;
                            }
                        }
                    }
                    for(int i=column+1; i<size;i++) {//w dół
                        if (this.board[row][i].contains("X")) {
                            break;
                        } else {
                            if (board[row][i].contains("O")) {
                                return false;
                            }
                        }
                    }
                    for(int j=row+1; j<size;j++){//w prawo
                        if(board[j][column].contains("X")){
                            break;
                        }else{
                            if(board[j][column].contains("O")){
                                return false;
                            }
                        }
                    }
                    for(int j=row-1; j>=0;j--){//w lewo
                        if(board[j][column].contains("X")){
                            break;
                        }else{
                            if(board[j][column].contains("O")){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return isCheckedSqueres(); //na samym koncu jezeli wszystko inne spełnione
    }

    /**
     * Metoda, która sprawdza czy kwadraty ponumerowane jak mają zajęte pola obok siebie to czy posiadają odpowiednią liczbę żarówek
     * @return true/false
     */
    private boolean isCheckedSqueres(){
        for(int row=0; row<size; row++){
            for(int column=0; column<size; column++){
                if(board[row][column].contains("1") || board[row][column].contains("2") || board[row][column].contains("3") || board[row][column].contains("4")){
                    int lampy=0;
                    int wolne=0;
                    if((row+1)!=size){
                        if(board[row+1][column].contains("O")){
                            lampy++;
                        }else if(board[row+1][column].equals(".")){
                            wolne++;
                        }
                    }
                    if((row-1)!=-1){
                        if(board[row-1][column].contains("O")){
                            lampy++;
                        }else if(board[row-1][column].equals(".")){
                            wolne++;
                        }
                    }
                    if((column+1)!=size){
                        if(board[row][column+1].contains("O")){
                            lampy++;
                        }else if(board[row][column+1].equals(".")){
                            wolne++;
                        }
                    }
                    if((column-1)!=-1){
                        if(board[row][column-1].contains("O")){
                            lampy++;
                        }else if(board[row][column-1].equals(".")){
                            wolne++;
                        }
                    }
                    if(board[row][column].contains("1")){
                        if(lampy<1){
                            if(wolne<1){
                                return false;
                            }
                        }
                    }
                    if(board[row][column].contains("2")){
                        if(lampy==1){
                            if(wolne<1){
                                return false;
                            }
                        }
                        else if(lampy==0){
                            if(wolne<2){
                                return false;
                            }
                        }
                    }
                    if(board[row][column].contains("3")){
                        switch (lampy) {
                            case 2:
                                if(wolne<1){
                                    return false;
                                }   break;
                            case 1:
                                if(wolne<2){
                                    return false;
                                }   break;
                            case 0:
                                if(wolne<3){
                                    return false;
                                }   break;
                            default:
                                break;
                        }
                    }
                    if(board[row][column].contains("4")){
                        switch (lampy) {
                            case 3:
                                if(wolne<1){
                                    return false;
                                }   break;
                            case 2:
                                if(wolne<2){
                                    return false;
                                }   break;
                            case 1:
                                if(wolne<3){
                                    return false;
                                }   break;
                            case 0:
                                if(wolne<4){
                                    return false;
                                }   break;
                            default:
                                break;
                        }
                    }
                }
            }
        }return true;
    }

    /**
     * Metoda, która modyfikuje mapę tak, aby nie było na mapie żadnych podświetleń.
     */
    private void mapaBezPodswietlen(){
        for(int i=0;i<size; i++){
            for(int j=0; j<size; j++){
                if (board[i][j].contains(".") || board[i][j].contains("!")){
                    board[i][j]=".";
                }
            }
        }
    }

    /**
     * Metoda, która próbuje rozwiązać mapę - algorytm powracania - backtracking
     */
    private void isSolution(){
        while(!stack.empty()){
            board = (String[][]) stack.pop();


            for(int row=0; row<size; row++){
                for(int column=0; column<size; column++){
                    if (board[row][column].equals(".") && !board[row][column].contains("!")){
                        if(isAvailible(row, column) && isCheckedSqueres()){
                            board[row][column]=" .!";
                            String[][] temporaryMap = przepisanieMapy(board);
                            zapal(row, column);
                            easyBlackSquares();
                            stack.push(temporaryMap);
                        }
                    }
                }
            }if(czyPoprawne()){
                return;
            }
        }
    }

}