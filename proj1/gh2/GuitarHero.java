package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

// For fun
public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i += 1) {
            double frequency = 440.0 * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(frequency);
        }

        int stringIndex = 0;
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index >= 0) {
                    stringIndex = index;
                    strings[stringIndex].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = strings[stringIndex].sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < 37; i += 1) {
                strings[i].tic();
            }
        }
    }
}

