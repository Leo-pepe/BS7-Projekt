public class EncrypterFactory {
    public E getEncrypter(Class<E> encrypterClass)
    {
        try {
            return encrypterClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
