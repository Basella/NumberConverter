import java.util.Scanner;
public class XputerFirstTask {
    private static Scanner input = new Scanner(System.in);
    private static final String[] units = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static void main(String[] args) {
        Long userInput = 1L;
        while (userInput != 0){
            System.out.print("Please enter a number between 1 - 1, 000,000,000,000 or 0 to quit: ");
            userInput = input.nextLong();
            String word = "";
            word += (userInput < 0) ? ("Minus " + numToWordsDouble(Math.abs(userInput))) : numToWordsDouble(userInput);
            System.out.println(word);
        }
        System.out.println("Goodbye");}

    private static String numToWordsDouble (long num) {
        String word = "";
// if statement to handle case of trillion
        if (num == 1000000000000L)  {
            word += units[(int) (num / 1000000000000L)] + " Trillion ";
        }

// if statement to handle case of billion
        if (((num >= 1000000000) && num < 10000000000L) && (num % 1000000000 == 0)) {
            word += units[(int) num / 1000000000] + " Billion ";
        } else if (((num >= 1000000000) && num < 10000000000L) && (num % 1000000000 != 0)) {
            word += units[(int) (num / 1000000000)] + " Billion " + numToWordsDouble(num % 1000000000);
        } else if (((num >= 10000000000L) && num < 100000000000L) && (num % 1000000000L == 0)) {
            if (num < 20000000000L) {
                word += units[(int) (num / 1000000000L)] + " Billion ";
            } else {
                word += tens[(int) (num / 100000000000L)] + " Billion " + numToWordsDouble(num % 1000000000);
            }
        } else if (((num >= 10000000000L) && num < 100000000000L) && (num % 1000000000L != 0)) {
            if (num < 20000000000L) {word += units[(int) (num / 1000000000L)] + " Billion " + numToWordsDouble(num % 1000000000L);
            } else {
                if (((num / 1000000000L % 10) == 0)) {
                    word += tens[(int) (num / 10000000000L)] + " Billion " + numToWordsDouble(num % 10000000000L);
                } else {
                    word += tens[(int) (num / 10000000000L)] + " " + numToWordsDouble(num % 10000000000L);
                }
            }
        } else if (((num >= 100000000000L) && num < 1000000000000L) && (num % 10000000000L == 0)) {
            word += units[(int) (num / 100000000000L)] + " Hundred Billion ";
        } else if (((num >= 100000000000L) && num < 1000000000000L) && (num % 10000000000L != 0)) {
            if (num / 1000000000 == 100) {
                word += units[(int) (num / 100000000000L)] + " Hundred Billion " + numToWordsDouble(num % 1000000000);
            } else {
                word += units[(int) (num / 100000000000L)] + " Hundred and " + numToWordsDouble(num % 100000000000L);
            }
        }

// if statement to handle case of million
        if (((num >= 1000000) && num < 10000000) && (num % 1000000 == 0)) {
            word += units[(int) num / 1000000] + " Million ";
        } else if (((num >= 1000000) && num < 10000000) && (num % 1000000 != 0)) {
            word += units[(int) num / 1000000] + " Million " + numToWordsDouble(num % 1000000);
        } else if (((num >= 10000000) && num < 100000000) && (num % 1000000 == 0)) {
            if (num < 20000000) {word += units[(int) num / 1000000] + " Million ";
            } else {
                word += tens[(int) num / 100000000] + " " + numToWordsDouble(num % 1000000);
            }
        } else if (((num >= 10000000) && num < 100000000) && (num % 1000000 != 0)) {
            if ((num < 20000000)) {
                word += units[(int) num / 1000000] + " Million " + numToWordsDouble(num % 1000000);
            } else {
                if ((((int) num / 1000000) / 10 == ((int) num / 10000000)) && ((int) num / 1000000) % 10 == 0) {
                    word += tens[(int) num / 10000000] + " Million " + numToWordsDouble(num % 10000000);
                } else {
                    word += tens[(int) num / 10000000] + " " + numToWordsDouble(num % 10000000);
                }
            }
        } else if (((num >= 100000000) && num < 1000000000) && (num % 10000000 == 0)) {
            word += units[(int) num / 100000000] + " Hundred Million ";
        } else if (((num >= 100000000) && num < 1000000000) && (num % 10000000 != 0)) {
            if (num / 1000000 == 100) {
                word += units[(int) num / 100000000] + " Hundred Million " + numToWordsDouble(num % 1000000);
            } else {
                word += units[(int) num / 100000000] + " Hundred and " + numToWordsDouble(num % 100000000);
            }
        }

// if statement to handle case of thousand
        if (((num >= 1000) && num < 10000) && (num % 1000 == 0)) {
            word += units[(int) num / 1000] + " Thousand ";
        } else if (((num >= 1000) && num < 10000) && (num % 1000 != 0)) {
            word += units[(int) num / 1000] + " Thousand " + numToWordsDouble(num % 1000);
        } else if (((num >= 10000) && num < 100000) && (num % 1000 == 0)){
            if (num < 20000) {
                word += units[(int) num / 1000] + " Thousand " + numToWordsDouble(num % 1000);
            } else {
                if ((int) num % 10000 == 0) {
                    word += tens[(int) num / 10000] + " Thousand " + numToWordsDouble(num % 10000);
                } else {
                    word += tens[(int) num / 10000] + " " + numToWordsDouble(num % 10000);
                }
            }
        } else if (((num >= 10000) && num < 100000) && (num % 1000 != 0)) {
            if (num < 20000) {
                word += units[(int) num / 1000] + " Thousand " + numToWordsDouble(num % 1000);
            } else {
                if ((((int) num / 1000) / 10 == ((int) num / 10000)) && ((int) num / 1000) % 10 == 0) {
                    word += tens[(int) num / 10000] + " Thousand " + numToWordsDouble((int) num % 10000);
                } else {
                    word += tens[(int) num / 10000] + " " + numToWordsDouble(num % 10000);
                }
            }
        } else if (((num >= 100000) && num < 1000000) && (num % 10000 == 0)) {
            word += units[(int) num / 100000] + " Hundred Thousand ";
        } else if (((num >= 100000) && num < 1000000) && (num % 10000 != 0)){
            if (num / 1000 == 100) {
                word += units[(int) num / 100000] + " Hundred Thousand and " + numToWordsDouble(num % 1000);
            } else {
                word += units[(int) num / 100000] + " Hundred and " + numToWordsDouble(num % 100000);
            }
        }

// if statement to handle case of hundred
        if (((num >= 100) && (num <1000)) && (num % 100 == 0)) {
            word += units[(int) num / 100] + " Hundred ";
        } else if (((num >= 100) && (num <1000)) && (num % 100 !=0)){
            word += units[(int) num / 100] + " Hundred and " + numToWordsDouble(num % 100);
        }

// if statement to handle case of tens and units
        if (num <= 19){
            word += units[(int) num];
        } else if ((num < 100) && (num % 10 == 0)) {
            word += tens[(int) num / 10];
        } else if ((num < 100) && (num % 10 != 0)) {
            word += tens[(int) num / 10] + " " + units[(int) num % 10];
        }
        return word;
    }
}