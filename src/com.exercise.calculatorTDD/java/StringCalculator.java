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
        else if (textAsNumber.contains("-")){
            String s2="" ;
            ArrayList<Character> mytTextAsNumber = new ArrayList<Character>();
            ArrayList<String> mytTextAsNumber2 = new ArrayList<String>();
            for (char c : textAsNumber.toCharArray()) {
               mytTextAsNumber.add(c);
            }
            for (int i = 0;i< mytTextAsNumber.size();i++) {
                if (mytTextAsNumber.get(i) == '-'){
                    mytTextAsNumber2.add("-");
                    mytTextAsNumber2.add(String.valueOf(mytTextAsNumber.get(i+1)));
                    mytTextAsNumber2.add(",");

                }
            }
            for (int i=0; i<mytTextAsNumber2.size()-1;i++) {
                 s2 += mytTextAsNumber2.get(i)  ;
            }
            return "Negative not allowed : "+ s2 ;
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
