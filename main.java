import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ali1 {
    public static void main(String[] args) {
        String arrayNames[]={"dEll","APPle","FaSt","GrEE"};
        List<String> names=Arrays.asList(arrayNames);
        List<String> resolvedNames=names.stream()
        .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1,str.length()).toLowerCase())
        .collect(Collectors.toList());  // [0].... 
        resolvedNames.forEach(e->System.out.println(e));
    }
}

public class ali2 {
    public static void main(String[] args) {
        List<String> dataPoints=new ArrayList<>();
        dataPoints.add("5,3,9");
        dataPoints.add("6,,7");
        dataPoints.add("2,3,7");
        dataPoints.add("2,4,8");
        dataPoints.add(",8,5");

        List<String[]> goodDataPoints=dataPoints.stream() //"5,3,9" , "6,,7" ..
        .map(a->a.split(",")) //{"5", "3" ,"9"} {"6", "", "7"}..
        .filter(b-> !b[0].equals("") && !b[1].equals("") && !b[2].equals("")) // true && false && true =false
        .collect(Collectors.toList());         
    }   
}






