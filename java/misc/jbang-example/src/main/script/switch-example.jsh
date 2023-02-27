double getDoubleUsingSwitch(Object o) {
    return switch (o) {
        case Integer i -> i.doubleValue();
        case Float f -> f.doubleValue();
        case String s -> Double.parseDouble(s);
        default -> 0d;
    };
}

System.out.println(getDoubleUsingSwitch("56.6"));
System.out.println(getDoubleUsingSwitch(5.4f));
System.out.println(getDoubleUsingSwitch(5));
System.out.println(getDoubleUsingSwitch(new Object()));