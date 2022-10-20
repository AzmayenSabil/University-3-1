import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBoxIterator implements Iterator{

    private final List<Box> boxes = new ArrayList<>();
    int position = 0;

    CompositeBoxIterator(Box... boxes){
        this.boxes.addAll(Arrays.asList(boxes));
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
