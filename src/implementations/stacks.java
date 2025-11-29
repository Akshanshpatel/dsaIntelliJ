package implementations;

public class stacks {
    private int[] arr;    //private so no one can directly access it and make changes
    private int idx=-1;

    public  stacks(){
        arr=new int[5];
    }
    public stacks(int n){
        arr=new int[n];
    }
    public void push(int item){
        idx++;
        arr[idx]=item;
    }
    public int pop(){
        int popped= arr[idx];
        idx--;
        return popped;
    }
    public boolean isEmpty(){
        return idx+1==0?true:false;
    }
    public boolean isFull(){
        return idx+1==arr.length-1?true:false;
    }
    public int size(){
        return idx+1;
    }
    public void display(){
        for(int i=0;i<=idx;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int peek(){
        return arr[idx];
    }


    public static void main(String[] args) {
        stacks st= new stacks(9);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
        st.pop();
        System.out.println(st.peek());
        st.push(67);
        st.display();
        System.out.println(st.isEmpty());
    }

}

