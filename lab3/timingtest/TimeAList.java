package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        Ns.addLast(1000);
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int power = 10;
        while (Ns.size() < power) {
            int Last = Ns.getLast();
            Ns.addLast(2 * Last);
        }

        for (int i = 0; i < Ns.size(); i += 1) {
            AList<Integer> temp = new AList<>();
            int opCount = Ns.get(i);

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < Ns.get(i); j += 1) {
                temp.addLast(0);
            }
            double timeInSeconds = sw.elapsedTime();

            times.addLast(timeInSeconds);
            opCounts.addLast(opCount);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
