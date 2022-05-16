class Stats {
    
    public static void main(String[] args) {
        
        if(args[0].equals("--product")) {
            double product = 1.0;
            for(int i = 1; i < args.length; i += 1) {
                product *= Double.parseDouble(args[i]);
            }
            System.out.println(product);
        }
        else if(args[0].equals("--mean")) {
            double sum = 0.0;
            int elements = 0;
            for(int i = 1; i < args.length; i += 1) {
                sum += Double.parseDouble(args[i]);
                elements += 1;
            }
            double mean = sum / elements;
            System.out.println(mean);
        }
        else if(args[0].equals("--total")) {
            double sum = 0.0;
            for(int i = 1; i < args.length; i += 1) {
                sum += Double.parseDouble(args[i]);
            }
            System.out.println(sum);
        }
        else if(args[0].equals("--max")) {
            double max = Double.parseDouble(args[1]);
            for(int i = 2; i < args.length; i += 1) {
                if(Double.parseDouble(args[i]) > max) {
                    max = Double.parseDouble(args[i]);
                }
            }
            System.out.println(max);
        }
        else if(args[0].equals("--min")) {
            double min = Double.parseDouble(args[1]);
            for(int i = 2; i < args.length; i += 1) {
                if(Double.parseDouble(args[i]) < min) {
                    min = Double.parseDouble(args[i]);
                }
            }
            System.out.println(min);
        }
        else {
            System.out.println("Bad option " + args[0]);
        }
    }

}