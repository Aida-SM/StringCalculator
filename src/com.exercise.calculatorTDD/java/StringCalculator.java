

public class StringCalculator {

    private int sum = 0;


    public  String add(String textAsNumber) {
        if (textAsNumber.isEmpty())
            return "0";
        else if (textAsNumber.contains(",")) {
            String[] splitNumbers = textAsNumber.split(",");
            for (String split: splitNumbers) {
                sum += Integer.parseInt(split) ;
            }
            return String.valueOf(sum);
        }
        else
            return textAsNumber ;

    }

}
