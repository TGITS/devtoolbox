public class HelloWithParameter {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("Hello from a JBang Script - No Parameter");
        } else {
            System.out.println("Hello from a JBang Script which was given the parameter : " + args[0]);
        }
    }
}
