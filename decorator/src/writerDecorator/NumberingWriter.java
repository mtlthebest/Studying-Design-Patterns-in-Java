package writerDecorator;

import java.io.IOException;
import java.io.Writer;

public class NumberingWriter extends WriterDecorator {

	private long lineNumber;
	
	public NumberingWriter(Writer out) {
		super(out);
		lineNumber=1;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] timeStamp = (lineNumber++ + "#").toCharArray();
		char[] newCbuf = new char[timeStamp.length + cbuf.length];
		System.arraycopy(timeStamp, 0, newCbuf, 0, timeStamp.length);
		System.arraycopy(cbuf, 0, newCbuf, timeStamp.length, len);
		this.out.write(newCbuf, off, len+timeStamp.length);
	}

}
