import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas Task digunakan untuk merepresentasikan tugas yang memiliki nama dan status penyelesaian.
 */
class Task {
    private final String name;
    private boolean isCompleted;

    /**
     * Konstruktor untuk membuat objek Task baru dengan nama yang diberikan.
     * Status penyelesaian tugas diatur ke "belum selesai" secara default.
     *
     * @param name Nama tugas
     */
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    /**
     * Mengembalikan nama tugas.
     *
     * @return Nama tugas
     */
    public String getName() {
        return name;
    }

    /**
     * Mengembalikan status penyelesaian tugas.
     *
     * @return true jika tugas selesai, false jika belum selesai
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Menandai tugas ini sebagai selesai.
     */
    public void markAsCompleted() {
        isCompleted = true;
    }

    /**
     * Mengembalikan representasi string dari tugas, termasuk status penyelesaiannya.
     *
     * @return String yang merepresentasikan nama tugas dan statusnya
     */
    @Override
    public String toString() {
        return name + (isCompleted ? " [Selesai]" : " [Belum Selesai]");
    }
}

/**
 * Kelas utama TaskReminder yang mengelola daftar tugas dan menyediakan
 * antarmuka pengguna untuk menambah, menyelesaikan, dan menampilkan tugas.
 */
class TaskReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            switch (choice) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    markTaskAsCompleted(scanner, tasks);
                    break;
                case 3:
                    displayTasks(tasks);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }

    /**
     * Menampilkan menu utama aplikasi ke pengguna.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Tandai Tugas Selesai");
        System.out.println("3. Tampilkan Tugas");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    /**
     * Menambahkan tugas baru ke daftar tugas berdasarkan input pengguna.
     *
     * @param scanner Scanner untuk menerima input pengguna
     * @param tasks Daftar tugas yang tersedia
     */
    private static void addTask(Scanner scanner, List<Task> tasks) {
        System.out.print("Masukkan nama tugas: ");
        String taskName = scanner.nextLine();
        tasks.add(new Task(taskName));
    }

    /**
     * Menandai tugas tertentu dalam daftar sebagai selesai, berdasarkan
     * input nomor dari pengguna.
     *
     * @param scanner Scanner untuk menerima input pengguna
     * @param tasks Daftar tugas yang tersedia
     */
    private static void markTaskAsCompleted(Scanner scanner, List<Task> tasks) {
        System.out.print("Masukkan nomor tugas yang sudah selesai: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Tugas berhasil ditandai sebagai selesai!");
        } else {
            System.out.println("Tugas tidak ditemukan!");
        }
    }

    /**
     * Menampilkan daftar tugas yang tersedia beserta status penyelesaiannya.
     *
     * @param tasks Daftar tugas yang tersedia
     */
    private static void displayTasks(List<Task> tasks) {
        System.out.println("Daftar Tugas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
