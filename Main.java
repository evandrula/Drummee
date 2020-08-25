import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    
    //All the data of the matrix will be stared here in form of integers
    protected static int[][] array = new int[6][6];
    //Variables for using in iterations (k is 97 because initially it stores the ASCII value of 'a')
    protected static int i, j, k = 97, d, e;
    //BufferdReader for user input
    protected static BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
    );
    //Two StringTokenizers one for breaking a complex command into indivisual commands (delim = ":") 
    //and one for further breaking them into commands along with parameters (delim = "-")
    protected static StringTokenizer stringTokenizer;
    protected static StringTokenizer stringTokenizer2;
    protected static String str;

    public static void main(String[] args) {
        System.out.println("Welcome to Drumme");
        print();
        System.out.println();
        
        //Making an array of ASCII values numbers not seperated the distinction is done while reading the matrix for avoiding confusion
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                array[i][j] = k;
                k++;
            }
        }
        while (true){
            String input = null;
            try {
                input = bufferedReader.readLine();
                if (input.equals("exit")) break;
                if (input.equals("help")) {
                    try{
                        int ch;
                        //Make sure to get the Path right
                            FileReader fileReader = new FileReader(
                                "help.txt");
                        while((ch = fileReader.read()) != -1){
                            System.out.print((char) ch);
                        }
                        fileReader.close();
                        break;
                        }
                        catch(FileNotFoundException e){
                            System.out.println("Drumme/src/help.txt not found");
                            e.printStackTrace();
                        break;
                        }
                }
                stringTokenizer = new StringTokenizer(input,":");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            while (true){
                try {
                    if (stringTokenizer.hasMoreTokens()) str = stringTokenizer.nextToken();
                        else {
                            print();
                            break;
                        }
                        if (str.length() > 1) {
                            stringTokenizer2 = new StringTokenizer(str, "-");
                            String str2 = stringTokenizer2.nextToken();
                            String str3 = stringTokenizer2.nextToken();
                            shuffle(str2, Integer.parseInt(str3), false);
                        } else {
                            shuffle(str, false);
                        }
                    } catch (NumberFormatException  e) {
                        System.out.println("error, please check your input");
                    }

            }
        }
    }

    private static void shuffle(String direction, boolean toPrint) {
        d = 0;
        e = 0;
        int[] dar = new int[6];
        int[] ear = new int[6];

        if (direction.equals("r")) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (j == 0) {
                        d = array[i][j];
                        array[i][j] = array[i][5];
                    } else {
                        e = array[i][j];
                        array[i][j] = d;
                        d = e;
                    }
                }
            }
        }
        if (direction.equals("l")) {
            for (int i = 0; i < 6; i++) {
                for (int j = 5; j > -1; j--) {
                    if (j == 5) {
                        d = array[i][j];
                        array[i][j] = array[i][0];
                    } else {
                        e = array[i][j];
                        array[i][j] = d;
                        d = e;
                    }
                }
            }
        }
        if (direction.equals("u")) {
            for (int i = 5; i > -1; i--) {
                if (i == 5) {
                    for (int x = 0; x < 6; x++) {
                        dar[x] = array[i][x];
                    }
                    for (int x = 0; x < 6; x++) {
                        array[i][x] = array[0][x];
                    }
                } else {
                    for (int x = 0; x < 6; x++) {
                        ear[x] = array[i][x];
                    }
                    for (int x = 0; x < 6; x++) {
                        array[i][x] = dar[x];
                    }
                    for (int x = 0; x < 6; x++) {
                        dar[x] = ear[x];
                    }
                }
            }
        }
        if (direction.equals("d")) {
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    for (int x = 0; x < 6; x++) {
                        dar[x] = array[i][x];
                    }
                    for (int x = 0; x < 6; x++) {
                        array[i][x] = array[5][x];
                    }
                } else {
                    for (int x = 0; x < 6; x++) {
                        ear[x] = array[i][x];
                    }
                    for (int x = 0; x < 6; x++) {
                        array[i][x] = dar[x];
                    }
                    for (int x = 0; x < 6; x++) {
                        dar[x] = ear[x];
                    }
                }
            }
        }

        if (toPrint) print();
    }

    private static void shuffle (String direction,int row, boolean toPrint){

        d = 0;
        e = 0;

        if (direction.equals("r")) {
                for (int i = 0; i < 6; i++) {
                    if (i == 0) {
                        d = array[row - 1][i];
                        array[row - 1][i] = array[row - 1][5];
                    } else {
                        e = array[row - 1][i];
                        array[row - 1][i] = d;
                        d = e;
                    }
                }
            }
        if (direction.equals("l")) {
                for (int i = 5; i > -1; i--) {
                    if (i == 5) {
                        d = array[row - 1][i];
                        array[row - 1][i] = array[row - 1][0];
                    } else {
                        e = array[row - 1][i];
                        array[row - 1][i] = d;
                        d = e;
                    }
                }
            }
        if (direction.equals("u")) {
            for (int i = 5; i > -1; i--) {
                if (i == 5) {
                    d = array[i][row-1];
                    array[i][row-1] = array[0][row-1];
                }
                else{
                    e = array[i][row-1];
                    array[i][row-1] = d;
                    d = e;
                }
            }
        }
        if (direction.equals("d")) {
                for (int i = 0; i < 6; i++) {
                    if (i == 0){
                        d = array[i][row-1];
                        array[i][row-1] = array[5][row-1];
                    }
                    else{
                        e = array[i][row-1];
                        array[i][row-1] = d;
                        d = e;
                    }
                }
            }

        if (toPrint) print();
    }

    private static void print(){
            for (i = 0; i < 6; i++) {
                for (j = 0; j < 6; j++) {
                    if (array[i][j] < 123) System.out.print((char) array[i][j] + "  ");
                    else System.out.print(array[i][j] - 122 + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
