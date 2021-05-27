

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        int size=0;
        PrimeNumberRange[] ranges=null;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));){

            size=Integer.parseInt(br.readLine());
            ranges=new PrimeNumberRange[size];

            for(int i=0;i<size;i++){
                ranges[i]=new PrimeNumberRange(br.readLine().split(" "));
            }

        }catch(Exception e){
            return;
        }
        Arrays.stream(ranges).forEach(range->{
            System.out.println(range.diff());
        });
      /*  for(PrimeRange range:ranges){
            System.out.println(range.diff());
        }*/

    }


    static class PrimeNumberRange{
        int start;
        int end;
        List<Integer> prime=new ArrayList<>();

        PrimeNumberRange(String[] arr){
            this.start=Integer.parseInt(arr[0]);
            this.end=Integer.parseInt(arr[1]);
        }


        public int diff(){
            int min=0;
            int max=0;
            boolean flag=false;

            for(int i=start;i<=end;i++){
                if(isPrimeNumber(i)){
                    min=i;
                    flag=true;
                    break;

                }
            }

            if(!flag){
                return -1;
            }

            for(int i=end;i>min;i--){
                if(isPrimeNumber(i)){
                    max=i;
                    break;
                }
            }
            if(max==min || (min!=0 && max==0)){
                return 0;
            }
            return max-min;
        }


    }

    public static boolean isPrimeNumber(int num){
        if(num==2 || num==3){
            return true;
        }
        if(!((num-1)%6==0 || (num+1)%6==0)){
            return false;
        }
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
