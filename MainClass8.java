import java.math.BigInteger;

public class MainClass8 {
    public int myAtoi(String str) {
        if(str.length() == 0) {
            return 0;
        }
        char[] result = new char[str.length()];
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        if(i == str.length()) {
            return 0;
        }
        boolean hasSign = false;
        boolean isNegativeSign = str.charAt(i) == '-';
        if(isSign(str.charAt(i))) {
            hasSign = true;
        }
        if (!(isDigit(str.charAt(i)) || isSign(str.charAt(i)))) {
            return 0;
        }
        int j = 0;
        for (j = hasSign?i+1:i; j < str.length(); j++) {
            if (!isDigit(str.charAt(j))) {
                break;
            }
        }
        String res = str.substring(i,j);
        if(res.length()==0) {
            return 0;
        }
        if(hasSign && res.length() == 1) {
            return 0;
        }
        long resLong = 0;
        try {
            resLong = Long.parseLong(res);
        } catch(NumberFormatException ex) {
            return isNegativeSign?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        if(resLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(resLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)resLong;
    }

    private boolean isDigit(char letter) {
        switch (letter) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
        }
        return false;
    }

    private boolean isSign(char letter) {
        switch (letter) {
            case '+':
            case '-':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new MainClass8().myAtoi("4193 with words"));
        System.out.println(new MainClass8().myAtoi("words and 987"));
        System.out.println(new MainClass8().myAtoi("   -42"));
        System.out.println(new MainClass8().myAtoi("-91283472332"));
        System.out.println(new MainClass8().myAtoi("00"));
        System.out.println(new MainClass8().myAtoi("43"));
        System.out.println(new MainClass8().myAtoi(""));
        System.out.println(new MainClass8().myAtoi("+"));
        System.out.println(new MainClass8().myAtoi("+3333"));
        System.out.println(new MainClass8().myAtoi("+ddd333"));
        System.out.println(new MainClass8().myAtoi("+333fddd"));
        System.out.println(new MainClass8().myAtoi(" "));
        System.out.println(new MainClass8().myAtoi("20000000000000000000"));
        System.out.println(new MainClass8().myAtoi("-20000000000000000000"));
    }
}
