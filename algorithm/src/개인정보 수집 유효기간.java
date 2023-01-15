

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        String[] today_array = today.split("\\.");
        System.out.println(Integer.parseInt(today_array[1]));
        
        ArrayList<Term> array = new ArrayList<>(); 
        ArrayList<Priacy> array2 = new ArrayList<>(); 
        ArrayList<Integer> array3 = new ArrayList<>();
        
        for(int i=0; i<terms.length; i++){
            String temp = terms[i];
            String[] terms_array = temp.split(" ");
            Term term = new Term();
            term.setContract(terms_array[0]);
            term.setNum(terms_array[1]);
            array.add(term);
        }
        
        for(int i=0; i<privacies.length; i++){
            String temp = privacies[i];
            String[] privacy_array = temp.split(" ");
            Priacy priacy = new Priacy();
            priacy.setContract(privacy_array[1]);
            priacy.setDate(privacy_array[0]);
            array2.add(priacy);
            
            for(int j=0; j<array.size(); j++){
                String temp2 = array.get(j).getContract();
                if(temp2.equals(privacy_array[1])){
                    
                    //String[] today_array = today.split("\\.");
                    String[] privacy_array2 = privacy_array[0].split("\\.");
                    
                    int t1 = Integer.parseInt(privacy_array2[1])+Integer.parseInt(array.get(j).getNum());
                    
                    int mok = t1/12;
                    int namuji = t1%12;
                    
                    if(namuji <=0 ){
                        
                        int t2 = Integer.parseInt(privacy_array2[0])+mok-1;
                        int t3 = 12;
                        
                        String mosu = today.replaceAll("\\.","");
                        String s = String.valueOf(t3);
                        if(s.length() == 1){
                            s= "0"+s;
                        }
                        String bigo = String.valueOf(t2)+s+privacy_array2[2];
                        //System.out.println(bigo);
                        //System.out.println(mosu);
                        
                        if(Integer.parseInt(bigo) <= Integer.parseInt(mosu)){
                            array3.add(i+1);
                        }
                        
                    }else{
                        int t2 = Integer.parseInt(privacy_array2[0])+mok;
                        int t3 = namuji;
                        
                        String mosu = today.replaceAll("\\.","");
                        String s = String.valueOf(t3);
                        if(s.length() == 1){
                            s= "0"+s;
                        }
                        String bigo = String.valueOf(t2)+s+privacy_array2[2];
                        //System.out.println(bigo);
                        //System.out.println(mosu);
                        
                        if(Integer.parseInt(bigo) <= Integer.parseInt(mosu)){
                            array3.add(i+1);
                        }
                        
                    }

                    
                }
            }
            
        }

                    
                   int[] answer = new int[array3.size()];
                    for(int i=0; i<array3.size(); i++){
                        answer[i] = array3.get(i);
                    }

        
        return answer;
    }
}

class Term {
   public String contract;
   public String num;
    
    public String getContract(){
        return this.contract;
    }
    public String getNum(){
        return this.num;
    }
    public void setContract(String contract){
        this.contract = contract;
    }
    public void setNum(String num){
        this.num = num;
    }
}

class Priacy {
   public String date;
   public String contract;
    
    public String getContract(){
        return this.contract;
    }
    public String getDate(){
        return this.date;
    }
    public void setContract(String contract){
        this.contract = contract;
    }
    public void setDate(String date){
        this.date = date;
    }
}