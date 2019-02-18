

public class StringCalculator {

    private int sum = 0;

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
        else if (textAsNumber.startsWith("//")){
            for (int i = 0 ; i<textAsNumber.length();i++){
                int num =textAsNumber.charAt(i);
                if(num >=48 && num <=57){
                    char num2= textAsNumber.charAt(i);
                    sum+=Integer.parseInt(String.valueOf(num2));
                }
            }
            return String.valueOf(sum);
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
