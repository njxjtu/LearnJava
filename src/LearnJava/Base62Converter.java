package LearnJava;

public class Base62Converter {

    // The 62-character digit set (0-9, A-Z, a-z)
    private static final String BASE62_CHARS = 
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = 62;

    /**
     * Converts a base-10 number (long) to a base-62 String.
     * * @param number The base-10 number to convert.
     * @return The base-62 representation as a String.
     */
    public static String encode(long number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        long tempNumber = number;

        while (tempNumber > 0) {
            // 1. Get the remainder (the next base-62 digit)
            int remainder = (int) (tempNumber % BASE);

            // 2. Prepend the corresponding character to the result
            result.insert(0, BASE62_CHARS.charAt(remainder));

            // 3. Divide the number by the base
            tempNumber = tempNumber / BASE;
        }

        return result.toString();
    }

    /**
     * Converts a base-62 String back to a base-10 number (long).
     * * @param base62String The base-62 string to decode.
     * @return The original base-10 number (long).
     */
    public static long decode(String base62String) {
        long number = 0;
        
        for (int i = 0; i < base62String.length(); i++) {
            char c = base62String.charAt(i);
            int index = BASE62_CHARS.indexOf(c);

            if (index == -1) {
                throw new IllegalArgumentException("Invalid character in base62 string: " + c);
            }

            // Calculation: number = number * BASE + index_of_char
            number = number * BASE + index;
        }
        
        return number;
    }
    
    public static void main(String[] args) {
        long decimalNumber = 123456789L;
        
        // Encode (Convert to base 62)
        String base62Result = Base62Converter.encode(decimalNumber);
        // Result: "K9Gl"
        
        System.out.println("Decimal: " + decimalNumber);
        System.out.println("Base 62: " + base62Result);

        // Decode (Convert back to base 10)
        long decodedNumber = Base62Converter.decode(base62Result);
        // Result: 123456789
        
        System.out.println("Decoded: " + decodedNumber);
    }
}