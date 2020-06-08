package Decision;

import java.util.ArrayList;
import java.util.List;

public class NotationConverter {

    private List<Character> notationColumn = new ArrayList<>();
    private List<Integer> notationRow = new ArrayList<>();

    public NotationConverter(){
        populateNotationSymbol();
    }

    public void populateNotationSymbol(){
        notationColumn.add('a');
        notationColumn.add('b');
        notationColumn.add('c');
        notationColumn.add('d');
        notationColumn.add('e');
        notationColumn.add('f');
        notationColumn.add('g');
        notationColumn.add('h');

        for(int x=8; x>0; x--){
            notationRow.add(x);
        }
    }

    public Character getNotationColumn(int y){
        return this.notationColumn.get(y);
    }

    public int getNotationRow(int x){
        return this.notationRow.get(x);
    }


}
