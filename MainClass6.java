public class MainClass6 {
    public String convert(String s, int numRows) {
        if(numRows <=1) {
            return s;
        }
        int length = s.length();
        int numOfPillarColumns = (length / (numRows + numRows - 2) + 1) * 2;
        char[][] values = new char[numOfPillarColumns][numRows];
        for (int i = 0, j = 0; i < length; i += numRows + (numRows - 2), j += 2) {
            int x = 0;
            for (x = 0; x < numRows; x++) {
                if (i + x >= length) break;
                values[j][x] = s.charAt(i + x);
            }
            for (int y = 0; y < numRows - 2; y++) {
                if (i + x + y >= length) break;
                values[j + 1][numRows - 2 - y] = s.charAt(i + x + y);
            }
        }
        char[] result = new char[length];
        int count=0;
        for(int i=0;i<values[0].length;i++) {
            for(int j=0;j<values.length;j++) {
                if(values[j][i]!=0) {
                    result[count++] = values[j][i];
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
//        new MainClass6().convert("PAYPALISHIRING", 4);
//        System.out.println(new MainClass6().convert("PAYPALISHIRING", 3));
//        System.out.println(new MainClass6().convert("PAYPALISHIRING", 2));
        System.out.println(new MainClass6().convert("PAYPALISHIRING", 4));
//        System.out.println(new MainClass6().convert("", 1));
    }
}
