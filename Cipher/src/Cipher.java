import Techniques.Technique;

public class Cipher {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: cipher [MODE] [TECHNIQUE] [TEXT]");
            return;
        }

        // getting mode
        Mode mode = Mode.valueOf(capitalizeFirst(args[0]));

        // getting technique
        Technique technique;
        try {
            Class<?> techniqueClass = Class.forName("Techniques." + capitalizeFirst(args[1]));
            technique = (Technique) techniqueClass.newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Make sure to spell the technique name correctly!");
            return;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // getting input text
        String inputText =  args[2];

        // encrypting or decrypting using the chosen technique to produce the output text
        String outputText = mode == Mode.Encrypt ? technique.encrypt(inputText, args) : technique.decrypt(inputText, args);

        // printing the output
        System.out.println(outputText);
    }

    private static String capitalizeFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}