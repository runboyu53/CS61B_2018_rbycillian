public class largerdemo {
    public static int larger(int x,int y){
        if(x>y){
            return x;
        }
        else return y;
    }
    public static void main(String[] args){
        int x=1,y=2;
        System.out.println(larger(x, y));
    }
}
