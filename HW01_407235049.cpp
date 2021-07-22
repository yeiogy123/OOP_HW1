#include <iostream>
#include <cmath>
#include <fstream>
#include <iomanip>
using namespace std;
int rule(float a, float b, float c);
int main() {
    int time = 0;
    float a,b,c;
    float s=0.0,area=0.0;
    cout<<"Please Input first number:";
    cin>>a>>b>>c;
    int rule_triangle = rule(a,b,c);
    fstream file;

    /**
     * file is used to open the file
     */

    file.open("cpp_result.txt", ios::out);
    while(rule_triangle != 1)
    {
        time++;
        file <<"Question "<< time <<" Inputs are a = "<<a<<", b = "<<b<<", c = "<<c<<endl;
        cout <<"Question "<< time <<" Inputs are a = "<<a<<", b = "<<b<<", c = "<<c<<endl;
        if (rule_triangle == 2)
        {
            cout << "The Input numbers must be positive." << endl;
            cout << "The Input is not legal." << endl;
            file << "The Input is not legal." << endl;
            cout << "Please Input first number:";
            cin >> a >> b >> c;
            rule_triangle = rule(a, b, c);
            continue;
        }
        else if (rule_triangle == 3)
        {
            cout << "The total of two of the Input numbers must"
                    "be greater than another Input number." << endl;

            cout << "The Input is not legal." << endl;
            file << "The Input is not legal." << endl;
            cout << "Please Input first number:";
            cin >> a >> b >> c;
            rule_triangle = rule(a, b, c);
            continue;
        }
        s = (a + b + c) / 2;
        area = sqrt(s * (s - a) * (s - b) * (s - c));
        if (!file)
        {
            cout << "file do not open."<<endl;
        }
        else
        {
	    cout <<fixed << "The area of the triangle is "<<setprecision(4)<<area<<endl;
            file <<fixed << "The area of the triangle is "<<setprecision(4)<<area<<endl;
        }
        cout<<"Please Input first number:";
        cin >> a >> b >> c;
        rule_triangle = rule(a, b, c);
    }
    cout << "Program exit." << endl;
    file << "Program exit." << endl;
    file.close();
    return 0;
}
int rule(float a, float b, float c)
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
{
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
        return 0 ;
}
