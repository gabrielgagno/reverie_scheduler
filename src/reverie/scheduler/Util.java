package reverie.scheduler;

import java.util.Random;

/**
 * Created by Dell on 11/8/2014.
 */
public abstract class Util {

    public static int randomize(int ub){
        Random rand = new Random();
        return rand.nextInt(ub);
    }

    public static int randomize(int lb, int ub){
        Random rand = new Random();
        return rand.nextInt(ub);
    }
}
