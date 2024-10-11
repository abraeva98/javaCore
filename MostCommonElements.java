import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class MostCommonElements {
    List<Integer> flatten = new ArrayList<>();
    Map<Integer, Integer> count = new HashMap<>();
    Integer maxVal = Integer.MIN_VALUE;

    private Integer findFrequent(List nestedList) {   
        for(Object element: nestedList) {
            if(element instanceof Integer) {
                flatten.add((Integer)element);
                count.put((Integer)element, count.getOrDefault((Integer)element, 0) + 1);
                maxVal = maxVal > count.get(element) ? maxVal : (Integer)element;
            } else if (element instanceof List) {
                findFrequent((List)element);
            }
        }
        return maxVal;
    }
    public static void main(String[] args) {
        List<Object> nestedList = new ArrayList<>(Arrays.asList(
            1, 2, 3, 
            new ArrayList<>(Arrays.asList(5, 5)),
            6, 
            new ArrayList<>(Arrays.asList(7, 8, 9, 
                new ArrayList<>(Arrays.asList(10, 11))
            ))
        ));
        Integer mostCommon = new MostCommonElements().findFrequent(nestedList);
        System.out.println(mostCommon);
    }
}
