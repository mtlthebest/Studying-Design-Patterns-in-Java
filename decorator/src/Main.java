import java.io.IOException;
import java.io.StringWriter;

import writerDecorator.CheckSumWriter;
import writerDecorator.NumberingWriter;
import writerDecorator.TimeStampWriter;
import writerDecorator.WriterDecorator;

public class Main {
	
	public static void main(String[] args) throws IOException{
		StringWriter sw = new StringWriter();
		NumberingWriter writerDecorator = new NumberingWriter(sw);
//		CheckSumWriter writerDecorator = new CheckSumWriter(sw);
//		TimeStampWriter writerDecorator = new TimeStampWriter(sw);
//		writerDecorator.write("hoge\n");
//		writerDecorator.write("fuga\n");
		writerDecorator.write("hoge\n");
		writerDecorator.write("fuga\n");
//		System.out.println(writerDecorator.getCheckSum());
		System.out.println(sw);
	}
}
