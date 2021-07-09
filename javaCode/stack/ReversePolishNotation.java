package stack;

//逆波兰表达式(中缀表达式)
public class ReversePolishNotation {
    public static void main(String[] args) {
        //String str = "3*(17-15)+18/6";//=9
        String[] notation = { "3", "17", "15", "-", "*", "18", "6", "/", "+" };
        System.out.println("getRet => " + getRet(notation));
    }

    public static int getRet(String[] str) {
        Stack<Integer> ops = new Stack();
        for (int i = 0; i < str.length; i++) {
            String cur = str[i];
            Integer o1;
            Integer o2;
            Integer ret;
            switch (cur) {
                case "+":
                    o1 = ops.pop();
                    o2 = ops.pop();
                    ret = o2 + o1;
                    ops.push(ret);
                    break;
                case "-":
                    o1 = ops.pop();
                    o2 = ops.pop();
                    ret = o2 - o1;
                    ops.push(ret);
                    break;
                case "*":
                    o1 = ops.pop();
                    o2 = ops.pop();
                    ret = o2 * o1;
                    ops.push(ret);
                    break;
                case "/":
                    o1 = ops.pop();
                    o2 = ops.pop();
                    ret = o2 / o1;
                    ops.push(ret);
                    break;
                default:
                    ops.push(Integer.parseInt(cur));
                    break;
            }
        }
        int ret = ops.pop();
        return ret;
    }
}