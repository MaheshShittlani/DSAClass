class TowerHanoi {
    public static void tower(int n, char beg, char aux, char end) {
        if(n == 1) {
            System.out.println("Disk "+ n +" moved from " + beg + " to " + end);
            return;
        }

        tower(n-1, beg, end, aux);
        System.out.println("Disk "+ n +" moved from " + beg + " to " + end);
        tower(n-1, aux, beg, end);
    }

    public static void main(String[] args) {
        tower(20, 'A', 'B', 'C');
    }
}