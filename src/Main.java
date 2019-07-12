import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<House> houses = new ArrayList<>();
        File name = new File("pla.in");
        Read(name,houses);
        Integer result = leftToRight(houses);
        System.out.println(result+" = leftToRight");
       // Integer result2 = topToDown(houses);
        //Sysstem.out.println(result2+" = topToDown");


    }
    private static void Read(File file,ArrayList<House> houses ){
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            integers.add(Integer.parseInt(scanner.next()));
        }

        if(!integers.isEmpty()) {

            Integer houseNum = integers.get(0);

            for (int i = 1; i < integers.size(); i+=2) {

                Integer w = integers.get(i);
                Integer h = integers.get(i+1);
                if (1<=w&&w<=1000000000&&1<=h&&h<=1000000000)
                houses.add(new House(w,h));
            }
        } else {
            throw new IllegalArgumentException("Error");
        }

    }

    private static Integer leftToRight(ArrayList<House> houses)
    {
        ArrayList<Integer> S = new ArrayList<>();
        Integer p = 0;
        for (int i = 0; i < houses.size(); i++)
        {
            Integer houseHeight =  houses.get(i).getHeight();
            while (!S.isEmpty() && getLastList(S) > houseHeight) {
                int index = S.size()-1;
                S.remove(index); // S.pop
            }
            if (S.isEmpty() || getLastList(S) < houseHeight) {
                S.add(houseHeight);
                p++;
            }
        }
        return p;
    }

    private static Integer getLastList(ArrayList<Integer> list) {
        if(!list.isEmpty()) {
            return list.get(list.size() -1);
        }
        return 0;
    }
}
