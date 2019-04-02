package com.lyp.sort;


/**
 * <p>@filename SingleLinkedListInsertSort</p>
 * <p>
 * <p>@description 单链表直接插入排序</p>
 *
 * @author Java猿人一枚
 * @version 1.0
 * @since 2019/4/1 16:42
 **/
public class SingleLinkedListInsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            singleLinkedList.addNode(nums[i], i);
        }
        System.out.print("排序前：");
        singleLinkedList.print();
        System.out.println();
        singleLinkedList = singleLinkedListInsertSort(singleLinkedList);
        System.out.print("排序后：");
        singleLinkedList.print();
    }

    /**
     * 单链表插入排序
     *
     * @param singleLinkedList
     * @return
     */
    public static SingleLinkedList<Integer> singleLinkedListInsertSort(SingleLinkedList<Integer> singleLinkedList){
        SingleLinkedList.Node<Integer> head = singleLinkedList.getHead();
        if(head == null || head.next == null){
            return singleLinkedList;
        }else{
            SingleLinkedList<Integer> newSingleLinkedList = new SingleLinkedList<>();
            newSingleLinkedList.addHead(head.value);
            while(head.next != null){
                head = head.next;
                SingleLinkedList.Node<Integer> newHead = newSingleLinkedList.getHead();
                for (int i = 0; i < newSingleLinkedList.size(); i++){
                    if(head.value < newHead.value){
                        newSingleLinkedList.addNode(head.value, i);
                        newSingleLinkedList.print();
                        System.out.println();
                        break;
                    }else{
                        newHead = newHead.next;
                    }
                }
            }

            singleLinkedList = newSingleLinkedList;
        }
        return singleLinkedList;
    }

    /**
     * 测试单链表实现
     */
    public static void testSingleLinkedList(){
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addHead(1);
        singleLinkedList.addHead(2);
        for(int i = 2; i < 5; i++){
            singleLinkedList.addNode(i+1, i);
        }
        singleLinkedList.addHead(10);
        singleLinkedList.addNode(8,3);
        singleLinkedList.addNode(0, 0);
        //预想结果打印：0 10 2 1 8 3 4 5
        singleLinkedList.print();
    }


}

class SingleLinkedList<E> {
    private Node<E> head;
    private int size;

    public SingleLinkedList() {

    }

    public void print(){
        Node<E> node = this.head.next;
        System.out.print(head.value + "\t");
        while(node != null){
            System.out.print(node.value + "\t");
            node = node.next;
        }
    }

    public void addHead(E e){
        this.addNode(e, 0);
    }

    public void addNode(E e, int position){
        //1.判断position的有效性[0, size]之间
        if(position > size || position < 0){
            System.out.println("请输入正确的position值！");
        }
        Node<E> newNode = new Node<>(e);
        if(position == this.size){
            //2.position==size
            if(this.head == null){
                //head为null表示size=0
                this.head = newNode;
            }else{
                //放最后
                Node<E> temp = this.head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }else{
            //3.else，
            if(0 == position){
                //放最前
                Node<E> temp = this.head;
                this.head = newNode;
                newNode.next = temp;
            }else{
                //找到position-1和position位置的节点,将插入节点放到中间位置
                Node<E> pNode = node(position);
                Node<E> preNode = node(position-1);
                preNode.next = newNode;
                newNode.next = pNode;
            }
        }
        size++;
    }

    /**
     * 找到position位置的节点
     *
     * @param position
     * @return
     */
    public Node<E> node(int position){
        Node<E> x = this.head;
        for (int i = 0; i < position; i++){
            x = x.next;
        }
        return x;
    }

    public int size(){
        return this.size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static class Node<E>{
        Node<E> next;
        E value;

        public Node(E value) {
            this.value = value;
        }
    }

}


