import java.text.DecimalFormat;
import java.util.ArrayList;

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
        else if (textAsNumber.contains("-") ){

            String errorText="" ;
            ArrayList<Character> textAsNumberCharList = new ArrayList<Character>();
            ArrayList<String> errorList = new ArrayList<String>();
            for (char c : textAsNumber.toCharArray()) {
               textAsNumberCharList.add(c);
            }
            for (int i = 0;i< textAsNumberCharList.size();i++) {
                if (textAsNumberCharList.get(i) == '-'){
                    errorList.add("-");
                    errorList.add(String.valueOf(textAsNumberCharList.get(i+1)));
                    errorList.add(",");

                }
            }
            for (int i=0; i<errorList.size()-1;i++) {
                errorText += errorList.get(i)  ;
            }
            if ( textAsNumber.contains(",,")) {
                int position = textAsNumber.indexOf(',');
                return "Negative not allowed : " + errorText + "\\nNumber expected but ',' found at position " + String.valueOf(position+1)+".";
            }else
                return "Negative not allowed : " + errorText;
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
