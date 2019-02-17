public class StringCalculator {



    public  String add(String textAsNumber) {
        if (textAsNumber.isEmpty())
            return "0";
        else if (textAsNumber.contains(",")) {

            String[] splitNumbers = textAsNumber.split(",");
            return String.valueOf(Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]));
        }
        else
            return textAsNumber ;

    }
}
