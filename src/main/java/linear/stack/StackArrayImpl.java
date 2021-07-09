package linear.stack;

public class StackArrayImpl {
    private final int size;
    private int top;
    private int[] a;

    public StackArrayImpl(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return true;
        }
        return false;
    }

    boolean push(int x) {
        if (top >= size) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    public int pop() {
        return isEmpty() ? 0 : a[top--];
    }

    public int peek() {
        return isEmpty() ? 0 : a[top--];
    }
}
