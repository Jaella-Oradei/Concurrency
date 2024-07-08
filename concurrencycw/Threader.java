//import java.nio.Buffer;

public class Threader extends Thread{//class where all threads created tat extends to thread class
    
    Warehouse warehouse = new Warehouse();// creating an instance of type warehouse.

    private Thread thread[];//creating an empty thread array.
    private int add, remove, bugf;// declaring ints 
    
    public Threader (int added, int removed, int bugflag){//constructor that takes in values from main
        this.add=added;//gives the value of add to added
        this.remove=removed;//gives the value of remove to removed
        this.bugf=bugflag;//gives the value of bugf to bugflag
        thread=new Thread[added + removed];//sets the value of thread to the sum or the added and remove input
    }

    //@Override
    public void start(){//function to run the whole thing
        if (bugf == 0){//if the value of bugf is 0, proceed with following code
            for(int i = 0; i<add; i++){//for loop to iterate the amount of times as the added number
                thread[i]=new Thread(this, "add");//thread of position of i creates a new thread called i
                thread[i].start();//thread of position i runs start function
                try{ //try to run join method and the calling of adding thread
                    thread[i].join(1000);//joins threads of position 1
                    warehouse.addingThreads();//runs adding thread in warehouse class  
                }
                catch(Exception e){//catch an exception 
                    System.out.println(e);// prints out exeption message 
                } 
            }
            for (int x=add; x<(remove+add); x++){//for loop that iterates from the size of add the amount of add and remove combined.
                thread[x]=new Thread(this, "remove");//creates a new thread in position x named remove
                thread[x].start();//runs thread of position x with function start.
                try{  //try to run join method and the calling of removing thread
                    thread[x].join(1000);//joins thread in position x together.
                    warehouse.removingThreads();//runs removing thread method.  
                }
                catch(Exception e){//catch an exception error
                    System.out.println(e);// prints out error message 
                }       
            }
            System.err.println("Final inventory size = " + warehouse.returnFinalInvetory());//prints out final inventory size by calling return method from warehouse  
        }else if (bugf==1){// else if the bugflag is 1, run following

            for(int i = 0; i<add; i++){//for loop to iterate the amount of times as the added number
                bugf=1;//sets bugflag to value 1 being the input
                thread[i]=new Thread(this, "add");//thread of position of i creates a new thread called i
                thread[i].start();//thread of position i runs start function
                try{ //try to run join method and the calling of adding thread
                    thread[i].join(1000);//joins threads of position 1
                    warehouse.incorrectADDresults(bugf);//runs the incorrect add method in the warehouse class and pass in the bugflag value  
                }
                catch(Exception e){//catches any exceptions
                    System.out.println(e);//prints exception mistakes
                } 
            }
            for (int x=add; x<(remove+add); x++){//for loop that iterates from the size of add the amount of add and remove combined.
                thread[x]=new Thread(this, "remove");//creates anew thread in position c
                thread[x].start();//calls the start function on the said thread that was just created
                try{  //tries the following code
                    thread[x].join(1000);//joins thread every 100millisecs
                    warehouse.incorrectREMOVEresults(bugf);//runs the incorrect remove results and passes in the bug variable
                }
                catch(Exception e){//catches any exception 
                    System.out.println(e);//prints out exception error message
                }       
            }
            System.err.println("Final inventory size = " + warehouse.returnFinalInvetory());// prints out final inventory size of wromg value.
        }

    }

    
}
