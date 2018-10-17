import java.util.Comparator;
import java.util.HashSet;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(Object[] input, Comparator comparator) {
            qSort(input,0,input.length-1, comparator);
    }

    private static void dSort(Object[] input, int low, int high, Comparator comparator) {
        int pivotPoint = pivot(input, low, high, comparator);
        if(pivotPoint > low) {
            qSort(input, low, pivotPoint, comparator);
            qSort(input, pivotPoint, high, comparator);
        }
    }

    private static int pivot(Object[] input, int low, int high, Comparator comparator) {
        if (low == high) {
            return -1;
        }
        Object temp;
        if (high-low == 2) {
            if (comparator.compare(input[low], input[high]) > 0){
                temp = input[low];
                input[low] = input[high];
                input[high] = temp;
            }
            return -1;
        }
        Object pivotElement = input[(high+low)/2];
        int left = low;
        int right = high;
        while (left <= right) {
            while (left < right && comparator.compare(input[left], pivotElement) < 0) {
                left++;
            }
            while (right > left && comparator.compare(input[right], pivotElement) > 0) {
                right--;
            }
            if (left <= right) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;
            }
        }
        return left;

    }

    public static Object[] qSort(Object[] array, int left, int right, Comparator comp){
        int ll=left;
        int rr=right;

        if (rr>ll){
            Object pivot = array[(ll+rr)/2];
            while (ll <=rr){
                // that's how we'll use the comparator:
                while(ll<right && comp.compare(array[ll], pivot) < 0){
                    ll +=1;
                }
                while(rr>left &&  comp.compare(array[rr], pivot) > 0){
                    rr -=1;
                }
                if (ll <=rr){
                    swap(array, ll ,rr);
                    ll +=1;
                    rr -=1;
                }
            }
            if (left < rr){
                qSort(array,left,rr, comp);

            }
            if (ll<right){
                qSort(array, ll, right, comp);
            }
        }
        return array;
    }

    static void swap(Object[] arr, int l, int r) {
        Object t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
