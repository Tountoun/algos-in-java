import com.ace3i.algos.Algos;
import com.ace3i.algos.Change;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // {1, 7, 3, 4, 2, 6, 9}
        int[] fromIds = {1, 5, 8, 2, 4};
        int[] toIds = {8, 1, 2, 4, 5};

        System.out.println(Algos.findNetworkEndpoint(5, fromIds, toIds));
    }
}
