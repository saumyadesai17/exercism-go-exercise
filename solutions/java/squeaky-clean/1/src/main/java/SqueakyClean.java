class SqueakyClean {
    static String clean(String identifier) {
        String cleaned = identifier.replace(" ", "_");
        char[] asArray = identifier.toCharArray();
        boolean nextCaseCapital = false;
        StringBuilder cleanString = new StringBuilder();

        for (char ch: asArray) {
            if (Character.isWhitespace(ch)) {
                cleanString.append('_');
            } else if (ch == '-') {
                    nextCaseCapital = true;
                    continue;
            } else if (Character.isDigit(ch)) {
                switch (ch) {
                    case '4':
                        cleanString.append('a');
                        break;
                    case '3':
                        cleanString.append('e');
                        break;
                    case '0':
                        cleanString.append('o');
                        break;
                    case '1':
                        cleanString.append('l');
                        break;
                    case '7':
                        cleanString.append('t');
                        break;
                }
            } else if (!Character.isLetterOrDigit(ch)) {
                continue;
            } else {
                if (nextCaseCapital) {
                    cleanString.append(Character.toUpperCase(ch));
                    nextCaseCapital = false;
                } else {
                    cleanString.append(ch);     
                }
            }
        }
        return cleanString.toString();
    }
}
