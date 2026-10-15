import br.com.dio.calc.Operation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o númedo da operação que deseja realizar (1 = sum, 2 = subtraction): ");
        var operationOption = scanner.nextInt();

        while (operationOption > 2 || operationOption < 1) {
            System.out.println("Escolha uma opção válida! (1 = sum, 2 = subtraction)");
            operationOption = scanner.nextInt();
        }

        var selectedOperation = Operation.values()[operationOption - 1];

        System.out.println("Informe os números que serão usados separados por virgulas (ex: 1,2,3,4)");
        var numbers = scanner.next();

        var numberArray = Arrays.stream(numbers.split(","))
                .mapToLong(Long::parseLong)
                .toArray();

        var result = selectedOperation.getOperationCallBack().exec(numberArray);

        var operationToShow = numbers.replaceAll(",", " " + selectedOperation.getSignal() + " ");
        System.out.printf("O resultado da operação %s = %s \n", operationToShow, result);
    }
}
