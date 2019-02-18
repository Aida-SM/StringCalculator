

public class StringCalculator {

    private int sum = 0;

    public  String add(String textAsNumber) {
        if (textAsNumber.isEmpty())
            return "0";
        else if(textAsNumber.contains("\n,")){
            int position = textAsNumber.indexOf(',');
            return "Number expected but '\n' found at position " + String.valueOf(position)+".";
        }
        else if (textAsNumber.contains(",")) {
            String[] splitNumbers = textAsNumber.split(",");
            for (String split: splitNumbers) {
                sum += Integer.parseInt(split) ;
            }
            return String.valueOf(sum);
        }
        else if(textAsNumber.contains("\n")){
             String[] splitNumbers = textAsNumber.split("\n");
            for (String split: splitNumbers) {
                sum += Integer.parseInt(split) ;
            }
            return String.valueOf(sum);
        }
        else
            return textAsNumber ;
    }
}
