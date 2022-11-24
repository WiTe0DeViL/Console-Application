interface ITestInterface{

    int status = 0;

}


public class Test implements ITestInterface{


    public static void main(String[] args){


        if(args[0] == "1")

            status = 0;

        else if(args[0] == "2")

            status = 1;


        System.out.print(status);

    }

}
