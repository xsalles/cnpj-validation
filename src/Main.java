import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cnpj;
        int[] sizeFirst = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] sizeSecond = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        int sumFirstDigit = 0;
        int sumSecondDigit = 0;
        int firstDigit = 0;
        int secondDigit = 0;

        System.out.println("Digite o cnpj que deseja saber se é válido ou não");
        cnpj = sc.next();
        cnpj = cnpj.replaceAll("[^0-9]", "");

        for (int i = 0; i < 12; i++) {
            sumFirstDigit += (Character.getNumericValue(cnpj.charAt(i)) * sizeFirst[i]);
        }

        for (int i = 0; i < 13; i++) {
            sumSecondDigit += Character.getNumericValue(cnpj.charAt(i)) * sizeSecond[i];
        }

        firstDigit = 11 - (sumFirstDigit % 11);

        if (firstDigit >= 10 || firstDigit <= 2) {
            firstDigit = 0;
        }

        secondDigit = 11 - (sumSecondDigit % 11);

        if (secondDigit >= 10 || secondDigit <= 2) {
            secondDigit = 0;
        }

        if (firstDigit != Character.getNumericValue(cnpj.charAt(12))
                || secondDigit != Character.getNumericValue(cnpj.charAt(13)) || cnpj.length() != 14) {
            System.out.println("CNPJ INVÁLIDO");
        } else {
            System.out.println("CNPJ VÁLIDO");
        }

        sc.close();
    }
}