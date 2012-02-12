package chemical;

public class Element {
	private String name;
	private String symbol;
	@Override
	public String toString() {
		return "Element [name=" + name + ", symbol=" + symbol
				+ ", atomicWeight=" + atomicWeight + "]";
	}

	private double atomicWeight;

	Element(String name, String symbol, double atomicWeight) {
		this.name = name;
		this.symbol = symbol;
		this.atomicWeight = atomicWeight;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getAtomicWeight() {
		return atomicWeight;
	}

}
