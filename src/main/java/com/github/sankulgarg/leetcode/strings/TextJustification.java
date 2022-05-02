package com.github.sankulgarg.leetcode.strings;

import java.util.LinkedList;
import java.util.List;

class TextJustification {

    public static final String SPACE = " ";
    private int maxWidth;
    private String[] words;

    public static void main(String[] args) {
        new TextJustification()
                .fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16);
    }

    public List<String> fullJustify(String[] ws, int maxW) {

        List<String> text = new LinkedList<>();
        maxWidth = maxW;
        words = ws;
        // Use start/end indexes into words array to avoid making a list of words in current line (for efficiency).
        int start = 0;
        int end = 1;
        int lineLen = words[start].length();

        for (; end < words.length; end++) {
            String word = words[end];

            if (lineLen + word.length() + 1 <= maxWidth) { // Word fits in this line. Plus one is for a space.
                lineLen += word.length() + 1;
            } else { // Word does not fit in this line, space out current line and start a new one.
                text.add(constructLine(start, end, lineLen));
                start = end;
                lineLen = word.length();
            }
        }

        if (end - start > 0) {
            text.add(lineWithoutInterWordPadding(start, end, lineLen));
        }

        return text;
    }

    private String lineWithoutInterWordPadding(int start, int end, int lineLength) {
        // Don't use stream Collectors.joining(" ") here, even though it is more readable. The below is faster.
        StringBuilder line = new StringBuilder();
        line.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            line.append(" ");
            line.append(words[i]);
        }
        return line.toString() + " ".repeat(maxWidth - lineLength);
    }

    private String constructLine(int start, int end, int lineLength) {
        int numSpaces = end - (start + 1);

        if (numSpaces == 0) { // Only one word in the line.
            return lineWithoutInterWordPadding(start, end, lineLength);
        }

        int padding = maxWidth - lineLength;       // Extra padding needed.
        int spaceNeeded = padding / numSpaces + 1; // Padding between each word (extra + minimum one).
        int leftOverSpaces = padding % numSpaces;  // Extra spaces that don't divide evenly between words.

        StringBuilder line = new StringBuilder();
        line.append(words[start]);

        for (int i = start + 1; i < end; i++) {
            line.append(" ".repeat(spaceNeeded));
            if (leftOverSpaces-- > 0) {
                line.append(' ');
            }
            line.append(words[i]);
        }

        return line.toString();
    }
}


/*

    public List<String> fullJustify(String[] words, int maxWidth) {

        int lengthSoFar = 0;
        List<String> paddedSol = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (lengthSoFar >= maxWidth || lengthSoFar + words[i].length() > maxWidth) {
                StringBuilder str = new StringBuilder();

                if (queue.size() == 1) {
                    str.append(queue.poll());
                    while (str.length() < maxWidth) {
                        str.append(SPACE);
                    }
                } else {
                    int pads = (maxWidth - (lengthSoFar - queue.size() -1)) / (queue.size() - 1);
                    int n = queue.size();
                    for (int ind = 0; ind < n - 1; ind++) {
                        str.append(queue.poll());
                        for (int p = 0; p < pads; p++)
                            if (str.length() + words[i - 1].length() < maxWidth)
                                str.append(SPACE);
                    }
                    str.append(queue.poll());
                    if(str.length()<maxWidth){
                        int ind = str.indexOf(SPACE);
                        while (str.length() < maxWidth)
                            str.insert(ind, SPACE);
                    }

                }

                paddedSol.add(str.toString());
                lengthSoFar = 0;

            }
            queue.offer(words[i]);
            lengthSoFar += words[i].length() + 1;

        }
        if (!queue.isEmpty()) {
            StringBuilder str = new StringBuilder();
            int n= queue.size();
            for (int i = 0; i < n - 1; i++) {
                str.append(queue.poll()).append(SPACE);
            }
            str.append(queue.poll());
            while (str.length() < maxWidth)
                str.append(SPACE);
            paddedSol.add(str.toString());
        }
        return paddedSol;
    }*/
