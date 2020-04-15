// If two requests on the queue have linked lists that intersect (like the example below),
// previous service could be improved to process only the difference between them.
// Write a method that receives two singly linked lists and return the intersecting node
// of the two lists (if exists). Note that the intersection is defined by reference, not value.
// (No need to change previous answer).

fun main(args: Array<String>) {

    val list1 = MyLinkedList().Node("C")
    list1.next = MyLinkedList().Node("A")
    list1.next!!.next = MyLinkedList().Node("E")
    list1.next!!.next!!.next = MyLinkedList().Node("H")
    list1.next!!.next!!.next!!.next = MyLinkedList().Node("J")
    list1.next!!.next!!.next!!.next!!.next = MyLinkedList().Node("B")
    list1.next!!.next!!.next!!.next!!.next!!.next = MyLinkedList().Node("A")


    val list2 = MyLinkedList().Node("D")
    list2.next = MyLinkedList().Node("F")
    list2.next!!.next = list1.next!!.next!!.next!!.next
    list2.next!!.next!!.next = list1.next!!.next!!.next!!.next!!.next
    list2.next!!.next!!.next!!.next = list1.next!!.next!!.next!!.next!!.next!!.next

    var result = getNode(list1, list2) as String
    print("The intersection occurred in: $result") 

}

class MyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    var length: Int = 0
    inner class Node(var value: Any?){
        var next: Node? = null
    }

    fun addAtHead(value: Any?){
        val h = this.head
        val newNode = Node(value)
        newNode.next = this.head
        head = newNode
        if (h == null) tail = newNode
        this.length++
    }

    fun addAtTail(value: Any?){
        var h = head
        val newNode = Node(value)
        newNode.next = null
        while (h!!.next !=null) h = h.next
        h.next = newNode
        tail = newNode
        this.length++
    }
}

/*function to get the intersection point of two linked 
    lists head1 and head2 */
    fun getNode(head1: MyLinkedList.Node?, head2: MyLinkedList.Node?): Any? { 
        val c1 = getCount(head1)
        val c2 = getCount(head2) 
  
        if (c1 > c2) { 
            var d = c1 - c2; 
            return getIntesectionNode(d, head1, head2); 
        } 
        else { 
            var d = c2 - c1; 
            return getIntesectionNode(d, head2, head1); 
        } 
    } 
  
    /* function to get the intersection point of two linked 
     lists head1 and head2 where head1 has d more nodes than 
     head2 */
    fun getIntesectionNode(d: Int, node1: MyLinkedList.Node?, node2: MyLinkedList.Node?): Any?{ 
        var i = 0
        var current1:MyLinkedList.Node? = node1 
        var current2:MyLinkedList.Node? = node2 
        
        while (i < d) { 
            if (current1 == null) { 
                return null
            } 
            current1 = current1.next
            i++
        } 

        while (current1 != null && current2 != null) { 
            if (current1.value == current2.value) { 
                return current1.value; 
            } 
            current1 = current1.next; 
            current2 = current2.next; 
        } 
  
        return null
    } 
  
    
    // returns the count of nodes in the list 
    fun getCount(node: MyLinkedList.Node?): Int { 
        var current = node 
        var count = 0
  
        while (current != null) { 
            count++
            current = current.next 
        } 
  
        return count 
    } 

fun printList(head: MyLinkedList.Node?) {

    var headAux = head
    while (headAux != null) {
        headAux = headAux.next
    }
}