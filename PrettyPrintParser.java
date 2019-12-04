package exercise;

/**
 * PrettyPrintParser extends XMLParser, overriding
 * the enter and exit functions to prefix all
 * opening tags with ⟶ and all closing tags
 * with ⟵ .
 */
public class PrettyPrintParser extends XMLParser{
    private int indentLevel = 0;


    public PrettyPrintParser(String filePath) {
        super(filePath);
    }


    @Override
    public void enter(String openTag){
        if(indentLevel == 0){
            System.out.print("\u2192  ");
            System.out.print(openTag);
            indentLevel  = indentLevel + 4;
        }
        else {
            for(int count = 0; count < indentLevel; count++){
                System.out.print(" ");
            }
            System.out.print("\u2192  ");
            System.out.print(openTag);
            indentLevel  = indentLevel + 4;
        }
    }


    @Override
    public void exit(String closeTag){
        if(indentLevel != 0){
            indentLevel  = indentLevel - 4;
            for(int count = 0; count < indentLevel; count++){
                System.out.print(" ");
            }
            System.out.print("\u2190  ");
            System.out.print(closeTag);
        }
        else {
            System.out.print("\u2190  ");
            System.out.print(closeTag);
        }
    }
}

