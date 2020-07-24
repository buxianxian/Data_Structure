import java.util.HashSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "bobo", "liu");
        System.out.println(student.hashCode());

        HashSet<Student> hashSet = new HashSet<>();
        //传进去后会自动调用Student类的hashCode方法，计算出相应的索引值，并存储到对应位置
        hashSet.add(student);

        HashMap<Student, Integer> hashMap = new HashMap<>();
        hashMap.put(student, 100);

        //如果我们没有重写hashCode方法，那么student和student2输出的是不同的hashCode
        //因为没有重写的话，使用的是java默认的hashCode
        //Object里的hashCode，是根据每个对象的地址，把它映射成一个整型
        //那么对于这两个对象，它使用了两次new，所以是不同的地址
        Student student2 = new Student(3, 2, "bobo", "liu");
        System.out.println(student2.hashCode());
    }
}
