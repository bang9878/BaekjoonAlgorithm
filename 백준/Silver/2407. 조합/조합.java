import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String m = st.nextToken();
        String n = st.nextToken();

        BigInteger bigM = new BigInteger(m);
        BigInteger bigN = new BigInteger(n);

        BigInteger numerator = new BigInteger("1");
        BigInteger denominator = new BigInteger("1");


        BigInteger num;
        for(int i = bigM.intValue(); i >bigM.subtract(bigN).intValue() ; i--){
            String iStr = String.valueOf(i);
            num = new BigInteger(iStr);
            numerator = numerator.multiply(num);
        }


        for(int i = 1; i <= bigN.intValue(); i++){
            String iStr = String.valueOf(i);
            num = new BigInteger(iStr);
            denominator = denominator.multiply(num);
        }

        BigInteger result = numerator.divide(denominator);
        System.out.println(result.toString());
    }
}
