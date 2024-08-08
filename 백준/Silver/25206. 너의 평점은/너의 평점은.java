import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalScore = 0L;
        double totalSubjectScore = 0L;


        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String subjectName = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P"))continue;

            totalScore += score;

            double subjectScore = subjectScoreCheck(grade);


            totalSubjectScore+=subjectScore*score;

        }

        double result = totalSubjectScore / totalScore;


        System.out.println(result);
    }

    private static double subjectScoreCheck(String grade) {
        if(grade.equals("A+"))
            return 4.5;
        else if (grade.equals("A0"))
            return 4.0;
        else if (grade.equals("B+"))
            return 3.5;
        else if (grade.equals("B0"))
            return 3.0;
        else if (grade.equals("C+"))
            return 2.5;
        else if (grade.equals("C0"))
            return 2.0;
        else if (grade.equals("D+"))
            return 1.5;
        else if (grade.equals("D0"))
            return 1.0;

        return 0.0;
    }
}
