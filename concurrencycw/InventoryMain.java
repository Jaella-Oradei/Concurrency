public class InventoryMain {// creates run called InventoryMain
   
    //private int addedthread, removedthread, bugflagName ;
    public static void main(String[] args){//main static method to run code

      
        int addedthread = Integer.parseInt(args[0]);//turns the first string argument input into an int variable named addedthread
        int removedthread = Integer.parseInt(args[1]);//turns the second string argument input into an int variable named removedthread
        int bugflagName = Integer.parseInt(args[2]);//turns the third string argument input into an int variable named bugflag
        Threader t1 = new Threader(addedthread, removedthread, bugflagName); //creates an insatnce of type threader that passes in 3 int variables
        t1.start();//runs the t1 threads by starting the function start()
        
    }
    
}
