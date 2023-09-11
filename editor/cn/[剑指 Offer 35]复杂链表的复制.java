
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        traverse(head);
        return originToClone.get(head);
    }

    HashSet<Node> visited = new HashSet<>();
    HashMap<Node, Node> originToClone = new HashMap<>();

    void traverse(Node node) {
        if (node == null) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (!originToClone.containsKey(node)) {
            originToClone.put(node, new Node(node.val));

        }
        Node cloneNode = originToClone.get(node);

        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);
        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
