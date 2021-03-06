import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores the program environment variables, functions, and main function.
 *
 */
public class Program {
	private HashMap<String, Evaluator> vars;
	private HashMap<String, Function> func;
	private Function main;
	private ArrayList<String> imports;

	public Program() {
		vars = new HashMap<String, Evaluator>();
		func = new HashMap<String, Function>();
		main = null;
		imports = new ArrayList<String>();
	}

	public Program(Program env) {
		vars = new HashMap<String, Evaluator>(env.vars);
		func = new HashMap<String, Function>(env.func);
	}

	public void setVar(String name, Evaluator val) {
		vars.put(name, val);
	}

	public Evaluator getVar(String name) {
		return vars.get(name);
	}

	public void defFunc(String name, Function f) {
		func.put(name, f);
	}

	public Function getFunc(String name) {
		return func.get(name);
	}

	public void setMain(Function main) {
		this.main = main;
	}

	public Function getMain() {
		return main;
	}
	
	public boolean addImport(String path){
		if(!imports.contains(path)){
			imports.add(path);
			return true;
		}
		return false;
	}

}
