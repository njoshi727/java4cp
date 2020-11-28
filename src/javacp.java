
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.*;

public class javacp {
    static final InputStreamReader it = new InputStreamReader(System.in);
    static final BufferedReader br = new BufferedReader(it);

    static int sti(String s)
    {
        return Integer.parseInt(s);
    }

    static int[] sta(String[] s)
    {
        int[] b = new int[s.length];
        for(int i=0;i<s.length;i++)
        {
            b[i] = sti(s[i]);
        }
        return b;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static long fact(int n)
    {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    static int inputint () throws IOException{
        return sti(br.readLine());
    }

    static int[] inputarr () throws IOException{
        return sta(br.readLine().split(" "));
    }

    public static void main(String[] args) throws IOException {

        // no of test case --> t
        int t = inputint();
        while (t-- >0){
            int[] arr = inputarr();
            int x = Math.max(arr[0],arr[1]);
            int y = Math.min(arr[0],arr[1]);

            if(x == y) System.out.println(2*x);
            else System.out.println(2*x-1);
        }
    }
    static long maxSubArraySum(int a[])
    {
        int size = a.length;
        long max_so_far = Long.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    static void printArrayList(ArrayList<Integer> a)
    {
        for(int i=a.size()-1;i>=0;i--)
        {
            System.out.print(a.get(i)+" ");
        }
    }
    static void maximumInAWindow(int[] a , int k){

        Deque<Integer> dq = new ArrayDeque<>(k);
        dq.addFirst(0);
        //for first K elements

        for(int i=1;i<k;i++)
        {
            while(a[dq.peekLast()] < a[i])
            {
                dq.removeLast();
                if(dq.size()==0)
                    break;
            }
            dq.addLast(i);
        }

        System.out.print(a[dq.peekFirst()]+" ");


        //For rest of the elements

        for(int i = 1 ; i < a.length - k +1 ; i++){

            while(dq.peekFirst() < i) {
                dq.removeFirst();
                if(dq.size()==0)
                    break;
            }

            if(dq.size()>0)
            {
                while(a[dq.peekLast()] < a[i+k-1])
                {
                    dq.removeLast();
                    if(dq.size()==0)
                        break;
                }
            }

            dq.addLast(i+k-1);
            System.out.print(a[dq.peekFirst()]+" ");
        }
    }
}