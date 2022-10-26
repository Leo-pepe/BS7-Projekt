public class CaesarEncryption extends Encrypter implements IEncryptionMethod
{
    private int _index;
    private char _startChar;

    CaesarEncryption(int index)
    {
        this._index = index;
    }

    public String doDecrypt(String text)
    {
        if(_index > 26)
        {
            _index = 4;
        }
        try
        {
            _startChar = _index < 0 ? 'a' : 'z';

            StringBuilder sb = new StringBuilder();
            for(char c : text.toCharArray())
            {
                char letter = (char) calculateCharPos(c, _index);
                sb.append(letter);
            }
            return sb.toString();
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("Invalid character in input!");
        }
        catch(Exception ex)
        {
            System.out.println("Undefined error!");
        }
        return null;
    }

    public String doEncrypt(String text) {
        return doDecrypt(text);
    }

    private int calculateCharPos(char asciiChar, int index)
    {
        int asciiPos = (int) asciiChar;

        if(asciiPos == 32)
        {
            return asciiPos;
        }

        if((asciiPos > 123 || asciiPos < 65) && (asciiPos < 92 || asciiPos > 96))
        {
            throw new IllegalArgumentException();
        }

        if (Character.toLowerCase(asciiChar) == _startChar)
        {
            if(_startChar == 'a')
            {
                asciiPos += 26;
            }
            else
            {
                asciiPos -= 26;
            }
        }
        asciiPos += index;

        return asciiPos;
    }
}

