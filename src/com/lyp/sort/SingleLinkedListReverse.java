package com.lyp.sort;

/**
 * 实现单链表的反转(LeetCode206)
 *
 * @author llspace
 * @since  2019-04-12
 */
public class SingleLinkedListReverse {

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addHead(1);
        for(int i = 2; i < 6; i++){
            singleLinkedList.addNode(i, i-1);
        }
        singleLinkedList.print();

        //测试单链表反转
        //singleLinkedList = reverse(singleLinkedList);
        //singleLinkedList = reverse1(singleLinkedList);
        singleLinkedList = reverse2(singleLinkedList);
        singleLinkedList.print();
    }

    /**
     * 就地反转法
     *
     * @param input
     * @return
     */
    public static SingleLinkedList<Integer> reverse(SingleLinkedList<Integer> input){
        SingleLinkedList.Node<Integer> head = input.getHead();
        SingleLinkedList.Node<Integer> next = head.next;

        while(next != null){
            input.addHead(next.value);
            head.next = next.next;
            next = next.next;
        }
        return input;
    }

    /**
     * 新建链表，头节点插入法
     *
     * @param input
     * @return
     */
    public static SingleLinkedList<Integer> reverse1(SingleLinkedList<Integer> input){
        SingleLinkedList<Integer> output = new SingleLinkedList<>();
        SingleLinkedList.Node<Integer> head = input.getHead();

        while(head != null){
            output.addHead(head.value);
            head = head.next;
        }

        return output;
    }

    /**
     * 递归反转法
     *
     * @param input
     * @return
     */
    public static SingleLinkedList<Integer> reverse2(SingleLinkedList<Integer> input){
        input.setHead(reverseNode(input.getHead()));
        return input;
    }

    public static SingleLinkedList.Node<Integer> reverseNode(SingleLinkedList.Node<Integer> head){
        if(head == null || head.next == null) {
            return head;
        }
        SingleLinkedList.Node<Integer> node = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}

