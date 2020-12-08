
import java.util.Scanner;

public class pr5951 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int M7 = 0;
        int M3 = 0;
        int M21 = 0;
        int MAX = 0;
        int RES = 0;

        System.out.println("Введите N: ");
        int N = read.nextInt();

        for (int i = 0; i < N; i++) {

            System.out.println("Введите DAT: ");
            int DAT = read.nextInt();

            if (DAT % 7 == 0 & DAT % 3 > 0 & DAT > M7) {
                M7 = DAT;
            }
            if (DAT % 3 == 0 & DAT > M3) {
                M3 = DAT;
            }
            if (DAT % 21 == 0 & DAT > M21) {
                if (M21 > MAX) {
                    MAX = M21;
                    M21 = DAT;
                } else if (DAT > MAX) {
                    MAX = DAT;
                }
            }
            System.out.println("Введите R: ");
            int R = read.nextInt();

            if (M7 * M3 < M21 * MAX) {
                RES = M21 * MAX;
            } else {
                RES = M3 * M7;
            }
            System.out.println("Вычисленное контрольное значение: " + RES);
            if (R == RES) {
                System.out.println("Контроль пройден");
            } else {
                System.out.println("Контроль не пройден");
            }

        }
    }
}

