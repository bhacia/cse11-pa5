import tester.*;

class Pair {
    
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

}

class ArrayExamples {

    static String joinWith(String[] strArray, String separator) {
        
        String result = "";
        if(strArray.length == 0) { //if input array is empty
            return result; //return empty string
        }
        else {
            for(int index = 0; index < (strArray.length - 1); index += 1) {
                result += strArray[index] + separator;
            }
            result += strArray[strArray.length - 1]; //last element with no separator
            return result;
        }

    }

    static boolean somethingFalse(boolean[] boolArray) {

        if(boolArray.length == 0) { //if input array is empty
            return false;
        }
        else {
            boolean toFind = false;
            for(boolean b : boolArray) {
                if(b == toFind) {
                    return true;
                }
            }
            return false;
        }

    }

    static int countWithinRange(double[] dArray, double low, double high) {

        if(dArray.length == 0) { //if input array is empty
            return 0;
        }
        else {
            int numOfElements = 0;
            for(double check : dArray) {
                if(check >= low && check <= high) {
                    numOfElements += 1;
                }
            }
            return numOfElements;
        }

    }

    static double[] numsWithinRange(double[] dArray, double low, double high) {

        if(dArray.length == 0) { //if input array is empty
            return new double[0];
        }
        else {
            int length = countWithinRange(dArray, low, high);
            double[] numsInRange = new double[length];
            int index = 0;
            for(double check : dArray) {
                if(check >= low && check <= high) {
                    numsInRange[index] = check;
                    index += 1;
                }
            }
            return numsInRange;
        }

    }

    static Pair maxmin(int[] intArray) {

        int smallest = intArray[0];
        int largest = intArray[0];
        for(int i = 1; i < intArray.length; i += 1) {
            if(intArray[i] > largest) {
                largest = intArray[i];
            }
            else if(intArray[i] < smallest) {
                smallest = intArray[i];
            }
        }
        return new Pair(smallest, largest);

    }

    static String earliest(String[] strArray) {

        String earliestStr = strArray[0];
        for(int i = 1; i < strArray.length; i += 1) {
            if(earliestStr.compareTo(strArray[i]) > 0) {
                earliestStr = strArray[i];
            }
        }
        return earliestStr;

    }

}

class MyExamples {

    void testJoinWith(Tester t) {
        String[] example1 = {"do", "re","mi", "fa", "so", "la", "ti", "do"};
        t.checkExpect(ArrayExamples.joinWith(example1, "-"), "do-re-mi-fa-so-la-ti-do");
        //resubit: add more tests
        String[] example2 = {"pop", "six", "squish", "uhuh", "cicero", "lipschitz"};
        t.checkExpect(ArrayExamples.joinWith(example2, "!"), "pop!six!squish!uhuh!cicero!lipschitz");
        String[] example3 = {"the", "wizard", "and", "i"};
        t.checkExpect(ArrayExamples.joinWith(example3, "+"), "the+wizard+and+i");
    }
  
    void testSomethingFalse(Tester t) {
        boolean[] example1 = {true, true, true, true};
        boolean[] example2 = {true, true, true, false};
        t.checkExpect(ArrayExamples.somethingFalse(example1), false);
        t.checkExpect(ArrayExamples.somethingFalse(example2), true);
        //resubmit: add more tests
        boolean[] example3 = {};
        t.checkExpect(ArrayExamples.somethingFalse(example3), false);
    }
  
    void testCountWithinRange(Tester t) {
        double[] example1 = {0.22, 1.2, 0.35, -1.8, 0.45, 2.1, 0.88, 1.3};
        t.checkExpect(ArrayExamples.countWithinRange(example1, 0.1, 0.9), 4);
        //resubmit: add more tests
        double[] example2 = {-2.1, -1.7, -0.4, 0.11, 0.98, 1.33, 2.76};
        t.checkExpect(ArrayExamples.countWithinRange(example2, -1.0, 1.0), 3);
        double[] example3 = {-5.4, -1.3, 0.03, 2.2, 5.4, 7.03};
        t.checkExpect(ArrayExamples.countWithinRange(example3, -5.0, 0.5), 2);
    }
  
    void testNumsWithinRange(Tester t) {
        double[] example1 = {0.52, -1.3, 0.45, -1.8, 0.25, 2.9, 2.8, 1.5};
        double[] expected1 = {0.52, -1.3, 0.45, 0.25};
        t.checkExpect(ArrayExamples.numsWithinRange(example1, -1.5, 0.9), expected1);
        //resubmit: add more tests
        double[] example2 = {-2.1, -1.7, -0.4, 0.11, 0.98, 1.33, 2.76};
        double[] expected2 = {-0.4, 0.11, 0.98};
        t.checkExpect(ArrayExamples.numsWithinRange(example2, -1.0, 1.0), expected2);
        double[] example3 = {-5.4, -1.3, 0.03, 2.2, 5.4, 7.03};
        double[] expected3 = {-1.3, 0.03};
        t.checkExpect(ArrayExamples.numsWithinRange(example3, -5.0, 0.5), expected3);
    }
  
    void testMaxmin(Tester t) {
        int[] example1 = {20, 3, 99, -8, 56, 31};
        t.checkExpect(ArrayExamples.maxmin(example1), new Pair(-8, 99));
        //resubmit: add more tests
        int[] example2 = {-2, 32, 4, -25, 77, 45};
        t.checkExpect(ArrayExamples.maxmin(example2), new Pair(-25, 77));
        int[] example3 = {9, -1, 10, 72, -30, 43};
        t.checkExpect(ArrayExamples.maxmin(example3), new Pair(-30, 72));
    }
  
    void testEarliest(Tester t) {
        String[] example1 = {"apple", "acorn", "banana", "orange"};
        t.checkExpect(ArrayExamples.earliest(example1), "acorn");
        //resubmit: add more tests
        String[] example2 = {"no", "wizard", "that", "there", "is", "or", "was"};
        t.checkExpect(ArrayExamples.earliest(example2), "is");
        String[] example3 = {"is", "ever", "going", "to", "bring", "me", "down"};
        t.checkExpect(ArrayExamples.earliest(example3), "bring");
    }
}

class ProvidedArrayExamples {

    void testJoinWith(Tester t) {
        String[] example1 = {"a", "b","c"};
        t.checkExpect(ArrayExamples.joinWith(example1, ":"), "a:b:c");
    }
  
    void testSomethingFalse(Tester t) {
        boolean[] example1 = {true, false};
        t.checkExpect(ArrayExamples.somethingFalse(example1), true);
    }
  
    void testCountWithinRange(Tester t) {
        double[] example = {0.1, 1.3, 2.6};
        t.checkExpect(ArrayExamples.countWithinRange(example, 1.1, 2.2), 1);
    }
  
    void testNumsWithinRange(Tester t) {
        double[] example = {0.0, 3.0, 1.4, 1.5, 2.7, 9.1, 2.1};
        double[] expected = {1.4, 1.5, 2.1};
        t.checkExpect(ArrayExamples.numsWithinRange(example, 1.1, 2.2), expected);
    }
  
    void testMaxmin(Tester t) {
        int[] example = {4, 5, 2, 3, 1};
        t.checkExpect(ArrayExamples.maxmin(example), new Pair(1, 5));
    }
  
    void testEarliest(Tester t) {
        String[] example = {"aa", "aab", "abcd", "a"};
        t.checkExpect(ArrayExamples.earliest(example), "a");
    }

}