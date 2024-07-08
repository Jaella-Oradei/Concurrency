public class Warehouse{//creates a public class called warehouse

    public int finalInventory;//creates a private variable of type int
    private int addWrongBug, removeWrongBug;

    public Warehouse(){//constructor of warehouse with no parameters 
        
    }
    public synchronized void addingThreads(){//synchronised method that adds threads
        finalInventory++;//increments finalInventory by 1.
        System.out.println("Thread added an item. Inventory size now =  " + finalInventory);//prints out that thread as been added and gives value of current inventory size
  
    }

    public synchronized void removingThreads(){//synchronised method that removes threads
        finalInventory--;//decrements finalInventory by 1
        System.out.println("Thread removed an item. Inventory size now =  " + finalInventory);//prints out that thread as been removed and gives value of current inventory size
    }

    public int returnFinalInvetory(){//method that returns a value of type int 
        return finalInventory;// returns the variable finalInventory
    }
    public synchronized void incorrectADDresults(int bug1){//synchronised method that takes in int value
        this.addWrongBug=bug1;//sets addwrongbug to the value of the parameter
        finalInventory--;//decrements the value of finalinventory
        finalInventory=finalInventory*addWrongBug;//multiplies finalinventory number by value of addwrongbug
        System.out.println("Thread added an item. Inventory size now =  " + finalInventory);//prints out current inventory size
    }

    public synchronized void incorrectREMOVEresults(int bug2){//synchronised method that takes in int value
        this.removeWrongBug=bug2;//sets removewrongbug to the parameter passed in
        finalInventory++;//increments value of finalinventory
        finalInventory=finalInventory*removeWrongBug;//multiples finalinventory number by value of addingworngbug
        System.out.println("Thread removed an item. Inventory size now =  " + finalInventory);//prints out current size of inventory
    }
}