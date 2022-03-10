import static java.lang.Character.*;

class SqueakyClean {

    public static final int GREEK_LETTER_ALPHA = 945;
    public static final int GREEK_LETTER_OMEGA = 969;
    public static final int UNICODE_HYPHEN = 45;

    static String clean(String identifier) {
        // create a StringBuilder variable to hold the cleaned name
        StringBuilder cleanedName = new StringBuilder();
        char[] charArray = identifier.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            char character = charArray[index];
            if (isSpaceChar(character)) { // check if the character is a space
                cleanedName.append("_");
            } else if (isISOControl(character)) { // check if the character is a control character
                cleanedName.append("CTRL");
                // check if the character is a greek letter
            } else if (character > GREEK_LETTER_ALPHA && character <= GREEK_LETTER_OMEGA) {
                continue;
            } else {
                if (character == UNICODE_HYPHEN) { // check if the character is a hyphen '-'
                    // get the next character in the string
                    char nextCharacter = charArray[index + 1];
                    // capitalize it and append to the string builder variable
                    cleanedName.append(toUpperCase(nextCharacter));
                    // increase the index since the next character is already processed
                    index++;
                } else if (!isLetter(character)) { // check if the character is not a letter
                    continue;
                } else {
                    cleanedName.append(character);
                }
            }
        }
        return cleanedName.toString();
    }
}
