public class TestBuku {
    public static void main(String[] args) {
        Buku[] book = new Buku[3];
        
        book[0] = new Buku();
        book[0].judul = "Introduction to Java Programming and Data Structures";
        book[0].penulis = "Daniel Liang";
        book[0].harga = 355000;
        
        book[1] = new Buku();
        book[1].judul = "Advanced Java Programming";
        book[1].penulis = "Uttam Roy";
        book[1].harga = 236250;
        
        book[2] = new Buku();
        book[2].judul = "Practical Java Programming";
        book[2].penulis = "Perry Xiao";
        book[2].harga = 95000;

        for (int i = 0; i < book.length; i++) {
            book[i].harga = book[i].harga * 110 / 100;
            System.out.printf("Buku %d:%nJudul\t: %s%nPenulis\t: %s%nHarga\t: Rp. %d%n", i + 1, book[i].judul,
                    book[i].penulis, book[i].harga);
        }
    }
}
