public class MainClass5 {
    public String longestPalindrome(String s) {
        if(s==null) {
            return null;
        }
        if(s.length()==0) {
            return "";
        }
        if(s.length()==1) {
            return s;
        }
        String longestVal = "";
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length()+1;j++) {
                String val = s.substring(i, j);
                if(isPalindrome(val) && val.length() > longestVal.length()) {
                    longestVal = val;
                }
            }
        }
        return longestVal;
    }

    public boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<s.length()/2;i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MainClass5().isPalindrome("babab"));
        System.out.println(new MainClass5().isPalindrome("bababd"));
        System.out.println(new MainClass5().isPalindrome("aa"));
        System.out.println(new MainClass5().isPalindrome("abcde"));
        System.out.println(new MainClass5().isPalindrome("abddeeddba"));

        System.out.println(new MainClass5().longestPalindrome("babad"));
        System.out.println(new MainClass5().longestPalindrome("cbbd"));
        System.out.println(new MainClass5().longestPalindrome("aa"));
        System.out.println(new MainClass5().longestPalindrome("dddeabddeeddbavvvvvddddddd"));

    }
}
