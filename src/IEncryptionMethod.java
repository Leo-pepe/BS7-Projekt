public interface IEncryptionMethod {
    String doDecrypt(String text);
    String doEncrypt(String text);
}
