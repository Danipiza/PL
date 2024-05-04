package asint;
import java.util.ArrayList;
import java.util.List;

// this file is adapted from https://github.com/bhavinshah7/Mini-Java-Compiler/blob/master/Compiler/src/main/java/eminijava/semantics/SemanticErrors.java

public class SemanticErrors {

	public static List<NameError> errorList = new ArrayList<>();

	public static void addError(int line, int col, String errorText) {
		NameError error = new NameError(line, col, errorText);
		errorList.add(error);
	}

}
