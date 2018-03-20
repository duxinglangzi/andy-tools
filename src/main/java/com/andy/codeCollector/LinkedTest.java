package com.andy.codeCollector;

/**
 * <p>Description: 单向链表操作 </p>
 * @author wuqiong  2018年3月20日
 */
public class LinkedTest {

    public static void main(String[] args) {

        Node n1=new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        Node h = n1;
        while (null != h) {
            System.out.print(h.getIndex() + " ");
            h = h.getNext();
        }

        Node re = reverse(n1);
        System.out.println("反转后---");
        while (null != re) {
            System.out.print(re.getIndex() + " ");
            re = re.getNext();
        }

    }

    /**
     * 方法描述: 递归方法
     * @param head
     * @return Node
     * @author wuqiong 2018年3月19日 下午4:08:12
     */
    public static Node reverse(Node head){
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse(head.getNext());// 先反转后续节点head.getNext()

        // 将自己的下一个节点。   的子节点  设置成自己， 那么两个节点 会形成一个 死循环。  所以必须将自己的下一个节点置空， 防止形成死链
        head.getNext().setNext(head);
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    /**
     * 方法描述:链表反转 (顺序查找并反转)
     * @param head
     * @return Node
     * @author wuqiong 2018年3月19日 下午6:04:02
     */
    public static Node re2(Node head){
        //非空判断
        if (head == null){
            return head;
        }

        Node qian = head;//1
        Node ben = head.getNext();//2
        Node tem;//3
        head.setNext(null);//置空头部,防止形成 一个 首尾相连的死链

        while(ben != null){
            tem = ben.getNext();
            ben.setNext(qian);

            qian = ben;
            ben = tem;
        }
        return qian;
    }

    /**
     * <p>Description: 一个简单的单向链表 内部类 </p>
     * @author wuqiong  2018年3月20日
     */
    private static class Node{
        int index;
        Node next;

        Node(int index){
            this.index=index;
        }
        public int getIndex() {
            return index;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }


}
