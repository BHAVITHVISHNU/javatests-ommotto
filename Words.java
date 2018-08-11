import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class Words
{
    public static void TopWords(String[] words){
        
    LinkedHashMap<String, Integer> occurrences = new LinkedHashMap<String, Integer>();
     for ( String word : words ) {
        Integer count = occurrences.get(word);
         if ( count == null ) {
             count = 0;
        }      
      occurrences.put(word, count + 1);
    }
    LinkedHashMap<String, Integer> sortedMap = sortByValue(occurrences);
    

    for(int i=0; i<5;i++) {
         System.out.println(getByIndex(sortedMap,i));
         
    }
}
   public static String getByIndex(LinkedHashMap<String,Integer> hMap, int index){
    return (String) hMap.keySet().toArray()[index];
   }
    
  private static LinkedHashMap<String, Integer> sortByValue(LinkedHashMap<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

       
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

       
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
     
  
    public static void main (String[] args)
    {
        String[] words = {"AAA","AAAh","BBB","BBB","BBB","CC","CC","XXX", "XXX","PP","PP","QQ","XXX","XXX"};
      
             int wrc=1;		
		
		/*for(int i=0;i<words.length;i++)				
		{
			for(int j=i+1;j<words.length;j++)	
			{
				
			if(words[i].equals(words[j]))	
				{
					wrc=wrc+1;				
					words[j]="0";		
				}
			}
			if(words[i]!="0")
			System.out.println(words[i]+"--"+wrc);	
			wrc=1;
}*/
       
           TopWords(words);
    }
}