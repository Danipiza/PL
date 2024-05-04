package asint;

// this file is adapted from https://github.com/bhavinshah7/Mini-Java-Compiler/blob/master/Compiler/src/main/java/eminijava/semantics/NameError.java

public class NameError{

	private int line;
	private int column;
	private String errorText;

	public NameError(int line, int column, String errorText) {
		this.line = line;
		this.column = column;
		this.errorText = errorText;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	@Override
	public String toString() {
		return line + ":" + column + " error: " + errorText;
	}

}
