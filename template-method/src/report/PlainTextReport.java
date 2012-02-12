package report;

public class PlainTextReport extends Report {

	@Override
	protected void outputStart() {
		// Nothing to do.

	}

	@Override
	protected void outputHead() {
		System.out.println("*****"+title+"*****");

	}

	@Override
	protected void outputBodyStart() {
		// Nothing to do.

	}

	@Override
	protected void outputParagraph(String paragraph) {
		System.out.println(" "+paragraph);

	}

	@Override
	protected void outputBodyEnd() {
		// Nothing to do.

	}

	@Override
	protected void outputEnd() {
		// TODO Auto-generated method stub

	}

}
