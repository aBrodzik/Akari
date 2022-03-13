
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * Klasa będąca wątkiem zegara 
 * 
 */
public class Stopwatch extends Thread {

    static public int sekundy,minuty;
    static public boolean stop=false;
    DecimalFormat formatCzasu = new DecimalFormat("00");
    /**
     * konstruktor startuje zegar
     * nie potrzebujemy zabijać wątku, wątek zabije się sam jak wykona się metoda run;
     */
    public Stopwatch(){
        stop=true;
        sekundy=0;
        minuty=0;
        this.start();
        
    }
    
    @Override
    public void run(){
       Akari.timer.setText(formatCzasu.format(minuty)+":"+formatCzasu.format(sekundy));
        while(stop){
                if (sekundy==60){
                    sekundy=0;
                    minuty++;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Akari.timer.setText(formatCzasu.format(minuty)+":"+formatCzasu.format(sekundy));
                sekundy++;
        }
    }
    /**
     * metoda zatrzymująca zegar i zwracająca jego czas, żeby go zapisać w pliku 
     * @return 
     */
    static public int[] getTime(){
        int[] time = new int[2];
        time[0]=minuty;
        time[1]=sekundy;
        stop=false;
        return time;
    }
    /**
     * Metoda, która resetuje wartości na zegarze
     */
    static public void reset(){
        sekundy=0;
        minuty=0;
    }
    /**
     * Testowa, not used
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
