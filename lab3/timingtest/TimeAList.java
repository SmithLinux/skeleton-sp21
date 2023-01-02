package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    /**
     * Ns the size of the data structure.
     * times the time require to compute all the operations.
     * opCounts the number of calls to addList().
     * */
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
        // TODO: YOUR CODE HERE
        AList<Integer> counts = new AList();
        AList<Integer> list = new AList();
        AList<Double> times = new AList();
        AList<Integer> opCounts = new AList();
        int preDataSize = 0;

        for (int i = 0; i < 8; i++) {
            int dataSize = 10000 * (1 << i);

            list.addLast(dataSize); // add the size of the data structure.
            opCounts.addLast(dataSize); // add the number of calls to addList().
            Stopwatch timer = new Stopwatch(); // start a timer.
            for (int j = preDataSize; j < dataSize; j++) {
                counts.addLast(j);
            }
            double time = timer.elapsedTime();
            preDataSize = dataSize;
            times.addLast(time);
        }
        printTimingTable(list, times, opCounts);
    }
}
