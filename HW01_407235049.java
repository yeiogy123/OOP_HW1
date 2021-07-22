import java.util.Scanner;
import java.io.*;
public class HW01_407235049
{
    public static int rule(double a, double b, double c)
    {
         /**
         * each of the parameter represent each of the triangle of the edge
         * @param a
         * @param b
         * @param c
         * @return 1 means program exit
         * @return 2 means one of the input is not greater than 0
         * @return 3 means triangle edge that did not follow the rule
         * @return 0 means that it follow the rule
         */
        if(a==-1&&b==-1&&c==-1)
            return 1;
        else if(a+b<=c||a+c<=b||b+c<=a||a<0||b<0||c<0)
        {
            if(a<0||b<0||c<0)
                return 2 ;
            else
                return 3 ;
        }
        else
            return 0;
    }
    public static void main(String[] args) throws IOException
    {
        FileWriter Fw = new FileWriter("java_result.txt");
        Scanner scan = new Scanner(System.in);
        double a, b, c, s, area;
        System.out.print("Please Input first number:");
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();
        int rule_triangle = rule(a, b, c);
        int time = 0;
        String illegal = "The Input is not legal.\n";
        while (rule_triangle != 1)
        {
            time++;
            System.out.println("Question "+time+" Inputs are a="+a+", b="+b+
                    ", c="+c);
            String inputTime = "Question "+time+" Inputs are a="+a+", b="+b+
                    ", c="+c+"\n";
            Fw.write(inputTime);
            if (rule_triangle == 2)
            {
                System.out.println("The Input is not legal.");
                Fw.write(illegal);
                System.out.println("The Input numbers must be positive.");
                System.out.print("Please Input first number:");
                a = scan.nextDouble();
                b = scan.nextDouble();
                c = scan.nextDouble();
                rule_triangle = rule(a, b, c);
                continue ;
            }
            else if (rule_triangle == 3)
            {
                System.out.println("The Input is not legal.");
                Fw.write(illegal);
                System.out.println("The total of two of the Input numbers must " +
                        "be greater than another Input number.");
                System.out.print("Please Input first number:");
                a = scan.nextDouble();
                b = scan.nextDouble();
                c = scan.nextDouble();
                rule_triangle = rule(a, b, c);
                continue;
            }
            s = (a + b + c) / 2;
            area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.println("The area of the triangle is : "+(double)Math.round(area*10000)/10000);
            String output = "The area of the triangle is :" +(double)Math.round(area*10000)/10000 + "\n" ;
            Fw.write(output);
            System.out.print("Please Input first number:");
            a = scan.nextDouble();
            b = scan.nextDouble();
            c = scan.nextDouble();
            rule_triangle = rule(a, b, c);
        }
        System.out.println("Program exit.");
        String exit = "Program exit.\n";
        Fw.write(exit);
        Fw.close();
    }
}
