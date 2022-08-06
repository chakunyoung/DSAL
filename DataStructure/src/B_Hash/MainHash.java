package B_Hash;

public class MainHash {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hm = new MyHashMap<>();

        hm.put("cha", 29);
        hm.put("cha", 100);
        System.out.println(hm);

        System.out.println(hm.containsKey("cha"));

        hm.remove("cha");
        System.out.println(hm);


    }


}
