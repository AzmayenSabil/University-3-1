import java.util.*;

public class DuckSimulatorMain {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        boolean running = true;

        System.out.println("press 1 -> task 1");
        System.out.println("press 2 -> task 2");
        System.out.println("press 3 -> task 3");
        System.out.println("press 4 -> task 4");
        System.out.println("press 5 -> task 5");
        System.out.println("press 6 -> task 6");
        System.out.println("press 0 -> to exit");
        System.out.println("press 9 -> to see options");

        int input = sc.nextInt();


        while(running) {

            if(input == 9) {
                System.out.println("press 1 -> task 1");
                System.out.println("press 2 -> task 2");
                System.out.println("press 3 -> task 3");
                System.out.println("press 4 -> task 4");
                System.out.println("press 5 -> task 5");
                System.out.println("press 6 -> task 6");
                System.out.println("press 0 -> to exit");
            }


            else if(input == 1) {
                System.out.println("----- Start of Task-1 -----");
                QuackBehaviour duck = new Duck();
                duck.quack();

                QuackBehaviour patiHash = new PatiHash();
                patiHash.quack();
                System.out.println("----- End of Task-1 -----");
                System.out.println();
            }

            else if(input == 2) {
                System.out.println("----- Start of Task-2 -----");
                QuackBehaviour goose = new DuckAdapter(new Goose());
                goose.quack();
                System.out.println("----- End of Task-2 -----");
                System.out.println();
            }

            else if(input == 3) {
                System.out.println("----- Start of Task-3 -----");
                //--------quack counter-------
                QuackCountable patiQuackCounter = new QuackCounter(new PatiHash());
                patiQuackCounter.quack();
                patiQuackCounter.quack();
                patiQuackCounter.quack();

                patiQuackCounter.getNumberOfQuacks();
                //-----------------------------

                //---------quack counter-------
                System.out.println();
                QuackCountable duckQuackCounter = new QuackCounter(new Duck());
                duckQuackCounter.quack();
                duckQuackCounter.quack();

                duckQuackCounter.getNumberOfQuacks();
                //-----------------------------
                System.out.println("----- End of Task-3 -----");
                System.out.println();
            }

            else if(input == 4) {
                System.out.println("----- Start of Task-4 -----");
                // Used factory pattern to create duck and quack counter
                DuckFactory duckFactory = new DuckFactory();
                System.out.println("New duck : ");
                QuackBehaviour duck2 = duckFactory.getFactory("patihash");

                QuackCounterFactory quackCounterFactory = new QuackCounterFactory();
                QuackCounter counter2 = (QuackCounter) quackCounterFactory.getCounterFactory("count", duck2);
                counter2.quack();
                counter2.quack();
                counter2.quack();
                counter2.getNumberOfQuacks();
                //-------------------------------------------------------
                System.out.println("----- End of Task-4 -----");
                System.out.println();
            }

            else if(input == 5) {
                System.out.println("----- Start of Task-5 -----");
                //-----FLOCK OF DUCKS-------
                FlockOfDucks flockOfDucks = new FlockOfDucks(new Duck());
                QuackBehaviour oneduck = new Duck();
                QuackBehaviour twoduck = new Duck();
                QuackBehaviour threeduck = new PatiHash();
                QuackBehaviour fourduck = new DuckAdapter(new Goose());

                flockOfDucks.add(oneduck);
                flockOfDucks.add(twoduck);
                flockOfDucks.add(threeduck);
                flockOfDucks.add(fourduck);

                flockOfDucks.quack();
                System.out.println("----- End of Task-5 -----");
                System.out.println();
            }


            else if(input == 6) {
                System.out.println("----- Start of Task-6 -----");
                FlockOfDucks flockOfDucks = new FlockOfDucks(new Duck());
                QuackBehaviour oneduck = new Duck();
                QuackBehaviour twoduck = new Duck();
                QuackBehaviour threeduck = new PatiHash();
                QuackBehaviour fourduck = new DuckAdapter(new Goose());

                flockOfDucks.add(oneduck);
                flockOfDucks.add(twoduck);
                flockOfDucks.add(threeduck);
                flockOfDucks.add(fourduck);

                DuckObserver duckObserver = new DuckObserver();
                flockOfDucks.registerObserver(duckObserver);
                //flockOfDucks.notifyObservers();
                flockOfDucks.quack();

                System.out.println("----- End of Task-6 -----");
                System.out.println();
            }
            else if(input == 0){
                running = false;
                break;
            }

            input = sc.nextInt();

            //--------------------------
        }


    }
}
