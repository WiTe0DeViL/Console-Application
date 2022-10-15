public class VipiChallenge {
    public static void main(String[] args) {

        System.out.println(sum(1342));
    }


    private static int sum(int i) {
        if (i == 0)
            return 0;
        return i % 10 + sum(i / 10);
    }

}
