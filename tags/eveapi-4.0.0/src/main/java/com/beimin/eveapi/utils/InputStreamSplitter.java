package com.beimin.eveapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamSplitter extends InputStream {
	private final InputStream src;
	private final OutputStream copy;

	public InputStreamSplitter(InputStream src, OutputStream copy) {
		this.src = src;
		this.copy = copy;
	}

	@Override
	public int read() throws IOException {
		int tmp = src.read();
		copy.write(tmp);
		return tmp;
	}

	@Override
	public int available() throws IOException {
		return src.available();
	}

	@Override
	public void close() throws IOException {
		src.close();
		copy.flush();
		copy.close();
	}

	@Override
	public synchronized void mark(int readlimit) {
		throw new RuntimeException("not available");
	}

	@Override
	public boolean markSupported() {
		return false;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int tmp = src.read(b, off, len);
		if (tmp > 0)
			copy.write(b, off, tmp);
		return tmp;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public synchronized void reset() throws IOException {
		throw new RuntimeException("not available");
	}

	@Override
	public long skip(long n) throws IOException {
		return src.skip(n);
	}
}