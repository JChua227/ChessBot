package Decision;

import java.util.ArrayList;
import java.util.List;

public class NotationConverter {

    private List<Character> notationSymbol = new ArrayList<>();

    public NotationConverter(){
        populateNotationSymbol();
    }

    public void populateNotationSymbol(){
        notationSymbol.add('a');
        notationSymbol.add('b');
        notationSymbol.add('c');
        notationSymbol.add('d');
        notationSymbol.add('e');
        notationSymbol.add('f');
        notationSymbol.add('g');
        notationSymbol.add('h');
    }

    public Character getNotationSymbol(int x){
        return this.notationSymbol.get(x);
    }


}
