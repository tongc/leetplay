public class MainClass7 {
    public int reverse(int x) {
        boolean isNegative = x<0;
        String val = String.valueOf(Math.abs((long)x));
        char[] result = new char[val.length()];
        for(int i=val.length()-1,j=0;i>=0;i--,j++) {
            result[j] = val.charAt(i);
        }
        long res = Long.parseLong((isNegative?"-":"") + new String(result));
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MainClass7().reverse(123));
        System.out.println(new MainClass7().reverse(-123));
        System.out.println(new MainClass7().reverse(0));
        System.out.println(new MainClass7().reverse(-333));
        System.out.println(new MainClass7().reverse(-250));
        System.out.println(new MainClass7().reverse(1534236469));
        System.out.println(new MainClass7().reverse(-2147483648));
    }
}
