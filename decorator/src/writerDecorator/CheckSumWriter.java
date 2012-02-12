package writerDecorator;

import java.io.IOException;
import java.io.Writer;

public class CheckSumWriter extends WriterDecorator {

	private int checkSum;
	
	public CheckSumWriter(Writer out) {
		super(out);
	}

	public int getCheckSum(){
		return checkSum;
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i=0;i<len;i++){
			checkSum = (checkSum + cbuf[i]) % 256;
		}
		this.out.write(cbuf, off, len);
	}

}
