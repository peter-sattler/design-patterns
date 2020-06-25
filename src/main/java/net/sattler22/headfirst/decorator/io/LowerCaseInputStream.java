package net.sattler22.headfirst.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class LowerCaseInputStream extends FilterInputStream {

    LowerCaseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        int result = super.read(b, offset, length);
        for (int i = offset; i < offset + result; i++)
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        return result;
    }
}
