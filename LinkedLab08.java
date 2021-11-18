import java.util.NoSuchElementException;

public class LinkedLab08<E> {

    private static class Node<E> {
        
        private E data;
        private Node<E> next;
        
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(E data) {
            this(data, null);
        }
        
        public Node() {
            this(null, null);
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public LinkedLab08() {
        head = new Node<>();
        tail = head;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    private Node<E> getNodeBefore(int index) {
        Node<E> current = head;
        for (int i=0; i<index; i++)
            current = current.next;
        return current;
    }

	public boolean contains(Object obj) {
	    Node<E> current = head.next;
	    while (current != null) {
	        if (current.data.equals(obj))
	            return true;
	        current = current.next;
	    }
	    return false;
	}
    
    public int indexOf(Object obj) {
        Node<E> current = head.next;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj))
                return index;
            current = current.next;
            index++;
        }
        throw new NoSuchElementException();
    }
    
    public E get(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
        return getNodeBefore(index).next.data;
    }

	public void add(E element) {
	    tail.next = new Node<>(element);
	    tail = tail.next;
	    size++;
	}

	public void add(int index, E element) {
	    if (index < 0 || index > size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node<E> previous = getNodeBefore(index);
	    Node<E> current = new Node<>(element, previous.next);
	    previous.next = current;
	    if (tail == previous)
	        tail = current;
	    size++;
	}

	public void remove(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node<E> previous = getNodeBefore(index);
	    previous.next = previous.next.next;
	    if (previous.next == null)
	        tail = previous;
	    size--;
	}

	public void set(int index, E element) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    getNodeBefore(index).next.data = element;
	}
	
	public void clear() {
	    head.next = null;
	    tail = head;
	    size = 0;
	}
	
	public boolean isEmpty() {
	    return size == 0;
	}
	
	public void moveFirstToLast() {
	    //TO DO: fill in the body of this method
		 if (size == 0)
	            throw new NoSuchElementException("List is Empty");
	        if (size > 1) {
	            Node<E> first = head.next;
	            head.next = first.next;
	            tail.next = first;
	            first.next = null;
	            tail = first;
	        }
		
	}
	
	public void moveLastToFirst() {
	    //TO DO: fill in the body of this method
		 if (size == 0)
	            throw new NoSuchElementException("List is Empty");
	        if (size > 1) {
	        	 Node<E> secLast = null; 
	             Node<E> last = head.next; 
	             while (last.next != null)   
	             { 
	                secLast = last; 
	                last = last.next;  
	             } 
	             secLast.next = null; 
	             last.next = head.next; 
	             head.next = last; 
	          }
	            
	        }

	
	public void swap(int i, int j) {
	    //TO DO: fill in the body of this method
		
		if (i < 0 || i >= size || j < 0 || j >=size)
	        throw new IndexOutOfBoundsException("Properly caught bad arguments");
		 E a = getNodeBefore(i).next.data;
		 E b = getNodeBefore(j).next.data;
		// set(j, a);
		// set(i, b);
		 E c = a;
		 a = b;
		 b = c;
		 
	}
	
	public void reverse() {
	    //TO DO: fill in the body of this method
		  if (size >=2) {
			  Node<E> prev = null; 
		        Node<E> current = head.next; 
		        Node<E> next = null; 
		        while (current != null) { 
		            next = current.next; 
		            current.next = prev; 
		            prev = current; 
		            current = next; 
		        } 
		        head.next = prev; 
		        
	        }
	    }
	    
        
	
	@Override
	public String toString() {
	    if (size == 0) return "[ ]";
	    StringBuilder sb = new StringBuilder("[");
	    Node<E> current = head.next;
	    while (current != null) {
	        sb.append(current.data.toString() + ", ");
	        current = current.next;
	    }
	    sb.setLength(sb.length() - 2);
	    sb.append("]\t");
	    return sb.toString();
	}
}