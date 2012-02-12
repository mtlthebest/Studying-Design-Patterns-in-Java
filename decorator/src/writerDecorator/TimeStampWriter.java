package writerDecorator;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeStampWriter extends WriterDecorator {

	private DateFormat dateFormat;
	
	public TimeStampWriter(Writer out) {
		super(out);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] timeStamp = (dateFormat.format(new Date()) + "#").toCharArray();
		char[] newCbuf = new char[timeStamp.length + cbuf.length];
		System.arraycopy(timeStamp, 0, newCbuf, 0, timeStamp.length);
		System.arraycopy(cbuf, 0, newCbuf, timeStamp.length, len);
		this.out.write(newCbuf, off, len+timeStamp.length);
	}
	
}
