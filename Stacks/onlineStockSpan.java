/*
1: Complete the next function in class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
2: The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
*/

import java.io.*;
import java.util.*;

public class onlineStockSpan {
    static class StockSpanner {

        static class Pair {
            int stock;
            int index;

            Pair(int s, int i) {
                stock = s;
                index = i;
            }
        }

        static Stack<Pair> st;
        static int c;

        public StockSpanner() {
            st = new Stack<>();
            c = 0;
        }

        public int next(int price) {
            c++;
            while (st.size() > 0 && st.peek().stock <= price) {
                st.pop();
            }
            if (st.size() == 0) {
                st.push(new Pair(price, c));
                return c;
            }
            int x = c - st.peek().index;
            st.push(new Pair(price, c));
            return x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StockSpanner obj = new StockSpanner();

        while (read.ready()) {
            int price = Integer.parseInt(read.readLine());
            System.out.println(obj.next(price));
        }
    }
}
