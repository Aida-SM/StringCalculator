import java.text.DecimalFormat;

public class StringCalculator {

    private float sum = 0;

    DecimalFormat format = new DecimalFormat("0.#");

    public  String add(String textAsNumber) {
        if (textAsNumber.isEmpty())
            return "0";
        else if(textAsNumber.contains("\n,")){
            int position = textAsNumber.indexOf(',');
            return "Number expected but '\n' found at position " + String.valueOf(position)+".";
        }
        else if (textAsNumber.endsWith(",")  || textAsNumber.endsWith("\n") ){
            return "Number expected but EOF found";
        }
        else if (textAsNumber.matches("//(.*)\\n(.*)")) {

            int firstPosition = textAsNumber.indexOf("//") + 2;
            int secondPosition= textAsNumber.indexOf("\n");
            String separationString = textAsNumber.substring(firstPosition,secondPosition);
            String separatedText = textAsNumber.substring(secondPosition+1);
            String[] separatedNumbers = separatedText.split(separationString);
            for (String numbers: separatedNumbers) {
                sum += Float.parseFloat(numbers) ;
            }
            return format.format(sum);
        }
        else if (textAsNumber.contains(",")) {
            String[] splitNumbers = textAsNumber.split(",");
            for (String split: splitNumbers) {
                sum += Float.parseFloat(split) ;
            }
            return format.format(sum);
        }
        else if(textAsNumber.contains("\n")){
            String[] splitNumbers = textAsNumber.split("\n");
            for (String split: splitNumbers) {
                sum += Float.parseFloat(split) ;
            }
            return format.format(sum);
        }

        else
            return textAsNumber ;

    }
}
