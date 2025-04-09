package SPCCSEM6;

import java.util.*;

public class Experiment6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] productionRules = new String[]{"t1->-c","t2->a+b","t3->a+b","t4->a+b","t5->d-5","t6->a+b","t7->-c","t8->d-5"};
        System.out.println("Production Rules are : "+Arrays.toString(productionRules));
        Set<String> stringSet = new HashSet<String>();
        for(int i=0;i<productionRules.length;i++){
            stringSet.add(productionRules[i].substring(productionRules[i].indexOf(">")+1));
        }
        System.out.println("After Eliminating Common Production Rules we get : ");
        String[] reducedProductionRules = stringSet.toArray(new String[0]);
        for (int i=0;i<reducedProductionRules.length;i++){
            System.out.println("t"+(i+1)+"->"+reducedProductionRules[i]);
        }
    }

}
