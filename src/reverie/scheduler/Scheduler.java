package reverie.scheduler;

/**
 * Created by Dell on 11/9/2014.
 */
public abstract class Scheduler {
    public static long weight(int wx, int wy, int x, int y){
        return (2*wx*x) + (wy *y);
    }
}
