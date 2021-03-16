import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;


public class ImageManipulatorMain {
   
   public static void main(String[] args) throws Exception
   {

      boolean err = compile(args);
      
      if(err)
		System.exit(1);
	  else
		execute(args);
      
   }
   
   public static boolean compile(String[] args) throws Exception
   {
	   
	  InputStream in = null;
      try {
         in = new FileInputStream(new File(args[0]));
      }
      catch(FileNotFoundException e)
      {
         System.err.println("ERROR: file does not exist\nUsage: ImageManipulatorMain <program-file>");
         System.exit(1);
      }
      // create a CharStream that reads from standard input:
      CharStream input = CharStreams.fromStream(in);
      // create a lexer that feeds off of input CharStream:
      ImageManipulatorLexer lexer = new ImageManipulatorLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      ImageManipulatorParser parser = new ImageManipulatorParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at main rule:
      ParseTree tree = parser.main();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         System.out.println("Verifying Semantics...");
         SemanticCheck semCheck = new SemanticCheck();
         semCheck.visit(tree);
      }
      System.out.println("Semantics Verified With Success!");
	  return false;
   }
   
   public static void execute(String[] args) throws Exception
   {
	   
      InputStream in = new FileInputStream(new File(args[0]));
      // create a CharStream that reads from standard input:
      CharStream input = CharStreams.fromStream(in);
      // create a lexer that feeds off of input CharStream:
      ImageManipulatorLexer lexer = new ImageManipulatorLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      ImageManipulatorParser parser = new ImageManipulatorParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at main rule:
      ParseTree tree = parser.main();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         System.out.println("Executing...\n\n\n");
         MyVisitor visitor = new MyVisitor();
         visitor.visit(tree);
      }
	   
   }
   
}
