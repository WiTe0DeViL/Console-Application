import java.util.EmptyStackException;

public class Stack {
    private int ind;
    char[] stack =new char[10];

    Stack(){
       this.ind = -1;
    }

    public void push(char item){
        if(ind == 9) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++ind] = item;
    }

    public char pop(){
        if(ind == -1){
            throw new EmptyStackException();
        }
        return stack[ind--];
    }
    public int size(){
        return ind+1;
    }
    public char peek(){
        if(ind == -1)
            throw new EmptyStackException();
        return stack[ind];
    }

}
