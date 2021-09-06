import java.util.*;
class Node{
    int x;
    int y;
    int value;
    Node left = null;
    Node right = null;
    public Node(int x,int y,int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class binaryTree{
    Node root = null;
    
    public void insertNode(Node n){
        if(this.root == null){
            this.root = n;
            return;
        }
        else{
            Node search = root;
            Node current;
            while(true){
                current = search;
                if(n.x > search.x){
                    search = search.right;
                    if(search == null){
                        current.right = n;
                        break;
                    }
                }
                else{
                    search = search.left;
                    if(search == null){
                        current.left = n;
                        break;
                    }
                }
                
            }
        }
    }
    public void pre(ArrayList<Integer> arr, Node r){
        arr.add(r.value);
        if(r.left != null) this.pre(arr,r.left);
        if(r.right != null) this.pre(arr,r.right);
    }
    public void post(ArrayList<Integer> arr, Node r){
        if(r.left != null) this.post(arr, r.left);
        if(r.right != null) this.post(arr, r.right);
        arr.add(r.value);
    }
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        binaryTree bt = new binaryTree();
        
        int[][] nodelist = new int[nodeinfo.length][];
        for(int i = 0; i < nodeinfo.length; i++){
            nodelist[i] = new int[]{i+1, nodeinfo[i][0],nodeinfo[i][1]};
        }
        Arrays.sort(nodelist, (a,b)->{
            return b[2]-a[2];
        });
        for(int i = 0; i < nodeinfo.length; i++){
            Node node = new Node(nodelist[i][1], nodelist[i][2], nodelist[i][0]);
            bt.insertNode(node);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        //System.out.println(bt.root.value);
        bt.pre(arr, bt.root);
        answer[0] = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[0][i] = arr.get(i);
        }
        arr = new ArrayList<>();
        bt.post(arr, bt.root);
        answer[1] = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[1][i] = arr.get(i);
        }
        return answer;
    }
}