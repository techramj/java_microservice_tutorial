import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1 {

    public static void main(String[] args) {

        String v=null;
        int size=0;
        String[] bloodComp=null;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));){
            v=br.readLine();
            size=Integer.parseInt(br.readLine());
            bloodComp=new String[size];
            for(int i=0;i<size;i++){
                bloodComp[i]=br.readLine();
            }

        }catch(Exception e){
            return;
        }

        for(String sub:bloodComp){
            if(isSubSequence(v,sub)){
                System.out.println("POSITIVE");
            }else{
                System.out.println("NEGATIVE");
            }
        }
    }

    public static boolean isSubSequence(String str,String sub){
        if(str==null || sub==null){
            return false;
        }
        if(sub.length()>str.length()){
            return false;
        }
        int subLen=0;
        int i=0;
        int subStratIdx=0;
        int subEndIdx=sub.length()-1;
        int len=str.length();
        while(i<=str.length()-1){
            char ch1=str.charAt(i);
            char ch2=sub.charAt(subStratIdx);
            if(str.charAt(i)==sub.charAt(subStratIdx)){
                subStratIdx+=1;
                ++subLen;
                if(subStratIdx==sub.length()){
                    return true;
                }

            }

            ch1=str.charAt(len-1-i);
            ch2=sub.charAt(subEndIdx);

            if(str.charAt(len-1-i)==sub.charAt(subEndIdx) && subStratIdx!=subEndIdx){
                --subEndIdx;
                ++subLen;
            }
            i+=1;
            if(subStratIdx>subEndIdx){
                break;
            }
        }
        if(subLen==sub.length()){
            return true;
        }
        return false;
    }




    public static boolean isSubSequence1(String str,String sub){


        if(str==null || sub==null){
            return false;
        }
        if(sub.length()>str.length()){
            return false;
        }
        int i=0;
        int subIdx=0;
        while(i<=str.length()-1){
            if(str.charAt(i)==sub.charAt(subIdx)){
                subIdx+=1;
                if(subIdx==sub.length()){
                    return true;
                }
            }
            i+=1;
        }
        return false;
    }

}
