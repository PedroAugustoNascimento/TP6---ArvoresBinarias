package src;
import java.util.Map;
import java.util.HashMap;   
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class Hash {

    //existem diversos outros exemplos de tabelas de dispersão, porém a maioria é uma variação de HashMap ou HashSet (ao menos o que encontrei na oracle)
    private Map<String, String> ExampleHash;
    private HashSet<String> ExampleSet;
    private LinkedHashMap<String, String> ExampleLinkedHash;
    private Hashtable<String, String> ExampleHashTable;

    public Hash(){
        ExampleHash = new HashMap<String,String>();
        ExampleSet = new HashSet<String>();
        ExampleLinkedHash = new LinkedHashMap<>();
        ExampleHashTable = new Hashtable<>();


        ExampleHash.put("chave1","valor1"); //implementação de um HashMap
        ExampleHash.put("chave2", "valor2");
        ExampleHash.put("chave3", "valor3");
        ExampleHash.put("chave4", "valor4");

        ExampleSet.add("valor5"); // implementação de um HashSet
        ExampleSet.add("valor6");
        ExampleSet.add("valor7");
        ExampleSet.add("valor8");

        ExampleLinkedHash.put("chave9", "valor9"); // implementação de um linked hash
        ExampleLinkedHash.put("chave9", "valor9");
        ExampleLinkedHash.put("chave9", "valor9");
        ExampleLinkedHash.put("chave9", "valor9");

        ExampleHashTable.put("chave10", "valor10"); //implementação de um hash table
        ExampleHashTable.put("chave11", "valor11");
        ExampleHashTable.put("chave12", "valor12");
    }


    public void getMapValue(){ //imprimindo todas as chaves com um for each
        for(String key: ExampleHash.keySet()){
            System.out.println("Key: "+key +" Value: "+ExampleHash.get(key));
        }
    
    }

    public void getSetValue(){ //imprimindo todos os valores do HashSet também usando um for each
        for(String value: ExampleSet){
            System.out.println("Value: "+value);
        }
    }

    public void getLinkedValue(){ //imprimindo todos os valores do LinkedHashSet também usando um for each
        for(String key: ExampleLinkedHash.keySet()){
            System.out.println("Key: "+key+ " Value: "+ExampleLinkedHash.get(key));
        }
    }

    public void getTableValue(){ //imprimindo todos os valores do Hash table também usando um for each
        for(String key: ExampleHashTable.keySet()){
            System.out.println("Key: "+key+ " Value: "+ExampleHashTable.get(key));
        }
    }



}
    
