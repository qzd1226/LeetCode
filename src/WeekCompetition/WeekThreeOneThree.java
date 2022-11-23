package WeekCompetition;

public class WeekThreeOneThree {
    public static void main(String[] args) {
        int num = 48; // 100;
        // 11001
        // 1001000
        // 24: 11000
        String fiveBinary=Integer.toBinaryString(num);
        System.out.println("fiveBinary:" + fiveBinary);
        for(int i = 0; i < fiveBinary.length(); i++){
            System.out.println(fiveBinary.charAt(i));
        }
    }
    // 1011
    // 001 111
}
