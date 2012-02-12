package writerDecorator;

import java.io.IOException;
import java.io.Writer;

public abstract class WriterDecorator extends Writer {
	
	protected Writer out;
	
	@Override
	public void close() throws IOException {
		this.out.close();

	}

	@Override
	public void flush() throws IOException {
		this.out.flush();

	}
	
	public WriterDecorator(Writer out){
		this.out = out;
	}
	
}
