// Singl
/** import java.util.ArrayList;
import java.util.List;

class Singleton{

    private List<Integer> list;
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton(){
        list = new ArrayList<>();
    }

    public void add(int value){
        list.add(value);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
} */

// Prototype

import java.util.ArrayList;
import java.util.List;

/** class Person implements Cloneable{
  private String name;
  private String surname;
  private int age;

  public Person(int age, String surname, String name) {
      this.age = age;
      this.surname = surname;
      this.name = name;
  }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public void setName(String name) {
      this.name = name;
  }

  public void setSurname(String surname) {
      this.surname = surname;
  }

  public void setAge(int age) {
      this.age = age;
  }

  public String getName() {
      return name;
  }

  public String getSurname() {
      return surname;
  }

  public int getAge() {
      return age;
  }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
} */

// Builder

/** class Pizza{
    private String dough;
    private String sous;
    private String topping;
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSous() {
        return sous;
    }

    public void setSous(String sous) {
        this.sous = sous;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza" + name + " => " + dough + " , " + topping + " , " + sous + " , ";
    }
}

interface PizzaBuilder {
    void BuildSous();
    void Buildtopping();
    void Builddough();
    Pizza getPizza();
}

class MaragaritaPizzaBuilder implements PizzaBuilder{

    Pizza pizza;

    public MaragaritaPizzaBuilder() {
        this.pizza = new Pizza("Margarita");
    }

    @Override
    public void BuildSous() {
        this.pizza.setSous("Tomat");
    }

    @Override
    public void Buildtopping() {
        this.pizza.setTopping("Cheese");
    }

    @Override
    public void Builddough() {
        this.pizza.setDough("small");
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }
}

class HavaiPizzaBuilder implements PizzaBuilder{

    Pizza pizza;

    public HavaiPizzaBuilder() {
        this.pizza = new Pizza("Havai");
    }

    @Override
    public void BuildSous() {
        this.pizza.setSous("White sous");
    }

    @Override
    public void Buildtopping() {
        this.pizza.setTopping("pineapple");
    }

    @Override
    public void Builddough() {
        this.pizza.setDough("Average");
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }
}

class Director{
    List<PizzaBuilder> builders;

    public Director(List<PizzaBuilder> builders) {
        this.builders = builders;
    }

    private List<Pizza> getPizzaDifferent(){
        List<Pizza> list = new ArrayList<>();

        for (int i = 0; i < builders.size(); i++) {
            builders.get(i).Builddough();
            builders.get(i).BuildSous();
            builders.get(i).Buildtopping();
            Pizza pizza = builders.get(i).getPizza();

            list.add(pizza);
        }
        return list;
    }

    public List<Pizza> getPizza(){
        return getPizzaDifferent();
    }

    -public static void main(String[] args) {

        List<PizzaBuilder> list = new ArrayList<>();
        list.addAll(
                List.of(
                        new HavaiPizzaBuilder(),
                        new MaragaritaPizzaBuilder()
                )
        );

        Director director = new Director(list);

        List<Pizza> pizza = director.getPizza();
        for (int i = 0; i < director.getPizza().size(); i++) {
            System.out.println(pizza.get(i));
        }
    -}
} */

// Factory method
   /**  abstract class Enemy{
         public abstract void attack();
     }

         class Ork extends Enemy{
             @Override
             public void attack() {
                 System.out.println("Ork attacks with axe!");
             }
         }

         class Elf extends Enemy{
             @Override
             public void attack() {
                 System.out.println("Elf attacks with bow");
             }
         }

     abstract class EnemySpawner{
        public abstract Enemy CreateEnemy();
     }


        class OrkSpawner extends EnemySpawner{
            @Override
            public Enemy CreateEnemy() {
                return new Ork();
            }
        }

        class ElfSpawner extends EnemySpawner{
            @Override
            public Enemy CreateEnemy() {
                return new Elf();
            }
        }

public class Pattern {
    public static void main(String[] args) {
        EnemySpawner spawner = new OrkSpawner();
        EnemySpawner spawner2 = new ElfSpawner();

        Enemy enemy = spawner.CreateEnemy();
        Enemy enemy2 = spawner2.CreateEnemy();

        enemy.attack();
        enemy2.attack();
    }
} */


   // Abstract factory
   interface Warrior{
     void attack();
   }
   interface Archer{
    void shoot();
   }

   class ElfWarrior implements Warrior{
       @Override
       public void attack() {
           System.out.println("Bonk!");
       }
   }

   class ElfArcher implements Archer{
       @Override
       public void shoot() {
           System.out.println("Pew!");
       }
   }

  class OrkWarrior implements Warrior{
    @Override
    public void attack() {
        System.out.println("Bam!");
    }
  }

  class OrkArcher implements Archer{
    @Override
    public void shoot() {
        System.out.println("Bang!");
    }
  }

  interface UnitFactory{
       Warrior CreateWarrior();
       Archer CreateArcher();
  }

  class ElfFactory implements UnitFactory{
      @Override
      public Warrior CreateWarrior() {
          return new ElfWarrior();
      }

      @Override
      public Archer CreateArcher() {
          return new ElfArcher();
      }
  }

  class OrkFactory implements UnitFactory{
      @Override
      public Archer CreateArcher() {
          return new OrkArcher();
      }

      @Override
      public Warrior CreateWarrior() {
          return new OrkWarrior();
      }
  }


   public class Pattern {
       public static void main(String[] args) {
           UnitFactory factory = new OrkFactory();

           Warrior warrior = factory.CreateWarrior();
           Archer archer = factory.CreateArcher();

           warrior.attack();
           archer.shoot();
       }
   }