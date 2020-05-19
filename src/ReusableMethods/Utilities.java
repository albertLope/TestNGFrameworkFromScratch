package ReusableMethods;

import java.util.Random;

public class Utilities {

    public int randomNumber(int max){

        Random random = new Random();

        return random.nextInt(max);

    }

}
