package algorithm.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeSort implements Sort {

    public void sort(int[] input) {
        log.info("merge-sort");
        int[] result = new int[input.length];
        divideSort(input, 0, input.length - 1, result);
    }

    /**
     * e.g <br/>
     * 4, 1, 3, 2 <br/>
     * 1, 4, 2, 3 <br/>
     * 4, 3, 2, 1 <br/>
     * 3, 1, 4, 2 <br/>
     */
    private void divideSort(int[] input, int idxFrom, int idxTo, int[] result) {
        if (idxTo - idxFrom < 1) {
            return;
        }

        int idxMid = (idxTo + idxFrom) / 2;
        divideSort(input, idxFrom, idxMid, result);
        divideSort(input, idxMid + 1, idxTo, result);
        merge(input, idxFrom, idxMid, idxTo, result);
        set(result, input, idxFrom, idxTo);
    }

    private void merge(int[] input, int idxFrom, int idxMid, int idxTo, int[] result) {
        int i = idxFrom, j = idxMid + 1;
            for (int k = idxFrom; k <= idxTo; k++) {
            if (i <= idxMid && (j > idxTo || input[i] < input[j])) {
                result[k] = input[i++];
            } else {
                result[k] = input[j++];
            }
        }
    }

    private void set(int[] source, int[] target, int idxFrom, int idxTo) {
        for (int i = idxFrom; i <= idxTo; i++) {
            target[i] = source[i];
        }
    }
}
