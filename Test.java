
public class Test {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please pass 0 or 1 as argument");
            return;
        }

        if(args[0].equals("0")){

            LRUCache lru = new LRUCache(2);
            lru.put(1, 1);
            lru.put(2, 2);
            System.out.println(lru.get(1));       
            lru.put(3, 3);
            System.out.println(lru.get(2));       
            lru.put(4, 4);
            System.out.println(lru.get(1));       
            System.out.println(lru.get(3));       
            System.out.println(lru.get(4));

            // lru.displayAll();
        }
        else{

            MyHashMap hashMap = new MyHashMap();
            hashMap.put(1, 10);
            hashMap.put(2,20);
            System.out.println(hashMap.get(1));
            System.out.println(hashMap.get(3));
    
            hashMap.put(2, 30);
            System.out.println(hashMap.get(2));
            hashMap.remove(2);
            System.out.println(hashMap.get(2));
    
            // hashMap.displayAll();
        }

    }
}
