package stack.operations;

import java.util.Stack;

/**
 * Created by Ravikanth on 5/8/2018.
 */
public class q23 {

    private void pattern(String pattern, String text){
        char ch;
        int matchedLength = 0;

        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            if (Character.compare(ch, pattern.charAt(matchedLength)) == 0)           {
                matchedLength++;
                if (matchedLength == pattern.length()){
                    System.out.println(i = pattern.length() + 1);
                    matchedLength = 0;

                }
            }else{
                matchedLength = 0;
                if (Character.compare(ch, pattern.charAt(matchedLength)) == 0){
                    matchedLength++;
                    if (matchedLength == pattern.length()){
                        System.out.println(i = pattern.length() + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        q23 test = new q23();
        test.pattern("vi", "ravikanth");
    }



}
