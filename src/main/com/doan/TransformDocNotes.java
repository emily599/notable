package main.com.doan;

import java.util.HashMap;
import java.util.Map;

public class TransformDocNotes {
    public static String transformDocNotes(String transcribedText) {

        if (transcribedText == null || transcribedText.isEmpty()) {
            return transcribedText;
        }

        String[] preItemDescriptionsList = transcribedText.split("Number", 2);

        if (preItemDescriptionsList.length != 2) {
            return transcribedText;
        }


        String textPreNumber = preItemDescriptionsList[0];
        String textPostNumber = preItemDescriptionsList[1];

        String[] initialNumberAndFollowingText= textPostNumber.trim().split(" ", 2);


        String initialStringNumber = initialNumberAndFollowingText[0];
        String followingText = initialNumberAndFollowingText[1];

        Integer initialInteger = numbersMap().get(initialStringNumber);


        String[] itemDescriptionsList = followingText.split("Number next");
        StringBuilder formattedString = new StringBuilder(textPreNumber + "\n");

        Integer nextNumber = initialInteger;
        Integer counter = 1;
        for (String s : itemDescriptionsList) {
            String itemDescription = capitalize(s.trim());

            formattedString
                    .append(nextNumber)
                    .append(". ")
                    .append(itemDescription);

            if (counter++ != itemDescriptionsList.length) {
                formattedString.append("\n");
            }

            nextNumber++;
        }


        return formattedString.toString();
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Map<String, Integer> numbersMap(){
        Map<String, Integer> numbersMap = new HashMap<String, Integer>();
        numbersMap.put("one", 1);
        numbersMap.put("two", 2);
        numbersMap.put("three", 3);
        numbersMap.put("four", 4);
        numbersMap.put("five", 5);
        numbersMap.put("six", 6);
        numbersMap.put("seven", 7);
        numbersMap.put("eight", 8);
        numbersMap.put("nine", 9);
        return numbersMap;
    }
}


