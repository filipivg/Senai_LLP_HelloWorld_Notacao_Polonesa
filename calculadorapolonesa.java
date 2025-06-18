import java.util.Scanner;
import java.util.Stack;

public class calculadorapolonesa {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Stack<Double> pilha = new Stack<>();

        System.out.println("Digite a expressão em notação polonesa (exemplo: 1 2 +):");
        String expressao = leia.nextLine();
        String[] tokens = expressao.split(" ");

        for (String token : tokens) {
            if (token.equals("+")) {
                pilha.push(pilha.pop() + pilha.pop());
            } else if (token.equals("-")) {
                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(a - b);
            } else if (token.equals("*")) {
                pilha.push(pilha.pop() * pilha.pop());
            } else if (token.equals("/")) {
                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(a / b);
            } else {
                pilha.push(Double.parseDouble(token));
            }
        }

        System.out.println("Resultado: " + pilha.pop());
        leia.close();
    }
}
