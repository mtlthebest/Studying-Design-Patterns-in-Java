package report;

public class HTMLReport extends Report {

	@Override
	protected void outputStart() {
		System.out.println("<html>");

	}

	@Override
	protected void outputHead() {
		System.out.println("	<head>");
		System.out.println("		<title>"+title+"</title>");
		System.out.println("	</head>");
	}

	@Override
	protected void outputBodyStart() {
		System.out.println("	<body>");
	}

	@Override
	protected void outputParagraph(String paragraph) {
		System.out.println("		<p>"+paragraph+"</p>");
	}

	@Override
	protected void outputBodyEnd() {
		System.out.println("	</body>");
	}

	@Override
	protected void outputEnd() {
		System.out.println("</html>");
	}

}
