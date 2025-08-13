import java.util.*;

// Chain Of Responsibility
/** class Account{
    String CardNumber;
    String FullName;
    double Money;
    int PIN;

    public Account(String cardNumber, String fullName, double money, int PIN) {
        CardNumber = cardNumber;
        FullName = fullName;
        Money = money;
        this.PIN = PIN;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
}

interface MoneyOperationHandler{
    void handle(String CardNumber, int PIN, double Money);
    void setNext(MoneyOperationHandler next);
}

class AccountDataBase{
    public static List<Account> accounts;

    static {
        accounts = new ArrayList<>();
        accounts.add(new Account("123", "John Doe", 500.0, 100));
        accounts.add(new Account("321", "Rick Kip", 4000.0, 400));
    }
}

class VerifyAccountHandler implements MoneyOperationHandler{
    private MoneyOperationHandler next;


    @Override
    public void handle(String CardNumber, int PIN, double Money) {
      boolean AccountExists = AccountDataBase
                              .accounts
                              .stream()
                              .anyMatch(account ->
                                  account.getCardNumber().equals(CardNumber) && account.getPIN() == PIN
                              );
      if (AccountExists) {
          if (next != null)
          next.handle(CardNumber, PIN, Money);
      }else {
          System.out.println("Account Not Found");
      }
    }

    @Override
    public void setNext(MoneyOperationHandler next) {
        this.next = next;
    }
}

class CheckMoneyHandler implements MoneyOperationHandler{
    private MoneyOperationHandler next;

    @Override
    public void handle(String CardNumber, int PIN, double Money) {
        Account account = AccountDataBase
                .accounts
                .stream()
                .filter(acc -> acc.getCardNumber().equals(CardNumber) && acc.getPIN() == PIN)
                .findFirst()
                .orElse(null);

        if (account != null && account.getMoney() >= Money) {
            if (next != null)
            next.handle(CardNumber, PIN, Money);
        }else  {
            System.out.println("Error! Not enough money");
        }
    }

    @Override
    public void setNext(MoneyOperationHandler next) {
        this.next = next;
    }
}

class MoneyOperationloggerHandler  implements MoneyOperationHandler{
    private MoneyOperationHandler next;

    @Override
    public void handle(String CardNumber, int PIN, double Money) {
        System.out.println("["+ new Date().toString() +"] - Card number : " + CardNumber + " ,Amount : " + Money );

        if (next != null) {
            next.handle(CardNumber, PIN, Money);
        }
    }

    @Override
    public void setNext(MoneyOperationHandler next) {
        this.next = next;
    }
}

class ReciveMoneyHandler implements MoneyOperationHandler{
    private MoneyOperationHandler next;

    @Override
    public void handle(String CardNumber, int PIN, double Money) {
        Account account = AccountDataBase.accounts
                .stream()
                .filter(acc -> acc.getCardNumber().equals(CardNumber) && acc.getPIN() == PIN)
                .findFirst()
                .orElse(null);

        if (account != null && account.getMoney() >= Money) {
            account.setMoney(account.getMoney() - Money);
            System.out.println("Transaction succesfull! Remaining balance : " + account.getMoney());
        }
    }

    @Override
    public void setNext(MoneyOperationHandler next) {
        this.next = next;
    }
}

public class PatternBehaviorial {
    public static void main(String[] args) {
        MoneyOperationHandler moneyOperationloggerHandler = new MoneyOperationloggerHandler();
        MoneyOperationHandler verifyAccountHandler = new VerifyAccountHandler();
        MoneyOperationHandler checkMoneyHandler = new CheckMoneyHandler();
        MoneyOperationHandler reciveMoneyHandler = new ReciveMoneyHandler();


        verifyAccountHandler.setNext(checkMoneyHandler);
        checkMoneyHandler.setNext(moneyOperationloggerHandler);
        moneyOperationloggerHandler.setNext(reciveMoneyHandler);

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to bank ATM....");
            System.out.println("Please enter your Card Number : ");
            String cardNumber = scanner.next();

            System.out.println("Please enter your PIN : ");
            int PIN = scanner.nextInt();

            System.out.println("Please enter your Money : ");
            double Money = scanner.nextDouble();

            verifyAccountHandler.handle(cardNumber, PIN, Money);
            System.out.println("\n");

        }while (true);
    }
} */


// Memento
  /**  enum Direction{
        UP, DAWN, LEFT, RIGHT;
    }

class Location{
    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

    class Player{
        private int hp = 100;
        private int stamina = 50;
        private String name;
        Location location;

        public Player(String name) {
            this.name = name;
            this.location = new Location(0,0);
        }

        public void Movie(Direction direction){
            switch (direction){
                case UP -> this.location.setY(location.getY() + 1);
                case DAWN ->  this.location.setY(location.getY() - 1);
                case LEFT -> this.location.setX(location.getX() - 1);
                case RIGHT -> this.location.setX(location.getX() + 1);
            }
        }

        public void Attack(){
            stamina -= 5;
        }

        public void TakeDamage(int damage){
            hp -= damage;
        }

        public void info(){
            System.out.println("\n");
            System.out.println("Name: " + this.name + ". hp: " + this.hp + ". stamina: " +
                                 this.stamina + ". location: " + location.getX() + ", " + location.getY());
        }

        public PlayerMemento save(){
            return new PlayerMemento(hp, stamina, name, location.getX(), location.getY());
        }

        public void load(PlayerMemento  memento){
            this.name = memento.getName();
            this.hp = memento.getHp();
            this.stamina = memento.getStamina();
            this.location = memento.getLocation();
        }
    }

    class PlayerMemento{
        private int hp = 100;
        private int stamina = 50;
        private String name;
        Location location;

        public PlayerMemento(int hp, int stamina, String name, int x, int y) {
            this.hp = hp;
            this.stamina = stamina;
            this.name = name;
            this.location = new Location(x, y);
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getStamina() {
            return stamina;
        }

        public void setStamina(int stamina) {
            this.stamina = stamina;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    class PlayerSaves{
        Player player;
        private Stack<PlayerMemento> saves;

        public PlayerSaves(Player player) {
            this.player = player;
            saves = new Stack<>();

        }

        public void savePlayer(){
            PlayerMemento playerMemento = player.save();
            saves.push(playerMemento);
        }

        public void loadPlayer(){
            if (!saves.empty()){
                PlayerMemento playerMemento = saves.pop();
                player.load(playerMemento);
            }else{
                System.out.println("No saves have been loaded");
            }
        }
    }

public class PatternBehaviorial {
    public static void main(String[] args) {
        Player player = new Player("Sayfer");
        PlayerSaves playerSaves = new PlayerSaves(player);
        playerSaves.savePlayer();
        player.info();

        player.Attack();
        player.Attack();
        player.TakeDamage(35);
        player.Movie(Direction.UP);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.DAWN);
        playerSaves.savePlayer();
        player.info();


        player.Attack();
        player.Attack();
        player.TakeDamage(35);
        player.Movie(Direction.UP);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.DAWN);
        playerSaves.savePlayer();
        player.info();


        player.Attack();
        player.Attack();
        player.TakeDamage(35);
        player.Movie(Direction.UP);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.LEFT);
        player.Movie(Direction.DAWN);
        player.info();

        System.out.println("--------------------------------------------------");
        System.out.println("                       YOU DEAD!                  ");
        System.out.println("                       YOU DEAD!                  ");
        System.out.println("--------------------------------------------------");
        playerSaves.loadPlayer();
        player.info();
    }
} */

// Template Method
/** abstract class Beverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("boil water...");
    }

    public void pourInCup(){
        System.out.println("pour in cup...");
    }

    abstract void brew();
    abstract void addCondiments();
  }

  class Tea extends Beverage {
      @Override
      void brew() {
          System.out.println("tea brew...");
      }

      @Override
      void addCondiments() {
          System.out.println("add tea condiments...");
      }
  }

class Coffee extends Beverage {
    @Override
    void brew() {
        System.out.println("Coffee brew...");
    }

    @Override
    void addCondiments() {
        System.out.println("add coffee condiments...");
    }
}

  public class PatternBehaviorial {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        Beverage beverage = new Coffee();
        beverage.prepareRecipe();
    }
} */

// Visitor
/** interface BuildingVisitor{
    void visit(Appartment appartment);
    void visit(Office office);
}

interface BuildingElement{
    void accept(BuildingVisitor visitor);
}

class Appartment implements BuildingElement{
    public  void accept(BuildingVisitor visitor){
        visitor.visit(this);
    }
}

class Office implements BuildingElement{
    public  void accept(BuildingVisitor visitor){
        visitor.visit(this);
    }
}

class PriceEvaluator implements BuildingVisitor{
    public void visit(Appartment appartment){
        System.out.println("Appartment valuation: 5.000$");
    }

    public void visit(Office office){
        System.out.println("Office valuation: 10.000$");
    }
}

class TaxInspector implements BuildingVisitor{
    public void visit(Appartment appartment){
        System.out.println("Appartment tax: 500$");
    }

    public void visit(Office office){
        System.out.println("Office tax: 1.000$");
    }
}

public class PatternBehaviorial {
    public static void main(String[] args) {
        BuildingElement appartment = new Appartment();
        BuildingElement office = new Office();

        BuildingVisitor priceVisitor = new PriceEvaluator();
        BuildingVisitor taxVisitor = new TaxInspector();

        System.out.println("--- GRADE ---");
        appartment.accept(priceVisitor);
        office.accept(priceVisitor);

        System.out.println();

        System.out.println("--- TAX ---");
        appartment.accept(taxVisitor);
        office.accept(taxVisitor);
    }
} */