package running;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Problem_1228 {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int test_case = 0; test_case < 10; test_case++) {
            int N = scanner.nextInt(); // 원본 암호문 뭉치 속 암호문의 개수
            LinkedList<Integer> origin = new LinkedList<>();
            
            for (int i = 0; i < N; i++) {
                int num = scanner.nextInt();
                origin.add(num);
            }
            
            int M = scanner.nextInt(); // 명령어의 개수
            
            for (int i = 0; i < M; i++) {
                char cmd = scanner.next().charAt(0);
                if (cmd == 'I') {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    LinkedList<Integer> s = new LinkedList<>();
                    for (int j = 0; j < y; j++) {
                        s.add(scanner.nextInt());
                    }
                    IInstruction instruction = new IInstruction(x, y, s);
                    instruction.run(origin);
                } else if (cmd == 'D') {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    DInstruction instruction = new DInstruction(x, y);
                    instruction.run(origin);
                } else if (cmd == 'A') {
                    int y = scanner.nextInt();
                    LinkedList<Integer> s = new LinkedList<>();
                    for (int j = 0; j < y; j++) {
                        s.add(scanner.nextInt());
                    }
                    AInstruction instruction = new AInstruction(y, s);
                    instruction.run(origin);
                }
            }
            
            for (int i = 0; i < 10 && !origin.isEmpty(); i++) {
                System.out.print(origin.poll() + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}

class Instruction {
    int x;
    int y;
    LinkedList<Integer> s;
    
    public Instruction(int x, int y) {
        this.x = x;
        this.y = y;
        this.s = new LinkedList<>();
    }
    
    void run(LinkedList<Integer> origin) {};
}

class IInstruction extends Instruction {
    public IInstruction(int x, int y, LinkedList<Integer> s) {
        super(x, y);
        this.s = s;
    }
    
    public void run(LinkedList<Integer> origin) {
        ListIterator<Integer> iterator = origin.listIterator(x - 1);
        for (int temp : this.s) {
            iterator.add(temp);
            iterator.next();
        }
    }
}

class DInstruction extends Instruction {
    public DInstruction(int x, int y) {
        super(x, y);
    }
    
    public void run(LinkedList<Integer> origin) {
        ListIterator<Integer> iterator = origin.listIterator(x);
        for (int i = 0; i < this.y; i++) {
            iterator.next();
            iterator.remove();
        }
    }
}

class AInstruction extends Instruction {
    public AInstruction(int y, LinkedList<Integer> s) {
        super(0, y);
        this.s = s;
    }
    
    public void run(LinkedList<Integer> origin) {
        ListIterator<Integer> iterator = origin.listIterator(origin.size());
        for (int temp : this.s) {
            iterator.add(temp);
            iterator.next();
        }
    }
}
