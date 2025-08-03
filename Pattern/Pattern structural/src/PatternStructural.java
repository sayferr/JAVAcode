import java.time.LocalDate;
import java.util.*;

//Facade 1
/** enum HotelType{
    ONE_STAR,
    TWO_STARS,
    THREE_STAR,
    FOUR_STARS,
    FIVE_STAR
}

class HotelBooking{
    public int BookHotel(HotelType hotelType, int days){
       return switch (hotelType){
            case ONE_STAR -> 100 * days;
            case TWO_STARS -> 200 * days;
            case THREE_STAR -> 220 * days;
            case FOUR_STARS -> 300 * days;
            case FIVE_STAR -> 450 * days;
        };
    }
}

enum TripType{
    BUS,
    TRAIN,
    FLIGHT
}

class TripBooking{
    public double BookTrip(TripType tripType, String from, String to){
        Random random = new Random();

        int distance = random.nextInt(4900) + 100;

        return switch (tripType){
             case BUS -> distance * 0.5;
             case TRAIN -> distance * 2.5;
             case FLIGHT -> distance * 5.5;
         };
    }
}

enum GuideType{
    NONE,
    AUDIO,
    PERSON
}

class GuideBooking{
    public double BookGuide(GuideType guideType, int days){
        return switch (guideType){
            case NONE -> 0;
            case AUDIO -> days * 30;
            case PERSON -> days * 100;
        };
    }
}

 class TravelAgencyParam{
private String from;
private String to;
private String when;
private int days;
private HotelType hotelType;
private TripType tripType;
private GuideType guideType;

     public String getFrom() {
         return from;
     }

     public TravelAgencyParam setFrom(String from) {
         this.from = from;
         return this;
     }

     public String getTo() {
         return to;
     }

     public TravelAgencyParam setTo(String to) {
         this.to = to;
         return this;
     }

     public String getWhen() {
         return when;
     }

     public TravelAgencyParam setWhen(String when) {
         this.when = when;
         return this;
     }

     public int getDays() {
         return days;
     }

     public TravelAgencyParam setDays(int days) {
         this.days = days;
         return this;
     }

     public HotelType getHotelType() {
         return hotelType;
     }

     public TravelAgencyParam setHotelType(HotelType hotelType) {
         this.hotelType = hotelType;
         return this;
     }

     public TripType getTripType() {
         return tripType;
     }

     public TravelAgencyParam setTripType(TripType tripType) {
         this.tripType = tripType;
         return this;
     }

     public GuideType getGuideType() {
         return guideType;
     }

     public TravelAgencyParam setGuideType(GuideType guideType) {
         this.guideType = guideType;
         return this;
     }
 }

class TravelAgency{
    public String BuildTrip(TravelAgencyParam travelAgencyParam){
        StringBuilder stringBuilder = new StringBuilder(1000);
        double price = 0;

        stringBuilder.append("Welcome Booking\n---------------------------------------\n");
        stringBuilder.append("From: " + travelAgencyParam.getFrom());
        stringBuilder.append("\nTo: " + travelAgencyParam.getTo());


        LocalDate start = LocalDate.parse(travelAgencyParam.getWhen());
        LocalDate end = start.plusDays(travelAgencyParam.getDays());

        stringBuilder.append("\nStart: " + start);
        stringBuilder.append("\nEnd: " + end);


        HotelBooking hotelBooking = new HotelBooking();
        double FromHotel = hotelBooking.BookHotel(travelAgencyParam.getHotelType(), travelAgencyParam.getDays());

        stringBuilder.append("\n---------------------------------------\n");
        stringBuilder.append("\nFrom Hotel :" + FromHotel);
        stringBuilder.append("\n---------------------------------------\n");


        TripBooking tripBooking = new TripBooking();
        double FromTrip = tripBooking.BookTrip(travelAgencyParam.getTripType(), travelAgencyParam.getFrom(),
                travelAgencyParam.getTo());

        stringBuilder.append("\nFrom Trip :" + FromTrip);
        stringBuilder.append("\n---------------------------------------\n");


        GuideBooking guideBooking = new GuideBooking();
        double FromGuide = guideBooking.BookGuide(travelAgencyParam.getGuideType(), travelAgencyParam.getDays());
        stringBuilder.append("\nFrom Guide :" + FromGuide);
        stringBuilder.append("\n---------------------------------------\n");

        price = FromTrip + FromHotel + FromGuide;
        stringBuilder.append("\nTotal sum :" + Math.round(price) + ".00");
        stringBuilder.append("\n---------------------------------------\n");

        return stringBuilder.toString();
    }
}

public class PatternStructural {
    public static void main(String[] args){
        TravelAgency travelAgency = new TravelAgency();
        TravelAgencyParam travelAgencyParam = new TravelAgencyParam()
                .setFrom("Erevan")
                .setTo("Moscow")
                .setDays(7)
                .setWhen("2025-03-30")
                .setTripType(TripType.FLIGHT)
                .setHotelType(HotelType.FIVE_STAR)
                .setGuideType(GuideType.NONE);

        String ticket = travelAgency.BuildTrip(travelAgencyParam);
        System.out.println(ticket);
    }
} */

// Proxy
   /** interface Image{
        void display();
    }

    class RealImage implements Image{
        public String filename;

        public RealImage(String filename){
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk(){
            System.out.println("Loading image from disk..." + filename);
        }

        public void display(){
            System.out.println("Displaying image..." + filename);
        }
    }

    class ProxyImage implements Image{
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename){
            this.filename = filename;
        }

        public void display(){
            if (realImage == null){
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

public class PatternStructural {
    public static void main(String[] args){
        Image image = new ProxyImage("proxy.jpg");
        //Load from disk
        image.display();

        //Load don't with disk
        image.display();
    }
} */


   //Flyweight

     class TreeType{
         private String name;
         private String color;
         private String texture;

         public TreeType(String name, String color, String texture){
             this.name=name;
             this.color=color;
             this.texture=texture;
         }

         public void drawTree(int x, int y){
             System.out.println("Drawing tree at: "+x+","+y);
         }
     }

     class Tree{
         private int x;
         private int y;
         private TreeType tree;

         public  Tree(int x, int y, TreeType tree){
             this.x=x;
             this.y=y;
             this.tree=tree;
         }

         public void drawTree(){
             tree.drawTree(x,y);
         }
     }

     class TreeFactory{
         private static Map<String, TreeType> types = new HashMap<>();

         public static TreeType getTreeType(String name,  String color, String texture){
             String key = name+color+texture;
             if(!types.containsKey(key)){
                 types.put(key,new TreeType(name,color,texture));
             }
             return types.get(key);
         }
     }

     class Forest{
         private List<Tree> trees = new ArrayList<>();

         public void PlantTree(int x, int y, String name,String color, String texture){
             TreeType tree = TreeFactory.getTreeType(name,color,texture);
             trees.add(new Tree(x,y,tree));
         }

         public void drawForest(){
             for (Tree tree : trees) {
                 tree.drawTree();
             }
         }
     }

     public class PatternStructural {
         public static void main(String[] args){
             Forest forest = new Forest();

             // 100 same tree
             for (int i = 0; i < 100; i++) {
                 forest.PlantTree(i, i, "Red Tree", "Red", "RedTexture.png");
             }

             // Others 100 tree
             for (int i = 0; i < 100; i++) {
                 forest.PlantTree(i, i + 1, "Green Tree", "Green", "GreenTexture.png");
             }

             forest.drawForest();
         }
     }


