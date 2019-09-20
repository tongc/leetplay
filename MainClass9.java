public class MainClass9 {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        String val = String.valueOf(x);
        for(int i=0;i<val.length()/2;i++) {
            if(val.charAt(i) != val.charAt(val.length()-1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MainClass9().isPalindrome(1));
        System.out.println(new MainClass9().isPalindrome(122));
        System.out.println(new MainClass9().isPalindrome(1221));
        System.out.println(new MainClass9().isPalindrome(111));
        System.out.println(new MainClass9().isPalindrome(1111));
        System.out.println(new MainClass9().isPalindrome(0));
        System.out.println(new MainClass9().isPalindrome(-2323));
    }
}
