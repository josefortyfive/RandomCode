package random;

class Test<T> {
    // An object of type T is declared
    T obj;
    Test(T obj) { this.obj = obj; } // constructor
    public T getObject() { return this.obj; }
}
 

class GenericTest {

    public static void main(String[] args)
    {
        // instance of Integer type
        StackDemo1<Integer> iObj = new StackDemo1<Integer>(15);
        System.out.println(iObj.getObject());
 
        // instance of String type
        StackDemo1<String> sObj
            = new StackDemo1<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
    }
}