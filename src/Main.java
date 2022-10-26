public class Main {
    public static void main(String[] args)
    {
        EncrypterFactory factory = new EncrypterFactory();
        CaesarEncryption ce = factory.getEncrypter(CaesarEncryption.class);
    }
}
