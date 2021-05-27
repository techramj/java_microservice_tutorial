package pkg1;

public class Test {

    public static void main(String[] args) {
        String abc="www.google.com+-/@3";
        //System.out.println(abc);
        String x=EncryptionUtil.encode(abc);
        System.out.println(x);
        System.out.println(EncryptionUtil.decode(x));
    }
}