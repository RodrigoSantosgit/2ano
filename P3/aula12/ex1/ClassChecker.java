package aula12.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassChecker {

	private Class<?> cl;
	private Field[] fields; 
	private Class<?> superClass;
	private Class<?>[] interfaceClasses;
	private Constructor<?>[] constr;
	private Method[] methods;
	private List<Object> createdObjects;
	private Scanner read;
	
	public ClassChecker (String name) throws ClassNotFoundException {
		cl = Class.forName(name);
		fields = cl.getDeclaredFields();
		superClass = cl.getSuperclass();
		interfaceClasses = cl.getInterfaces();
		constr = cl.getConstructors();
		methods = cl.getDeclaredMethods();
		createdObjects = new ArrayList<>();
		read= new Scanner(System.in);
	}
	
	public List<Object> getCreatedObjects() {
		return createdObjects;
	}
	
	public String getSuperClass() {
		String info = "";
		if (superClass != null && !superClass.getSimpleName().equals("Object")) {
			info = cl.getSimpleName() + " extends " + superClass.getSimpleName();
		}
		return info;
	}
	
	public String getInterfaces() {
		String info = "";
		if (interfaceClasses.length != 0) {
			info += " implements ";
			for (int i = 0; i < interfaceClasses.length; i++) {
				info += interfaceClasses[i].getSimpleName();
				if (i != interfaceClasses.length - 1) 
					info += ", ";
			}
		}
		return info;
	}
	
	public String getFields() {
		String info = " ";
		if (fields.length > 0) {
			for (Field f : fields) {
				info += Modifier.toString(f.getModifiers()) + " ";	// Modifiers
				info += f.getType() + " "; 							// type										
				info += f.getName() + ";\n ";						// FIELD name
				}
		}
		else 
			info = "\t// No fields\n";

		return info;
	}
	
	public String getConstructor() {
		String info = " ";
		for(int i = 0; i < constr.length; i++) {
			info += constr[i].getDeclaringClass().getSimpleName() 
					+ "(";
			Class<?>[] param = constr[i].getParameterTypes();
			for(int j=0; j<param.length; j++) {
				if(j< param.length-1)
					info += param[j].getSimpleName() + ", ";
				else
					info += param[j].getSimpleName();
			}
			info += ")\n ";
		}
		return info;
	}
	
	public String getMethods() {
		String info = " ";
		for(int i = 0; i < methods.length; i++) {
			info += methods[i].getName()
					+ "(";
			Class<?>[] param = methods[i].getParameterTypes();
			for(int j=0; j<param.length; j++) {
				if(j< param.length-1)
					info += param[j].getSimpleName() + ", ";
				else
					info += param[j].getSimpleName();
			}
			info += ")\n ";
		}
		return info;
	}
	public Object createObject(String className) throws ClassNotFoundException,
		InstantiationException,Exception {
		Class<?> reflection = Class.forName(className);
		if(Modifier.isAbstract( reflection.getModifiers() ) || reflection.isInterface())
			throw new InstantiationException();
		
		for(int i = 0; i < constr.length; i++) {
			System.out.println(i+" - "+constr[i].toGenericString());
		}
		
		System.out.print("Selected constructor: ");
		int chosenIndex = read.nextInt();
		Constructor<?> chosenConstr = constr[chosenIndex];
		Class<?>[] params = chosenConstr.getParameterTypes();
		List<Object> args = new ArrayList<>();
		for(Class<?> param : params) {
			args.add(getObjectOfType(param));
		}
		return chosenConstr.newInstance(args.toArray(new Object[0]));
	}

	private Object getObjectOfType(Class<?> param) throws ClassNotFoundException, InstantiationException, Exception {
		String argType = param.getCanonicalName();
		Object obj = null;
		String inputValue = null;
		if(param.isPrimitive()) {
			System.out.print(argType+": ");
			inputValue = read.nextLine();
		}
		if(argType.equals("float")) {
			obj = Float.parseFloat(inputValue);
		}else if(argType.equals("double")) {
			obj = Double.parseDouble(inputValue);
		}else if(argType.equals("byte")) {
			obj = Byte.parseByte(inputValue);
		}else if(argType.equals("int")) {
			obj = Integer.parseInt(inputValue);
		}else if(argType.equals("short")) {
			obj = Short.parseShort(inputValue);
		}else if(argType.equals("long")) {
			obj = Long.parseLong(inputValue);
		}else if(argType.equals("boolean")) {
			obj = Boolean.parseBoolean(inputValue);
		}else if(argType.equals("char")) {
			obj = inputValue.charAt(0);
		}else if(argType.equals("String")){
			obj = inputValue;
		}else{ //In case it's not a primitive type
			obj = createObject(param.getCanonicalName());
		}
		return obj;
	}
}
