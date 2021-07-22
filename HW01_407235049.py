import math


def main():
    print("Please Input number:", end='')
    
    
    #use map function to input with the spit() function 
   
    a, b, c = map(float, input().split())
    rule_triangle = rule(a, b, c)
    time = 0

    #use open to open the file

    file = open("python_result.txt", mode='a')
    while rule_triangle != 1:
        time = time + 1
        print("Question "+str(time)+" Input are a="+str(a)+", b="+str(b)+", c="+str(c))
        file.write("Question "+str(time)+" Input are a="+str(a)+", b="+str(b)+", c="+str(c)+"\n")
        if rule_triangle == 2:
            print("The Input is not legal.")
            file.write("The Input is not legal.\n")
            print("The Input numbers must be positive.")
            print("Please Input number:", end='')
            a, b, c = map(float, input().split())
            rule_triangle = rule(a, b, c)
            continue
        elif rule_triangle == 3:
            print("The Input is not legal.")
            file.write("The Input is not legal.\n")
            print("The total of two of the Input numbers must"
                  "be greater than another Input number.")
            print("Please Input number:", end='')
            a, b, c = map(float, input().split())
            rule_triangle = rule(a, b, c)
            continue
        s = (float(a + b + c))/2
        area = math.sqrt(s * (s-a) * (s-b) * (s-c))
        print("The area of the triangle is : ", format(area, '.4f'))
        file.write("The area of the triangle is :"+str(format(area, '.4f'))+"\n")
        print("Please Input number:", end='')
        a, b, c = map(float, input().split())
        rule_triangle = rule(a, b, c)
    print("Program exit.")
    file.write("Program exit.\n")
    file.close()
    return


def rule(a, b, c):

    #each of the number to return means the different of the situation
    
    if a == -1 and b == -1 and c == -1:
        return 1
    elif a+b <= c or a+c <= b or b+c <= a or a < 0 or b < 0 or c < 0:
        if a < 0 or b < 0 or c < 0:
            return 2
        else:
            return 3
    else:
        return 0


main()






































