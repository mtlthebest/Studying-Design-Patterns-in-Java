package command.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CommandUtils {

	public static String execCommand(List<String> cmds) throws CommandError {
		String stdOutput = new String();
		String errOutput = new String();
		final String LINE_SEPA = System.getProperty("line.separator");
		Runtime r = Runtime.getRuntime();
		InputStream in = null;
		BufferedReader br = null;
		try {
			try {
				Process p = r.exec((String[]) cmds.toArray(new String[0]));
				in = p.getInputStream();
				StringBuffer out = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = br.readLine()) != null) {
					out.append(line + LINE_SEPA);
				}
				stdOutput = out.toString();
				br.close();
				in.close();
				in = p.getErrorStream();
				StringBuffer err = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(in));
				while ((line = br.readLine()) != null) {
					err.append(line + LINE_SEPA);
				}
				errOutput = err.toString();
				int exitCode = p.waitFor();
				if (exitCode != 0) {
					throw new CommandError(exitCode, errOutput);
				}
				return stdOutput;

			} finally {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			if (e instanceof CommandError) {
				throw (CommandError)e;
			}else{
				throw new CommandError(e);
			}
		}
	}
}
