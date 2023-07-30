package Exercise;

import java.util.Scanner;

public class p10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalLightsabersPrice = Math.ceil(studentsCount * 1.10) * lightsaberPrice;
        double totalRobesPrice = robePrice * studentsCount;
        int freeBelts = studentsCount / 6;
        double totalBeltsPrice = beltPrice * (studentsCount - freeBelts);
        double total = totalBeltsPrice + totalRobesPrice + totalLightsabersPrice;

        if (total <= amountOfMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", total - amountOfMoney);
        }
    }
}