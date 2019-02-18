import java.text.DecimalFormat;

public class StringCalculator {

    private float sum = 0;
    DecimalFormat format = new DecimalFormat("0.##");

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
        else if (textAsNumber.contains("-")){
            int position = textAsNumber.indexOf('-');
            return "Negative not allowed : -"+textAsNumber.charAt(position+1);
        }


        else if (textAsNumber.matches("//(.*)\n(.*)")) {
            int firstPosition = textAsNumber.indexOf("//") + 2;
            int secondPosition= textAsNumber.indexOf("\n");
            String separationString = textAsNumber.substring(firstPosition,secondPosition);
            String separatedText = textAsNumber.substring(secondPosition+1);
            String[] separatedNumbers = separatedText.split(separationString);
            for (String number : separatedNumbers) {
                try {
                    sum += Float.parseFloat(number);
                }catch (Exception e){
                    if (separationString.equals(number)) {
                        continue;
                    }else
                      return  separationString +" expected but "+number +" found at position " + separatedText.indexOf(number) ;
                }
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
