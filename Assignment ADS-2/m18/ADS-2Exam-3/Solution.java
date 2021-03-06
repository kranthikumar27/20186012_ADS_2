import java.util.Scanner;
import java.util.*;
/**
 * Class for solution.
 */
public final class Solution {
    // Don't modify this method.
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }

    // Don't modify this method.
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }

    public static BinarySearchST<String, Integer> loadDictionary(final String file) {
        BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
        // your code goes here
        String[] tokens = toReadFile(file);
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String str = tokens[i].toLowerCase();
            if (!st.contains(str)) {
                st.put(str, 1);
            } else {
                st.put(str, st.get(str) + 1);
            }
        }
        return st;
    }
}

class T9 {
    TST tstobj;
    public T9(BinarySearchST<String, Integer> st) {
        tstobj = new TST();
        for (String key : st.keys()) {
            tstobj.put(key, st.get(key));
        }
    }

    // get all the prefixes that match with given prefix.
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        return tstobj.keysWithPrefix(prefix);
    }

    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here

        
        return null;
    }

    // return all possibilities(words), find top k with highest frequency.
    public Iterable<String> getSuggestions(final Iterable<String> words,final int k) {
        // your code goes here
        // int m = 0;
        // for (String key : words) {
        //     Integer value = tstobj.get(key);
        //     if (st.contains(value)) {
        //         String str = st.get(value);
        //         if (str.length() > key.length()) {
        //             key = str;
        //         }
        //     }
        //     st.put(value, key);
        // }
        return null;
    }

    // final output
    // Don't modify this method.
    public Iterable<String> t9(final String t9Signature,final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
