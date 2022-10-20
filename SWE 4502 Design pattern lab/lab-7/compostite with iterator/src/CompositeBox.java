import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CompositeBox implements Box{
    private final List<Box> boxes = new ArrayList<>();
    CompositeBoxIterator compositeBoxIterator = null;

    public CompositeBox(Box... boxes) {
        this.boxes.addAll(Arrays.asList(boxes));
        compositeBoxIterator = new CompositeBoxIterator(boxes);
    }

    @Override
    public double calculatePrice() {
        return boxes.stream().mapToDouble(Box::calculatePrice).sum();
    }
}
