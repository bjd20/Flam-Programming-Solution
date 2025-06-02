
public class MyHashMap {
    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int n; // No. of nodes
    private int N; // Size of bucket array;
    private Node[] buckets;  // bucket array

    public MyHashMap(){
        this.N = 5;
        this.buckets = new Node[N];
    }

    private int hashFunction(int K){
        return K % N;
    }

    private void reHash(){
        this.N *= 2;
        n=0;

        Node[] oldBuckets = buckets;
        this.buckets = new Node[N];

        //copying
        for (int i = 0; i < oldBuckets.length; i++) {
            Node curr = oldBuckets[i];
            while(curr != null){
                put(curr.key, curr.value);
                curr = curr.next;
            }
        }


    }

    public void put(int k, int v){
        int bi = hashFunction(k);

        Node curr = buckets[bi];
        if(curr == null){
            buckets[bi] = new Node(k,v);
        }
        else{
            while(curr != null){
                if(curr.key == k){
                    curr.value = v;
                    return;
                }
                if(curr.next == null) break;
                curr = curr.next;
            }
            curr.next = new Node(k,v);
        }

        n++;
        double lambda  = (double) n/N;       // lambda is a threshold.
        if(lambda > 2.0){
            reHash();
        }
    }

    public int get(int k){
        int bi = hashFunction(k);
        Node curr = buckets[bi];

        while(curr != null){
            if(curr.key == k){
                return curr.value;
            }
        }
        return -1;
    }

    public void remove(int k){
        int bi = hashFunction(k);
        Node curr = buckets[bi];
        
        if(curr == null) return;
        if(curr.key == k){
            buckets[bi] = curr.next;
            n--;
            return;
        }

        Node prev = curr;
        curr = curr.next;

        while (curr!= null) {
            if(curr.key == k){
                prev.next = curr.next;
                n--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }


    public void displayAll(){
        System.out.printf("All %d pairs are: \n", n);

        for (int i = 0; i < buckets.length; i++) {
            Node curr = buckets[i];
            while(curr != null){
                System.out.println(curr.key+ " : " +curr.value);
                curr = curr.next;
            }
        }
    }

}
