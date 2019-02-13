
/**
 * Implementation of the Queue data structure
 * using a linked list
 *
 * @author jmlon
 *
 */
class Queue<T> : Iterable<T> {

    private var n : Int = 0

    private var head: Node? = null
    private var tail: Node? = null

    private var pos: Node? = null

    inner class Node(val item: T, var next: Node?)

    fun enqueue(item: T) {
        val node = Node(item, null)
        if (tail!=null) {
            tail?.next = node
        }
        else {
            head = node
        }
        tail = node
        n++
    }

    fun dequeue(): T? {
        if (head==null)
            throw Exception("The queue is empty")
        val item = head?.item
        head = head?.next
        n--
        return item
    }

    fun size() = n

    fun isEmpty() = n==0


    override fun iterator(): Iterator<T> {
        return QueueIterator()
    }

    inner class QueueIterator : Iterator<T> {
        private var pos : Node? = head

        override fun hasNext(): Boolean {
            return pos!=null
        }

        override fun next(): T {
            // Use a safe-call to handle the case of pos==null
            pos?.let {
                val item = it.item
                pos = it.next
                return item
            }
            throw NullPointerException("Queue iterator empty")
        }
    }


}

// Unit tests of the Queue data structure
fun main(args: Array<String>) {
    // Create a queue and check it is empty
    val queue = Queue<Int>()
    assert(queue.size()==0 && queue.isEmpty())

    // Add some items and check size and not empty
    queue.enqueue(5)
    queue.enqueue(6)
    queue.enqueue(7)
    assert(queue.size()==3 && ! queue.isEmpty())

    // Dequeue an item. Check FIFO order and size
    val item = queue.dequeue()
    assert(item==5 && queue.size()==2)

    // Test the iterator
    for(x in queue) {
        print("$x, ")
    }

}
