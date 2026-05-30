interface playable {
    void play();
}
class Guitar implements playable {
    @Override
    public void play() {
        System.out.println("Playing guitar");
    }
}
public class Interface {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        guitar.play();
    }
}
