public class variableTest {
    public static int add(int var1, int var2){
        int sum = var1+var2;
        System.out.println("WE MADE IT");
        return sum;
    }
    public static void main(String[] args) {
        double a =8.0;
    double b=5.0;
    double c=7;
    int x=add(3,100);
        System.out.println(x);
    double ans= a*b-(7*c);
    System.out.println(ans);
    int d=(int)c++;
    System.out.println(c);
    System.out.println(d);
        System.out.println(c-17);
    if(d>c){
        System.out.println("Hooplah");
    }else if((c-17)==ans){
        System.out.println("crazy world");
    }else{
        System.out.println("rats");
    }
    int far = 2;
    switch(far){
            case 1: System.out.println("Case 1!!!!");
            case 2: System.out.println("Case 2!!");

        }
    }
}