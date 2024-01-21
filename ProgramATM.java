import java.util.Scanner;
public class ProgramATM {
    // Data dummy untuk simulasi username dan password
    private static final String USERNAME = "jamilatur";
    private static final String PASSWORD = "123";

    // Saldo awal
    private static double saldo = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input username
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();

        // Input password
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        // Proses login
        if (login(inputUsername, inputPassword)) {
            // Jika login berhasil, tampilkan menu
            int choice;
            do {
                displayMenu();
                System.out.print("Masukkan pilihan Anda (1-4): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        cekSaldo();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        tarikTunai();
                        break;
                    case 4:
                        System.out.println("Terima kasih, telah menggunakan layanan ATM.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
                }

            } while (choice != 4);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

        scanner.close();
    }

    // Fungsi untuk melakukan login
    private static boolean login(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Fungsi untuk menampilkan menu
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Deposit");
        System.out.println("3. Tarik Tunai");
        System.out.println("4. Keluar");
    }

    // Fungsi untuk menampilkan saldo
    private static void cekSaldo() {
        System.out.println("Saldo Anda saat ini: Rp " + saldo);
    }

    // Fungsi untuk melakukan deposit
    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah deposit: Rp ");
        double depositAmount = scanner.nextDouble();
        saldo += depositAmount;
        System.out.println("Deposit berhasil. Saldo Anda saat ini: Rp " + saldo);
    }

    // Fungsi untuk melakukan tarik tunai
    private static void tarikTunai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah tarik tunai: Rp ");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount <= saldo) {
            saldo -= withdrawAmount;
            System.out.println("Tarik tunai berhasil. Saldo Anda saat ini: Rp " + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi untuk tarik tunai.");
        }
    }
}


