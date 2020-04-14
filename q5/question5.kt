// 5. Remove duplicates on email thread:
// When different email clients are used on a same thread, the discussion get messy
// because old messages are included again and get duplicated. Given a email thread
// (represented by a singly unsorted linked list of messages), write a function that
// remove duplicated messages from it.

fun main(args: Array<String>) {
    val list = MyLinkedList()

    list.addAtHead("email-1")
    list.addAtTail("email-2")
    list.addAtTail("email-1")
    list.addAtTail("email-2")
    list.addAtTail("email-3")
    list.addAtTail("email-1")

    list.removeDuplicates()
    list.printList()
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

    fun deleteAtIndex(index: Int) {
        /* Delete the index-th node in the linked list, if the index is valid. */
        var curr = this.head
        var prev:Node? = null

        var counter = 0
        if (index < 0 || index >= this.length) return
        if (index == 0){
            head = curr!!.next
            this.length--
            return
        }
        while (counter != index){
            prev = curr
            curr = prev!!.next
            counter++
        }
        prev!!.next = curr!!.next
        if (index == length-1) tail = prev
        this.length--
    }

    fun removeDuplicates(){
        var hashSet = hashSetOf<Any?>()
        
        var curr = head
        var prev:Node? = null

        while (curr != null) {
            if(hashSet.contains(curr.value)){
                prev!!.next = curr.next
                this.length--
            }else{
                hashSet.add(curr.value)
                prev = curr
            }
            curr = curr.next
        }
    }

    fun printList() {

        var headAux = head
        while (headAux != null) {
            print("${headAux.value}, ")
            headAux = headAux.next
        }
    }

}