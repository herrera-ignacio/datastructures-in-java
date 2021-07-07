package linear.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Queue implementation using 2 stacks and making dequeue operation costly O(N)
 * so that enqueue operation is O(1).
 */
public class QueueStackEnqueueImpl implements Queue<Integer> {
    private Stack<Integer> enqStack;
    private Stack<Integer> deqStack;

    /**
     * Enqueue item
     * Time Complexity: O(1)
     */
    @Override
    public void add(Integer item) throws IllegalStateException
    {
        enqStack.push(item);
        System.out.println(item + " added to Queue");
    }

    /**
     * Dequeue item
     * Time Complexity: O(N)
     * If deqStack is empty, elements from enqStack will be moved.
     */
    @Override
    public Integer remove() throws NoSuchElementException {
        if (this.enqStack.isEmpty() && this.deqStack.isEmpty())
            throw new NoSuchElementException();

        this.balanceStacks();

        return this.deqStack.pop();
    }

    /**
     * Time Complexity: O(N)
     * (Same logic as remove/dequeue)
     */
    @Override
    public Integer peek() {
        this.balanceStacks();

        if (this.deqStack.isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        return this.deqStack.peek();
    }

    /**
     * Move elements from enqStack to deqStack only if deqStack is empty
     */
    private void balanceStacks()
    {
        if (this.deqStack.isEmpty())
        {
            while(!this.enqStack.isEmpty())
            {
                this.deqStack.push(this.enqStack.pop());
            }
        }
    }
}
