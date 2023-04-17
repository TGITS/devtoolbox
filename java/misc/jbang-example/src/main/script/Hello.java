class Hello { 

    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("Hello from a JBang Script");
        } else {
            System.out.println("Hello " + args[0]);
        }
    }
}
