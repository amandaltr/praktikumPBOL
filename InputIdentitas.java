import java.util.Scanner;

public class InputIdentitas {
    public static void main(String[] args) {
        //memanggil fungsi scanner untuk membaca input user
        Scanner scanner = new Scanner(System.in);
        
        //user menginput nama dan nim
        System.out.print("Masukkan nama Anda : ");
        String nama = scanner.nextLine(); //scan input nama
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();  //scan input NIM
        
        //menampilkan output
        System.out.println("Nama yang Anda masukkan adalah: " + nama);
        System.out.println("NIM yang Anda masukkan adalah: " + nim);

        scanner.close(); //menutup scanner
    }
}
