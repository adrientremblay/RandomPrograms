package Techniques;

public class Caesar implements Technique{
    private static int defaultShiftCount = 3; // as used by Caesar

    @Override
    public String encrypt(String text, String[] args) {
       int shiftCount = defaultShiftCount;

       StringBuilder sb = new StringBuilder(text.length());

       for (char c : text.toCharArray()) {
           int nextCharCode;

           if (c == ' ') {
                nextCharCode = c;
           } else if (c >= 97 && c <= 122)  {
               nextCharCode = (((c - 97) + shiftCount) % 26) + 97;
           } else if (c >= 65 && c <= 90)  {
               nextCharCode = (((c - 65) + shiftCount) % 26) + 65;
           }  else {
               nextCharCode = c + shiftCount;
           }

           sb.append((char) (nextCharCode));
       }

       return sb.toString();
    }

    @Override
    public String decrypt(String text, String[] args) {
        return null;
    }
}
