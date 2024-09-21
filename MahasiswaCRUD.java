import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MahasiswaCRUD 
{
    private static Map<String, String> mahasiswaMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n ------------------- Menu PSI Mahasiswa -----------------");
            System.out.println("1. Create Mahasiswa");
            System.out.println("2. Read daftar mahasiswa");
            System.out.println("3. Update identitas mahasiswa");
            System.out.println("4. Delete data mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih salah satu : ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    readMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    deleteMahasiswa();
                    break;
                case 5:
                    System.out.println("Anda telah logout dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan yang anda masukkan tidak tersedia.");
            }
        } while (pilihan != 5);
    }

    private static void createMahasiswa() {
        System.out.print("Masukkan NIM : ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            System.out.println("Mahasiswa telah terdaftar, silahkan coba lagi");
        } else {
            System.out.print("Masukkan nama mahasiswa : ");
            String nama = scanner.nextLine();
            mahasiswaMap.put(nim, nama);
            System.out.println("Data mahasiswa berhasil ditambahkan.");
        }
    }

    private static void readMahasiswa() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Data mahasiswa tidak terdaftar.");
        } else {
            System.out.println("\nDaftar Mahasiswa : ");
            for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
                System.out.println("NIM : " + entry.getKey() + ", Nama : " + entry.getValue());
            }
        }
    }

    private static void updateMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diubah : ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            System.out.print("Masukkan Nama baru : ");
            String namaBaru = scanner.nextLine();
            mahasiswaMap.put(nim, namaBaru);
            System.out.println("Data mahasiswa berhasil diupdate.");
        } else {
            System.out.println("NIM tidak terdaftar.");
        }
    }

    private static void deleteMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus : ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            mahasiswaMap.remove(nim);
            System.out.println("Mahasiswa berhasil dihapus dari daftar.");
        } else {
            System.out.println("NIM tidak terdaftar.");
        }
    }
}
