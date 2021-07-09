package stack;

//括号匹配
public class BracketsMatch {
    
    public static void main(String[] args) {
        String str = "(abc(test)())";
        System.out.println("  ismatch? => " + isMatch(str));
    }

    public static boolean isMatch(String str){
        Stack<String> chars =  new Stack();//存储(
        for (int i = 0; i < str.length(); i++) {//遍历str
            String curChar = str.charAt(i)+ "";
            if(curChar.equals("(")){//判断是否为(?是则入栈;
                chars.push(curChar);
            }else if(curChar.equals(")")){
                //继续判断是否有括号?是则弹出一个左并判断其是否为null?为null则无匹配的左;不为null则有匹配的左
                String pop = chars.pop();
                if(pop == null) return false;

            }
        }
        
        //判断栈中还有没有剩余的左,若有则括号不匹配
        if(chars.size() == 0)
            return true;
        else
            return false;
    }
}