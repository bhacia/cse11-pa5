class Longest {
    
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("");
        }
        else {
            String longestStr = args[0];
            for(int i = 1; i < args.length; i += 1) {
                if(args[i].length() > longestStr.length()) {
                    longestStr = args[i];
                }
            }
            System.out.println(longestStr);
        }

    }

}