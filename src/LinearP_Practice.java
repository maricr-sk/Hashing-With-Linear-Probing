public class LinearP_Practice {
    private static final String [] HTABLE = new String[26];
    private static final int n = HTABLE.length;

    public static void insert(String key){
        if(!findS(key)) {
            int index = h(key);
            int i = 0;
            while ( (!HTABLE[(index + i) % n].equals("-") && !HTABLE[(index + i) % n].equals("*")) && i < n){
                i++;
            }
            if (i == n) return;
            HTABLE[(index + i) % n] = key;
        }
    }

    public static boolean delete (String key){
        int i = 0;
        int index = h(key);
        while ( HTABLE [(index + i) % n] != key && i < n){ i++; }
        if(i == n) return false;
        HTABLE[(index + i) % n ] = "*";
        return true;
        //should call find before it can be deleted
    }

    public static boolean findS (String key) {
        return find(key) != -1;
    }

    public static int find(String key) {
        //which index it is found
        int index = h(key);
        int i = 0;
        while ((!HTABLE[(index + i) % n].equals("-") || !HTABLE[(index + i) % n].equals("*")) && i < n) {
            i++;
        }
        if (i >= n) return -1;
        return i;
    }

    public static int h(String key){ return key.charAt(0) - 'A'; }

    public static void print(String [] arr){
        String answer = "{ ";
        for(int i = 0; i < arr.length; ++i ){
            answer += arr[i];
            if(i != arr.length -1) answer += ", ";
        }
        answer += " }";
        System.out.println(answer);
    }

    public static void main(String[] args) {
        for(int i  = 0; i < HTABLE.length; ++i){ HTABLE[i] = "-"; }
        String [] array = {"Apple", "Balloon", "Constable", "Cake","Syrup","Donut","Xylophone"};
        for(String i : array){
            insert(i);
        }
        print(HTABLE);
        delete("Apple");
        print(HTABLE);
        insert("Aardvark");
        print(HTABLE);
    }
}
