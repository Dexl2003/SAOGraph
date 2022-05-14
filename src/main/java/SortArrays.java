import java.util.Random;

public class SortArrays {

    public long genArray(long size) {
        Random random = new Random();
        int[] arrayINT = random.ints(size,10,99999).toArray();
        return sortArray(arrayINT);
    }

    public long sortArray(int[] arrayINT){
        long start = System.nanoTime();
        for (int i = arrayINT.length -1; i > 0; i--) {
            for (int j = 0; j < i ; j++)
                if (arrayINT[j] > arrayINT[j + 1]) {
                    int tmp = arrayINT[j];
                    arrayINT[j] = arrayINT[j + 1];
                    arrayINT[j + 1] = tmp;
                }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        return elapsed;
    }
}
