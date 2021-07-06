package linear.stack;

public class StackLinkedListImpl {
    private StackNode root;

    static class StackNode {
        int data;
        StackNode next;
        StackNode(int data) { this.data = data; }
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void push(int data)
    {
        StackNode newNode = new StackNode(data);

        if (root == null)
        {
            root = newNode;
        }
        else
        {
            StackNode lastRoot = root;
            root = newNode;
            newNode.next = lastRoot;
        }
    }

    public int pop() throws IllegalStateException
    {
       if (isEmpty())
           throw new IllegalStateException("Stack is empty");

       int popped = root.data;
       root = root.next;
       return popped;
    }

    public int peek() throws IllegalStateException
    {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return root.data;
    }
}
