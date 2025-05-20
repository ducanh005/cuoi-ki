import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FullTimeEmployee emp1 = new FullTimeEmployee("VU DUC ANH", LocalDate.of(2020, 5, 10), 2000, 500);
        PartTimeEmployee emp2 = new PartTimeEmployee("VU DUC KIEN", LocalDate.of(2022, 8, 15), 120, 15);

        emp1.showInfo();
        System.out.println();
        emp2.showInfo();
    }
}

abstract class Employee {
    private String name;
    private LocalDate started;

    public Employee(String name, LocalDate started) {
        this.name = name;
        this.started = started;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public abstract void showInfo();
    public abstract double calcSalary();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;

    public FullTimeEmployee(String name, LocalDate started, double monthlySalary, double bonus) {
        super(name, started);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    public double calcSalary() {
        return monthlySalary + bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Full-Time Employee: " + getName());
        System.out.println("Started: " + getStarted());
        System.out.println("Salary: " + calcSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int workingHour;
    private double rate;

    public PartTimeEmployee(String name, LocalDate started, int workingHour, double rate) {
        super(name, started);
        this.workingHour = workingHour;
        this.rate = rate;
    }

    @Override
    public double calcSalary() {
        return workingHour * rate;
    }

    @Override
    public void showInfo() {
        System.out.println("Part-Time Employee: " + getName());
        System.out.println("Started: " + getStarted());
        System.out.println("Salary: " + calcSalary());
    }
}

//cau 11
// a.
interface Animal {
    void eat();
    void showInfo();
}

interface Bird extends Animal {
    void fly();
}

interface Horse extends Animal {
    void run();
}

// b.
class Pegaus implements Bird, Horse {
    public String name;
    private int age;

    public Pegaus(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating.");
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void run() {
        System.out.println(name + " is running.");
    }
}

// c.
public static void cau1() {
    Pegaus p1 = new Pegaus("PegasusOne", 5);
    Pegaus p2 = new Pegaus("PegasusTwo", 7);

    p1.eat(); p1.fly(); p1.run(); p1.showInfo();
    p2.eat(); p2.fly(); p2.run(); p2.showInfo();
}



//cau 22
import java.util.Scanner;

public static void cau2() {
    Scanner sc = new Scanner(System.in);
    try {
        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("Tên: " + name + ", Tuổi: " + age);
    } catch (Exception e) {
        System.out.println("Đã xảy ra lỗi: " + e.getMessage());
    }
}

// cau 3
import java.io.*;

public static void cau3() {
    try {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("students.txt"));
        writer.write("Nguyen Van A\nTran Thi B\nLe Van C\n");
        writer.close();

        InputStreamReader reader = new InputStreamReader(new FileInputStream("students.txt"));
        int ch;
        System.out.println("Nội dung file:");
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Lỗi: " + e.getMessage());
    }
}


import java.io.*;

public class MyIO_StreamReaderWriter {
    public static void main(String[] args) {
        String filename = "stream_rw.txt";
        String content = "Hello world!";

        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename))) {
            osw.write(content);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return;
        }

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filename))) {
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = isr.read()) != -1) {
                sb.append((char) ch);
            }
            System.out.println(sb.toString().toUpperCase());
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}

import java.io.*;

public class MyIO {
    public static void main(String[] args) {
        String filename = "utf8.txt";
        String fullName = "Nguyen Van An";

        // Ghi vào file bằng BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(fullName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc file bằng BufferedReader và xử lý viết hoa phần họ
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.trim().split("\\s+"); // tách theo khoảng trắng
                if (parts.length > 0) {
                    parts[0] = parts[0].toUpperCase(); // viết hoa phần họ
                }
                // Ghép lại tên đầy đủ
                StringBuilder result = new StringBuilder();
                for (String word : parts) {
                    result.append(word).append(" ");
                }
                System.out.println(result.toString().trim());
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

import java.io.*;

public class MyIO {
    public static void main(String[] args) {
        String filename = "int.txt";
        int num1 = 10;
        int num2 = 20;

        // Ghi 2 số nguyên vào file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(num1);
            dos.writeInt(num2);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        // Đọc 2 số nguyên từ file và tính tổng
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int a = dis.readInt();
            int b = dis.readInt();
            int total = a + b;
            System.out.println("Total: " + total);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}


// cau 4
import java.util.Random;

public static void cau4() {
    String name = "Nguyen"; // thay bằng tên của bạn

    Thread t1 = new Thread(() -> {
        try {
            for (char c : name.toCharArray()) {
                System.out.println("Chữ cái: " + c);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("T1 lỗi: " + e.getMessage());
        }
    });

    Thread t2 = new Thread(() -> {
        Random rand = new Random();
        for (int i = 0; i < name.length(); i++) {
            int num = -1 * (rand.nextInt(10) + 1);
            System.out.println("Số ngẫu nhiên: " + num);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("T2 lỗi: " + e.getMessage());
            }
        }
    });

    t1.start();
    t2.start();
}

// cau 5
import java.util.*;

public static void cau5() {
    List<Pegaus> list = new ArrayList<>();
    list.add(new Pegaus("Peg1", 3));
    list.add(new Pegaus("Peg2", 6));

    Map<Integer, Pegaus> map = new HashMap<>();
    int key = 1;
    for (Pegaus p : list) {
        map.put(key++, p);
    }

    for (Map.Entry<Integer, Pegaus> entry : map.entrySet()) {
        System.out.print("Key: " + entry.getKey() + " - ");
        entry.getValue().showInfo();
    }
}

import java.util.*;

public class WordCountSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập câu:");
        String line = sc.nextLine();

        String[] words = line.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("Kết quả:");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}


import java.util.*;

public class MaxFinder {
    public static <T extends Comparable<T>> T findMax(Set<T> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }

        T max = null;
        for (T element : set) {
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(3, 9, 2, 5, 7));
        Integer maxNumber = findMax(numbers);
        System.out.println("Max: " + maxNumber);

        Set<String> names = new HashSet<>(Arrays.asList("An", "Binh", "Cuong"));
        String maxName = findMax(names);
        System.out.println("Max name: " + maxName);

        Set<Integer> emptySet = new HashSet<>();
        System.out.println("Empty set max: " + findMax(emptySet));
    }
}

import java.util.*;

public class DuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 5, 2, 7, 3, 8, 3, 9);

        Map<Integer, Integer> countMap = new HashMap<>();

        // Đếm số lần xuất hiện
        for (int num : list) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Các số bị lặp lại:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
            }
        }
    }
}


import java.util.*;

public class ConvertStringsToIntegers {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("10", "abc", "25", "5x", "100", "42");

        List<Integer> intList = new ArrayList<>();

        for (String s : stringList) {
            try {
                int number = Integer.parseInt(s);
                intList.add(number);
            } catch (NumberFormatException e) {
                // Bỏ qua nếu không phải số nguyên
            }
        }

        System.out.println("Danh sách số nguyên:");
        for (int num : intList) {
            System.out.println(num);
        }
    }
}

